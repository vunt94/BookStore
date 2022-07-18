package com.example.bookstore.controller;

import com.example.bookstore.entity.*;
import com.example.bookstore.service.OrderService;
import com.example.bookstore.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private OrderService orderService;

    @Autowired
    HttpServletRequest request;
    @GetMapping("payment")
    public String index() {
//  TODO: add process to create payment
        Accounts.Account acc =orderService.getAccountById(1);
        List<Shipments.Shipment> shipmentsByUserId = shipmentService.getShipmentsByUserId("1");
        Orders.Order order = orderService.getOrder(1);
        List<OrderDetails.OrderDetail> orderDetail = orderService.getOrderDetailByOrder("1");
        List<Products.Product> productByOrder = orderService.getProductByOrder(orderDetail);
        request.setAttribute("shipmentsByUserId",shipmentsByUserId);
        request.setAttribute("orderDetailByOrder", orderDetail);
        request.setAttribute("productByOrder",productByOrder);
        request.setAttribute("account",acc);
        request.setAttribute("order",order);
        return "payment";
    }
}
