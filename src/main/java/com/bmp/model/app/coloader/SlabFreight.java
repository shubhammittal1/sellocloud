package com.bmp.model.app.coloader;

import java.io.Serializable;

public class SlabFreight implements Serializable{
	
	private static final long serialVersionUID = 7537278342336712495L;
	
	private Double fromWeight;
	private Double toWeight;
	private Double rate;
	
	public SlabFreight(){}

	public Double getFromWeight() {
		return fromWeight;
	}

	public void setFromWeight(Double fromWeight) {
		this.fromWeight = fromWeight;
	}

	public Double getToWeight() {
		return toWeight;
	}

	public void setToWeight(Double toWeight) {
		this.toWeight = toWeight;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
	
}
