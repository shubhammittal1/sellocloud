package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.constant.ClientStatusPushType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component("com.bmp.model.app.saleorder.PushPacketStatusHistory")
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="push_Packet_Status_History")
@AssignKey(assvalue=false)
public class PushPacketStatusHistory extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Indexed
	private String clientKey_s;
	private Map<String, PacketsHistoryNew> packetsHistoryNew;
	@Indexed
	private boolean pendingPushStatus_b; 
	@Indexed
	private boolean pushStatusTerminat_b;
	private Map<String, BFILPacketsHistory> bfilPacketsHistory;
	private String errorLogsKey;
	private String successLogsKey;
	private boolean podPushed;
	
	private Map<ClientStatusPushType, Object> extraHistory;
	private Map<ClientStatusPushType, Boolean> extraPushed;
	
	public String getClientKey_s() {
		return clientKey_s;
	}
	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}
	public Map<String, PacketsHistoryNew> getPacketsHistoryNew() {
		return packetsHistoryNew;
	}
	public void setPacketsHistoryNew(Map<String, PacketsHistoryNew> packetsHistoryNew) {
		this.packetsHistoryNew = packetsHistoryNew;
	}
	public boolean isPendingPushStatus_b() {
		return pendingPushStatus_b;
	}
	public void setPendingPushStatus_b(boolean pendingPushStatus_b) {
		this.pendingPushStatus_b = pendingPushStatus_b;
	}
	public boolean isPushStatusTerminat_b() {
		return pushStatusTerminat_b;
	}
	public void setPushStatusTerminat_b(boolean pushStatusTerminat_b) {
		this.pushStatusTerminat_b = pushStatusTerminat_b;
	}
	public Map<String, BFILPacketsHistory> getBfilPacketsHistory() {
		return bfilPacketsHistory;
	}
	public void setBfilPacketsHistory(Map<String, BFILPacketsHistory> bfilPacketsHistory) {
		this.bfilPacketsHistory = bfilPacketsHistory;
	}
	public String getErrorLogsKey() {
		return errorLogsKey;
	}
	public void setErrorLogsKey(String errorLogsKey) {
		this.errorLogsKey = errorLogsKey;
	}
	public String getSuccessLogsKey() {
		return successLogsKey;
	}
	public void setSuccessLogsKey(String successLogsKey) {
		this.successLogsKey = successLogsKey;
	}
	public boolean isPodPushed() {
		return podPushed;
	}
	public void setPodPushed(boolean podPushed) {
		this.podPushed = podPushed;
	}
	public Map<ClientStatusPushType, Object> getExtraHistory() {
		return extraHistory;
	}
	public void setExtraHistory(Map<ClientStatusPushType, Object> extraHistory) {
		this.extraHistory = extraHistory;
	}
	public Map<ClientStatusPushType, Boolean> getExtraPushed() {
		return extraPushed;
	}
	public void setExtraPushed(Map<ClientStatusPushType, Boolean> extraPushed) {
		this.extraPushed = extraPushed;
	}
	
	
	
}
