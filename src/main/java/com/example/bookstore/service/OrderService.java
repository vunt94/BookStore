package com.example.bookstore.service;

import com.example.bookstore.entity.*;

import java.util.List;
import java.util.Map;

public interface OrderService {
    public Orders.Order getOrder(int OrderId);
    public Orders getOrdersByUserId(int id);
    public List<OrderDetails.OrderDetail> getOrderDetailByOrder(int orderId);
    public Orders updateOrder(String userId);

    public Map<OrderDetails.OrderDetail,Products.Product> getProductByOrder(List<OrderDetails.OrderDetail> orderDetails);

    public Orders addOrder();
    public int update(List<Carts.Cart> list);

    public Accounts.Account getAccountById(int id);
}
