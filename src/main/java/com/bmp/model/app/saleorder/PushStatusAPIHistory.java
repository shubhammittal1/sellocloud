package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component("com.bmp.model.app.saleorder.PushStatusAPIHistory")
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="push_Status_API_History")
@AssignKey(assvalue=false)
public class PushStatusAPIHistory extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String clientKey;
	private Map<String, PacketsHistory> packetsHistory;
	
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public Map<String, PacketsHistory> getPacketsHistory() {
		return packetsHistory;
	}
	public void setPacketsHistory(Map<String, PacketsHistory> packetsHistory) {
		this.packetsHistory = packetsHistory;
	}

}
