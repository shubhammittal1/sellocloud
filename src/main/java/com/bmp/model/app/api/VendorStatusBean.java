package com.bmp.model.app.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.saleorder.CourierWeightBean;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="vendorStatusBean")
@AssignKey(assvalue=false)
public class VendorStatusBean extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String vendorname;
	private String courierawbnumber;
	private String currentStatus;
	private Date statusUpdateDateTime;
	private String currentLocationName;
	private List<VendorPacketsHistory> packetsHistory;
	private String drsReason;
	private CourierWeightBean courierWeightBean;
	
	public VendorStatusBean(){
		super();
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getCourierawbnumber() {
		return courierawbnumber;
	}

	public void setCourierawbnumber(String courierawbnumber) {
		this.courierawbnumber = courierawbnumber;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Date getStatusUpdateDateTime() {
		return statusUpdateDateTime;
	}

	public void setStatusUpdateDateTime(Date statusUpdateDateTime) {
		this.statusUpdateDateTime = statusUpdateDateTime;
	}

	public String getCurrentLocationName() {
		return currentLocationName;
	}

	public void setCurrentLocationName(String currentLocationName) {
		this.currentLocationName = currentLocationName;
	}

	public List<VendorPacketsHistory> getPacketsHistory() {
		return packetsHistory;
	}

	public void setPacketsHistory(List<VendorPacketsHistory> packetsHistory) {
		this.packetsHistory = packetsHistory;
	}

	public String getDrsReason() {
		return drsReason;
	}

	public void setDrsReason(String drsReason) {
		this.drsReason = drsReason;
	}

	public CourierWeightBean getCourierWeightBean() {
		return courierWeightBean;
	}

	public void setCourierWeightBean(CourierWeightBean courierWeightBean) {
		this.courierWeightBean = courierWeightBean;
	}
	
	
		
}
