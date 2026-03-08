package com.bmp.model.app.incentive;

public class FuelBean {
	
	private Integer startKm;
	private Integer endKm;
	private Integer totalKms;
	private Double amount;
	
	
	public FuelBean(){
		super();
	}
	
	public Integer getTotalKms() {
		return totalKms;
	}
	public Double getAmount() {
		return amount;
	}
	public void setTotalKms(Integer totalKms) {
		this.totalKms = totalKms;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getStartKm() {
		return startKm;
	}

	public void setStartKm(Integer startKm) {
		this.startKm = startKm;
	}

	public Integer getEndKm() {
		return endKm;
	}

	public void setEndKm(Integer endKm) {
		this.endKm = endKm;
	}
	
}
