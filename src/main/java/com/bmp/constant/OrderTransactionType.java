package com.bmp.constant;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public enum OrderTransactionType {
	FORWARD_FREIGHT_CHARGES,
	RTO_FREIGHT_CHARGES,
	COD_CHARGE_REVERSAL ,
	FORWARD_FREIGHT_CHARGE_REVERSAL,
	COURIER_FORWARD_FREIGHT_CHARGE;//  (Courier weight)
	
	public static Map<String,String> getKeyVal (){
		Map<String, String> map = new HashedMap();
		map.put("FORWARD_FREIGHT_CHARGES", "Forward freight charges");
		map.put("RTO_FREIGHT_CHARGES","RTO freight charges");
		map.put("COD_CHARGE_REVERSAL","COD charge reversal");
		map.put("FORWARD_FREIGHT_CHARGE_REVERSAL","Forward freight charge reversal");
		map.put("COURIER_FORWARD_FREIGHT_CHARGE","Revised forward freight charge");
		return map;
	}
}
