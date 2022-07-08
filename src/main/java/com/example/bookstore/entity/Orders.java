
package com.example.bookstore.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="Order" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="accountID" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="orderDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "order"
})
@XmlRootElement(name = "Orders")
public class Orders {

    @XmlElement(name = "Order", required = true)
    protected List<Orders.Order> order;

    /**
     * Gets the value of the order property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the order property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Orders.Order }
     * 
     * 
     */
    public List<Orders.Order> getOrder() {
        if (order == null) {
            order = new ArrayList<Orders.Order>();
        }
        return this.order;
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
     *         &lt;element name="accountID" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="orderDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "accountID",
        "orderDate",
        "totalPrice",
        "note"
    })
    public static class Order {

        @XmlSchemaType(name = "unsignedByte")
        protected short accountID;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar orderDate;
        @XmlSchemaType(name = "unsignedShort")
        protected int totalPrice;
        protected String note;
        @XmlAttribute(name = "ID", required = true)
        @XmlSchemaType(name = "unsignedByte")
        protected short id;

        /**
         * Gets the value of the accountID property.
         * 
         */
        public short getAccountID() {
            return accountID;
        }

        /**
         * Sets the value of the accountID property.
         * 
         */
        public void setAccountID(short value) {
            this.accountID = value;
        }

        /**
         * Gets the value of the orderDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getOrderDate() {
            return orderDate;
        }

        /**
         * Sets the value of the orderDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setOrderDate(XMLGregorianCalendar value) {
            this.orderDate = value;
        }

        /**
         * Gets the value of the totalPrice property.
         * 
         */
        public int getTotalPrice() {
            return totalPrice;
        }

        /**
         * Sets the value of the totalPrice property.
         * 
         */
        public void setTotalPrice(int value) {
            this.totalPrice = value;
        }

        /**
         * Gets the value of the note property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNote() {
            return note;
        }

        /**
         * Sets the value of the note property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNote(String value) {
            this.note = value;
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
