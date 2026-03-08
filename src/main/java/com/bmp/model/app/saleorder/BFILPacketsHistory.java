package com.bmp.model.app.saleorder;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BFILPacketsHistory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String loanProposalID ;
	private String vendorId ;
	private String status ;
	private String teleCallStatus ;
	private String memberInterest ;
	private String reason ;
	private String disPatchDate ;
	private String invoiceNumber ;
	private String invoiceDate ;
	private String serialNumber ;
	private String courierName ;
	private String expectedDateOfDelivery ;
	private String deliveryStatus ;
	private String deliveryDate ;
	private String reasonsforNondelivery ;
	private String typeofPOD ;
	private String POD ;
	private String deliveryAgentNumber;
	private String receivedBy;
	private String statusType;
	private String externalStatus;
	private String externalStatusCode;
	private boolean statusPushed;
	private boolean ralStatusPushed;
	private String reasonsforMemberRefusal;
	
	public BFILPacketsHistory() {
		super();
	}

	public String getLoanProposalID() {
		return loanProposalID;
	}

	public void setLoanProposalID(String loanProposalID) {
		this.loanProposalID = loanProposalID;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTeleCallStatus() {
		return teleCallStatus;
	}

	public void setTeleCallStatus(String teleCallStatus) {
		this.teleCallStatus = teleCallStatus;
	}

	public String getMemberInterest() {
		return memberInterest;
	}

	public void setMemberInterest(String memberInterest) {
		this.memberInterest = memberInterest;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDisPatchDate() {
		return disPatchDate;
	}

	public void setDisPatchDate(String disPatchDate) {
		this.disPatchDate = disPatchDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public String getExpectedDateOfDelivery() {
		return expectedDateOfDelivery;
	}

	public void setExpectedDateOfDelivery(String expectedDateOfDelivery) {
		this.expectedDateOfDelivery = expectedDateOfDelivery;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getReasonsforNondelivery() {
		return reasonsforNondelivery;
	}

	public void setReasonsforNondelivery(String reasonsforNondelivery) {
		this.reasonsforNondelivery = reasonsforNondelivery;
	}

	public String getTypeofPOD() {
		return typeofPOD;
	}

	public void setTypeofPOD(String typeofPOD) {
		this.typeofPOD = typeofPOD;
	}

	public String getDeliveryAgentNumber() {
		return deliveryAgentNumber;
	}

	public void setDeliveryAgentNumber(String deliveryAgentNumber) {
		this.deliveryAgentNumber = deliveryAgentNumber;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getExternalStatus() {
		return externalStatus;
	}

	public void setExternalStatus(String externalStatus) {
		this.externalStatus = externalStatus;
	}

	public String getExternalStatusCode() {
		return externalStatusCode;
	}

	public void setExternalStatusCode(String externalStatusCode) {
		this.externalStatusCode = externalStatusCode;
	}

	public boolean isStatusPushed() {
		return statusPushed;
	}

	public void setStatusPushed(boolean statusPushed) {
		this.statusPushed = statusPushed;
	}

	public String getPOD() {
		return POD;
	}

	public void setPOD(String pOD) {
		POD = pOD;
	}

	public boolean isRalStatusPushed() {
		return ralStatusPushed;
	}

	public void setRalStatusPushed(boolean ralStatusPushed) {
		this.ralStatusPushed = ralStatusPushed;
	}

	public String getReasonsforMemberRefusal() {
		return reasonsforMemberRefusal;
	}

	public void setReasonsforMemberRefusal(String reasonsforMemberRefusal) {
		this.reasonsforMemberRefusal = reasonsforMemberRefusal;
	}

	}