package com.bmp.bean;

import java.util.Map;

import com.bmp.constant.ClientQCStatus;
import com.bmp.constant.QCStatus;
import com.bmp.model.app.masters.QCMaster;

public class VerifyOrderQCBean {
	
	private String awbNumber;
	private String client_keys;
	private String saleOrderNo;
	private String OrderDate;
	private String OrderStatus;
	private String category;
	private String returnReason;
	private Map<String , QCMaster> qclist;
	private QCStatus qcStatus;
	private String consigneName;
	private String consigneNumber;
	private ClientQCStatus clientQCStatus; 
	private String senderName;
	private String senderNumber;
	private String latLong;
	
	public VerifyOrderQCBean() {
		super();
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public String getClient_keys() {
		return client_keys;
	}

	public void setClient_keys(String client_keys) {
		this.client_keys = client_keys;
	}

	public String getSaleOrderNo() {
		return saleOrderNo;
	}

	public void setSaleOrderNo(String saleOrderNo) {
		this.saleOrderNo = saleOrderNo;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public Map<String, QCMaster> getQclist() {
		return qclist;
	}

	public void setQclist(Map<String, QCMaster> qclist) {
		this.qclist = qclist;
	}

	public QCStatus getQcStatus() {
		return qcStatus;
	}

	public void setQcStatus(QCStatus qcStatus) {
		this.qcStatus = qcStatus;
	}

	public String getConsigneName() {
		return consigneName;
	}

	public void setConsigneName(String consigneName) {
		this.consigneName = consigneName;
	}

	public ClientQCStatus getClientQCStatus() {
		return clientQCStatus;
	}

	public void setClientQCStatus(ClientQCStatus clientQCStatus) {
		this.clientQCStatus = clientQCStatus;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getConsigneNumber() {
		return consigneNumber;
	}

	public void setConsigneNumber(String consigneNumber) {
		this.consigneNumber = consigneNumber;
	}

	public String getSenderNumber() {
		return senderNumber;
	}

	public void setSenderNumber(String senderNumber) {
		this.senderNumber = senderNumber;
	}

	public String getLatLong() {
		return latLong;
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}
	

}
