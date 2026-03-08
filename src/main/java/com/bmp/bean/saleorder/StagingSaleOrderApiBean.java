package com.bmp.bean.saleorder;


public class StagingSaleOrderApiBean {
	
	private String awbNumber;					//mandate - BMP AWB Number
	private String orderNumber;                 //mandate - Client Order Id
	private String orderDate;                   //optional - Format (yyyy/MM/dd HH:mm:ss)
	private String clientName;                  //mandate - Client Key Given by BMP
	private String vendorName;                  //mandate - Vendor/Warehouse Name
	private String pickupAddress;               //mandate
	private String pickupLandmark;              //optional
	private String pickupMobileNumber;           //mandate
	private String pickupAlternateNumber;         //optional
	private String pickupPincode;              //mandate
	private String pickupDateTime;
	private String pickupTimeSlot;
	private String consigneeName;               //mandate
	private String consigneeAddress;            //mandate
	private String consigneeLandmark;           //optional
	private String consigneePincode;           //mandate
	private String consigneeMobileNumber;        //mandate
	private String consigneeAlternateNumber;      //optional
	private String consigneeEmailId;            //optional
	private String productCode;                 //mandate - SKU/Product Code
	private String productDescription;          //mandate - Product Name/Description
	private Integer quantity;                   //mandate - Product Quantity
	private Float weight;                       //mandate - Product weight
	private Float length;                       //mandate - Product length
	private Float width;                        //mandate - Product width
	private Float height;                       //mandate - Product height
	private Float collectableAmount;            //mandate - Total Collectible Amount
	private Float productPrice;                 //mandate - Declared Product Price
	private String paymentMode;                 //mandate - COD/PREPAID
	private String dgGood;                      //mandate - yes/no
	private String manifestNumber;              //mandate - Client Manifest Number
	private String productType;                 //optional - default standard
	private String orderType;                   //optional - default FWD Forward
	private String brand;                       //optional - Product Brand
	private String category;                    //optional - Product Category
	private String returnReason;                //optional - Reason code required in ReverseQC
	private String size;                        //optional - product size
	private String color;                       //optional - product color
	private String productImagesUrl;            //optional

	private String returnVendorName;            //mandate
	private String returnAddress;               //mandate
	private String returnLandmark;              //optional
	private String returnMobileNumber;         //mandate
	private String returnAlternateNumber;       //optional
	private String returnPincode;               //mandate

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

	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	public String getPickupLandmark() {
		return pickupLandmark;
	}
	public void setPickupLandmark(String pickupLandmark) {
		this.pickupLandmark = pickupLandmark;
	}
	public String getPickupMobileNumber() {
		return pickupMobileNumber;
	}
	public void setPickupMobileNumber(String pickupMobileNumber) {
		this.pickupMobileNumber = pickupMobileNumber;
	}
	public String getPickupAlternateNumber() {
		return pickupAlternateNumber;
	}
	public void setPickupAlternateNumber(String pickupAlternateNumber) {
		this.pickupAlternateNumber = pickupAlternateNumber;
	}
	public String getPickupPincode() {
		return pickupPincode;
	}
	public void setPickupPincode(String pickupPincode) {
		this.pickupPincode = pickupPincode;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Float getLength() {
		return length;
	}
	public void setLength(Float length) {
		this.length = length;
	}
	public Float getWidth() {
		return width;
	}
	public void setWidth(Float width) {
		this.width = width;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getCollectableAmount() {
		return collectableAmount;
	}
	public void setCollectableAmount(Float collectableAmount) {
		this.collectableAmount = collectableAmount;
	}
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getDgGood() {
		return dgGood;
	}
	public void setDgGood(String dgGood) {
		this.dgGood = dgGood;
	}
	public String getManifestNumber() {
		return manifestNumber;
	}
	public void setManifestNumber(String manifestNumber) {
		this.manifestNumber = manifestNumber;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
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
	public String getProductImagesUrl() {
		return productImagesUrl;
	}
	public void setProductImagesUrl(String productImagesUrl) {
		this.productImagesUrl = productImagesUrl;
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
	public String getReturnMobileNumber() {
		return returnMobileNumber;
	}
	public void setReturnMobileNumber(String returnMobileNumber) {
		this.returnMobileNumber = returnMobileNumber;
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
	public String getReturnVendorName() {
		return returnVendorName;
	}
	public void setReturnVendorName(String returnVendorName) {
		this.returnVendorName = returnVendorName;
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
	
}
