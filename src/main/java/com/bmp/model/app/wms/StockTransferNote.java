package com.bmp.model.app.wms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.LocationType;
import com.bmp.constant.StnTransferType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
@JsonIgnoreProperties(ignoreUnknown = true)
*/
@Document(collection="stockTransferNote")
@AssignKey(assvalue=true)
public class StockTransferNote extends MongoBaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String clientKey;
	private String supplierKey;
	private String fromWarehouse;
	private String toWarehouse;
	private List<ProductSkus> productSkuList;
	private StatusMasterNew currentStatus;
	private Map<String, StockTransferNoteHistory> stnHistory;
	private String statusFlowKey;
	private StnTransferType transferType; //(WAREHOUSE_TO_WAREHOUSE/WAREHOUSE_TO_SUPPLIER)
	private LocationType  stnType; //GOOD/BAD
	
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getSupplierKey() {
		return supplierKey;
	}
	public void setSupplierKey(String supplierKey) {
		this.supplierKey = supplierKey;
	}
	public String getFromWarehouse() {
		return fromWarehouse;
	}
	public void setFromWarehouse(String fromWarehouse) {
		this.fromWarehouse = fromWarehouse;
	}
	public String getToWarehouse() {
		return toWarehouse;
	}
	public void setToWarehouse(String toWarehouse) {
		this.toWarehouse = toWarehouse;
	}
	public List<ProductSkus> getProductSkuList() {
		return productSkuList;
	}
	public void setProductSkuList(List<ProductSkus> productSkuList) {
		this.productSkuList = productSkuList;
	}
	public StatusMasterNew getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(StatusMasterNew currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public String getStatusFlowKey() {
		return statusFlowKey;
	}
	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Map<String, StockTransferNoteHistory> getStnHistory() {
		return stnHistory;
	}
	public void setStnHistory(Map<String, StockTransferNoteHistory> stnHistory) {
		this.stnHistory = stnHistory;
	}
	public StnTransferType getTransferType() {
		return transferType;
	}
	public void setTransferType(StnTransferType transferType) {
		this.transferType = transferType;
	}
	public LocationType getStnType() {
		return stnType;
	}
	public void setStnType(LocationType stnType) {
		this.stnType = stnType;
	}
}
