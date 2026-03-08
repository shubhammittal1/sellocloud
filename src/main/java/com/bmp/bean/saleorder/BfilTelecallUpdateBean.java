package com.bmp.bean.saleorder;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BfilTelecallUpdateBean {

	@JsonProperty("LoanProposalID")
	private String LoanProposalID;
	
	@JsonProperty("UpdateDate")
	private String UpdateDate;
	
	@JsonProperty("AlternateMobileNumber")
	private String AlternateMobileNumber;
	
	@JsonProperty("TelecallStatus")
	private String TelecallStatus;
	
	public BfilTelecallUpdateBean() {
		super();
	}

	public String getLoanProposalID() {
		return LoanProposalID;
	}

	public void setLoanProposalID(String loanProposalID) {
		LoanProposalID = loanProposalID;
	}

	public String getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}

	public String getAlternateMobileNumber() {
		return AlternateMobileNumber;
	}

	public void setAlternateMobileNumber(String alternateMobileNumber) {
		AlternateMobileNumber = alternateMobileNumber;
	}

	public String getTelecallStatus() {
		return TelecallStatus;
	}

	public void setTelecallStatus(String telecallStatus) {
		TelecallStatus = telecallStatus;
	}
	
	
}
