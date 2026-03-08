package com.bmp.model.c2c;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="webUserAccountLog")
@AssignKey(assvalue=false)
public class WebUserAccountLog extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -4677577840752533287L;
	@Indexed
	private String webUserKey_s;
	private Double amount;
	private Double currentBalance;
	private Double modifiedBalance;
	private String paymentType;
	private String paymentSubType;
	@Indexed
	private String transactionKey_s;
	private String remark;
	
	public WebUserAccountLog(){}
	
	public String getWebUserKey_s() {
		return webUserKey_s;
	}
	public void setWebUserKey_s(String webUserKey_s) {
		this.webUserKey_s = webUserKey_s;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public Double getModifiedBalance() {
		return modifiedBalance;
	}
	public void setModifiedBalance(Double modifiedBalance) {
		this.modifiedBalance = modifiedBalance;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentSubType() {
		return paymentSubType;
	}
	public void setPaymentSubType(String paymentSubType) {
		this.paymentSubType = paymentSubType;
	}
	public String getTransactionKey_s() {
		return transactionKey_s;
	}
	public void setTransactionKey_s(String transactionKey_s) {
		this.transactionKey_s = transactionKey_s;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


}
