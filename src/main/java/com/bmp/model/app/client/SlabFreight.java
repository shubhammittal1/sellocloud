package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.Map;

public class SlabFreight implements Serializable {
	
	private static final long serialVersionUID = -8575353733352640748L;
	
	private Double fromWeight;
	private Double toWeight;
	private Double incrementalWeight;
	private Double incrementalRate;
	private Double rate;
	private Map<String, Double> zoneRatesMap;
	
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

	public Map<String, Double> getZoneRatesMap() {
		return zoneRatesMap;
	}

	public void setZoneRatesMap(Map<String, Double> zoneRatesMap) {
		this.zoneRatesMap = zoneRatesMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
