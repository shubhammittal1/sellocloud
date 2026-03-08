package com.bmp.bean.wms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.app.wms.ProductSkus;
import com.bmp.model.app.wms.StockTransferNoteHistory;
import com.bmp.model.base.MongoBaseBean;

public class StockTransferNoteBean extends MongoBaseBean implements Serializable {

        private static final long serialVersionUID = 1L;

        private String clientKey;
        private String supplierKey;
        private String fromWarehouse;
        private String toWarehouse;
        private List<ProductSkus> productSkuList;
        private StatusMasterNew currentStatus;
        private Map<String, StockTransferNoteHistory> stnHistory;
        private String statusFlowKey;
        private String stnType; //(WAREHOUSE_TO_WAREHOUSE/WAREHOUSE_TO_SUPPLIER)

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

        public String getStnType() {
            return stnType;
        }
        public void setStnType(String stnType) {
            this.stnType = stnType;
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

}
