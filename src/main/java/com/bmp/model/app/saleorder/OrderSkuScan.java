package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="orderSkuScan")
@AssignKey(assvalue=true)
public class OrderSkuScan extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String awbNumber;
	private String branchKey_s;
	private String branchName;
	private int count;
	//private Map<String, OrderSkuMap> packets;
	private Map<String, String> orderSkuMap;
	@Indexed
	private List<String> packetList_ss;

	public OrderSkuScan() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public String getBranchKey_s() {
		return branchKey_s;
	}

	public void setBranchKey_s(String branchKey_s) {
		this.branchKey_s = branchKey_s;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public List<String> getPacketList_ss() {
		return packetList_ss;
	}

	public void setPacketList_ss(List<String> packetList_ss) {
		this.packetList_ss = packetList_ss;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Map<String, String> getOrderSkuMap() {
		return orderSkuMap;
	}

	public void setOrderSkuMap(Map<String, String> orderSkuMap) {
		this.orderSkuMap = orderSkuMap;
	}

}