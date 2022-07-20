package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.entity.OrderDetails;
import com.example.bookstore.entity.Orders;
import com.example.bookstore.entity.Products;
import com.example.bookstore.service.OrderService;
import com.example.bookstore.ulti.PaymentJAXBParser;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
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
    public Orders getOrders() {
        return jaxbParser.getListOrderFromXML();
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
    public void update(Orders orders) {
        try {
            jaxbParser.writeOrdersToXml(orders);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
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
