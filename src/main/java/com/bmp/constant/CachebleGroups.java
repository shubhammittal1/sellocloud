package com.bmp.constant;

public enum CachebleGroups {
	
	PINCODE_GROUPS("pincodeGroups"),
	COURIER_PRIORITYS("courierPrioritys"),
	SETTINGS("settings"),
	STATUS("status"),
	PINCODES("pincodes"),
	COURIER_PRIORITY_TEMPLATE("courierPriorityTemplate"),
	COURIER("courier"),
	CLIENT("client"),
	STATUSFLOW("statusflow");
	
    private final String value;

    CachebleGroups(final String newValue) {
    	value = newValue;
    }

    public String getValue() { return value; }
		
}
