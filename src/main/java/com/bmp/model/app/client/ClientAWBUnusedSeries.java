package com.bmp.model.app.client;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.PaymentType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
@Document(collection="clientAWBUnusedSeries")
@AssignKey(assvalue=false)
public class ClientAWBUnusedSeries extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -2895853850392968242L;
    
	private String awbNumber;
	
	@Indexed
	private String clientKey_s;
	
	@Indexed
	private PaymentType paymentType_s;
	
	@Indexed
	private String productType_s;
	
	public ClientAWBUnusedSeries() {}

	public String getAwbNumber() {
		return awbNumber;
	}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public PaymentType getPaymentType_s() {
		return paymentType_s;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	public void setPaymentType_s(PaymentType paymentType_s) {
		this.paymentType_s = paymentType_s;
	}

	public String getProductType_s() {
		return productType_s;
	}

	public void setProductType_s(String productType_s) {
		this.productType_s = productType_s;
	}
	
}
