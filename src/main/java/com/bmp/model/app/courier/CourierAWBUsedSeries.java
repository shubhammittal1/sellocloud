package com.bmp.model.app.courier;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.PaymentType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="courierAWBUsedSeries")
@AssignKey(assvalue=false)
public class CourierAWBUsedSeries extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -2895853850392968242L;
    
	private String awbNumber;
	
	@Indexed
	private String courierKey_s;
	
	@Indexed
	private PaymentType paymentType_s;

	public CourierAWBUsedSeries() {}


	public String getAwbNumber() {
		return awbNumber;
	}


	public String getCourierKey_s() {
		return courierKey_s;
	}


	public PaymentType getPaymentType_s() {
		return paymentType_s;
	}


	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}


	public void setCourierKey_s(String courierKey_s) {
		this.courierKey_s = courierKey_s;
	}


	public void setPaymentType_s(PaymentType paymentType_s) {
		this.paymentType_s = paymentType_s;
	}
	
}
