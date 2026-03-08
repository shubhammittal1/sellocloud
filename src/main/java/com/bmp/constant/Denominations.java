package com.bmp.constant;

public enum Denominations {
	TWO_THOUSAND(2000), ONE_THOUSAND(1000), FIVE_HUNDRED(500), ONE_HUNDRED(100), FIFTY(50), TWENTY(20), TEN(10), FIVE(5), TWO(2), ONE(1);
	
	int value;
	
	Denominations (int value) {
		this.value = value;
	}
	
	public int getValue () {
		return value;
	}
}

