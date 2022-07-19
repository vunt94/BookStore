package com.example.bookstore.service;

import com.example.bookstore.entity.Shipments;

import java.util.List;

public interface ShipmentService {
    public Shipments.Shipment getShipmentsByOrderId(int orderId);
    public Shipments addShipments(Shipments.Shipment shipments);
    public Shipments deteleShipment(Shipments shipments);
    public Shipments updateShipment(Shipments.Shipment shipments);

}
