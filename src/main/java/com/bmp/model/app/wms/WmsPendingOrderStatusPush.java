package com.bmp.model.app.wms;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.CatalogueSource;
import com.bmp.constant.OrderSource;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="wmsPendingOrderStatusPush")
@AssignKey(assvalue=false)
public class WmsPendingOrderStatusPush extends MongoBaseBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	private String orderKey;
    private String awbNumber;
    private String packageId;
    private OrderSource source;
    private String marketPlaceKey;
    private boolean pendingPush = false;
    private List<WmsOrderHistory> history;
    
	public String getOrderKey() {
		return orderKey;
	}
	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getMarketPlaceKey() {
		return marketPlaceKey;
	}
	public void setMarketPlaceKey(String marketPlaceKey) {
		this.marketPlaceKey = marketPlaceKey;
	}
	public boolean isPendingPush() {
		return pendingPush;
	}
	public void setPendingPush(boolean pendingPush) {
		this.pendingPush = pendingPush;
	}
	public List<WmsOrderHistory> getHistory() {
		return history;
	}
	public void setHistory(List<WmsOrderHistory> history) {
		this.history = history;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public OrderSource getSource() {
		return source;
	}
	public void setSource(OrderSource source) {
		this.source = source;
	}

}
