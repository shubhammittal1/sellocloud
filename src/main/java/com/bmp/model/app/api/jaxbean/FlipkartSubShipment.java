package com.bmp.model.app.api.jaxbean;

public class FlipkartSubShipment {

    private String subShipment;
    private Dimensions dimensions;

    public String getSubShipment() {
        return subShipment;
    }
    public void setSubShipment(String subShipment) {
        this.subShipment = subShipment;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
