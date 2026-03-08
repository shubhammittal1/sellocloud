package com.bmp.model.c2c;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebUserBulkOrder {
	private String bulkId_s;
    private List<String> packetId;
    private String gvname;
    private Long gvValue;
	
	public String getGvname() {
		return gvname;
	}
	public void setGvname(String gvname) {
		this.gvname = gvname;
	}
	public Long getGvValue() {
		return gvValue;
	}
	public void setGvValue(Long gvValue) {
		this.gvValue = gvValue;
	}
	public String getBulkId_s() {
		return bulkId_s;
	}
	public void setBulkId_s(String bulkId_s) {
		this.bulkId_s = bulkId_s;
	}
	public List<String> getPacketId() {
		return packetId;
	}
	public void setPacketId(List<String> packetId) {
		this.packetId = packetId;
	}
  
}