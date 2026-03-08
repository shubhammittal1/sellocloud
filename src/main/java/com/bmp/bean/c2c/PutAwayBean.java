package com.bmp.bean.c2c;

import com.bmp.constant.LocationType;
import com.bmp.constant.PutAwayType;

public class PutAwayBean{
    private String location;
    private String clientKey;
    private LocationType locationType;
    private String warehouseKey;
    private String skuCode;
    private int qty;
    private PutAwayType putAwayType ;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public String getWarehouseKey() {
        return warehouseKey;
    }

    public void setWarehouseKey(String warehouseKey) {
        this.warehouseKey = warehouseKey;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

	public PutAwayType getPutAwayType() {
		return putAwayType;
	}

	public void setPutAwayType(PutAwayType putAwayType) {
		this.putAwayType = putAwayType;
	}
}
