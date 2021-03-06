
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkFKIntegrity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkFKIntegrity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.talend.com/mdm}WSDeleteItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkFKIntegrity", propOrder = {
    "arg0"
})
public class CheckFKIntegrity {

    protected WSDeleteItem arg0;

    /**
     * Default no-arg constructor
     * 
     */
    public CheckFKIntegrity() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public CheckFKIntegrity(final WSDeleteItem arg0) {
        this.arg0 = arg0;
    }

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link WSDeleteItem }
     *     
     */
    public WSDeleteItem getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSDeleteItem }
     *     
     */
    public void setArg0(WSDeleteItem value) {
        this.arg0 = value;
    }

}
