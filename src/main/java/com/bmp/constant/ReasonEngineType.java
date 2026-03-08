package com.bmp.constant;

import java.util.ArrayList;
import java.util.List;

public enum ReasonEngineType {
	FWD_PICKUP, RVP_PICKUP, FWD_NDR, RTO_NDR;
	
	public static List<String> getAllValue(){
		List<String> list = new ArrayList<String>();
		for(ReasonEngineType engineType : ReasonEngineType.values()){
			list.add(engineType.name());
		}
		return list;
	}
}
