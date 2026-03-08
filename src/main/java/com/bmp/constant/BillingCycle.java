package com.bmp.constant;

public enum BillingCycle {
	
	DAILY(0), 
	WEEKLY(7),
	FORTNIGHTLY(15),
    MONTHLY(30),
    HALFYEARLY(60),
	YEARLY(365);
	

    private final int value;

    BillingCycle(final int newValue) {
    	value = newValue;
    }

    public int getValue() { return value; }
}
