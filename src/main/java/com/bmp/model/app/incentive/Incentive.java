package com.bmp.model.app.incentive;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="incentive")
@AssignKey(assvalue=true)
public class Incentive extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = -2266030021184600448L;
	
	private String fromDate;
	private String toDate;
	@Indexed
	private String pickerKey_s;
	private String pickerName;
	private String contactNumber;
	private String empCode;
	@Indexed
	private String branchKey_s;
	private String branchName;
	@Indexed
	private String incentiveType_s;
	private Double totalAmount;
	private Double appIncentiveAmount;
	private Double fuelIncentiveAmount;
	private Double shipIncentiveAmount;
	private List<String> appDrsList;
	private List<String> appPickList;
	private FuelIncentive fuelIncentive;
	private ShipmentIncentive shipmentIncentive;
	@Indexed
	private String incentiveStatus_s;
	
	public Incentive(){
		super();
	}
	
	public String getFromDate() {
		return fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public String getPickerKey_s() {
		return pickerKey_s;
	}
	public String getPickerName() {
		return pickerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getEmpCode() {
		return empCode;
	}
	public String getBranchKey_s() {
		return branchKey_s;
	}
	public String getIncentiveType_s() {
		return incentiveType_s;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public Double getAppIncentiveAmount() {
		return appIncentiveAmount;
	}
	public Double getFuelIncentiveAmount() {
		return fuelIncentiveAmount;
	}
	public Double getShipIncentiveAmount() {
		return shipIncentiveAmount;
	}
	public List<String> getAppDrsList() {
		return appDrsList;
	}
	public List<String> getAppPickList() {
		return appPickList;
	}
	public FuelIncentive getFuelIncentive() {
		return fuelIncentive;
	}
	public ShipmentIncentive getShipmentIncentive() {
		return shipmentIncentive;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public void setPickerKey_s(String pickerKey_s) {
		this.pickerKey_s = pickerKey_s;
	}
	public void setPickerName(String pickerName) {
		this.pickerName = pickerName;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public void setBranchKey_s(String branchKey_s) {
		this.branchKey_s = branchKey_s;
	}
	public void setIncentiveType_s(String incentiveType_s) {
		this.incentiveType_s = incentiveType_s;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setAppIncentiveAmount(Double appIncentiveAmount) {
		this.appIncentiveAmount = appIncentiveAmount;
	}
	public void setFuelIncentiveAmount(Double fuelIncentiveAmount) {
		this.fuelIncentiveAmount = fuelIncentiveAmount;
	}
	public void setShipIncentiveAmount(Double shipIncentiveAmount) {
		this.shipIncentiveAmount = shipIncentiveAmount;
	}
	public void setAppDrsList(List<String> appDrsList) {
		this.appDrsList = appDrsList;
	}
	public void setAppPickList(List<String> appPickList) {
		this.appPickList = appPickList;
	}
	public void setFuelIncentive(FuelIncentive fuelIncentive) {
		this.fuelIncentive = fuelIncentive;
	}
	public void setShipmentIncentive(ShipmentIncentive shipmentIncentive) {
		this.shipmentIncentive = shipmentIncentive;
	}
	
	public String getIncentiveStatus_s() {
		return incentiveStatus_s;
	}

	public void setIncentiveStatus_s(String incentiveStatus_s) {
		this.incentiveStatus_s = incentiveStatus_s;
	}

	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
}
