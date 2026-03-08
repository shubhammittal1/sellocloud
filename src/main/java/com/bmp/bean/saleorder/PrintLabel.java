package com.bmp.bean.saleorder;

import java.io.Serializable;

public class PrintLabel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String awbType;
	private String awbNumber;
	private String conditionValue;
	private String printType;
	
	public PrintLabel() {
		super();
	}

	public String getAwbType() {
		return awbType;
	}

	public void setAwbType(String awbType) {
		this.awbType = awbType;
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public String getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	public String getPrintType() {
		return printType;
	}

	public void setPrintType(String printType) {
		this.printType = printType;
	}
	
	
	
	
}
