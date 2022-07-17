package com.example.bookstore.controller;

import com.example.bookstore.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
    @Autowired
    private ShipmentService shipmentService;
    @GetMapping("payment")
    public String index() {
//  TODO: add process to create payment
        return "payment";
    }
}
