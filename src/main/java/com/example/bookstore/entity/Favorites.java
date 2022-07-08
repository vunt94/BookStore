
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
 *         &lt;element name="Favorite" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
    "favorite"
})
@XmlRootElement(name = "Favorites")
public class Favorites {

    @XmlElement(name = "Favorite", required = true)
    protected List<Favorites.Favorite> favorite;

    /**
     * Gets the value of the favorite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the favorite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFavorite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Favorites.Favorite }
     * 
     * 
     */
    public List<Favorites.Favorite> getFavorite() {
        if (favorite == null) {
            favorite = new ArrayList<Favorites.Favorite>();
        }
        return this.favorite;
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
     *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
        "productId",
        "accountId"
    })
    public static class Favorite {

        @XmlSchemaType(name = "unsignedByte")
        protected short productId;
        @XmlSchemaType(name = "unsignedByte")
        protected short accountId;

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

    }

}
