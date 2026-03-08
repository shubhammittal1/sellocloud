package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.bean.saleorder.TeleCallingBean;
import com.bmp.bean.saleorder.TeleCallingHistoryBean;
import com.bmp.bean.saleorder.TeleStatusBean;
import com.bmp.constant.BillingStatus;
import com.bmp.constant.CodCashStatus;
import com.bmp.constant.RemittanceStatus;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="saleOrderCalling")
@AssignKey(assvalue=false)
@Component("com.bmp.model.app.saleorder.SaleOrderCalling")
public class SaleOrderCalling extends MongoBaseBean implements Serializable,Cloneable {

	private static final long serialVersionUID = -2266030021184600448L;
	private String awbNumber;
	private String clientKey;
	private Map<String, TeleCallingHistoryBean> telecallingNdrVerifyHistory;
	private Map<String, TeleCallingHistoryBean> telecallingDeliveryVerifyHistory;
	
	public SaleOrderCalling() {
		super();
	}
	
	@Override
	public Object clone()throws CloneNotSupportedException{  
		return org.apache.commons.lang3.SerializationUtils.clone((SaleOrderCalling)super.clone());
		//return super.clone();  
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public Map<String, TeleCallingHistoryBean> getTelecallingNdrVerifyHistory() {
		return telecallingNdrVerifyHistory;
	}

	public void setTelecallingNdrVerifyHistory(Map<String, TeleCallingHistoryBean> telecallingNdrVerifyHistory) {
		this.telecallingNdrVerifyHistory = telecallingNdrVerifyHistory;
	}

	public Map<String, TeleCallingHistoryBean> getTelecallingDeliveryVerifyHistory() {
		return telecallingDeliveryVerifyHistory;
	}

	public void setTelecallingDeliveryVerifyHistory(Map<String, TeleCallingHistoryBean> telecallingDeliveryVerifyHistory) {
		this.telecallingDeliveryVerifyHistory = telecallingDeliveryVerifyHistory;
	}

	}