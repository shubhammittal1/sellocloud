package com.bmp.model.app.masters;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.constant.PaymentType;
import com.bmp.constant.UserType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component("com.bmp.model.app.masters.AWBSeries")
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="AWBSeries")
@AssignKey(assvalue=false)
public class AWBSeries extends MongoBaseBean implements Cloneable{
	
	private static final long serialVersionUID = -2103839018867460964L;
	
	@Indexed
	private UserType entityType_s;
	
	@Indexed
	private String entityKey_s;
	
	@Indexed
	private PaymentType paymentType_s;
	
	@Indexed
	private String awbNumber_s;
	
	@Indexed
	private Boolean used_b;
	private String productType;
	
	public AWBSeries () {
		super();
	}
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}

	public UserType getEntityType_s() {
		return entityType_s;
	}

	public void setEntityType_s(UserType entityType_s) {
		this.entityType_s = entityType_s;
	}


	public String getAwbNumber_s() {
		return awbNumber_s;
	}

	public void setAwbNumber_s(String awbNumber_s) {
		this.awbNumber_s = awbNumber_s;
	}

	public String getEntityKey_s() {
		return entityKey_s;
	}

	public void setEntityKey_s(String entityKey_s) {
		this.entityKey_s = entityKey_s;
	}

	public PaymentType getPaymentType_s() {
		return paymentType_s;
	}

	public void setPaymentType_s(PaymentType paymentType_s) {
		this.paymentType_s = paymentType_s;
	}

	public Boolean getUsed_b() {
		return used_b;
	}

	public void setUsed_b(Boolean used_b) {
		this.used_b = used_b;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}