
package com.example.bookstore.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="Shipment" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="shippingAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="shippingCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="shippingType" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
    "shipment"
})
@XmlRootElement(name = "Shipments")
public class Shipments {

    @XmlElement(name = "Shipment", required = true)
    protected List<Shipments.Shipment> shipment;

    /**
     * Gets the value of the shipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shipments.Shipment }
     * 
     * 
     */
    public List<Shipments.Shipment> getShipment() {
        if (shipment == null) {
            shipment = new ArrayList<Shipments.Shipment>();
        }
        return this.shipment;
    }


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
     *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="shippingAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="shippingCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="shippingType" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *       &lt;/sequence>
     *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "userId",
        "orderId",
        "shippingAddress",
        "shippingCost",
        "shippingType"
    })
    public static class Shipment {
        @XmlSchemaType(name = "unsignedByte")
        protected int userId;
        @XmlSchemaType(name = "unsignedByte")
        protected short orderId;
        @XmlElement(required = true)
        protected String shippingAddress;
        @XmlElement(required = true)
        protected BigDecimal shippingCost;
        @XmlSchemaType(name = "unsignedByte")
        protected short shippingType;
        @XmlAttribute(name = "ID", required = true)
        @XmlSchemaType(name = "unsignedByte")
        protected short id;

        /**
         * Gets the value of the orderId property.
         * 
         */
        public short getOrderId() {
            return orderId;
        }

        public int getUserId() {
            return userId;
        }

        /**
         * Sets the value of the orderId property.
         * 
         */
        public void setOrderId(short value) {
            this.orderId = value;
        }
        public void setUserId(int value) {
            this.userId = value;
        }

        /**
         * Gets the value of the shippingAddress property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getShippingAddress() {
            return shippingAddress;
        }

        /**
         * Sets the value of the shippingAddress property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setShippingAddress(String value) {
            this.shippingAddress = value;
        }

        /**
         * Gets the value of the shippingCost property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getShippingCost() {
            return shippingCost;
        }

        /**
         * Sets the value of the shippingCost property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setShippingCost(BigDecimal value) {
            this.shippingCost = value;
        }

        /**
         * Gets the value of the shippingType property.
         * 
         */
        public short getShippingType() {
            return shippingType;
        }

        /**
         * Sets the value of the shippingType property.
         * 
         */
        public void setShippingType(short value) {
            this.shippingType = value;
        }

        /**
         * Gets the value of the id property.
         * 
         */
        public short getID() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         */
        public void setID(short value) {
            this.id = value;
        }

    }

}
