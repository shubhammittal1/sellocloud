package com.bmp.model.app.utility;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.AlertStatus;
import com.bmp.constant.AlertType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="smsMailMaster")
@AssignKey(assvalue=false)
public class SmsMailMaster extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = 6381211981474998144L;
	
	@Indexed
	private AlertType alertType_s;
	@Indexed
	private AlertStatus  alertStatus_s;
	private String message;
	private String from;
	private String to;
	private String cc;
	private String subjectLine;
	private String alertMasterId;
	@Indexed
	private String awb;
	@Indexed
	private String client;
	private String statusKey;
	private String ndrKey;
	
	public SmsMailMaster() {
		super();
	}
	
	public AlertType getAlertType_s() {
		return alertType_s;
	}
	public void setAlertType_s(AlertType alertType_s) {
		this.alertType_s = alertType_s;
	}
	public AlertStatus getAlertStatus_s() {
		return alertStatus_s;
	}
	public void setAlertStatus_s(AlertStatus alertStatus_s) {
		this.alertStatus_s = alertStatus_s;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getSubjectLine() {
		return subjectLine;
	}
	public void setSubjectLine(String subjectLine) {
		this.subjectLine = subjectLine;
	}
	public String getAlertMasterId() {
		return alertMasterId;
	}
	public void setAlertMasterId(String alertMasterId) {
		this.alertMasterId = alertMasterId;
	}

	public String getAwb() {
		return awb;
	}

	public void setAwb(String awb) {
		this.awb = awb;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getStatusKey() {
		return statusKey;
	}

	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}

	public String getNdrKey() {
		return ndrKey;
	}

	public void setNdrKey(String ndrKey) {
		this.ndrKey = ndrKey;
	}
	
}
