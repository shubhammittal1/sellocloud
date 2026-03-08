package com.bmp.model.app.api.jaxbean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlipkartShipment {
    private String shipmentId;
    private String locationId;
    private List<FlipkartTaxItem> taxItems;
    private List<FlipkartSerialNumber> serialNumbers;
    private List<FlipkartSubShipment> subShipments;
    private List<Invoice> invoices;

    public FlipkartShipment() {
        super();
    }

    public String getShipmentId() {
        return shipmentId;
    }
    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public List<FlipkartTaxItem> getTaxItems() {
        return taxItems;
    }

    public void setTaxItems(List<FlipkartTaxItem> taxItems) {
        this.taxItems = taxItems;
    }

    public List<FlipkartSerialNumber> getSerialNumbers() {
        return serialNumbers;
    }
    public void setSerialNumbers(List<FlipkartSerialNumber> serialNumbers) {
        this.serialNumbers = serialNumbers;
    }

    public List<FlipkartSubShipment> getSubShipments() {
        return subShipments;
    }

    public void setSubShipments(List<FlipkartSubShipment> subShipments) {
        this.subShipments = subShipments;
    }
    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

}
