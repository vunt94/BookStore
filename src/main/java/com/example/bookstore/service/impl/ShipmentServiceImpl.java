package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Orders;
import com.example.bookstore.entity.Shipments;
import com.example.bookstore.service.ShipmentService;
import com.example.bookstore.ulti.PaymentJAXBParser;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    PaymentJAXBParser jaxbParser = new PaymentJAXBParser();
    @Override
    public Shipments.Shipment getShipmentsByOrderId(int orderId) {
        List<Shipments.Shipment> shipmentsByJAXB = jaxbParser.getShipmentsByJAXB();
        List<Shipments.Shipment> shipments = new ArrayList<>();

        for (Shipments.Shipment shipment: shipmentsByJAXB
             ) {
            if(shipment.getOrderId() == orderId){
                return shipment;
            }
        }
        return null;
    }

    @Override
    public Shipments addShipments(Shipments.Shipment shipment) {
        List<Shipments.Shipment> shipments = jaxbParser.getShipmentsByJAXB();
        shipments.add(shipment);
        jaxbParser.writeFavoriteProductToXML(shipments);
        return null;
    }

    @Override
    public Shipments deteleShipment(Shipments shipments) {
        return null;
    }

    @Override
    public void updateShipment( String address, Orders ordersByUserId) {
        Shipments listShipmentFromXML = jaxbParser.getListShipmentFromXML();
        Shipments.Shipment shipment = new Shipments.Shipment();
        shipment.setOrderId(Short.parseShort(ordersByUserId.getOrder().get(0).getId()+""));
        shipment.setID(Short.parseShort((listShipmentFromXML.getShipment().size()+1)+""));
        shipment.setShippingAddress(address);
        listShipmentFromXML.getShipment().add(shipment);
        try {
            jaxbParser.writeShipmentToXml(listShipmentFromXML);
        }catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
