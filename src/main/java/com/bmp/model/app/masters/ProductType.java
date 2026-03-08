package com.bmp.model.app.masters;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.PaymentType;
import com.bmp.constant.ServiceMode;
import com.bmp.constant.UserType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="productType")
@AssignKey(assvalue=false)
public class ProductType extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -6431940599439401760L;
	
	private String name;
	private String desc;
	private UserType userType;
	private PaymentType paymentType;
	private ServiceMode serviceMode;

	public ProductType(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public ServiceMode getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(ServiceMode serviceMode) {
		this.serviceMode = serviceMode;
	}

}