package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.bean.saleorder.TeleCallingBean;
import com.bmp.constant.TeleCallingType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="teleCallingManifest")
@AssignKey(assvalue=true)
public class TeleCallingManifest extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = -1653566048825959255L;

	private int totalCount;
	private int openCount;
	private int closeCount;
	@Indexed
	private String userKeys;
	@Indexed
	private String manifestStatus;
	@Indexed
	private List<String> orderlist;
	private Map<String, TeleCallingBean> orderMap;
	private TeleCallingType teleCallingType;
	
	public TeleCallingManifest() {
		super();
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getOpenCount() {
		return openCount;
	}

	public void setOpenCount(int openCount) {
		this.openCount = openCount;
	}

	public int getCloseCount() {
		return closeCount;
	}

	public void setCloseCount(int closeCount) {
		this.closeCount = closeCount;
	}

	public String getUserKeys() {
		return userKeys;
	}

	public void setUserKeys(String userKeys) {
		this.userKeys = userKeys;
	}

	public String getManifestStatus() {
		return manifestStatus;
	}

	public void setManifestStatus(String manifestStatus) {
		this.manifestStatus = manifestStatus;
	}

	public List<String> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<String> orderlist) {
		this.orderlist = orderlist;
	}

	public Map<String, TeleCallingBean> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<String, TeleCallingBean> orderMap) {
		this.orderMap = orderMap;
	}

	public TeleCallingType getTeleCallingType() {
		return teleCallingType;
	}

	public void setTeleCallingType(TeleCallingType teleCallingType) {
		this.teleCallingType = teleCallingType;
	}

}
