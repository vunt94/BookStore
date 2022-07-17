package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Shipments;
import com.example.bookstore.service.ShipmentService;
import com.example.bookstore.ulti.PaymentJAXBParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    PaymentJAXBParser jaxbParser = new PaymentJAXBParser();
    @Override
    public List<Shipments.Shipment> getShipmentsByUserId(String userId) {
        List<Shipments.Shipment> shipmentsByJAXB = jaxbParser.getShipmentsByJAXB();
        List<Shipments.Shipment> shipments = new ArrayList<>();
        for (Shipments.Shipment shipment: shipmentsByJAXB
             ) {
//            if(shipment.get)
        }
        return null;
    }

    @Override
    public Shipments addShipments(Shipments shipments) {
        return null;
    }

    @Override
    public Shipments deteleShipment(Shipments shipments) {
        return null;
    }

    @Override
    public Shipments updateShipment(Shipments.Shipment shipments) {
        return null;
    }
}
