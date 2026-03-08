package com.bmp.model.app.incentive;

import java.util.Map;

public class FuelIncentive {

	private Map<String, FuelBean> drsMap;
	private Map<String, FuelBean> pickMap;
	private Integer totalKms;
	private Double amount;
	
	public FuelIncentive(){
		super();
	}
	
	public Map<String, FuelBean> getDrsMap() {
		return drsMap;
	}
	public Map<String, FuelBean> getPickMap() {
		return pickMap;
	}
	public Integer getTotalKms() {
		return totalKms;
	}
	public Double getAmount() {
		return amount;
	}
	public void setDrsMap(Map<String, FuelBean> drsMap) {
		this.drsMap = drsMap;
	}
	public void setPickMap(Map<String, FuelBean> pickMap) {
		this.pickMap = pickMap;
	}
	public void setTotalKms(Integer totalKms) {
		this.totalKms = totalKms;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
