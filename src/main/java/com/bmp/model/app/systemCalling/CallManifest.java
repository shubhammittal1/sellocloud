package com.bmp.model.app.systemCalling;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.CallManifestStatus;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="callManifest")
@AssignKey(assvalue=false)
public class CallManifest extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String campaignKey_s;
	private String campaignName;
	private String scheduleDateTime;
	private CallManifestStatus status;
	@Indexed
	private String fromNumber;
	private String callsId;
	private String fromDate;
	private String toDate;
	private String client;
	private List<String> packetStatus;
	private CallManifestStatus type;  //KEYS or CUSTOM
	private String awbNumbers;
	private String productType;
	private int totalAwb;
	private Integer croneStatus = 0;
	private boolean allCallTrigger;
	private Integer autoClosedCroneStatus = 0;
	
	public CallManifest() {
		super();
	}
	 
	public String getCampaignKey_s() {
		return campaignKey_s;
	}
	public void setCampaignKey_s(String campaignKey_s) {
		this.campaignKey_s = campaignKey_s;
	}
	public String getScheduleDateTime() {
		return scheduleDateTime;
	}
	public void setScheduleDateTime(String scheduleDateTime) {
		this.scheduleDateTime = scheduleDateTime;
	}
	public CallManifestStatus getStatus() {
		return status;
	}
	public void setStatus(CallManifestStatus status) {
		this.status = status;
	}
	/*public Map<String, CallingBean> getAwbMap() {
		return awbMap;
	}
	public void setAwbMap(Map<String, CallingBean> awbMap) {
		this.awbMap = awbMap;
	}*/
	public String getFromNumber() {
		return fromNumber;
	}
	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}
	public String getCallsId() {
		return callsId;
	}
	public void setCallsId(String callsId) {
		this.callsId = callsId;
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

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public List<String> getPacketStatus() {
		return packetStatus;
	}

	public void setPacketStatus(List<String> packetStatus) {
		this.packetStatus = packetStatus;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public CallManifestStatus getType() {
		return type;
	}

	public void setType(CallManifestStatus type) {
		this.type = type;
	}

	public String getAwbNumbers() {
		return awbNumbers;
	}

	public void setAwbNumbers(String awbNumbers) {
		this.awbNumbers = awbNumbers;
	}

	public int getTotalAwb() {
		return totalAwb;
	}

	public void setTotalAwb(int totalAwb) {
		this.totalAwb = totalAwb;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getCroneStatus() {
		return croneStatus;
	}

	public void setCroneStatus(Integer croneStatus) {
		this.croneStatus = croneStatus;
	}

	public boolean isAllCallTrigger() {
		return allCallTrigger;
	}

	public void setAllCallTrigger(boolean allCallTrigger) {
		this.allCallTrigger = allCallTrigger;
	}

	public Integer getAutoClosedCroneStatus() {
		return autoClosedCroneStatus;
	}

	public void setAutoClosedCroneStatus(Integer autoClosedCroneStatus) {
		this.autoClosedCroneStatus = autoClosedCroneStatus;
	}
	
}
