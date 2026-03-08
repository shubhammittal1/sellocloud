package com.bmp.model.app.masters;

import com.bmp.model.app.facility.Branch;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceProvider {
	
	private String courierKey; 
	private int prepaid;
	private int postpaid;
	private int air;
	private int surface;
	private String productCodes;
	private Branch controllingbranch;
	private String clientCode;
	private int pickupAvailable;
	private int dropAvailable;
	private Boolean expired;
	private Long createdDate;
    private Long modifiedDate;
    private String createdBy;
    private String updatedBy;
    private String serviceLevels;
    
    private String pincodeGroup;
    private String north;
    private String east;
    private String west;
    private String south;
    private String other;
    private int oda;
    
	public ServiceProvider() {
		super();
	}

	public String getCourierKey() {
		return courierKey;
	}

	public void setCourierKey(String courierKey) {
		this.courierKey = courierKey;
	}

	public String getProductCodes() {
		return productCodes;
	}

	public void setProductCodes(String productCodes) {
		this.productCodes = productCodes;
	}

	public Branch getControllingbranch() {
		return controllingbranch;
	}

	public void setControllingbranch(Branch controllingbranch) {
		this.controllingbranch = controllingbranch;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getPrepaid() {
		return prepaid;
	}

	public int getPostpaid() {
		return postpaid;
	}

	public int getAir() {
		return air;
	}

	public int getSurface() {
		return surface;
	}

	public int getPickupAvailable() {
		return pickupAvailable;
	}

	public int getDropAvailable() {
		return dropAvailable;
	}

	public Boolean getExpired() {
		return expired;
	}

	public void setPrepaid(int prepaid) {
		this.prepaid = prepaid;
	}

	public void setPostpaid(int postpaid) {
		this.postpaid = postpaid;
	}

	public void setAir(int air) {
		this.air = air;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public void setPickupAvailable(int pickupAvailable) {
		this.pickupAvailable = pickupAvailable;
	}

	public void setDropAvailable(int dropAvailable) {
		this.dropAvailable = dropAvailable;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}

	public String getServiceLevels() {
		return serviceLevels;
	}

	public void setServiceLevels(String serviceLevels) {
		this.serviceLevels = serviceLevels;
	}

	public String getPincodeGroup() {
		return pincodeGroup;
	}

	public void setPincodeGroup(String pincodeGroup) {
		this.pincodeGroup = pincodeGroup;
	}

	public String getNorth() {
		return north;
	}

	public void setNorth(String north) {
		this.north = north;
	}

	public String getEast() {
		return east;
	}

	public void setEast(String east) {
		this.east = east;
	}

	public String getWest() {
		return west;
	}

	public void setWest(String west) {
		this.west = west;
	}

	public String getSouth() {
		return south;
	}

	public void setSouth(String south) {
		this.south = south;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getOda() {
		return oda;
	}

	public void setOda(int oda) {
		this.oda = oda;
	}

}