package com.bmp.model.app.client;

import java.io.Serializable;

public class FlatFreight implements Serializable {
	
	private static final long serialVersionUID = 7342286241945454318L;

	private Double baseWeight;
	private Double baseRate;
	private Double baseCharge;
	private Double incrementalWeight;
	private Double incrementalRate;
	
	public FlatFreight(){}
	
	public Double getBaseWeight() {
		return baseWeight;
	}
	public void setBaseWeight(Double baseWeight) {
		this.baseWeight = baseWeight;
	}
	public Double getBaseRate() {
		return baseRate;
	}
	public void setBaseRate(Double baseRate) {
		this.baseRate = baseRate;
	}
	public Double getIncrementalWeight() {
		return incrementalWeight;
	}
	public void setIncrementalWeight(Double incrementalWeight) {
		this.incrementalWeight = incrementalWeight;
	}
	public Double getIncrementalRate() {
		return incrementalRate;
	}
	public void setIncrementalRate(Double incrementalRate) {
		this.incrementalRate = incrementalRate;
	}

	public Double getBaseCharge() {
		return baseCharge;
	}

	public void setBaseCharge(Double baseCharge) {
		this.baseCharge = baseCharge;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
