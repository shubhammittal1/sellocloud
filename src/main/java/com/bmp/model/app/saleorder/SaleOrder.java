package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.bean.saleorder.TeleCallingBean;
import com.bmp.bean.saleorder.TeleStatusBean;
import com.bmp.constant.BillingStatus;
import com.bmp.constant.CodCashStatus;
import com.bmp.constant.RemittanceStatus;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="saleOrder")
@AssignKey(assvalue=false)
@Component("com.bmp.model.app.saleorder.SaleOrder")
public class SaleOrder extends MongoBaseBean implements Serializable,Cloneable {

	private static final long serialVersionUID = -2266030021184600448L;

	private String awbNumber;
	private String statusFlowKey;
	private StatusMasterNew currentStatus;
	private String source; // C2C, IOS APP, ANDROID APP, CLIENT_API, UPLOAD

	@Indexed
	private String routingMode_s; // DRS, 3PL, INTERNAL_TRANSFER
	//@Indexed
	private String sourceBranch_s;
	//TODO : T R
	//private String previousBranch_s;
	//@Indexed
	private String currentBranch_s;
	//@Indexed
	private String nextBranch_s;
	//@Indexed
	private String destinationBranch_s;
	
	//TODO : T RI
	private String manifestKey; //manifestKey_s;
	//TODO : T RI
	private String bagKey; //bagKey_s;

	@Indexed
	private String courierKey_s;
	@Indexed
	private String courierAWBNumber_s;
	
	@Indexed
	private String courierMasterAWBNumber;
	private String courierDocumentAWBNumber;
	@Indexed
	private String clientKey_s;
	private String clientManifest;
	//TODO : Remove
	//private Long scannedDate_l;
	private Long scannedDate;
	//TODO : Remove r
	//private String pickupSheetKey_s;
	//TODO : Remove r
	private String pickupRequestKey;
	private Integer pickupAttemptedCount;
	private String pickupFailReason;
	
	@Indexed
	private Boolean handOver_b;
	private String handOverBranch;

	//private Boolean customerPickup_b; // New
	//TODO : Remove r
	//private ClientWarehouse clientWarehouse; // new

	/* Sender Details Start */
	private String senderName; // new
	//TODO : Remove
	//TODO : S RI
	//private String senderMobileNumber_s; // new
	private String senderMobileNumber; // new
	private String senderAltNumber; // new
	private String senderEmail; // new
	private String senderCountry; // new
	private String senderState; // new
	private String senderCity; // pickupLocationCity
	private String senderAddress; // pickupLocationAddress
	private String senderLandmark; // NEW
	private String pickupDateTime;
	private String pickupTimeSlot;
	//TODO : S RI
	//private String senderPincode_s; // pickupLocationPincode_s
	private String senderPincode; // pickupLocationPincode_s
	/* Sender Details End */

	/* Receiver Details Start */
	private String consigneeName;
	//TODO : S RI
	//private String consigneeMobileNumber_s; // consigneeContact_l
	private String consigneeMobileNumber; // consigneeContact_l
	private String consigneeAlternateNumber; // consigneeAlternateNumber_l
	private String consigneeEmailId;
	private String consigneeCountry;
	private String consigneeState;
	private String consigneeCity;
	private String consigneeAddress;
	private String consigneeLandmark;
	//TODO : S RI
	//private String consigneePincode_s; // consigneePincode_i
	private String consigneePincode; // consigneePincode_i
	/* Receiver Details End */

	private String productType;
	@Indexed
	private String paymentType_s;
	//TODO : S RI
	//private String serviceMode_s;
	private String serviceMode;
	@Indexed
	private String saleOrderNumber_s;
	private String saleOrderDate;

	private String productSKU; // sku_ProductCode
	private String productName; // product
	private Integer quantity;
	private Double weight;
	private Double length;
	private Double width;
	private Double height;
	private Double dimensionalWeight;
	private Double collectableAmount;
	private Double productPrice; // grossAmount
	private String perishable;
	private String flammable;

	private Double actualWeight;
	private Double actualLength;
	private Double actualWidth;
	private Double actualHeight;
	private Double actualDimensionalWeight;
	private Double chargableWeight;

	@Indexed
	private Boolean softDataReceived_b;
	//TODO : Remove r x
	private List<String> drsList;
	private Map<String, PacketsHistory> packetsHistory;
	@Indexed
	private String drsReason_s;
	private Integer drsAttemptedCount;
	@Indexed
	private String rtoReason_s;
	
	//TODO : Remove r
	private Boolean rto;
	
	//TODO : Remove ex
	private String cashClosingCode;
	//TODO : Remove ex
	@Indexed
	private CodCashStatus codCashStatus_s;  
	@Indexed
	private Long deliveredDate_l;
	@Indexed
	private Long rtoDate;
	
	//TODO : T ex
	//private String remittanceNo;
	//TODO : T ex
	@Indexed
	private RemittanceStatus remittanceStatus_s;
	
	//TODO : S ex
	@Indexed
	private boolean pushTrackingDone_b;
	//TODO : S ex
	//@Indexed
	private boolean orderPunchIn3pl_b;
	
	private String returnReason;
	private String category;
	private String brand;
	private String size;
	private String color;
	private String imeiNumber;
	@Indexed
	private String orderType_s;
	private String productImagesUrl;
	private String pendingStatusToUpload;
	
	private String clientOrderDate;				//optional
	private String returnName;					//mandate
	private String returnAddress;               //mandate
	private String returnLandmark;              //optional
	private String returnMobileNumber;         	//mandate
	private String returnAlternateNumber;       //optional
	private String returnPincode;				//mandate
	private String returnCountry;
	private String returnState;
	private String returnCity;

	private String isSellerRegUnderGST;         //optional
	private String sellerGSTRegNumber;          //optional
	private String buyerGSTRegNumber;           //optional
	private String eWayBillSrNumber;            //optional
	private String hsnCode;                     //optional
	private String taxableValue;                //optional
	private String sGSTAmount;                  //optional
	private String cGSTAmount;                  //optional
	private String iGSTAmount;                  //optional
	private String vendorBranchCode; 
	
	@Indexed
	private BillingStatus billingStatus_s;
	private boolean systemCalling;
	private boolean sendManualSms;
	
	private String invoiceStatus;
	private String telecallingStatus;
	private int telecallingCount;
	private Map<String, TeleCallingBean> telecallingHistory;
	private String clientVendorCode;
	private String invoiceDate;
	private int totalTelecallingCount;
	private Boolean teleStatusPush;
	private Boolean contactUpdate;
	private String callingManifestId;
	private String callingManifestStatus;
	private String callingManifestUserKey;
	private Map<String, TeleStatusBean> teleStatusMap;
	private String cancelReason;
	private String proformaInvoiceNumber;
	private String proformaInvoiceDate;
	private boolean merchantHandOver;
	private boolean isB2B;
	//@Indexed
	//private String parentAwb;
	private String serviceType;
	private Boolean isInternational = false;
	private boolean isOwnerRisk = false;
	private String carrierId;
	
	public SaleOrder() {
		super();
	}
	
	@Override
	public Object clone()throws CloneNotSupportedException{  
		return org.apache.commons.lang3.SerializationUtils.clone((SaleOrder)super.clone());
		//return super.clone();  
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public String getStatusFlowKey() {
		return statusFlowKey;
	}

	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}

	public StatusMasterNew getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(StatusMasterNew currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRoutingMode_s() {
		return routingMode_s;
	}

	public void setRoutingMode_s(String routingMode_s) {
		this.routingMode_s = routingMode_s;
	}

	public String getSourceBranch_s() {
		return sourceBranch_s;
	}

	public void setSourceBranch_s(String sourceBranch_s) {
		this.sourceBranch_s = sourceBranch_s;
	}

	public String getCurrentBranch_s() {
		return currentBranch_s;
	}

	public void setCurrentBranch_s(String currentBranch_s) {
		this.currentBranch_s = currentBranch_s;
	}

	public String getNextBranch_s() {
		return nextBranch_s;
	}

	public void setNextBranch_s(String nextBranch_s) {
		this.nextBranch_s = nextBranch_s;
	}

	public String getDestinationBranch_s() {
		return destinationBranch_s;
	}

	public void setDestinationBranch_s(String destinationBranch_s) {
		this.destinationBranch_s = destinationBranch_s;
	}

	public String getManifestKey() {
		return manifestKey;
	}

	public void setManifestKey(String manifestKey) {
		this.manifestKey = manifestKey;
	}

	public String getBagKey() {
		return bagKey;
	}

	public void setBagKey(String bagKey) {
		this.bagKey = bagKey;
	}

	public String getCourierKey_s() {
		return courierKey_s;
	}

	public void setCourierKey_s(String courierKey_s) {
		this.courierKey_s = courierKey_s;
	}

	public String getCourierAWBNumber_s() {
		return courierAWBNumber_s;
	}

	public void setCourierAWBNumber_s(String courierAWBNumber_s) {
		this.courierAWBNumber_s = courierAWBNumber_s;
	}
	
	public String getCourierMasterAWBNumber() {
		return courierMasterAWBNumber;
	}

	public void setCourierMasterAWBNumber(String courierMasterAWBNumber) {
		this.courierMasterAWBNumber = courierMasterAWBNumber;
	}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	public String getClientManifest() {
		return clientManifest;
	}

	public void setClientManifest(String clientManifest) {
		this.clientManifest = clientManifest;
	}

	public Long getScannedDate() {
		return scannedDate;
	}

	public void setScannedDate(Long scannedDate) {
		this.scannedDate = scannedDate;
	}

	public String getPickupRequestKey() {
		return pickupRequestKey;
	}

	public void setPickupRequestKey(String pickupRequestKey) {
		this.pickupRequestKey = pickupRequestKey;
	}

	public Integer getPickupAttemptedCount() {
		return pickupAttemptedCount;
	}

	public void setPickupAttemptedCount(Integer pickupAttemptedCount) {
		this.pickupAttemptedCount = pickupAttemptedCount;
	}

	public String getPickupFailReason() {
		return pickupFailReason;
	}

	public void setPickupFailReason(String pickupFailReason) {
		this.pickupFailReason = pickupFailReason;
	}

	public Boolean getHandOver_b() {
		return handOver_b;
	}

	public void setHandOver_b(Boolean handOver_b) {
		this.handOver_b = handOver_b;
	}

	public String getHandOverBranch() {
		return handOverBranch;
	}

	public void setHandOverBranch(String handOverBranch) {
		this.handOverBranch = handOverBranch;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderMobileNumber() {
		return senderMobileNumber;
	}

	public void setSenderMobileNumber(String senderMobileNumber) {
		this.senderMobileNumber = senderMobileNumber;
	}

	public String getSenderAltNumber() {
		return senderAltNumber;
	}

	public void setSenderAltNumber(String senderAltNumber) {
		this.senderAltNumber = senderAltNumber;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSenderCountry() {
		return senderCountry;
	}

	public void setSenderCountry(String senderCountry) {
		this.senderCountry = senderCountry;
	}

	public String getSenderState() {
		return senderState;
	}

	public void setSenderState(String senderState) {
		this.senderState = senderState;
	}

	public String getSenderCity() {
		return senderCity;
	}

	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderLandmark() {
		return senderLandmark;
	}

	public void setSenderLandmark(String senderLandmark) {
		this.senderLandmark = senderLandmark;
	}

	public String getSenderPincode() {
		return senderPincode;
	}

	public void setSenderPincode(String senderPincode) {
		this.senderPincode = senderPincode;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeMobileNumber() {
		return consigneeMobileNumber;
	}

	public void setConsigneeMobileNumber(String consigneeMobileNumber) {
		this.consigneeMobileNumber = consigneeMobileNumber;
	}

	public String getConsigneeAlternateNumber() {
		return consigneeAlternateNumber;
	}

	public void setConsigneeAlternateNumber(String consigneeAlternateNumber) {
		this.consigneeAlternateNumber = consigneeAlternateNumber;
	}

	public String getConsigneeEmailId() {
		return consigneeEmailId;
	}

	public void setConsigneeEmailId(String consigneeEmailId) {
		this.consigneeEmailId = consigneeEmailId;
	}

	public String getConsigneeCountry() {
		return consigneeCountry;
	}

	public void setConsigneeCountry(String consigneeCountry) {
		this.consigneeCountry = consigneeCountry;
	}

	public String getConsigneeState() {
		return consigneeState;
	}

	public void setConsigneeState(String consigneeState) {
		this.consigneeState = consigneeState;
	}

	public String getConsigneeCity() {
		return consigneeCity;
	}

	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneeLandmark() {
		return consigneeLandmark;
	}

	public void setConsigneeLandmark(String consigneeLandmark) {
		this.consigneeLandmark = consigneeLandmark;
	}

	public String getConsigneePincode() {
		return consigneePincode;
	}

	public void setConsigneePincode(String consigneePincode) {
		this.consigneePincode = consigneePincode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPaymentType_s() {
		return paymentType_s;
	}

	public void setPaymentType_s(String paymentType_s) {
		this.paymentType_s = paymentType_s;
	}

	public String getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
	}

	public String getSaleOrderNumber_s() {
		return saleOrderNumber_s;
	}

	public void setSaleOrderNumber_s(String saleOrderNumber_s) {
		this.saleOrderNumber_s = saleOrderNumber_s;
	}

	public String getSaleOrderDate() {
		return saleOrderDate;
	}

	public void setSaleOrderDate(String saleOrderDate) {
		this.saleOrderDate = saleOrderDate;
	}

	public String getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getCollectableAmount() {
		return collectableAmount;
	}

	public void setCollectableAmount(Double collectableAmount) {
		this.collectableAmount = collectableAmount;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getPerishable() {
		return perishable;
	}

	public void setPerishable(String perishable) {
		this.perishable = perishable;
	}

	public String getFlammable() {
		return flammable;
	}

	public void setFlammable(String flammable) {
		this.flammable = flammable;
	}

	public Double getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(Double actualWeight) {
		this.actualWeight = actualWeight;
	}

	public Double getActualLength() {
		return actualLength;
	}

	public void setActualLength(Double actualLength) {
		this.actualLength = actualLength;
	}

	public Double getActualWidth() {
		return actualWidth;
	}

	public void setActualWidth(Double actualWidth) {
		this.actualWidth = actualWidth;
	}

	public Double getActualHeight() {
		return actualHeight;
	}

	public void setActualHeight(Double actualHeight) {
		this.actualHeight = actualHeight;
	}

	public Double getActualDimensionalWeight() {
		return actualDimensionalWeight;
	}

	public void setActualDimensionalWeight(Double actualDimensionalWeight) {
		this.actualDimensionalWeight = actualDimensionalWeight;
	}

	public Double getChargableWeight() {
		return chargableWeight;
	}

	public void setChargableWeight(Double chargableWeight) {
		this.chargableWeight = chargableWeight;
	}

	public Boolean getSoftDataReceived_b() {
		return softDataReceived_b;
	}

	public void setSoftDataReceived_b(Boolean softDataReceived_b) {
		this.softDataReceived_b = softDataReceived_b;
	}

	public List<String> getDrsList() {
		return drsList;
	}

	public void setDrsList(List<String> drsList) {
		this.drsList = drsList;
	}

	public Map<String, PacketsHistory> getPacketsHistory() {
		return packetsHistory;
	}

	public void setPacketsHistory(Map<String, PacketsHistory> packetsHistory) {
		this.packetsHistory = packetsHistory;
	}

	public String getDrsReason_s() {
		return drsReason_s;
	}

	public void setDrsReason_s(String drsReason_s) {
		this.drsReason_s = drsReason_s;
	}

	public Integer getDrsAttemptedCount() {
		return drsAttemptedCount;
	}

	public void setDrsAttemptedCount(Integer drsAttemptedCount) {
		this.drsAttemptedCount = drsAttemptedCount;
	}

	public String getRtoReason_s() {
		return rtoReason_s;
	}

	public void setRtoReason_s(String rtoReason_s) {
		this.rtoReason_s = rtoReason_s;
	}

	public Boolean getRto() {
		return rto;
	}

	public void setRto(Boolean rto) {
		this.rto = rto;
	}

	public String getCashClosingCode() {
		return cashClosingCode;
	}

	public void setCashClosingCode(String cashClosingCode) {
		this.cashClosingCode = cashClosingCode;
	}

	public CodCashStatus getCodCashStatus_s() {
		return codCashStatus_s;
	}

	public void setCodCashStatus_s(CodCashStatus codCashStatus_s) {
		this.codCashStatus_s = codCashStatus_s;
	}

	public Long getDeliveredDate_l() {
		return deliveredDate_l;
	}

	public void setDeliveredDate_l(Long deliveredDate_l) {
		this.deliveredDate_l = deliveredDate_l;
	}

	public RemittanceStatus getRemittanceStatus_s() {
		return remittanceStatus_s;
	}

	public void setRemittanceStatus_s(RemittanceStatus remittanceStatus_s) {
		this.remittanceStatus_s = remittanceStatus_s;
	}

	public boolean isPushTrackingDone_b() {
		return pushTrackingDone_b;
	}

	public void setPushTrackingDone_b(boolean pushTrackingDone_b) {
		this.pushTrackingDone_b = pushTrackingDone_b;
	}

	public boolean isOrderPunchIn3pl_b() {
		return orderPunchIn3pl_b;
	}

	public void setOrderPunchIn3pl_b(boolean orderPunchIn3pl_b) {
		this.orderPunchIn3pl_b = orderPunchIn3pl_b;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImeiNumber() {
		return imeiNumber;
	}

	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}

	public String getOrderType_s() {
		return orderType_s;
	}

	public void setOrderType_s(String orderType_s) {
		this.orderType_s = orderType_s;
	}

	public String getProductImagesUrl() {
		return productImagesUrl;
	}

	public void setProductImagesUrl(String productImagesUrl) {
		this.productImagesUrl = productImagesUrl;
	}

	public String getPendingStatusToUpload() {
		return pendingStatusToUpload;
	}

	public void setPendingStatusToUpload(String pendingStatusToUpload) {
		this.pendingStatusToUpload = pendingStatusToUpload;
	}

	public String getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}

	public String getReturnLandmark() {
		return returnLandmark;
	}

	public void setReturnLandmark(String returnLandmark) {
		this.returnLandmark = returnLandmark;
	}

	public String getReturnAlternateNumber() {
		return returnAlternateNumber;
	}

	public void setReturnAlternateNumber(String returnAlternateNumber) {
		this.returnAlternateNumber = returnAlternateNumber;
	}

	public String getReturnPincode() {
		return returnPincode;
	}

	public void setReturnPincode(String returnPincode) {
		this.returnPincode = returnPincode;
	}

	public String getReturnCountry() {
		return returnCountry;
	}

	public void setReturnCountry(String returnCountry) {
		this.returnCountry = returnCountry;
	}

	public String getReturnState() {
		return returnState;
	}

	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}

	public String getReturnCity() {
		return returnCity;
	}

	public void setReturnCity(String returnCity) {
		this.returnCity = returnCity;
	}

	public String getIsSellerRegUnderGST() {
		return isSellerRegUnderGST;
	}

	public void setIsSellerRegUnderGST(String isSellerRegUnderGST) {
		this.isSellerRegUnderGST = isSellerRegUnderGST;
	}

	public String getSellerGSTRegNumber() {
		return sellerGSTRegNumber;
	}

	public void setSellerGSTRegNumber(String sellerGSTRegNumber) {
		this.sellerGSTRegNumber = sellerGSTRegNumber;
	}

	public String getBuyerGSTRegNumber() {
		return buyerGSTRegNumber;
	}

	public void setBuyerGSTRegNumber(String buyerGSTRegNumber) {
		this.buyerGSTRegNumber = buyerGSTRegNumber;
	}

	public String geteWayBillSrNumber() {
		return eWayBillSrNumber;
	}

	public void seteWayBillSrNumber(String eWayBillSrNumber) {
		this.eWayBillSrNumber = eWayBillSrNumber;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getTaxableValue() {
		return taxableValue;
	}

	public void setTaxableValue(String taxableValue) {
		this.taxableValue = taxableValue;
	}

	public String getsGSTAmount() {
		return sGSTAmount;
	}

	public void setsGSTAmount(String sGSTAmount) {
		this.sGSTAmount = sGSTAmount;
	}

	public String getcGSTAmount() {
		return cGSTAmount;
	}

	public void setcGSTAmount(String cGSTAmount) {
		this.cGSTAmount = cGSTAmount;
	}

	public String getiGSTAmount() {
		return iGSTAmount;
	}

	public void setiGSTAmount(String iGSTAmount) {
		this.iGSTAmount = iGSTAmount;
	}

	public String getReturnMobileNumber() {
		return returnMobileNumber;
	}

	public void setReturnMobileNumber(String returnMobileNumber) {
		this.returnMobileNumber = returnMobileNumber;
	}

	public String getClientOrderDate() {
		return clientOrderDate;
	}

	public void setClientOrderDate(String clientOrderDate) {
		this.clientOrderDate = clientOrderDate;
	}

	public String getReturnName() {
		return returnName;
	}

	public void setReturnName(String returnName) {
		this.returnName = returnName;
	}

	public BillingStatus getBillingStatus_s() {
		return billingStatus_s;
	}

	public void setBillingStatus_s(BillingStatus billingStatus_s) {
		this.billingStatus_s = billingStatus_s;
	}

	public String getVendorBranchCode() {
		return vendorBranchCode;
	}

	public void setVendorBranchCode(String vendorBranchCode) {
		this.vendorBranchCode = vendorBranchCode;
	}

	public boolean isSystemCalling() {
		return systemCalling;
	}

	public void setSystemCalling(boolean systemCalling) {
		this.systemCalling = systemCalling;
	}

	public String getPickupDateTime() {
		return pickupDateTime;
	}

	public void setPickupDateTime(String pickupDateTime) {
		this.pickupDateTime = pickupDateTime;
	}

	public String getPickupTimeSlot() {
		return pickupTimeSlot;
	}

	public void setPickupTimeSlot(String pickupTimeSlot) {
		this.pickupTimeSlot = pickupTimeSlot;
	}

	public boolean isSendManualSms() {
		return sendManualSms;
	}

	public void setSendManualSms(boolean sendManualSms) {
		this.sendManualSms = sendManualSms;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getTelecallingStatus() {
		return telecallingStatus;
	}

	public void setTelecallingStatus(String telecallingStatus) {
		this.telecallingStatus = telecallingStatus;
	}

	public int getTelecallingCount() {
		return telecallingCount;
	}

	public void setTelecallingCount(int telecallingCount) {
		this.telecallingCount = telecallingCount;
	}

	public Map<String, TeleCallingBean> getTelecallingHistory() {
		return telecallingHistory;
	}

	public void setTelecallingHistory(Map<String, TeleCallingBean> telecallingHistory) {
		this.telecallingHistory = telecallingHistory;
	}

	public String getClientVendorCode() {
		return clientVendorCode;
	}

	public void setClientVendorCode(String clientVendorCode) {
		this.clientVendorCode = clientVendorCode;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getTotalTelecallingCount() {
		return totalTelecallingCount;
	}

	public void setTotalTelecallingCount(int totalTelecallingCount) {
		this.totalTelecallingCount = totalTelecallingCount;
	}

	public Boolean getTeleStatusPush() {
		return teleStatusPush;
	}

	public void setTeleStatusPush(Boolean teleStatusPush) {
		this.teleStatusPush = teleStatusPush;
	}

	public Boolean getContactUpdate() {
		return contactUpdate;
	}

	public void setContactUpdate(Boolean contactUpdate) {
		this.contactUpdate = contactUpdate;
	}

	public String getCallingManifestId() {
		return callingManifestId;
	}

	public void setCallingManifestId(String callingManifestId) {
		this.callingManifestId = callingManifestId;
	}

	public String getCallingManifestStatus() {
		return callingManifestStatus;
	}

	public void setCallingManifestStatus(String callingManifestStatus) {
		this.callingManifestStatus = callingManifestStatus;
	}

	public String getCallingManifestUserKey() {
		return callingManifestUserKey;
	}

	public void setCallingManifestUserKey(String callingManifestUserKey) {
		this.callingManifestUserKey = callingManifestUserKey;
	}

	public Map<String, TeleStatusBean> getTeleStatusMap() {
		return teleStatusMap;
	}

	public void setTeleStatusMap(Map<String, TeleStatusBean> teleStatusMap) {
		this.teleStatusMap = teleStatusMap;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getProformaInvoiceNumber() {
		return proformaInvoiceNumber;
	}

	public void setProformaInvoiceNumber(String proformaInvoiceNumber) {
		this.proformaInvoiceNumber = proformaInvoiceNumber;
	}

	public String getProformaInvoiceDate() {
		return proformaInvoiceDate;
	}

	public void setProformaInvoiceDate(String proformaInvoiceDate) {
		this.proformaInvoiceDate = proformaInvoiceDate;
	}

	public boolean isMerchantHandOver() {
		return merchantHandOver;
	}

	public void setMerchantHandOver(boolean merchantHandOver) {
		this.merchantHandOver = merchantHandOver;
	}

	public boolean isB2B() {
		return isB2B;
	}

	public void setB2B(boolean isB2B) {
		this.isB2B = isB2B;
	}

	/*public String getParentAwb() {
		return parentAwb;
	}

	public void setParentAwb(String parentAwb) {
		this.parentAwb = parentAwb;
	}*/

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Boolean getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(Boolean isInternational) {
		this.isInternational = isInternational;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getDimensionalWeight() {
		return dimensionalWeight;
	}

	public void setDimensionalWeight(Double dimensionalWeight) {
		this.dimensionalWeight = dimensionalWeight;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getCourierDocumentAWBNumber() {
		return courierDocumentAWBNumber;
	}

	public void setCourierDocumentAWBNumber(String courierDocumentAWBNumber) {
		this.courierDocumentAWBNumber = courierDocumentAWBNumber;
	}

	public Long getRtoDate() {
		return rtoDate;
	}

	public void setRtoDate(Long rtoDate) {
		this.rtoDate = rtoDate;
	}

	public boolean isOwnerRisk() {
		return isOwnerRisk;
	}

	public void setOwnerRisk(boolean isOwnerRisk) {
		this.isOwnerRisk = isOwnerRisk;
	}
	
}
