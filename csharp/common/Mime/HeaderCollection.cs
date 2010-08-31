﻿using System;
using System.Collections.Generic;
using System.Linq;

using NHINDirect.Collections;

namespace NHINDirect.Mime
{
    /// <summary>
    /// Represents a collection of MIME and RFC 5322 headers
    /// </summary>
    public class HeaderCollection : ObjectCollection<Header>
    {
        /// <summary>
        /// Initializes a new empty collection
        /// </summary>
        public HeaderCollection()
        {                
        }
        
        /// <summary>
        /// Initializes a new collection from an enumeration of headers.
        /// </summary>
        /// <param name="headers">An enumeration of <see cref="Header"/> instances.</param>
        public HeaderCollection(IEnumerable<Header> headers)
            : base(headers)
        {
        }
        
        /// <summary>
        /// Gets and sets the named header. Setting a header to <c>null</c> will remove the header.
        /// </summary>
        /// <remarks>
        /// Headers are not case sensitive, so <c>myHeaders["content-type"]</c> and <c>myHeaders["Content-Type"]</c>
        /// will refer to the same header value.
        /// </remarks>
        /// <param name="name">The name of the header to get or set. See remarks.</param>
        /// <returns>The <see cref="Header"/> associated with the header name.</returns>
        public Header this[string name]
        {
            get
            {
                int i = IndexOf(name);
                if (i < 0)
                {
                    return null;
                }
                
                return this[i];
            }  
            set
            {
                int currentIndex = IndexOf(name);
                if (currentIndex < 0)
                {
                    if (value != null) // If null, then there is nothing to do
                    {
                        //
                        // Not found. New Header
                        //
                        VerifyName(name, value);
                        Add(value);
                    }
                    
                    return;
                }
                
                if (value == null)
                {
                    //
                    // Null value means remove existing header
                    //
                    RemoveAt(currentIndex);
                }
                else
                {
                    VerifyName(name, value);
                    this[currentIndex] = value;
                }
            }          
        }
        
        /// <summary>
        /// Returns the <c>Content-*</c> headers specified by the MIME RFCs
        /// </summary>
        /// <remarks>
        /// When processing an RFC 5322 message, it if often useful to extract the main MIME
        /// entity from the message. Because of the structure of MIME and RFC 5322 messages,
        /// the MIME entity is the collection of MIME headers and the body.
        /// </remarks>
        /// <example>
        /// The following code extracts the body and the MIME headers from a message (note that
        /// Message object already provides a convenience method for this):
        /// <code>
        /// string email = File.ReadAllText("message.eml");
        /// Message msg = MimeParser.ParseMessage(email);
        /// Body body = message.Body;
        /// IEnumerable&lt;Headers&gt; mimeHeaders = msg.Headers.MimeHeaders; //Content-Type:, Content-Disposition:, etc.
        /// IEnumerable&lt;Headers&gt; nonMimeMeaders = msg.Headers.NonMimeHeaders; // To:, From:, etc
        /// </code>
        /// </example>
        public IEnumerable<Header> MimeHeaders
        {
            get
            {
                return from header in this
                                where ( MimeStandard.StartsWith(header.Name, MimeStandard.HeaderPrefix))
                                select header;                
            }
        }
        
        /// <summary>
        /// Returns the non MIME (not <c>Content-*</c>) headers
        /// </summary>
        /// <remarks>See documentation for <see cref="HeaderCollection.MimeHeaders"/> for more detail.</remarks>
        public IEnumerable<Header> NonMimeHeaders
        {
            get
            {
                return from header in this
                       where (!MimeStandard.StartsWith(header.Name, MimeStandard.HeaderPrefix))
                       select header;
            }
        }
        
        /// <summary>
        /// Returns the index to a header name. See <see cref="HeaderCollection"/> for more details.
        /// </summary>
        /// <remarks>
        /// Headers are not case sensitive, so <c>myHeaders.IndexOf("content-type")</c> and 
        /// <c>myHeaders.IndexOf("Content-Type")</c>
        /// will refer to the same header value.
        /// </remarks>
        /// <param name="name">The name of the header to get or set. See remarks.</param>
        /// <returns>The zero-based index of the named header or -1 if the header was not found.</returns>
        public int IndexOf(string name)
        {
            if (string.IsNullOrEmpty(name))
            {
                throw new ArgumentException("name was null or empty", "name");
            }
            
            for (int i = 0, count = Count; i < count; ++i)
            {
                if (MimeStandard.Equals(this[i].Name, name))
                {
                    return i;
                }
            }            
            
            return -1;
        }
        
        /// <summary>
        /// Adds a named header with an associated value to this collection.
        /// </summary>
        /// <example>
        /// <code>
        /// Message = MimeParser.ParseMessage(File.ReadAllText("message.eml"));
        /// message.Headers.Add("my-foo-header", "bar;baz");
        /// </code>
        /// </example>
        /// <param name="name">The header name, case insensitive.</param>
        /// <param name="value">The associated value of the header</param>
        public void Add(string name, string value)
        {
            Add(new Header(name, value));
        }

        /// <summary>
        /// Adds a header specified by a key-value pair to this collection.
        /// </summary>
        /// <param name="value">The pair where the key is the header
        /// name, and the value is the header value.</param>
        public void Add(KeyValuePair<string, string> value)
        {
            Add(value.Key, value.Value);
        }
        
        /// <summary>
        /// Adds an enumeration of pairs to this collection as headers.
        /// </summary>
        /// <param name="headers">The enumeration to add to this collection.</param>
        public void Add(IEnumerable<KeyValuePair<string, string>> headers)
        {
            if (headers == null)
            {
                throw new ArgumentNullException("headers");
            }

            foreach (KeyValuePair<string, string> pair in headers)
            {
                Add(pair);
            }
        }
                
        /// <summary>
        /// Adds or updates a named header with an associated value.
        /// </summary>
        /// <param name="name">The header name to add or update.</param>
        /// <param name="value">The header value to which to set the header.</param>
        public void AddUpdate(string name, string value)
        {
            this[name] = new Header(name, value);
        }
        
        /// <summary>
        /// Adds or updates each of an enumeration of headers.
        /// </summary>
        /// <param name="headers">The headers to add or update.</param>
        public void AddUpdate(IEnumerable<Header> headers)
        {
            if (headers == null)
            {
                throw new ArgumentNullException("headers");
            }
            
            foreach (Header header in headers)
            {
                this[header.Name] = header;
            }
        }

        /// <summary>
        /// Adds or updates each of an enumeration of pair instances..
        /// </summary>
        /// <param name="headers">The pair instances to add or update, where
        /// each key specifies the header name, and each value the header value.</param>
        public void AddUpdate(IEnumerable<KeyValuePair<string, string>> headers)
        {
            if (headers == null)
            {
                throw new ArgumentNullException("headers");
            }

            foreach (KeyValuePair<string, string> header in headers)
            {
                this[header.Value] = new Header(header);
            }
        }
        
        /// <summary>
        /// Adds all headers from <c>source</c> that match the predicate provided by <c>filter</c>
        /// </summary>
        /// <param name="source">The enumeration of <see cref="Header"/> instances to add</param>
        /// <param name="filter">The filter to supply before </param>
        public void Add(IEnumerable<Header> source, Predicate<Header> filter)
        {
            if (source == null)
            {
                throw new ArgumentNullException("source");
            }

            foreach (Header header in source)
            {
                if (filter == null || filter(header))
                {
                    Add(header);
                }
            }
        }

        /// <summary>
        /// Adds all headers from <c>source</c> where the headers match the names provided by <c>headerNames</c>
        /// </summary>
        /// <param name="source">The enumeration of <see cref="Header"/> instances to add</param>
        /// <param name="headerNames">An array of names to filter <c>source</c> by.</param>
        public void Add(IEnumerable<Header> source, string[] headerNames)
        {
            if (source == null)
            {
                throw new ArgumentNullException("source");
            }

            foreach (Header header in source)
            {
                if (headerNames == null || headerNames.Contains(header.Name, MimeStandard.Comparer))
                {
                    Add(header);
                }
            }
        }
        
        /// <summary>
        /// Sets or updates the <c>header</c> value in this collection
        /// </summary>
        /// <param name="header">The <see cref="Header"/> to update.</param>
        public void Set(Header header)
        {
            if (header == null)
            {
                throw new ArgumentNullException("header");
            }
            
            this[header.Name] = header;
        }
        
        /// <summary>
        /// Gets the value of the header with the given name.
        /// </summary>
        /// <remarks>Header matching uses case insenstive comparison.</remarks>
        /// <param name="headerName">The header name for which to retrieve the value.</param>
        /// <returns>The value of the header, or <c>null</c> if the header does not exist in this collection</returns>
        public string GetValue(string headerName)
        {
            Header header = this[headerName];
            if (header == null)
            {
                return null;
            }
            
            return header.Value;
        }

        /// <summary>
        /// Adds or updates the value of the header with the given name.
        /// If value is null, removes the header entirely
        /// </summary>
        /// <remarks>Header matching uses case insenstive comparison.</remarks>
        /// <param name="name">The header name for which to set the value.</param>
        /// <param name="value">The value name to add or update</param>
        public void SetValue(string name, string value)
        {
            int index = IndexOf(name);
            if (index < 0)
            {
                if (value != null)
                {
                    this.Add(name, value);
                }                
                return;
            }
            
            if (value == null)
            {
                this.RemoveAt(index);
            }
            else
            {
                this[index] = new Header(name, value);
            }
        }
        
        /// <summary>
        /// Performs a shallow clone of this header
        /// </summary>
        /// <returns>The cloned value.</returns>
        public HeaderCollection Clone()
        {
            return new HeaderCollection(this);
        }
        
        /// <summary>
        /// Does a deep clone - also clones each header object
        /// </summary>
        /// <returns></returns>
        public HeaderCollection DeepClone()
        {
            var copy = new HeaderCollection();
			foreach (var header in this)
            {
                copy.Add(header.Clone());
            }
            
            return copy;
        }
        
        /// <summary>
        /// Selects the collection of content headers out of this collection
        /// </summary>
        /// <remarks>See <see cref="HeaderCollection.MimeHeaders"/></remarks>
        /// <returns>A collection of content headers</returns>
        public HeaderCollection SelectMimeHeaders()
        {
            return new HeaderCollection(MimeHeaders);
        }

        /// <summary>
        /// Selects the collection of non-content headers out of this collection
        /// </summary>
        /// <remarks>See <see cref="HeaderCollection.NonMimeHeaders"/></remarks>
        /// <returns>A collection the non-content headers</returns>
        public HeaderCollection SelectNonMimeHeaders()
        {
            return new HeaderCollection(NonMimeHeaders);
        }

        /// <summary>
        /// Verifies that a header name matches name of the associate header, with MIME string comparison semantics. 
        /// </summary>
        /// <param name="name">The header name to verify</param>
        /// <param name="header">The <see cref="Header"/> to verify against.</param>
    	static void VerifyName(string name, Header header)
        {
            if (!MimeStandard.Equals(name, header.Name))
            {
                throw new MimeException(MimeError.InvalidHeader);
            }
        }
    }
}
