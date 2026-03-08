package com.bmp.bean.saleorder;

import java.util.Set;

import com.bmp.bean.client.ClientWarehouseApiBean;

public class PickupRequestApiBean {
	
	private String pickupId;
	private String pickupDateTime;
	private ClientWarehouseApiBean warehouse;
	private Integer expectedPackageCount;
	private String clientKey;
	private Set<String> awbNumbers;
	private String manifestNo;

	public String getPickupId() {
		return pickupId;
	}
	public void setPickupId(String pickupId) {
		this.pickupId = pickupId;
	}
	public String getPickupDateTime() {
		return pickupDateTime;
	}
	public void setPickupDateTime(String pickupDateTime) {
		this.pickupDateTime = pickupDateTime;
	}
	public Integer getExpectedPackageCount() {
		return expectedPackageCount;
	}
	public void setExpectedPackageCount(Integer expectedPackageCount) {
		this.expectedPackageCount = expectedPackageCount;
	}
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public Set<String> getAwbNumbers() {
		return awbNumbers;
	}
	public void setAwbNumbers(Set<String> awbNumbers) {
		this.awbNumbers = awbNumbers;
	}
	public String getManifestNo() {
		return manifestNo;
	}
	public void setManifestNo(String manifestNo) {
		this.manifestNo = manifestNo;
	}
	public ClientWarehouseApiBean getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(ClientWarehouseApiBean warehouse) {
		this.warehouse = warehouse;
	}

}
