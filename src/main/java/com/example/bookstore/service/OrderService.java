package com.example.bookstore.service;

import com.example.bookstore.entity.OrderDetails;
import com.example.bookstore.entity.Orders;

public interface OrderService {
    public Orders getOrder(String userId);
    public OrderDetails getOrderDetail(String userId, String orderId);
    public Orders updateOrder(String userId);


}
