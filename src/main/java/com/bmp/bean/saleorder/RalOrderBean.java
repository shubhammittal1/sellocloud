package com.bmp.bean.saleorder;

import java.io.Serializable;
import java.util.Date;

public class RalOrderBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String awbNumber;
	private String orderNumber;
	private String orderDate;
	private String clientName;
	private String vndorName;
	private String pickupAddress;                 
	private String pickupPincode;                  
	private String pickupMobileNumber;             
	private String pickupAlternateNumber;         
	private String consigneeName;                  
	private String consigneeAddress;              
	private String consigneeLandmark;              
	private String consigneePincode;               
	private String consigneeMobileNumber;         
	private String consigneeAlternateNumber;       
	private String consignee_Emailid;              
	private String product_Code;                  
	private String product_Name;                  
	private Integer quantity;  
	private Double weight;   
	private Double length;    
	private Double width;     
	private Double height;    
	private Double collective_Amt;                 
	private Double product_Price;                  
	private String paymentMode;                   
	private Boolean dgGood;    
	private String manifestNumber;                 
	private String product_Type;                   
	private String order_Type;
	private Integer igst_Value;
	private Integer sgst_Value;
	private Integer cgst_Value;
	private String invoiceStatus;
	private String loanCode;
	private String sksVendorId;
	
	public RalOrderBean() {
		super();
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getVndorName() {
		return vndorName;
	}

	public void setVndorName(String vndorName) {
		this.vndorName = vndorName;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getPickupPincode() {
		return pickupPincode;
	}

	public void setPickupPincode(String pickupPincode) {
		this.pickupPincode = pickupPincode;
	}

	public String getPickupMobileNumber() {
		return pickupMobileNumber;
	}

	public void setPickupMobileNumber(String pickupMobileNumber) {
		this.pickupMobileNumber = pickupMobileNumber;
	}

	public String getPickupAlternateNumber() {
		return pickupAlternateNumber;
	}

	public void setPickupAlternateNumber(String pickupAlternateNumber) {
		this.pickupAlternateNumber = pickupAlternateNumber;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneeLandmark() {
		return consigneeLandmark;
	}

	public void setConsigneeLandmark(String consigneeLandmark) {
		this.consigneeLandmark = consigneeLandmark;
	}

	public String getConsigneePincode() {
		return consigneePincode;
	}

	public void setConsigneePincode(String consigneePincode) {
		this.consigneePincode = consigneePincode;
	}

	public String getConsigneeMobileNumber() {
		return consigneeMobileNumber;
	}

	public void setConsigneeMobileNumber(String consigneeMobileNumber) {
		this.consigneeMobileNumber = consigneeMobileNumber;
	}

	public String getConsigneeAlternateNumber() {
		return consigneeAlternateNumber;
	}

	public void setConsigneeAlternateNumber(String consigneeAlternateNumber) {
		this.consigneeAlternateNumber = consigneeAlternateNumber;
	}

	public String getConsignee_Emailid() {
		return consignee_Emailid;
	}

	public void setConsignee_Emailid(String consignee_Emailid) {
		this.consignee_Emailid = consignee_Emailid;
	}

	public String getProduct_Code() {
		return product_Code;
	}

	public void setProduct_Code(String product_Code) {
		this.product_Code = product_Code;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getCollective_Amt() {
		return collective_Amt;
	}

	public void setCollective_Amt(Double collective_Amt) {
		this.collective_Amt = collective_Amt;
	}

	public Double getProduct_Price() {
		return product_Price;
	}

	public void setProduct_Price(Double product_Price) {
		this.product_Price = product_Price;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Boolean getDgGood() {
		return dgGood;
	}

	public void setDgGood(Boolean dgGood) {
		this.dgGood = dgGood;
	}

	public String getManifestNumber() {
		return manifestNumber;
	}

	public void setManifestNumber(String manifestNumber) {
		this.manifestNumber = manifestNumber;
	}

	public String getProduct_Type() {
		return product_Type;
	}

	public void setProduct_Type(String product_Type) {
		this.product_Type = product_Type;
	}

	public String getOrder_Type() {
		return order_Type;
	}

	public void setOrder_Type(String order_Type) {
		this.order_Type = order_Type;
	}

	public Integer getIgst_Value() {
		return igst_Value;
	}

	public void setIgst_Value(Integer igst_Value) {
		this.igst_Value = igst_Value;
	}

	public Integer getSgst_Value() {
		return sgst_Value;
	}

	public void setSgst_Value(Integer sgst_Value) {
		this.sgst_Value = sgst_Value;
	}

	public Integer getCgst_Value() {
		return cgst_Value;
	}

	public void setCgst_Value(Integer cgst_Value) {
		this.cgst_Value = cgst_Value;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getLoanCode() {
		return loanCode;
	}

	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}

	public String getSksVendorId() {
		return sksVendorId;
	}

	public void setSksVendorId(String sksVendorId) {
		this.sksVendorId = sksVendorId;
	}
	
	
}
