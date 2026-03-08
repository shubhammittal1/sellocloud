package com.bmp.model.app.saleorder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RemittenceBankDeposit {
	
	private String bankName;
	private String accountNo;
	private String transactionNo;
	private Double depositedAmt;
	private String depositSlip;
	private String depositDate;
	
	public RemittenceBankDeposit(){
		super();
	}

	public String getBankName() {
		return bankName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public Double getDepositedAmt() {
		return depositedAmt;
	}

	public String getDepositSlip() {
		return depositSlip;
	}

	public String getDepositDate() {
		return depositDate;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public void setDepositedAmt(Double depositedAmt) {
		this.depositedAmt = depositedAmt;
	}

	public void setDepositSlip(String depositSlip) {
		this.depositSlip = depositSlip;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}
	
	
}
