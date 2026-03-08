
package com.bmp.bean.saleorder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacketInscan {

	private String pickupSheetKey;
	private String pickRequestKey;
	private String awbNumber;
	private List<String> awbNumberList;
	private Integer actualPacket;
	private String client;

	public String getPickupSheetKey() {
		return pickupSheetKey;
	}

	public void setPickupSheetKey(String pickupSheetKey) {
		this.pickupSheetKey = pickupSheetKey;
	}

	public String getPickRequestKey() {
		return pickRequestKey;
	}

	public void setPickRequestKey(String pickRequestKey) {
		this.pickRequestKey = pickRequestKey;
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public List<String> getAwbNumberList() {
		return awbNumberList;
	}

	public void setAwbNumberList(List<String> awbNumberList) {
		this.awbNumberList = awbNumberList;
	}

	public Integer getActualPacket() {
		return actualPacket;
	}

	public void setActualPacket(Integer actualPacket) {
		this.actualPacket = actualPacket;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
}
