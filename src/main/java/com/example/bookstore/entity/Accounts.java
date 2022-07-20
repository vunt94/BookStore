
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
 *         &lt;element name="Account" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="isAdmin" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "account"
})
@XmlRootElement(name = "Accounts")
public class Accounts {

    @XmlElement(name = "Account", required = true)
    protected List<Accounts.Account> account;


    public Accounts() {
    }


    public Accounts(List<Account> account) {
        this.account = account;
    }

    /**
     * Gets the value of the account property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Accounts.Account }
     */
    public List<Accounts.Account> getAccount() {
        if (account == null) {
            account = new ArrayList<Accounts.Account>();
        }
        return this.account;
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
     *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="isAdmin" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *       &lt;/sequence>
     *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "userName",
            "password",
            "phoneNumber",
            "isAdmin"
    })
    public static class Account {

        @XmlElement(required = true)
        protected String userName;
        @XmlElement(required = true)
        protected String password;
        @XmlSchemaType(name = "unsignedInt")
        protected String phoneNumber;
        @XmlSchemaType(name = "unsignedByte")
        protected int isAdmin;
        @XmlAttribute(name = "ID", required = true)
        @XmlSchemaType(name = "unsignedByte")
        protected int id;

        /**
         * Gets the value of the userName property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getUserName() {
            return userName;
        }

        /**
         * Sets the value of the userName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setUserName(String value) {
            this.userName = value;
        }

        /**
         * Gets the value of the password property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPassword() {
            return password;
        }

        /**
         * Sets the value of the password property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPassword(String value) {
            this.password = value;
        }

        /**
         * Gets the value of the phoneNumber property.
         */
        public String getPhoneNumber() {
            return phoneNumber;
        }

        /**
         * Sets the value of the phoneNumber property.
         */
        public void setPhoneNumber(String value) {
            this.phoneNumber = value;
        }

        /**
         * Gets the value of the isAdmin property.
         */
        public int getIsAdmin() {
            return isAdmin;
        }

        /**
         * Sets the value of the isAdmin property.
         */
        public void setIsAdmin(int value) {
            this.isAdmin = value;
        }

        /**
         * Gets the value of the id property.
         */
        public int getID() {
            return id;
        }

        /**
         * Sets the value of the id property.
         */
        public void setID(int value) {
            this.id = value;
        }

    }

}
