package com.example.bookstore.service;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.entity.OrderDetails;
import com.example.bookstore.entity.Orders;
import com.example.bookstore.entity.Products;

import java.util.List;

public interface OrderService {
    public Orders.Order getOrder(int OrderId);
    public List<OrderDetails.OrderDetail> getOrderDetailByOrder(int orderId);
    public Orders updateOrder(String userId);

    public List<Products.Product> getProductByOrder(List<OrderDetails.OrderDetail> orderDetails);

    public Orders addOrder();

    public Accounts.Account getAccountById(int id);
}
