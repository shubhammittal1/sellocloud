package com.bmp.model.app.coloader;

import java.io.Serializable;

public class FlatFreight implements Serializable {

	private static final long serialVersionUID = 886123743776781453L;
	
	private Double baseWeight;
	private Double baseRate;
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

}
