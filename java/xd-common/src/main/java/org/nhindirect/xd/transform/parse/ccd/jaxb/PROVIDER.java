/* 
 * Copyright (c) 2010, NHIN Direct Project
 * All rights reserved.
 *  
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright 
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright 
 *    notice, this list of conditions and the following disclaimer in the 
 *    documentation and/or other materials provided with the distribution.  
 * 3. Neither the name of the the NHIN Direct Project (nhindirect.org)
 *    nor the names of its contributors may be used to endorse or promote products 
 *    derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY 
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND 
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS 
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.20 at 07:20:23 PM EDT 
//


package org.nhindirect.xd.transform.parse.ccd.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ENCOUNTER_ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PROVIDER_OID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EVENT_START_DATE_TIME">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EVENT_END_DATE_TIME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="1000-01-01T00:00:00"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ORGANIZATION_OID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ORGANIZATION_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PERFORMER_TYPE_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FUNCTION_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FUNCTION_CODE_SYSTEM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FUNCTION_CODE_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PROVIDER_EUID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PERSON_FIRST_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PERSON_PREFIX" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PERSON_LAST_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SOFTWARE_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PROVIDER_TYPE_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "encounterid",
    "provideroid",
    "eventstartdatetime",
    "eventenddatetime",
    "organizationoid",
    "organizationname",
    "performertypecode",
    "functioncode",
    "functioncodesystem",
    "functioncodename",
    "providereuid",
    "personfirstname",
    "personprefix",
    "personlastname",
    "softwarename",
    "providertypecode"
})
@XmlRootElement(name = "PROVIDER")
public class PROVIDER {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "ENCOUNTER_ID")
    protected int encounterid;
    @XmlElement(name = "PROVIDER_OID", required = true)
    protected String provideroid;
    @XmlElement(name = "EVENT_START_DATE_TIME", required = true)
    protected String eventstartdatetime;
    @XmlElementRef(name = "EVENT_END_DATE_TIME", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> eventenddatetime;
    @XmlElementRef(name = "ORGANIZATION_OID", type = JAXBElement.class)
    protected JAXBElement<String> organizationoid;
    @XmlElementRef(name = "ORGANIZATION_NAME", type = JAXBElement.class)
    protected JAXBElement<String> organizationname;
    @XmlElement(name = "PERFORMER_TYPE_CODE", required = true)
    protected String performertypecode;
    @XmlElementRef(name = "FUNCTION_CODE", type = JAXBElement.class)
    protected JAXBElement<String> functioncode;
    @XmlElementRef(name = "FUNCTION_CODE_SYSTEM", type = JAXBElement.class)
    protected JAXBElement<String> functioncodesystem;
    @XmlElementRef(name = "FUNCTION_CODE_NAME", type = JAXBElement.class)
    protected JAXBElement<String> functioncodename;
    @XmlElementRef(name = "PROVIDER_EUID", type = JAXBElement.class)
    protected JAXBElement<String> providereuid;
    @XmlElementRef(name = "PERSON_FIRST_NAME", type = JAXBElement.class)
    protected JAXBElement<String> personfirstname;
    @XmlElementRef(name = "PERSON_PREFIX", type = JAXBElement.class)
    protected JAXBElement<String> personprefix;
    @XmlElementRef(name = "PERSON_LAST_NAME", type = JAXBElement.class)
    protected JAXBElement<String> personlastname;
    @XmlElementRef(name = "SOFTWARE_NAME", type = JAXBElement.class)
    protected JAXBElement<String> softwarename;
    @XmlElement(name = "PROVIDER_TYPE_CODE", required = true)
    protected String providertypecode;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the encounterid property.
     * 
     */
    public int getENCOUNTERID() {
        return encounterid;
    }

    /**
     * Sets the value of the encounterid property.
     * 
     */
    public void setENCOUNTERID(int value) {
        this.encounterid = value;
    }

    /**
     * Gets the value of the provideroid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVIDEROID() {
        return provideroid;
    }

    /**
     * Sets the value of the provideroid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVIDEROID(String value) {
        this.provideroid = value;
    }

    /**
     * Gets the value of the eventstartdatetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTSTARTDATETIME() {
        return eventstartdatetime;
    }

    /**
     * Sets the value of the eventstartdatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTSTARTDATETIME(String value) {
        this.eventstartdatetime = value;
    }

    /**
     * Gets the value of the eventenddatetime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEVENTENDDATETIME() {
        return eventenddatetime;
    }

    /**
     * Sets the value of the eventenddatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEVENTENDDATETIME(JAXBElement<XMLGregorianCalendar> value) {
        this.eventenddatetime = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the organizationoid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getORGANIZATIONOID() {
        return organizationoid;
    }

    /**
     * Sets the value of the organizationoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setORGANIZATIONOID(JAXBElement<String> value) {
        this.organizationoid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the organizationname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getORGANIZATIONNAME() {
        return organizationname;
    }

    /**
     * Sets the value of the organizationname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setORGANIZATIONNAME(JAXBElement<String> value) {
        this.organizationname = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the performertypecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERFORMERTYPECODE() {
        return performertypecode;
    }

    /**
     * Sets the value of the performertypecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERFORMERTYPECODE(String value) {
        this.performertypecode = value;
    }

    /**
     * Gets the value of the functioncode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFUNCTIONCODE() {
        return functioncode;
    }

    /**
     * Sets the value of the functioncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFUNCTIONCODE(JAXBElement<String> value) {
        this.functioncode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the functioncodesystem property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFUNCTIONCODESYSTEM() {
        return functioncodesystem;
    }

    /**
     * Sets the value of the functioncodesystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFUNCTIONCODESYSTEM(JAXBElement<String> value) {
        this.functioncodesystem = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the functioncodename property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFUNCTIONCODENAME() {
        return functioncodename;
    }

    /**
     * Sets the value of the functioncodename property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFUNCTIONCODENAME(JAXBElement<String> value) {
        this.functioncodename = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the providereuid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPROVIDEREUID() {
        return providereuid;
    }

    /**
     * Sets the value of the providereuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPROVIDEREUID(JAXBElement<String> value) {
        this.providereuid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the personfirstname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPERSONFIRSTNAME() {
        return personfirstname;
    }

    /**
     * Sets the value of the personfirstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPERSONFIRSTNAME(JAXBElement<String> value) {
        this.personfirstname = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the personprefix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPERSONPREFIX() {
        return personprefix;
    }

    /**
     * Sets the value of the personprefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPERSONPREFIX(JAXBElement<String> value) {
        this.personprefix = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the personlastname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPERSONLASTNAME() {
        return personlastname;
    }

    /**
     * Sets the value of the personlastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPERSONLASTNAME(JAXBElement<String> value) {
        this.personlastname = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the softwarename property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSOFTWARENAME() {
        return softwarename;
    }

    /**
     * Sets the value of the softwarename property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSOFTWARENAME(JAXBElement<String> value) {
        this.softwarename = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the providertypecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVIDERTYPECODE() {
        return providertypecode;
    }

    /**
     * Sets the value of the providertypecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVIDERTYPECODE(String value) {
        this.providertypecode = value;
    }

}
