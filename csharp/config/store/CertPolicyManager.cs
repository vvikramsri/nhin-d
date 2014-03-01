﻿/* 
 Copyright (c) 2014, Direct Project
 All rights reserved.

 Authors:
    Joe Shook     Joseph.Shook@Surescipts.com
  
Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
Neither the name of The Direct Project (directproject.org) nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 
*/

using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.Linq;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Health.Direct.Config.Store
{
    public class CertPolicyManager : IEnumerable<CertPolicy>
    {
        ConfigStore m_store;
        ICertPolicyValidator m_validator;

        internal CertPolicyManager(ConfigStore store, ICertPolicyValidator validator)
        {
            m_store = store;
            m_validator = validator;
        }

        internal CertPolicyManager(ConfigStore store)
        {
            m_store = store;
        }

        internal ConfigStore Store
        {
            get
            {
                return m_store;
            }
        }

        //internal DataLoadOptions DataLoadOptions
        //{
        //    get
        //    {
        //        var dataLoadOptions = new DataLoadOptions();
        //        dataLoadOptions.LoadWith<CertPolicy>(c => c.CertPolicyGroupMap);
        //        return dataLoadOptions;
        //    }
        //}

        public CertPolicy Add(CertPolicy policy)
        {
            using (ConfigDatabase db = this.Store.CreateContext())
            {
                this.Add(db, policy);
                db.SubmitChanges();
                return policy;
            }
        }

        public CertPolicy Add(ConfigDatabase db, CertPolicy policy)
        {
            if (db == null)
            {
                throw new ArgumentNullException("db");
            }
            if (policy == null)
            {
                throw new ConfigStoreException(ConfigStoreError.InvalidCertPolicy);
            }
            policy.ValidateHasData();

            if (!m_validator.IsValidLexicon(policy))
            {
                throw new ConfigStoreException(ConfigStoreError.InvalidCertPolicy);
            }

            db.CertPolicies.InsertOnSubmit(policy);
            return policy;
        }

        public int Count()
        {
            using (ConfigDatabase db = this.Store.CreateReadContext())
            {
                return db.CertPolicies.GetCount();
            }
        }


        public CertPolicy Get(string name)
        {
            using (ConfigDatabase db = this.Store.CreateReadContext())
            {
                return this.Get(db, name);
            }
        }

        public CertPolicy Get(ConfigDatabase db, string name)
        {
            if (db == null)
            {
                throw new ArgumentNullException("db");
            }
            if (string.IsNullOrEmpty(name))
            {
                throw new ConfigStoreException(ConfigStoreError.InvalidCertPolicyName);
            }

            return db.CertPolicies.Get(name);
        }


        public void Update(CertPolicy policy)
        {
            using (ConfigDatabase db = this.Store.CreateContext())
            {
                this.Update(db, policy);
                db.SubmitChanges();
            }
        }


        protected void Update(ConfigDatabase db, CertPolicy policy)
        {
            if (db == null)
            {
                throw new ArgumentNullException("db");
            }
            if (policy == null)
            {
                throw new ConfigStoreException(ConfigStoreError.InvalidDomain);
            }

            CertPolicy update = new CertPolicy();
            update.CopyFixed(policy);

            db.CertPolicies.Attach(update);
            update.ApplyChanges(policy);
        }

        public void RemoveAll(ConfigDatabase db)
        {
            db.CertPolicies.ExecDeleteAll();
        }

        public void RemoveAll()
        {
            using (ConfigDatabase db = this.Store.CreateContext())
            {
                this.RemoveAll(db);
            }
        }

        public IEnumerator<CertPolicy> GetEnumerator()
        {
            using (ConfigDatabase db = this.Store.CreateContext())
            {
                foreach (CertPolicy policy in db.CertPolicies)
                {
                    yield return policy;
                }
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
        
        
    }
}
