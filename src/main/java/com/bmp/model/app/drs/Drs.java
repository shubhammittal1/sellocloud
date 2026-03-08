package com.bmp.model.app.drs;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.DrsType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="drs")
@AssignKey(assvalue=false)
public class Drs extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String branchKey_s;
	private String branchName;
	@Indexed
	private String routeKey_s;
	private String routeName;
	@Indexed
	private String deliveryBoyKey_s;
	private String deliveryBoyName;
	private String deliveryBoyMobileNo;
	private String vehicleNo;
	private String startKm;
	private String endKm;
	private StatusMasterNew currentStatus;
	private String statusFlowKey;
	@Indexed
	private List<String> packetList_ss;
	private List<String> deliveredPackets;
	private Map<String, PacketsHistory> packets;
	private Map<String, DrsHistory> drsHistory;
	private Double drsValue;
	private Double collectableAmount;
	@Indexed
	private Boolean podUpload_b;
	private String appKm;
	private DrsType drsType;
	
	public Drs() {
		super();
	}

	public List<String> getDeliveredPackets() {
		return deliveredPackets;
	}

	public void setDeliveredPackets(List<String> deliveredPackets) {
		this.deliveredPackets = deliveredPackets;
	}

	public Boolean getPodUpload_b() {
		return podUpload_b;
	}

	public void setPodUpload_b(Boolean podUpload_b) {
		this.podUpload_b = podUpload_b;
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

	public String getRouteKey_s() {
		return routeKey_s;
	}

	public void setRouteKey_s(String routeKey_s) {
		this.routeKey_s = routeKey_s;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getDeliveryBoyKey_s() {
		return deliveryBoyKey_s;
	}

	public void setDeliveryBoyKey_s(String deliveryBoyKey_s) {
		this.deliveryBoyKey_s = deliveryBoyKey_s;
	}

	public String getDeliveryBoyName() {
		return deliveryBoyName;
	}

	public void setDeliveryBoyName(String deliveryBoyName) {
		this.deliveryBoyName = deliveryBoyName;
	}

	public String getDeliveryBoyMobileNo() {
		return deliveryBoyMobileNo;
	}

	public void setDeliveryBoyMobileNo(String deliveryBoyMobileNo) {
		this.deliveryBoyMobileNo = deliveryBoyMobileNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getStartKm() {
		return startKm;
	}

	public void setStartKm(String startKm) {
		this.startKm = startKm;
	}

	public String getEndKm() {
		return endKm;
	}

	public void setEndKm(String endKm) {
		this.endKm = endKm;
	}

	/*public StatusMaster getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(StatusMaster currentStatus) {
		this.currentStatus = currentStatus;
	}*/
	

	public String getStatusFlowKey() {
		return statusFlowKey;
	}

	public StatusMasterNew getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(StatusMasterNew currentStatus) {
		this.currentStatus = currentStatus;
	}

	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}

	public Map<String, PacketsHistory> getPackets() {
		return packets;
	}

	public void setPackets(Map<String, PacketsHistory> packets) {
		this.packets = packets;
	}

	public Map<String, DrsHistory> getDrsHistory() {
		return drsHistory;
	}

	public void setDrsHistory(Map<String, DrsHistory> drsHistory) {
		this.drsHistory = drsHistory;
	}

	public List<String> getPacketList_ss() {
		return packetList_ss;
	}

	public void setPacketList_ss(List<String> packetList_ss) {
		this.packetList_ss = packetList_ss;
	}

	public Double getDrsValue() {
		return drsValue;
	}

	public void setDrsValue(Double drsValue) {
		this.drsValue = drsValue;
	}

	public Double getCollectableAmount() {
		return collectableAmount;
	}

	public void setCollectableAmount(Double collectableAmount) {
		this.collectableAmount = collectableAmount;
	}

	public String getAppKm() {
		return appKm;
	}

	public void setAppKm(String appKm) {
		this.appKm = appKm;
	}

	public DrsType getDrsType() {
		return drsType;
	}

	public void setDrsType(DrsType drsType) {
		this.drsType = drsType;
	}
	
	

}
