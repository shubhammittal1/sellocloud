package com.bmp.model.app.drs;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.Denominations;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="branchCashClosing")
@AssignKey(assvalue=false)
public class BranchCashClosing extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Indexed
	private String cashClosingCode_s;
	private String statusFlowKey;
	private StatusMaster currentStatus;
	@Indexed
	private String genaratedByBranchKey_s;
	private String genaratedByBranchName;
	@Indexed
	private Long cashClosingCodeDate_l;
	private Double branchCashCollectible;
	private Double branchCashReceived;
	private Double branchCashDepo;
	private String branchClosingDoc;
	@Indexed
	private List<String> openDRS_ss;
	@Indexed
	private List<String> closeDRS_ss;
	private Map<Denominations, Integer> denominations;
	private List<BranchBankDeposite> bankDeposites;
	private String remark;
	
	public BranchCashClosing() {
		super();
	}
	
	public String getGenaratedByBranchName() {
		return genaratedByBranchName;
	}

	public void setGenaratedByBranchName(String genaratedByBranchName) {
		this.genaratedByBranchName = genaratedByBranchName;
	}

	public String getStatusFlowKey() {
		return statusFlowKey;
	}

	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}

	public StatusMaster getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(StatusMaster currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getGenaratedByBranchKey_s() {
		return genaratedByBranchKey_s;
	}

	public void setGenaratedByBranchKey_s(String genaratedByBranchKey_s) {
		this.genaratedByBranchKey_s = genaratedByBranchKey_s;
	}

	public String getCashClosingCode_s() {
		return cashClosingCode_s;
	}

	public void setCashClosingCode_s(String cashClosingCode_s) {
		this.cashClosingCode_s = cashClosingCode_s;
	}
	
	public Long getCashClosingCodeDate_l() {
		return cashClosingCodeDate_l;
	}

	public void setCashClosingCodeDate_l(Long cashClosingCodeDate_l) {
		this.cashClosingCodeDate_l = cashClosingCodeDate_l;
	}

	public Double getBranchCashCollectible() {
		return branchCashCollectible;
	}

	public void setBranchCashCollectible(Double branchCashCollectible) {
		this.branchCashCollectible = branchCashCollectible;
	}

	public Double getBranchCashReceived() {
		return branchCashReceived;
	}

	public void setBranchCashReceived(Double branchCashReceived) {
		this.branchCashReceived = branchCashReceived;
	}

	public Double getBranchCashDepo() {
		return branchCashDepo;
	}

	public void setBranchCashDepo(Double branchCashDepo) {
		this.branchCashDepo = branchCashDepo;
	}

	public String getBranchClosingDoc() {
		return branchClosingDoc;
	}

	public void setBranchClosingDoc(String branchClosingDoc) {
		this.branchClosingDoc = branchClosingDoc;
	}

	public List<String> getOpenDRS_ss() {
		return openDRS_ss;
	}

	public void setOpenDRS_ss(List<String> openDRS_ss) {
		this.openDRS_ss = openDRS_ss;
	}

	public List<String> getCloseDRS_ss() {
		return closeDRS_ss;
	}

	public void setCloseDRS_ss(List<String> closeDRS_ss) {
		this.closeDRS_ss = closeDRS_ss;
	}

	public Map<Denominations, Integer> getDenominations() {
		return denominations;
	}

	public void setDenominations(Map<Denominations, Integer> denominations) {
		this.denominations = denominations;
	}

	public List<BranchBankDeposite> getBankDeposites() {
		return bankDeposites;
	}

	public void setBankDeposites(List<BranchBankDeposite> bankDeposites) {
		this.bankDeposites = bankDeposites;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
