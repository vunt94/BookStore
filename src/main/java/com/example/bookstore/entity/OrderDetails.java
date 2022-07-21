
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
 *         &lt;element name="Order_detail" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="orderID" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="productID" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="subPrice" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
    "orderDetail"
})
@XmlRootElement(name = "Order_details")
public class OrderDetails {

    @XmlElement(name = "Order_detail", required = true)
    protected List<OrderDetails.OrderDetail> orderDetail;

    /**
     * Gets the value of the orderDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderDetails.OrderDetail }
     * 
     * 
     */
    public List<OrderDetails.OrderDetail> getOrderDetail() {
        if (orderDetail == null) {
            orderDetail = new ArrayList<OrderDetails.OrderDetail>();
        }
        return this.orderDetail;
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
     *         &lt;element name="orderID" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="productID" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="subPrice" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
        "orderID",
        "productID",
        "subPrice",
        "quantity"
    })
    public static class OrderDetail {

        @XmlSchemaType(name = "unsignedByte")
        protected int orderID;
        @XmlSchemaType(name = "unsignedByte")
        protected short productID;
        @XmlSchemaType(name = "unsignedShort")
        protected int subPrice;
        @XmlSchemaType(name = "unsignedByte")
        protected short quantity;
        @XmlAttribute(name = "ID", required = true)
        @XmlSchemaType(name = "unsignedByte")
        protected int id;

        /**
         * Gets the value of the orderID property.
         * 
         */
        public int getOrderID() {
            return orderID;
        }

        /**
         * Sets the value of the orderID property.
         * 
         */
        public void setOrderID(int value) {
            this.orderID = value;
        }

        /**
         * Gets the value of the productID property.
         * 
         */
        public short getProductID() {
            return productID;
        }

        /**
         * Sets the value of the productID property.
         * 
         */
        public void setProductID(short value) {
            this.productID = value;
        }

        /**
         * Gets the value of the subPrice property.
         * 
         */
        public int getSubPrice() {
            return subPrice;
        }

        /**
         * Sets the value of the subPrice property.
         * 
         */
        public void setSubPrice(int value) {
            this.subPrice = value;
        }

        /**
         * Gets the value of the quantity property.
         * 
         */
        public short getQuantity() {
            return quantity;
        }

        /**
         * Sets the value of the quantity property.
         * 
         */
        public void setQuantity(short value) {
            this.quantity = value;
        }

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

    }

}
