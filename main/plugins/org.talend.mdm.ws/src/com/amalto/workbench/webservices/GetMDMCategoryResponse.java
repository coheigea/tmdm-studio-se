
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMDMCategoryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMDMCategoryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.talend.com/mdm}WSCategoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMDMCategoryResponse", propOrder = {
    "_return"
})
public class GetMDMCategoryResponse {

    @XmlElement(name = "return")
    protected WSCategoryData _return;

    /**
     * Default no-arg constructor
     * 
     */
    public GetMDMCategoryResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetMDMCategoryResponse(final WSCategoryData _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WSCategoryData }
     *     
     */
    public WSCategoryData getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSCategoryData }
     *     
     */
    public void setReturn(WSCategoryData value) {
        this._return = value;
    }

}
