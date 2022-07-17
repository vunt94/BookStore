package com.example.bookstore.service;

import com.example.bookstore.entity.Shipments;

import java.util.List;

public interface ShipmentService {
    public List<Shipments.Shipment> getShipmentsByUserId(String userId);
    public Shipments addShipments(Shipments shipments);
    public Shipments deteleShipment(Shipments shipments);
    public Shipments updateShipment(Shipments.Shipment shipments);

}
