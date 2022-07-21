package com.example.bookstore.service.impl;

import com.example.bookstore.entity.*;
import com.example.bookstore.service.OrderService;
import com.example.bookstore.ulti.PaymentJAXBParser;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    PaymentJAXBParser jaxbParser = new PaymentJAXBParser();
    @Override
    public Orders.Order getOrder(int orderId) {
        Orders listOrderFromXML = jaxbParser.getListOrderFromXML();
        for (Orders.Order order: listOrderFromXML.getOrder()
             ) {
            if(order.getId()==orderId){
                return order;
            }
        }
        return null;
    }

    @Override
    public Orders getOrdersByUserId(int id) {
        Orders listOrderFromXML = jaxbParser.getListOrderFromXML();
        Orders listOrderByUserId = new Orders();
        for (Orders.Order or: listOrderFromXML.getOrder()
             ) {
            if(or.getAccountID() == id){
                listOrderByUserId.getOrder().add(or);
            }
        }
        return listOrderByUserId;
    }

    @Override
    public List<OrderDetails.OrderDetail> getOrderDetailByOrder(int orderId) {
        List<OrderDetails.OrderDetail> orderDetailByJAXB = jaxbParser.getOrderDetailByJAXB();
        List<OrderDetails.OrderDetail> orderDetailByOrder = new ArrayList<>();
        for (OrderDetails.OrderDetail orderDetail: orderDetailByJAXB) {
            if(orderDetail.getOrderID() == orderId){
                orderDetailByOrder.add(orderDetail);
            }
        }
        return orderDetailByOrder;
    }

    @Override
    public Orders updateOrder(String userId) {
        return null;
    }

    @Override
    public Map<OrderDetails.OrderDetail, Products.Product> getProductByOrder(List<OrderDetails.OrderDetail> orderDetails) {
        List<Products.Product> productByOrderByJAXB = jaxbParser.getProductByOrderByJAXB();
        Map<OrderDetails.OrderDetail, Products.Product> productsByOrder = new HashMap<>();
        for (Products.Product product: productByOrderByJAXB
             ) {
            for (OrderDetails.OrderDetail orderDetail : orderDetails
            ){
                if(product.getID() == orderDetail.getProductID()){
                    productsByOrder.put(orderDetail,product);
                }
            }
        }
        return productsByOrder;
    }

    @Override
    public Orders addOrder() {
        return null;
    }

    @Override
    public int update(List<Carts.Cart> list) {

        Orders listOrderFromXML = jaxbParser.getListOrderFromXML();

        Orders.Order order = new Orders.Order();
        order.setId(listOrderFromXML.getOrder().size()+1);
        OrderDetails orderDetails = jaxbParser.getListOrderDetailFromXML();

        int totalMoney=10;
        try {
        for (Carts.Cart cart: list
             ) {
            totalMoney+=cart.getPrice()*cart.getQuantity();
            order.setAccountID(cart.getAccountId());
            order.setOrderDate("21-07-2022");
            order.setTotalPrice(0);
            OrderDetails.OrderDetail orderDetail = new OrderDetails.OrderDetail();
            orderDetail.setID(orderDetails.getOrderDetail().size()+1);
            orderDetail.setOrderID(order.getId());
            orderDetail.setProductID(cart.getProductId());
            orderDetail.setQuantity(cart.getQuantity());
            orderDetail.setSubPrice(cart.getPrice()*cart.getQuantity());
            orderDetails.getOrderDetail().add(orderDetail);
            jaxbParser.writeOrdersDetailToXml(orderDetails);

        }

        order.setTotalPrice(totalMoney);
        listOrderFromXML.getOrder().add(order);




            jaxbParser.writeOrdersToXml(listOrderFromXML);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return order.getId();
    }

    @Override
    public Accounts.Account getAccountById(int id) {
        Accounts listAccountFromXML = jaxbParser.getListAccountFromXML();
        for (Accounts.Account acc:listAccountFromXML.getAccount()
             ) {
            if(acc.getID()==id){
                return acc;
            }
        }
        return null;
    }
}
