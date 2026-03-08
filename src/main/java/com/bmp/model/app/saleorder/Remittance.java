package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="remittance")
@AssignKey(assvalue=true)
public class Remittance extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String clientKey_s;
	@Indexed
	private Long dueDate_l;
	private Double collectedAmt;
	private Double depositedAmt;
	private String statusFlowKey;
	private StatusMaster status;
	@Indexed
	private List<String> awbNo_ss;
	private String documentName;
	private List<RemittenceBankDeposit> remittenceBankDeposit;
	private String remarks;
	
	public Remittance(){
		super(); 
	}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public Long getDueDate_l() {
		return dueDate_l;
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

	public List<String> getAwbNo_ss() {
		return awbNo_ss;
	}

	public String getDocumentName() {
		return documentName;
	}

	public List<RemittenceBankDeposit> getRemittenceBankDeposit() {
		return remittenceBankDeposit;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	public void setDueDate_l(Long dueDate_l) {
		this.dueDate_l = dueDate_l;
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

	public void setAwbNo_ss(List<String> awbNo_ss) {
		this.awbNo_ss = awbNo_ss;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public void setRemittenceBankDeposit(
			List<RemittenceBankDeposit> remittenceBankDeposit) {
		this.remittenceBankDeposit = remittenceBankDeposit;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
