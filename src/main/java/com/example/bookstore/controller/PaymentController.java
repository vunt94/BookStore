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

    private final int ORDER_DEMO_ID = 1;
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private OrderService orderService;

    @GetMapping("payment")
    public String index(HttpServletRequest request) {
    //  TODO: Account get from session
        Accounts.Account acc = orderService.getAccountById(ORDER_DEMO_ID);
        Shipments.Shipment shipmentsByUserId = shipmentService.getShipmentsByOrderId(ORDER_DEMO_ID);
        Orders.Order order = orderService.getOrder(ORDER_DEMO_ID);
        List<OrderDetails.OrderDetail> orderDetail = orderService.getOrderDetailByOrder(ORDER_DEMO_ID);
        List<Products.Product> productByOrder = orderService.getProductByOrder(orderDetail);
        request.setAttribute("shipmentsByUserId",shipmentsByUserId);
        request.setAttribute("orderDetailByOrder", orderDetail);
        request.setAttribute("productByOrder",productByOrder);
        request.setAttribute("account",acc);
        request.setAttribute("order",order);
        return "payment";
    }


}
