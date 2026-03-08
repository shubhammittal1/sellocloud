package com.bmp.model.app.wms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.BusinessType;
import com.bmp.constant.OrderSource;
import com.bmp.constant.PaymentType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.saleorder.Address;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="order")
@AssignKey(assvalue=false)
public class Order extends MongoBaseBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Indexed
	private String clientKey;
	private String clientName;
	private StatusMasterNew currentStatus;
	@Indexed
	private String clientChannelKey;
	@Indexed
	private String shopCode;
	@Indexed
	private OrderSource orderSource;
	@Indexed
	private PaymentType paymentType;
	private BusinessType businessType;
	@Indexed
	private String orderId;
	private Double orderAmount;
	private String orderDate;
	private Integer quantity = 0;
	private Integer fulfilledQuantity = 0;
	@Indexed
	private List<String> orderSkuKeys;
	private Map<String,Integer>skuCodeQty;
	@Transient
	private Map<String,Double>skuCodeAmount;
	private Address shippingAddress;
	private Address billingAddress;
	private Boolean isFulfilled = false;
	private List<String> packageKeys;
	private String eWayBill;
	private String coloaderKey;
	private String coloaderVahicleNo;
    private String skuImageUrls;
    private boolean isPod;

	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public StatusMasterNew getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(StatusMasterNew currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getClientChannelKey() {
		return clientChannelKey;
	}
	public void setClientChannelKey(String clientChannelKey) {
		this.clientChannelKey = clientChannelKey;
	}
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public OrderSource getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(OrderSource orderSource) {
		this.orderSource = orderSource;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getFulfilledQuantity() {
		return fulfilledQuantity;
	}
	public void setFulfilledQuantity(Integer fulfilledQuantity) {
		this.fulfilledQuantity = fulfilledQuantity;
	}
	public List<String> getOrderSkuKeys() {
		return orderSkuKeys;
	}
	public void setOrderSkuKeys(List<String> orderSkuKeys) {
		this.orderSkuKeys = orderSkuKeys;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BusinessType getBusinessType() {
		return businessType;
	}
	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}
	public Map<String,Integer> getSkuCodeQty() {
		return skuCodeQty;
	}
	public void setSkuCodeQty(Map<String,Integer> skuCodeQty) {
		this.skuCodeQty = skuCodeQty;
	}
	public Boolean getIsFulfilled() {
		return isFulfilled;
	}
	public void setIsFulfilled(Boolean isFulfilled) {
		this.isFulfilled = isFulfilled;
	}
	public Map<String,Double> getSkuCodeAmount() {
		return skuCodeAmount;
	}
	public void setSkuCodeAmount(Map<String,Double> skuCodeAmount) {
		this.skuCodeAmount = skuCodeAmount;
	}
	public List<String> getPackageKeys() {
		return packageKeys;
	}
	public void setPackageKeys(List<String> packageKeys) {
		this.packageKeys = packageKeys;
	}
	public String geteWayBill() {
		return eWayBill;
	}
	public void seteWayBill(String eWayBill) {
		this.eWayBill = eWayBill;
	}
	
	public String getColoaderKey() {
		return coloaderKey;
	}
	public void setColoaderKey(String coloaderKey) {
		this.coloaderKey = coloaderKey;
	}
	public String getColoaderVahicleNo() {
		return coloaderVahicleNo;
	}
	public void setColoaderVahicleNo(String coloaderVahicleNo) {
		this.coloaderVahicleNo = coloaderVahicleNo;
	}

    public Boolean getFulfilled() {
        return isFulfilled;
    }

    public void setFulfilled(Boolean fulfilled) {
        isFulfilled = fulfilled;
    }

    public String getSkuImageUrls() {
        return skuImageUrls;
    }

    public void setSkuImageUrls(String skuImageUrls) {
        this.skuImageUrls = skuImageUrls;
    }

    public boolean isPod() {
        return isPod;
    }

    public void setPod(boolean pod) {
        isPod = pod;
    }
}
