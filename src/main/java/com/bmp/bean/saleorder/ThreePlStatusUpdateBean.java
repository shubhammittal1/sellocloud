package com.bmp.bean.saleorder;

public class ThreePlStatusUpdateBean {
	
	private String awbNumber;
	private String status;
	private String date;
	private String city;
	private String time;
	private String rtoReasonkey;
	private String ndrReason;
	private String complaintId;
	
	public String getNdrReason() {
		return ndrReason;
	}
	public void setNdrReason(String ndrReason) {
		this.ndrReason = ndrReason;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public String getStatus() {
		return status;
	}
	public String getDate() {
		return date;
	}
	public String getCity() {
		return city;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRtoReasonkey() {
		return rtoReasonkey;
	}
	public void setRtoReasonkey(String rtoReasonkey) {
		this.rtoReasonkey = rtoReasonkey;
	}
	public String getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}
	
	

}
