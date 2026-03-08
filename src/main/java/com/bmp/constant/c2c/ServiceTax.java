package com.bmp.constant.c2c;

import java.math.BigDecimal;

public enum ServiceTax {
	SERVICE_TAX(new BigDecimal(0.0));
	private BigDecimal value;  
		
	private ServiceTax(BigDecimal value){  
		this.value=value;  
	}
	public BigDecimal getValue() {
		return value;
	} 
}
