package com.bmp.model.app.webhook;

import java.io.Serializable;


import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.WebhookType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="trackingWebhook")
@AssignKey(assvalue=true)
public class TrackingWebhook extends MongoBaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String awbNumber;
    private String courierAwb;
    private WebhookType webhookType;
    private String payload;
    private boolean historyMapped;
    private String ef1;
    private String ef2;
    public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getCourierAwb() {
		return courierAwb;
	}
	public void setCourierAwb(String courierAwb) {
		this.courierAwb = courierAwb;
	}
	public WebhookType getWebhookType() {
		return webhookType;
	}
	public void setWebhookType(WebhookType webhookType) {
		this.webhookType = webhookType;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public boolean isHistoryMapped() {
		return historyMapped;
	}
	public void setHistoryMapped(boolean historyMapped) {
		this.historyMapped = historyMapped;
	}
	public String getEf1() {
		return ef1;
	}
	public void setEf1(String ef1) {
		this.ef1 = ef1;
	}
	public String getEf2() {
		return ef2;
	}
	public void setEf2(String ef2) {
		this.ef2 = ef2;
	}
	
}
