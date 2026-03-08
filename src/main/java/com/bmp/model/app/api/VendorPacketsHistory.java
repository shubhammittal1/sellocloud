package com.bmp.model.app.api;

import java.util.Date;

public class VendorPacketsHistory  implements Comparable<VendorPacketsHistory> {

	private String statusId;
	private String name;
	private String location;
	private String activity;
	private Date updateDate;
	private Long DateValue;
	private String rtoReason;
	private String lat;
	private String lng;
	private String rtoAwbNumber;
	
	public VendorPacketsHistory(){}
	public VendorPacketsHistory(String statusId, String name, String location, String activity, Date updateDate,
			Long dateValue, String lat, String lng, String rtoAwbNumber) {
		super();
		this.statusId = statusId;
		this.name = name;
		this.location = location;
		this.activity = activity;
		this.updateDate = updateDate;
		this.DateValue = dateValue;
		this.lat = lat;
		this.lng = lng;
		this.rtoAwbNumber = rtoAwbNumber;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Long getDateValue() {
		return DateValue;
	}
	public void setDateValue(Long dateValue) {
		DateValue = dateValue;
	}
	@Override
	public int compareTo(VendorPacketsHistory arg0) {
		// TODO Auto-generated method stub
		return getUpdateDate().compareTo(arg0.getUpdateDate());
	}
	public String getRtoReason() {
		return rtoReason;
	}
	public void setRtoReason(String rtoReason) {
		this.rtoReason = rtoReason;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getRtoAwbNumber() {
		return rtoAwbNumber;
	}
	public void setRtoAwbNumber(String rtoAwbNumber) {
		this.rtoAwbNumber = rtoAwbNumber;
	}
	
	
}
