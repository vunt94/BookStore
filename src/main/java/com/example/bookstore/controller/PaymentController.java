package com.example.bookstore.controller;

import com.example.bookstore.entity.*;
import com.example.bookstore.service.OrderService;
import com.example.bookstore.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PaymentController {

    private final int ORDER_DEMO_ID = 1;
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private OrderService orderService;
    @Autowired
    HttpSession session;
    @GetMapping("payment")
    public String index(HttpServletRequest request) {
    //  TODO: First time check
        // TODO: account from session
        List<Carts.Cart> list = new ArrayList<>();
        list = (List<Carts.Cart>) session.getAttribute("listCart");
        Accounts.Account acc = orderService.getAccountById(ORDER_DEMO_ID);

        // TODO: list orderdetails from cart
        List<OrderDetails.OrderDetail> orderDetails = orderService.getOrderDetailByOrder(ORDER_DEMO_ID);
        Map<OrderDetails.OrderDetail,Products.Product> productByOrder = orderService.getProductByOrder(orderDetails);
        request.setAttribute("orderDetails", orderDetails);
        request.setAttribute("productByOrder",productByOrder);
        request.setAttribute("account",acc);
        int calculating = 10;
        for (OrderDetails.OrderDetail order: orderDetails
             ) {
            calculating+=order.getSubPrice();
        }
        // TODO: calculate totalprice
        request.setAttribute("totalPrice", calculating);
        return "payment";
    }
    @GetMapping("payment-list")
    public String listOrder(HttpServletRequest request, @RequestParam(name = "userId") int userId) {
    //  TODO: List all order
        Orders ordersByUserId = orderService.getOrdersByUserId(userId);
        Shipments.Shipment shipmentsByOrderId = shipmentService.getShipmentsByOrderId(ordersByUserId.getOrder().get(0).getId());
        request.setAttribute("shipmentsByIdOrder",shipmentsByOrderId);
        request.setAttribute("ordersByUserId",ordersByUserId.getOrder());
        return "payment-list";
    }
    @GetMapping("payment-detail")
    public String detailOrder(HttpServletRequest request, @RequestParam(name = "id") int orderId) {
    //  TODO: view detail of an order
        // TODO: Account get from session
        Accounts.Account acc = orderService.getAccountById(orderId);
        Shipments.Shipment shipmentByUserId = shipmentService.getShipmentsByOrderId(orderId);
        Orders.Order order = orderService.getOrder(orderId);
        List<OrderDetails.OrderDetail> orderDetails = orderService.getOrderDetailByOrder(orderId);
        Map<OrderDetails.OrderDetail,Products.Product> productByOrder = orderService.getProductByOrder(orderDetails);
        int calculating = 10;
        for (OrderDetails.OrderDetail ordersss: orderDetails
        ) {
            calculating+=ordersss.getSubPrice();
        }
        request.setAttribute("shipment",shipmentByUserId);
        request.setAttribute("orderDetails", orderDetails);
        request.setAttribute("productByOrder",productByOrder);
        request.setAttribute("account",acc);
        request.setAttribute("order",order);
        request.setAttribute("totalPrice", calculating);
        return "payment";
    }
    @GetMapping("payment-suscess")
    public String paymentSuscess() {
        // TODO: Add order
//        orderService.addOrder();
//        // TODO: Add shipment
//        shipmentService.addShipments(new Shipments.Shipment());
//        // TODO: Add order detail

        return "paymentSuscess";
    }
    @PostMapping("payment-delete")
    public String deleteOrder(HttpServletRequest request, @RequestParam(name = "id") int orderId) {
    //  TODO: delete an order
        Orders ordersListObj = orderService.getOrdersByUserId(1);
        List<Orders.Order> orders = ordersListObj.getOrder();

        // TODO: calculate totalprice
        for (Orders.Order order:
             orders) {
            if (order.getId() == orderId) {
                orders.remove(order);
                return "payment";
            }
        }
        orderService.update(ordersListObj);
        return "payment";
    }


}
