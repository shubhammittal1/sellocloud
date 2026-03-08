package com.bmp.model.app.client;

import java.io.Serializable;

public class ClientRate implements Serializable {

	private static final long serialVersionUID = -5537796509740841356L;
	
	private String contractStartDate;
	private String contractEndDate;
	private String productType;
	private String rateZoneTempleate;
	
	public ClientRate() {}

	public String getContractStartDate() {
		return contractStartDate;
	}

	public String getContractEndDate() {
		return contractEndDate;
	}

	public String getProductType() {
		return productType;
	}

	public String getRateZoneTempleate() {
		return rateZoneTempleate;
	}

	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setRateZoneTempleate(String rateZoneTempleate) {
		this.rateZoneTempleate = rateZoneTempleate;
	}
	
}
