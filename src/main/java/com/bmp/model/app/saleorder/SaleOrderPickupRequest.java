package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.model.app.facility.UserComment;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Component("com.bmp.model.app.saleorder.SaleOrderPickupRequest")
@Document(collection="pickupRequest")
@AssignKey(assvalue=false)
public class SaleOrderPickupRequest extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String pickupId_s;
	private String pickupDateTime;
	private String pickupTimeSlot;
	@Indexed
	private Long pickupDateTimeLong_l;
	private ClientWarehouse clientWarehouse;
	private Integer expectedPackageCount;
	private Integer actualPackageCount;
	@Indexed
	private String clientKey_s;
	private String clientName;
	@Indexed
	private String branchKey_s;
	private String branchName;
	private String statusFlowKey;
	private StatusMasterNew status;
	private Set<String> awbNumbers;
	private Map<String,PickupHistory> pickupHistoryMap;
	private List<UserComment> comments;
	@Indexed
	private String pickupSheet_s;
	private String notPickReasonKey;
	private String orderType;
	@Indexed
	private String manifestNo_s;
	@Indexed
	private String courierKey_s;
	private String sellerId;
	private String courierPickupId;
	
	public SaleOrderPickupRequest() {
		super();
	}

	public String getPickupId_s() {
		return pickupId_s;
	}

	public String getPickupDateTime() {
		return pickupDateTime;
	}

	public Long getPickupDateTimeLong_l() {
		return pickupDateTimeLong_l;
	}

	public ClientWarehouse getClientWarehouse() {
		return clientWarehouse;
	}

	public Integer getExpectedPackageCount() {
		return expectedPackageCount;
	}

	public Integer getActualPackageCount() {
		return actualPackageCount;
	}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public String getClientName() {
		return clientName;
	}

	public String getBranchKey_s() {
		return branchKey_s;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getStatusFlowKey() {
		return statusFlowKey;
	}
 
	
	/*public StatusMaster getStatus() {
		return status;
	}*/


	public StatusMasterNew getStatus() {
		return status;
	}

	public void setStatus(StatusMasterNew status) {
		this.status = status;
	}

	public Map<String, PickupHistory> getPickupHistoryMap() {
		return pickupHistoryMap;
	}

	public List<UserComment> getComments() {
		return comments;
	}

	public String getPickupSheet_s() {
		return pickupSheet_s;
	}

	public String getNotPickReasonKey() {
		return notPickReasonKey;
	}

	public void setPickupId_s(String pickupId_s) {
		this.pickupId_s = pickupId_s;
	}

	public void setPickupDateTime(String pickupDateTime) {
		this.pickupDateTime = pickupDateTime;
	}

	public void setPickupDateTimeLong_l(Long pickupDateTimeLong_l) {
		this.pickupDateTimeLong_l = pickupDateTimeLong_l;
	}

	public void setClientWarehouse(ClientWarehouse clientWarehouse) {
		this.clientWarehouse = clientWarehouse;
	}

	public void setExpectedPackageCount(Integer expectedPackageCount) {
		this.expectedPackageCount = expectedPackageCount;
	}

	public void setActualPackageCount(Integer actualPackageCount) {
		this.actualPackageCount = actualPackageCount;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setBranchKey_s(String branchKey_s) {
		this.branchKey_s = branchKey_s;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}

	/*public void setStatus(StatusMaster status) {
		this.status = status;
	}*/


	public void setPickupHistoryMap(Map<String, PickupHistory> pickupHistoryMap) {
		this.pickupHistoryMap = pickupHistoryMap;
	}

	public void setComments(List<UserComment> comments) {
		this.comments = comments;
	}

	public void setPickupSheet_s(String pickupSheet_s) {
		this.pickupSheet_s = pickupSheet_s;
	}

	public void setNotPickReasonKey(String notPickReasonKey) {
		this.notPickReasonKey = notPickReasonKey;
	}

	public Set<String> getAwbNumbers() {
		return awbNumbers;
	}

	public void setAwbNumbers(Set<String> awbNumbers) {
		this.awbNumbers = awbNumbers;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getManifestNo_s() {
		return manifestNo_s;
	}

	public void setManifestNo_s(String manifestNo_s) {
		this.manifestNo_s = manifestNo_s;
	}

	public String getCourierKey_s() {
		return courierKey_s;
	}

	public void setCourierKey_s(String courierKey_s) {
		this.courierKey_s = courierKey_s;
	}

	public String getPickupTimeSlot() {
		return pickupTimeSlot;
	}

	public void setPickupTimeSlot(String pickupTimeSlot) {
		this.pickupTimeSlot = pickupTimeSlot;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getCourierPickupId() {
		return courierPickupId;
	}

	public void setCourierPickupId(String courierPickupId) {
		this.courierPickupId = courierPickupId;
	}
	
	
	
}
