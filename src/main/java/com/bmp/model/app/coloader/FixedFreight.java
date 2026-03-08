package com.bmp.model.app.coloader;

import java.io.Serializable;

public class FixedFreight implements Serializable {
	
	private static final long serialVersionUID = -4783120485087187138L;
	private Double baseKM;
	private Double baseRate;
	private Double incrementalKM;
	private Double incrementalRate;
	private Double baseHours;
	private Double baseHoursRate;
	private Double incrementalHours;
	private Double incrementalHoursRate;
	
	public FixedFreight() {
		
	}

	public Double getBaseKM() {
		return baseKM;
	}

	public void setBaseKM(Double baseKM) {
		this.baseKM = baseKM;
	}

	public Double getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(Double baseRate) {
		this.baseRate = baseRate;
	}

	public Double getIncrementalKM() {
		return incrementalKM;
	}

	public void setIncrementalKM(Double incrementalKM) {
		this.incrementalKM = incrementalKM;
	}

	public Double getIncrementalRate() {
		return incrementalRate;
	}

	public void setIncrementalRate(Double incrementalRate) {
		this.incrementalRate = incrementalRate;
	}

	public Double getBaseHours() {
		return baseHours;
	}

	public void setBaseHours(Double baseHours) {
		this.baseHours = baseHours;
	}

	public Double getBaseHoursRate() {
		return baseHoursRate;
	}

	public void setBaseHoursRate(Double baseHoursRate) {
		this.baseHoursRate = baseHoursRate;
	}

	public Double getIncrementalHours() {
		return incrementalHours;
	}

	public void setIncrementalHours(Double incrementalHours) {
		this.incrementalHours = incrementalHours;
	}

	public Double getIncrementalHoursRate() {
		return incrementalHoursRate;
	}

	public void setIncrementalHoursRate(Double incrementalHoursRate) {
		this.incrementalHoursRate = incrementalHoursRate;
	}
}
