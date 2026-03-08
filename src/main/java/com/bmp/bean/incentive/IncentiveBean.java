package com.bmp.bean.incentive;

import java.util.List;
import java.util.Map;

import com.bmp.model.app.incentive.FuelIncentive;
import com.bmp.model.app.incentive.ShipmentIncentive;

public class IncentiveBean {

	private String fromDate;
	private String toDate;
	private String branchKey_s;
	private String pickerKey_s;
	private String incentiveType_s;
	private List<String> drsList;
	private List<String> pickupList;
	private List<String> appDrsList;
	private List<String> appPickupList;
	private Double totalAmtForDrs;
	private Double totalAmtForPickup;
	private Double totalAmtForApp;
	private FuelIncentive fuelIncentive;
	private ShipmentIncentive shipmentIncentive;
	private Map<String, List<String>> objectMap;
	
	public IncentiveBean(){
		super();
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getBranchKey_s() {
		return branchKey_s;
	}

	public void setBranchKey_s(String branchKey_s) {
		this.branchKey_s = branchKey_s;
	}

	public String getPickerKey_s() {
		return pickerKey_s;
	}

	public void setPickerKey_s(String pickerKey_s) {
		this.pickerKey_s = pickerKey_s;
	}

	public String getIncentiveType_s() {
		return incentiveType_s;
	}

	public void setIncentiveType_s(String incentiveType_s) {
		this.incentiveType_s = incentiveType_s;
	}

	public List<String> getDrsList() {
		return drsList;
	}

	public void setDrsList(List<String> drsList) {
		this.drsList = drsList;
	}

	public List<String> getPickupList() {
		return pickupList;
	}

	public void setPickupList(List<String> pickupList) {
		this.pickupList = pickupList;
	}

	public Double getTotalAmtForDrs() {
		return totalAmtForDrs;
	}

	public void setTotalAmtForDrs(Double totalAmtForDrs) {
		this.totalAmtForDrs = totalAmtForDrs;
	}

	public Double getTotalAmtForPickup() {
		return totalAmtForPickup;
	}

	public void setTotalAmtForPickup(Double totalAmtForPickup) {
		this.totalAmtForPickup = totalAmtForPickup;
	}

	public Double getTotalAmtForApp() {
		return totalAmtForApp;
	}

	public void setTotalAmtForApp(Double totalAmtForApp) {
		this.totalAmtForApp = totalAmtForApp;
	}

	public FuelIncentive getFuelIncentive() {
		return fuelIncentive;
	}

	public void setFuelIncentive(FuelIncentive fuelIncentive) {
		this.fuelIncentive = fuelIncentive;
	}

	public Map<String, List<String>> getObjectMap() {
		return objectMap;
	}

	public void setObjectMap(Map<String, List<String>> objectMap) {
		this.objectMap = objectMap;
	}

	public ShipmentIncentive getShipmentIncentive() {
		return shipmentIncentive;
	}

	public void setShipmentIncentive(ShipmentIncentive shipmentIncentive) {
		this.shipmentIncentive = shipmentIncentive;
	}

	public List<String> getAppDrsList() {
		return appDrsList;
	}

	public void setAppDrsList(List<String> appDrsList) {
		this.appDrsList = appDrsList;
	}

	public List<String> getAppPickupList() {
		return appPickupList;
	}

	public void setAppPickupList(List<String> appPickupList) {
		this.appPickupList = appPickupList;
	}
		
}
