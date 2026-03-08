package com.bmp.model.app.wms;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "purchaseOrder")
@AssignKey(assvalue=false)
public class PurchaseOrder extends MongoBaseBean {
	@Indexed
    private String clientKey;
	@Indexed
    private String supplierKey;
	@Indexed
    private String warehouseKey;
    private String poDate;
    private List<ProductSkus> productSkuList;
    private StatusMasterNew currentStatus;
    private Map<String, PoHistory> poHistory;
    @Indexed
    private String statusFlowKey;
    private String clientName;
    private String supplierName;
    
    public String getStatusFlowKey() {
        return statusFlowKey;
    }

    public void setStatusFlowKey(String statusFlowKey) {
        this.statusFlowKey = statusFlowKey;
    }

    public PurchaseOrder() {
        super();
    }

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

    public String getWarehouseKey() {
        return warehouseKey;
    }

    public void setWarehouseKey(String warehouseKey) {
        this.warehouseKey = warehouseKey;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate;
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

    public Map<String, PoHistory> getPoHistory() {
        return poHistory;
    }

    public void setPoHistory(Map<String, PoHistory> poHistory) {
        this.poHistory = poHistory;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSupplierName() { return supplierName; }

    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }
}
