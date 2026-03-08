package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.bean.saleorder.OrderLbhBean;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="stagingSaleOrder")
@AssignKey(assvalue=false)
public class StagingSaleOrder extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String clientKey_s;        //clientName_s
	//private Boolean customerPickup_b; // New
	private ClientWarehouse clientWarehouse; // new
	/* Sender Details Start */
	private String senderName; // new  
	private String senderMobileNumber_s; // new
	private String senderAltNumber; // new
	private String senderEmail; // new
	private String senderCountry; //new
	private String senderState; // new
	private String senderCity; // pickupLocationCity
	private String senderAddress; //pickupLocationAddress 
	private String senderLandmark; //NEW
	private String senderPincode_s; //pickupLocationPincode_s
	private String pickupDateTime;
	private String pickupTimeSlot;
	/* Sender Details End */
	
	/* Receiver Details Start */
	private String consigneeName;	
	private String consigneeMobileNumber_s; //consigneeContact_l 
	private String consigneeAlternateNumber; //consigneeAlternateNumber_l
	private String consigneeEmailId;
	private String consigneeCountry;
	private String consigneeState;
	private String consigneeCity;
	private String consigneeAddress;
	private String consigneeLandmark;
	private String consigneePincode_s; //consigneePincode_i
	/* Receiver Details End */
	
	private String productType;
	private String paymentType_s;
	//private String serviceMode_s;
	private String awbNumber_s; //bmp_AWB_Number_s
	private String saleOrderNumber_s; 
	private String saleOrderDate;
	private String manifestNumber;
	
	private String productSKU; //sku_ProductCode
	private String productName; //product
	private Integer quantity;
	private Double weight;
	private Double length;
	private Double width;
	private Double height;
	private Double collectableAmount; 
	private Double productPrice; //grossAmount 
	private String perishable;
	private String flammable;
	
	private String assignedCourierKey; //assignedCourierId
	private String source_s;
	private Long createdDateInLong_l;
	private Boolean convertedToSaleOrder_b;
	private Double dimensionalWeight;
	private Double chargableWeight;
	
	private String statusFlowKey;
	private StatusMaster status;
	private String branchKey_s;
	private String branchName;
	private PacketsHistory packetsHistory;
	
	private String sourceBranch_s;
	private String currentBranch_s;
	private String destinationBranch_s;

	private String	returnReason;
	private String	category;
	private String	brand;
	private String	size;
	private String	color;
	private String	imeiNumber;
	private String	orderType_s;
	private String productImagesUrl;

	private String pendingStatusToUpload;
	private String rtoReason;

	private String clientOrderDate;				//optional
	private String returnName;        		    //mandate
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
	private String sourceLatLong;               //optional
	private String destLatLong;                 //optional
	
	private String bankName;          //optional
	private String applicationNo;     //optional
	private String memberId;          //optional
	private String code;              //optional
	private String serviceLevel;
	
	private boolean isB2B;
	//@Indexed
	//private String parentAwb;
	private String serviceType;
	private Boolean isInternational = false;
	private boolean isOwnerRisk = false;
	private List<OrderLbhBean> dimensions;
	
	
	public StagingSaleOrder() {
		super();
	}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	/*public Boolean getCustomerPickup_b() {
		return customerPickup_b;
	}

	public void setCustomerPickup_b(Boolean customerPickup_b) {
		this.customerPickup_b = customerPickup_b;
	}*/

	public ClientWarehouse getClientWarehouse() {
		return clientWarehouse;
	}

	public void setClientWarehouse(ClientWarehouse clientWarehouse) {
		this.clientWarehouse = clientWarehouse;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderMobileNumber_s() {
		return senderMobileNumber_s;
	}

	public void setSenderMobileNumber_s(String senderMobileNumber_s) {
		this.senderMobileNumber_s = senderMobileNumber_s;
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

	public String getSenderPincode_s() {
		return senderPincode_s;
	}

	public void setSenderPincode_s(String senderPincode_s) {
		this.senderPincode_s = senderPincode_s;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeMobileNumber_s() {
		return consigneeMobileNumber_s;
	}

	public void setConsigneeMobileNumber_s(String consigneeMobileNumber_s) {
		this.consigneeMobileNumber_s = consigneeMobileNumber_s;
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

	public String getConsigneePincode_s() {
		return consigneePincode_s;
	}

	public void setConsigneePincode_s(String consigneePincode_s) {
		this.consigneePincode_s = consigneePincode_s;
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

	/*public String getServiceMode_s() {
		return serviceMode_s;
	}

	public void setServiceMode_s(String serviceMode_s) {
		this.serviceMode_s = serviceMode_s;
	}*/

	public String getAwbNumber_s() {
		return awbNumber_s;
	}

	public void setAwbNumber_s(String awbNumber_s) {
		this.awbNumber_s = awbNumber_s;
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

	public String getManifestNumber() {
		return manifestNumber;
	}

	public void setManifestNumber(String manifestNumber) {
		this.manifestNumber = manifestNumber;
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

	public String getAssignedCourierKey() {
		return assignedCourierKey;
	}

	public void setAssignedCourierKey(String assignedCourierKey) {
		this.assignedCourierKey = assignedCourierKey;
	}

	public String getSource_s() {
		return source_s;
	}

	public void setSource_s(String source_s) {
		this.source_s = source_s;
	}

	public Long getCreatedDateInLong_l() {
		return createdDateInLong_l;
	}

	public void setCreatedDateInLong_l(Long createdDateInLong_l) {
		this.createdDateInLong_l = createdDateInLong_l;
	}

	public Boolean getConvertedToSaleOrder_b() {
		return convertedToSaleOrder_b;
	}

	public void setConvertedToSaleOrder_b(Boolean convertedToSaleOrder_b) {
		this.convertedToSaleOrder_b = convertedToSaleOrder_b;
	}

	public Double getDimensionalWeight() {
		return dimensionalWeight;
	}

	public void setDimensionalWeight(Double dimensionalWeight) {
		this.dimensionalWeight = dimensionalWeight;
	}

	public Double getChargableWeight() {
		return chargableWeight;
	}

	public void setChargableWeight(Double chargableWeight) {
		this.chargableWeight = chargableWeight;
	}

	public String getStatusFlowKey() {
		return statusFlowKey;
	}

	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}

	public StatusMaster getStatus() {
		return status;
	}

	public void setStatus(StatusMaster status) {
		this.status = status;
	}

	public String getBranchKey_s() {
		return branchKey_s;
	}

	public void setBranchKey_s(String branchKey_s) {
		this.branchKey_s = branchKey_s;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public PacketsHistory getPacketsHistory() {
		return packetsHistory;
	}

	public void setPacketsHistory(PacketsHistory packetsHistory) {
		this.packetsHistory = packetsHistory;
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

	public String getDestinationBranch_s() {
		return destinationBranch_s;
	}

	public void setDestinationBranch_s(String destinationBranch_s) {
		this.destinationBranch_s = destinationBranch_s;
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

	public String getRtoReason() {
		return rtoReason;
	}

	public void setRtoReason(String rtoReason) {
		this.rtoReason = rtoReason;
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

	public String getSourceLatLong() {
		return sourceLatLong;
	}

	public String getDestLatLong() {
		return destLatLong;
	}

	public void setSourceLatLong(String sourceLatLong) {
		this.sourceLatLong = sourceLatLong;
	}

	public void setDestLatLong(String destLatLong) {
		this.destLatLong = destLatLong;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
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

	public List<OrderLbhBean> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<OrderLbhBean> dimensions) {
		this.dimensions = dimensions;
	}

	public boolean isOwnerRisk() {
		return isOwnerRisk;
	}

	public void setOwnerRisk(boolean isOwnerRisk) {
		this.isOwnerRisk = isOwnerRisk;
	}


	
}
