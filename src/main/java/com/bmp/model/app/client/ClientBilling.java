package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="clientBilling")
@AssignKey(assvalue=true)
public class ClientBilling extends MongoBaseBean implements Serializable{
	
private static final long serialVersionUID = 1L;
    @Indexed
	private String clientKey_s;
	private Long fromDate;
	private Long toDate;
	private Double collectedAmt;
	private Double depositedAmt;
	private Double totalBillingWeight;
	private String statusFlowKey;
	private StatusMaster status;
	private String documentName;
	@Indexed
	private String reportStatus_s;
	@Indexed
	private String reportKey_s;
	private List<BillingBankDeposit> billingBankDeposit;
	private Double grossAmount;
	private Double taxableAmount;
	private Double totalAmount;
	private List<String> billingShipments;
	private Integer totalAwbCount = 0;
	private Integer successAwbCount = 0;
	private Integer errorAwbCount = 0;
	private Map<String, String> errorMap;
	
	@Indexed
	private String invoiceNo;
	
	public ClientBilling(){
		super();
	}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public Long getFromDate() {
		return fromDate;
	}

	public Long getToDate() {
		return toDate;
	}

	public Double getCollectedAmt() {
		return collectedAmt;
	}

	public Double getDepositedAmt() {
		return depositedAmt;
	}

	public String getStatusFlowKey() {
		return statusFlowKey;
	}

	public StatusMaster getStatus() {
		return status;
	}

	public String getDocumentName() {
		return documentName;
	}

	public List<BillingBankDeposit> getBillingBankDeposit() {
		return billingBankDeposit;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(Long toDate) {
		this.toDate = toDate;
	}

	public void setCollectedAmt(Double collectedAmt) {
		this.collectedAmt = collectedAmt;
	}

	public void setDepositedAmt(Double depositedAmt) {
		this.depositedAmt = depositedAmt;
	}

	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}

	public void setStatus(StatusMaster status) {
		this.status = status;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public void setBillingBankDeposit(List<BillingBankDeposit> billingBankDeposit) {
		this.billingBankDeposit = billingBankDeposit;
	}

	

	public Double getTotalBillingWeight() {
		return totalBillingWeight;
	}

	public void setTotalBillingWeight(Double totalBillingWeight) {
		this.totalBillingWeight = totalBillingWeight;
	}

	public String getReportStatus_s() {
		return reportStatus_s;
	}

	public void setReportStatus_s(String reportStatus_s) {
		this.reportStatus_s = reportStatus_s;
	}

	public String getReportKey_s() {
		return reportKey_s;
	}

	public void setReportKey_s(String reportKey_s) {
		this.reportKey_s = reportKey_s;
	}

	public Double getGrossAmount() {
		return grossAmount;
	}

	public Double getTaxableAmount() {
		return taxableAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public void setTaxableAmount(Double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<String> getBillingShipments() {
		return billingShipments;
	}

	public void setBillingShipments(List<String> billingShipments) {
		this.billingShipments = billingShipments;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getTotalAwbCount() {
		return totalAwbCount;
	}

	public void setTotalAwbCount(Integer totalAwbCount) {
		this.totalAwbCount = totalAwbCount;
	}

	public Integer getSuccessAwbCount() {
		return successAwbCount;
	}

	public void setSuccessAwbCount(Integer successAwbCount) {
		this.successAwbCount = successAwbCount;
	}

	public Integer getErrorAwbCount() {
		return errorAwbCount;
	}

	public void setErrorAwbCount(Integer errorAwbCount) {
		this.errorAwbCount = errorAwbCount;
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	
}
