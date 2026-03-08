package com.bmp.model.app.drs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchBankDeposite {
	
	private String bankName;
	private String bankAccNo;
	private String bankTranNo;
	private String depositeDate;
	private Double depositedAmount;
	private String bankSlipName;
	
	public BranchBankDeposite () {
		super();
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getBankTranNo() {
		return bankTranNo;
	}

	public void setBankTranNo(String bankTranNo) {
		this.bankTranNo = bankTranNo;
	}
	

	public String getDepositeDate() {
		return depositeDate;
	}

	public void setDepositeDate(String depositeDate) {
		this.depositeDate = depositeDate;
	}

	public Double getDepositedAmount() {
		return depositedAmount;
	}

	public void setDepositedAmount(Double depositedAmount) {
		this.depositedAmount = depositedAmount;
	}

	public String getBankSlipName() {
		return bankSlipName;
	}

	public void setBankSlipName(String bankSlipName) {
		this.bankSlipName = bankSlipName;
	}
	
}
