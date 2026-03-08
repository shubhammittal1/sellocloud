package com.bmp.model.app.webhook;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.constant.WebhookType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="orderPushWebhook")
@AssignKey(assvalue=true)
public class OrderPushWebhook extends MongoBaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String awbNumber;
    private WebhookType webhookType;
    private Object payload;
    private String ef1;
    private String ef2;
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public WebhookType getWebhookType() {
		return webhookType;
	}
	public void setWebhookType(WebhookType webhookType) {
		this.webhookType = webhookType;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
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
