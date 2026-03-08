package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.PickupSheetType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="pickupSheet")
@AssignKey(assvalue=false)
public class PickupSheet extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Indexed
	private String branchKey_s;
	private String branchName;
	@Indexed
	private String routeKey_s;
	private String routeName;
	@Indexed
	private String pickerKey_s;
	private String pickerName;
	@Indexed
	private String coloaderKey_s;
	private String coloaderName;
	private String vehicleNo;
	private String startKM;
	private String endKM;
	private StatusMasterNew status;
	private String statusFlowKey;
	@Indexed
	private List<String> pickupRequestKeys_ss;
	private Map<String,PickupHistory> pickupHistoryMap;
	private Map<String,PickupRequestHistory> pickupRequestHistoryMap;
	@Indexed
	private Boolean podUpload_b;
	private PickupSheetType pickupSheetType;
	private String appKm;

	public PickupSheet() {
		super();
	}
	
	public String getStatusFlowKey() {
		return statusFlowKey;
	}

	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
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

	public String getPickerKey_s() {
		return pickerKey_s;
	}

	public void setPickerKey_s(String pickerKey_s) {
		this.pickerKey_s = pickerKey_s;
	}

	public String getPickerName() {
		return pickerName;
	}

	public void setPickerName(String pickerName) {
		this.pickerName = pickerName;
	}

	public String getColoaderKey_s() {
		return coloaderKey_s;
	}

	public void setColoaderKey_s(String coloaderKey_s) {
		this.coloaderKey_s = coloaderKey_s;
	}

	public String getColoaderName() {
		return coloaderName;
	}

	public void setColoaderName(String coloaderName) {
		this.coloaderName = coloaderName;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getStartKM() {
		return startKM;
	}

	public void setStartKM(String startKM) {
		this.startKM = startKM;
	}

	public String getEndKM() {
		return endKM;
	}

	public void setEndKM(String endKM) {
		this.endKM = endKM;
	}

	public StatusMasterNew getStatus() {
		return status;
	}

	public void setStatus(StatusMasterNew status) {
		this.status = status;
	}

	public List<String> getPickupRequestKeys_ss() {
		return pickupRequestKeys_ss;
	}

	public void setPickupRequestKeys_ss(List<String> pickupRequestKeys_ss) {
		this.pickupRequestKeys_ss = pickupRequestKeys_ss;
	}

	public Map<String, PickupHistory> getPickupHistoryMap() {
		return pickupHistoryMap;
	}

	public void setPickupHistoryMap(Map<String, PickupHistory> pickupHistoryMap) {
		this.pickupHistoryMap = pickupHistoryMap;
	}

	public Map<String, PickupRequestHistory> getPickupRequestHistoryMap() {
		return pickupRequestHistoryMap;
	}

	public void setPickupRequestHistoryMap(Map<String, PickupRequestHistory> pickupRequestHistoryMap) {
		this.pickupRequestHistoryMap = pickupRequestHistoryMap;
	}

	public Boolean getPodUpload_b() {
		return podUpload_b;
	}

	public void setPodUpload_b(Boolean podUpload_b) {
		this.podUpload_b = podUpload_b;
	}
	
	public PickupSheetType getPickupSheetType() {
		return pickupSheetType;
	}

	public void setPickupSheetType(PickupSheetType pickupSheetType) {
		this.pickupSheetType = pickupSheetType;
	}

	public String getAppKm() {
		return appKm;
	}

	public void setAppKm(String appKm) {
		this.appKm = appKm;
	}
	
}
