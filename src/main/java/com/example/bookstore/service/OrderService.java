package com.example.bookstore.service;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.entity.OrderDetails;
import com.example.bookstore.entity.Orders;
import com.example.bookstore.entity.Products;

import java.util.List;
import java.util.Map;

public interface OrderService {
    public Orders.Order getOrder(int OrderId);
    public Orders getOrdersByUserId(int id);
    public List<OrderDetails.OrderDetail> getOrderDetailByOrder(int orderId);
    public Orders updateOrder(String userId);

    public Map<OrderDetails.OrderDetail,Products.Product> getProductByOrder(List<OrderDetails.OrderDetail> orderDetails);

    public Orders addOrder();
    public void update(Orders orders);

    public Accounts.Account getAccountById(int id);
}
