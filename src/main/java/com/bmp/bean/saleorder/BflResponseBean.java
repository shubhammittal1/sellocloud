package com.bmp.bean.saleorder;

import java.io.Serializable;

public class BflResponseBean implements Serializable{

private static final long serialVersionUID = 1L;
	
	private String LoanProposalID;
	private String Code;
	private String Remarks;
	
	public String getLoanProposalID() {
		return LoanProposalID;
	}
	public void setLoanProposalID(String loanProposalID) {
		LoanProposalID = loanProposalID;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	
	

	
}
