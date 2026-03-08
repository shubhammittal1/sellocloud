package com.bmp.model.app.wms;

import com.bmp.constant.LocationType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="warehouseLocation")
@AssignKey(assvalue=true)
public class WarehouseLocationMaster extends MongoBaseBean implements Serializable {


    private String locationCode;
    private String locationName;
    @Indexed
    private String clientKey;
    @Indexed
    private String warehouseKey;
    private Long locationCapacity;
    private LocationType locationType;
    @Indexed
    private boolean isVirtualLocation = false;

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getWarehouseKey() {
        return warehouseKey;
    }

    public void setWarehouseKey(String warehouseKey) {
        this.warehouseKey = warehouseKey;
    }

    public Long getLocationCapacity() {
        return locationCapacity;
    }

    public void setLocationCapacity(Long locationCapacity) {
        this.locationCapacity = locationCapacity;
    }

	public boolean isVirtualLocation() {
		return isVirtualLocation;
	}

	public void setVirtualLocation(boolean isVirtualLocation) {
		this.isVirtualLocation = isVirtualLocation;
	}

}
