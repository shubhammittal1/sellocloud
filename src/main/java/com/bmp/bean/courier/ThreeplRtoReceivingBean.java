package com.bmp.bean.courier;

import java.io.Serializable;

public class ThreeplRtoReceivingBean implements Serializable{
	
	private String awbNumber;
	private String rtoReceivedStatus;
	private String rtoReceivedReasonId;
	private String branchKey;
	
	public ThreeplRtoReceivingBean(){
		super();
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public String getRtoReceivedStatus() {
		return rtoReceivedStatus;
	}
	public String getRtoReceivedReasonId() {
		return rtoReceivedReasonId;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public void setRtoReceivedStatus(String rtoReceivedStatus) {
		this.rtoReceivedStatus = rtoReceivedStatus;
	}
	public void setRtoReceivedReasonId(String rtoReceivedReasonId) {
		this.rtoReceivedReasonId = rtoReceivedReasonId;
	}
	public String getBranchKey() {
		return branchKey;
	}
	public void setBranchKey(String branchKey) {
		this.branchKey = branchKey;
	}
	
	

}
