package com.bmp.bean.convertor;

public class ConvertorHeader {
	
	private String clientHeader;
	private String bmpHeader;
	
	private Boolean isStatic;
	private String staticValue;
	private Boolean isConcat;
	private String headerConcat;
	
	private String extra1;
	private String extra2;

	public ConvertorHeader() {
		super();
	}


	public String getClientHeader() {
		return clientHeader;
	}
	public void setClientHeader(String clientHeader) {
		this.clientHeader = clientHeader;
	}
	public String getBmpHeader() {
		return bmpHeader;
	}
	public void setBmpHeader(String bmpHeader) {
		this.bmpHeader = bmpHeader;
	}
	
	public String getStaticValue() {
		return staticValue;
	}
	public void setStaticValue(String staticValue) {
		this.staticValue = staticValue;
	}
	
	public Boolean getIsStatic() {
		return isStatic;
	}
	public void setIsStatic(Boolean isStatic) {
		this.isStatic = isStatic;
	}
	public Boolean getIsConcat() {
		return isConcat;
	}
	public void setIsConcat(Boolean isConcat) {
		this.isConcat = isConcat;
	}

	public String getHeaderConcat() {
		return headerConcat;
	}
	public void setHeaderConcat(String headerConcat) {
		this.headerConcat = headerConcat;
	}
	public String getExtra1() {
		return extra1;
	}
	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}
	public String getExtra2() {
		return extra2;
	}
	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}
	
	
}
