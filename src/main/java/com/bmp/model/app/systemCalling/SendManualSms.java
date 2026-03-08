package com.bmp.model.app.systemCalling;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.CallManifestStatus;
import com.bmp.constant.c2c.SmsType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="manualSms")
@AssignKey(assvalue=true)
public class SendManualSms extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String client;
	//private List<String> productTypes;
	private SmsType smsType;
	private int totalAwb;
	private Integer croneStatus = 0;
	private CallManifestStatus status;
	private String packetStatus;
	private String alertTemplateId;
	private String awbNumbers;
	private String fromDate;
	private String toDate;
	private String type;
	private Map<String,String> error = new HashMap<String,String>();
	
	public SendManualSms() {
		super();
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	/*public List<String> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<String> productTypes) {
		this.productTypes = productTypes;
	}*/

	public int getTotalAwb() {
		return totalAwb;
	}

	public void setTotalAwb(int totalAwb) {
		this.totalAwb = totalAwb;
	}

	public Integer getCroneStatus() {
		return croneStatus;
	}

	public void setCroneStatus(Integer croneStatus) {
		this.croneStatus = croneStatus;
	}

	public CallManifestStatus getStatus() {
		return status;
	}

	public void setStatus(CallManifestStatus status) {
		this.status = status;
	}

	public String getPacketStatus() {
		return packetStatus;
	}

	public void setPacketStatus(String packetStatus) {
		this.packetStatus = packetStatus;
	}

	public String getAlertTemplateId() {
		return alertTemplateId;
	}

	public void setAlertTemplateId(String alertTemplateId) {
		this.alertTemplateId = alertTemplateId;
	}

	public String getAwbNumbers() {
		return awbNumbers;
	}

	public void setAwbNumbers(String awbNumbers) {
		this.awbNumbers = awbNumbers;
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

	public SmsType getSmsType() {
		return smsType;
	}

	public void setSmsType(SmsType smsType) {
		this.smsType = smsType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, String> getError() {
		return error;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}

}
