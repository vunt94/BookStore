package com.example.bookstore.ulti;

import com.example.bookstore.Constant;
import com.example.bookstore.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PaymentJAXBParser {
    public List<Shipments.Shipment> getShipmentsByJAXB() {
        try {
            JAXBContext context = JAXBContext.newInstance(Shipments.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Shipments shipments= (Shipments) unmarshaller.unmarshal(new File("src/main/resources/xml/Shipment.xml"));
            return shipments.getShipment();
        } catch (JAXBException ex) {
            Logger.getLogger(PaymentJAXBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void writeShipmentToXml(Shipments shipments) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Shipments.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(shipments, new File(constant.FavoriteXMLPath));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public List<OrderDetails.OrderDetail> getOrderDetailByJAXB() {
        try {
            JAXBContext context = JAXBContext.newInstance(OrderDetails.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            OrderDetails orders= (OrderDetails) unmarshaller.unmarshal(new File("src/main/resources/xml/OrderDetail.xml"));
            return orders.getOrderDetail();
        } catch (JAXBException ex) {
            Logger.getLogger(PaymentJAXBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Products.Product> getProductByOrderByJAXB() {
        try {
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Products products= (Products) unmarshaller.unmarshal(new File("src/main/resources/xml/Products.xml"));
            return products.getProduct();
        } catch (JAXBException ex) {
            Logger.getLogger(PaymentJAXBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Constant constant = new Constant();

    public void writeProductToFavoriteXML(Favorites.Favorite favorite) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Favorites.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Favorites favoritesCurrently =
                (Favorites) unmarshaller.unmarshal(new File("src/main/resources/xml/FavoritesTest.xml"));
        favoritesCurrently.getFavorite().add(favorite);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(favoritesCurrently, new File("src/main/resources/xml/FavoritesTest.xml"));
    }

    public void deleteProductFromFavoriteXML(int productId, int accId) {
        try {
            JAXBContext context = JAXBContext.newInstance(Favorites.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Favorites favoritesCurrently =
                    (Favorites) unmarshaller.unmarshal(new File("src/main/resources/xml/FavoritesTest.xml"));
            for (int i = 0; i < favoritesCurrently.getFavorite().size(); i++) {
                int pid = (int) favoritesCurrently.getFavorite().get(i).getProductId();
                int aid = (int) favoritesCurrently.getFavorite().get(i).getAccountId();
                if (aid == accId && productId == pid) {
                    favoritesCurrently.getFavorite().remove(i);
                    break;
                }
            }
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(favoritesCurrently, new File("src/main/resources/xml/FavoritesTest.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    public Favorites getListFavoriteFromXML() {

        try {
            JAXBContext context = JAXBContext.newInstance(Favorites.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Favorites favorites =
                    (Favorites) unmarshaller.unmarshal(new File(constant.FavoriteXMLPath));
            return favorites;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFavoriteProductToXML(List<Shipments.Shipment> favorites) {
        try {
            JAXBContext context = JAXBContext.newInstance(Favorites.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(favorites, new File(constant.FavoriteXMLPath));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    public Accounts getListAccountFromXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(Accounts.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Accounts accounts =
                    (Accounts) unmarshaller.unmarshal(new File(constant.AccountXMLPath));
            return accounts;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Orders getListOrderFromXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(Orders.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Orders orders =
                    (Orders) unmarshaller.unmarshal(new File(constant.ORDER_XML_PATH));
            return orders;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeAccountToXML(Accounts.Account account) {
        try {
        JAXBContext context = JAXBContext.newInstance(Accounts.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Accounts accountCurrentList =
                (Accounts) unmarshaller.unmarshal(new File(constant.AccountXMLPath));
        accountCurrentList.getAccount().add(account);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(accountCurrentList, new File(constant.AccountXMLPath));

        } catch (JAXBException e) {
            throw  new RuntimeException(e);
        }
    }

    public Products getListProductFromXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Products products =
                    (Products) unmarshaller.unmarshal(new File(constant.ProductXMLPath));
            return products;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }



}
