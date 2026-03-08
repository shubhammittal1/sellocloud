package com.bmp.bean.incentive;

public class IncentiveExcelBean {

	private String key;
	private String type;
	private String startKm;
	private String endKm;
	private String source;
	private String reqShipkey;
	private double totalShipPickDel;
	private double totalShipAttempt;
	private double totalShipment;
	
	public IncentiveExcelBean(){
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartKm() {
		return startKm;
	}

	public void setStartKm(String startKm) {
		this.startKm = startKm;
	}

	public String getEndKm() {
		return endKm;
	}

	public void setEndKm(String endKm) {
		this.endKm = endKm;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReqShipkey() {
		return reqShipkey;
	}

	public void setReqShipkey(String reqShipkey) {
		this.reqShipkey = reqShipkey;
	}

	public double getTotalShipPickDel() {
		return totalShipPickDel;
	}

	public void setTotalShipPickDel(double totalShipPickDel) {
		this.totalShipPickDel = totalShipPickDel;
	}

	public double getTotalShipAttempt() {
		return totalShipAttempt;
	}

	public void setTotalShipAttempt(double totalShipAttempt) {
		this.totalShipAttempt = totalShipAttempt;
	}

	public double getTotalShipment() {
		return totalShipment;
	}

	public void setTotalShipment(double totalShipment) {
		this.totalShipment = totalShipment;
	}
	
}
