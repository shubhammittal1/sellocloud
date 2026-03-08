package com.bmp.model.app.api.jaxbean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlipkartShipmentsBean {
    List<FlipkartShipment> shipments;

    public List<FlipkartShipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<FlipkartShipment> shipments) {
        this.shipments = shipments;
    }

}
