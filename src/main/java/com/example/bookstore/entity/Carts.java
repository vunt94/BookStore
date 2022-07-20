
package com.example.bookstore.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="Cart" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                 &lt;/sequence>
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
    "cart"
})
@XmlRootElement(name = "Carts")
public class Carts {

    @XmlElement(name = "Cart", required = true)
    protected List<Carts.Cart> cart;

    /**
     * Gets the value of the cart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Carts.Cart }
     * 
     * 
     */
    public List<Carts.Cart> getCart() {
        if (cart == null) {
            cart = new ArrayList<Carts.Cart>();
        }
        return this.cart;
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
     *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
        "accountId",
        "productId",
        "name",
        "quantity",
        "image",
        "price"
    })
    public static class Cart {

        @XmlSchemaType(name = "unsignedByte")
        protected short accountId;
        @XmlSchemaType(name = "unsignedByte")
        protected short productId;
        @XmlElement(required = true)
        protected String name;
        @XmlSchemaType(name = "unsignedByte")
        protected short quantity;
        @XmlElement(required = true)
        protected String image;
        @XmlSchemaType(name = "unsignedByte")
        protected short price;

        /**
         * Gets the value of the accountId property.
         * 
         */
        public short getAccountId() {
            return accountId;
        }

        /**
         * Sets the value of the accountId property.
         * 
         */
        public void setAccountId(short value) {
            this.accountId = value;
        }

        /**
         * Gets the value of the productId property.
         * 
         */
        public short getProductId() {
            return productId;
        }

        /**
         * Sets the value of the productId property.
         * 
         */
        public void setProductId(short value) {
            this.productId = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
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
         * Gets the value of the image property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getImage() {
            return image;
        }

        /**
         * Sets the value of the image property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setImage(String value) {
            this.image = value;
        }

        /**
         * Gets the value of the price property.
         * 
         */
        public short getPrice() {
            return price;
        }

        /**
         * Sets the value of the price property.
         * 
         */
        public void setPrice(short value) {
            this.price = value;
        }

    }

}
