//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.10.03 at 04:08:28 PM EDT 
//


package edu.umd.cs.guitar.model.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="InitialMappingList" type="{}InitialMappingListType" minOccurs="0"/>
 *         &lt;element name="EdgeMappingList" type="{}EdgeMappingListType" minOccurs="0"/>
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
    "initialMappingList",
    "edgeMappingList"
})
@XmlRootElement(name = "Mapping")
public class Mapping {

    @XmlElement(name = "InitialMappingList")
    protected InitialMappingListType initialMappingList;
    @XmlElement(name = "EdgeMappingList")
    protected EdgeMappingListType edgeMappingList;

    /**
     * Gets the value of the initialMappingList property.
     * 
     * @return
     *     possible object is
     *     {@link InitialMappingListType }
     *     
     */
    public InitialMappingListType getInitialMappingList() {
        return initialMappingList;
    }

    /**
     * Sets the value of the initialMappingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialMappingListType }
     *     
     */
    public void setInitialMappingList(InitialMappingListType value) {
        this.initialMappingList = value;
    }

    /**
     * Gets the value of the edgeMappingList property.
     * 
     * @return
     *     possible object is
     *     {@link EdgeMappingListType }
     *     
     */
    public EdgeMappingListType getEdgeMappingList() {
        return edgeMappingList;
    }

    /**
     * Sets the value of the edgeMappingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link EdgeMappingListType }
     *     
     */
    public void setEdgeMappingList(EdgeMappingListType value) {
        this.edgeMappingList = value;
    }

}
