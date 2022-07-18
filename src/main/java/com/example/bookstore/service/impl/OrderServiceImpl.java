package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.entity.OrderDetails;
import com.example.bookstore.entity.Orders;
import com.example.bookstore.entity.Products;
import com.example.bookstore.service.OrderService;
import com.example.bookstore.ulti.PaymentJAXBParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    PaymentJAXBParser jaxbParser = new PaymentJAXBParser();
    @Override
    public Orders.Order getOrder(int orderId) {
        Orders listOrderFromXML = jaxbParser.getListOrderFromXML();
        for (Orders.Order order: listOrderFromXML.getOrder()
             ) {
            if(order.getID()==orderId){
                return order;
            }
        }
        return null;
    }

    @Override
    public List<OrderDetails.OrderDetail> getOrderDetailByOrder(String orderId) {
        List<OrderDetails.OrderDetail> orderDetailByJAXB = jaxbParser.getOrderDetailByJAXB();
        List<OrderDetails.OrderDetail> orderDetailByOrder = new ArrayList<>();
        int id = Integer.parseInt(orderId);
        for (OrderDetails.OrderDetail orderDetail: orderDetailByJAXB
        ) {
            if(orderDetail.getOrderID()==id){
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
    public List<Products.Product> getProductByOrder(List<OrderDetails.OrderDetail> orderDetails) {
        List<Products.Product> productByOrderByJAXB = jaxbParser.getProductByOrderByJAXB();
        List<Products.Product> productsByOrder = new ArrayList<>();
        for (Products.Product product: productByOrderByJAXB
             ) {
            for (OrderDetails.OrderDetail orderDetail : orderDetails
            ){
                if(product.getID() == orderDetail.getProductID()){
                    productsByOrder.add(product);
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
