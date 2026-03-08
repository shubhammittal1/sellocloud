package com.bmp.model.c2c;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="c2cPacket")
@AssignKey(assvalue=true)
public class Packet extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 2557171511720295408L;
	
	@Indexed
	private String userId_s;
	
	@Indexed
	private String saleOderNo_s;
	
	@Indexed
	private String orderDate_s;
	
	@Indexed
	private String courierAwbNumber_s;
	
	@Indexed
	private String bmpAwbNumber_s;
	
	@Indexed
    private String packetid_s;
	
	@Indexed
    private String status_s;
    private String statusName;
    private String category;
    
    @Indexed
    private Long pickupdate_l;
    //delivery date
    
    @Indexed
    private Long deliveredDate_l;
    
    //service detail
    private String serviceId;
    
    @Indexed
	private String serviceName_s;
    
    @Indexed
	private String serviceType_s;
	private BigDecimal serviceCharge;
	private BigDecimal serviceTax;
	private BigDecimal totalAmount;
	private String productAmount;
	
    //order source
	private String pickupCity;
	private String pickupState;
	private String pickupPincode;
	private String pickupSenderName;
	private String pickupDate;  
	private String pickupAddress;               
	private String pickupLandmark;             
	private String pickupMobileNumber;           
	private String pickupAlternateNumber; 
	
	@Indexed
	private String pickupEmaiId_s;
	
	//destination deatil
	private String consigneeCity;
	private String consigneePincode;
	private String consigneeState;
	private String consigneeName;              
	private String consigneeAddress;            
	private String consigneeLandmark;           
	private String consigneeMobileNumber;        
	private String consigneeAlternateNumber; 
	
	@Indexed
	private String consigneeEmailId_s;
    private List<CTOCPacketsHistory> packetsHistory;
    private Charges charges;
    
    //product detail
    private String productDescription;
    private String name;
    private String codeSKU;
    private String contents;
    private String hwlUnit;
    private String weightUnit;
    private BigDecimal weight;
    private BigDecimal length;
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal packetPrice;
    
    // no of packets
    private Integer quantity;
    @Indexed
    private String codReceiveptNo_s;
    private boolean idProofMandatory;

	private String pickupLongitude;
	private String branchName;
	private String pickupLattitude;
    
	@Indexed
    private Boolean paymentStatus_b;
	
	@Indexed
    private String paymentType_s;
	
	@Indexed
    private String giftVoucharCode_s;
	
	@Indexed
    private String giftVoucharValue_s;
    
    public Packet() {
		super();
	}
	public String getUserId_s() {
		return userId_s;
	}
	public void setUserId_s(String userId_s) {
		this.userId_s = userId_s;
	}
	public String getSaleOderNo_s() {
		return saleOderNo_s;
	}
	public void setSaleOderNo_s(String saleOderNo_s) {
		this.saleOderNo_s = saleOderNo_s;
	}
	public String getOrderDate_s() {
		return orderDate_s;
	}
	public void setOrderDate_s(String orderDate_s) {
		this.orderDate_s = orderDate_s;
	}
	public String getCourierAwbNumber_s() {
		return courierAwbNumber_s;
	}
	public void setCourierAwbNumber_s(String courierAwbNumber_s) {
		this.courierAwbNumber_s = courierAwbNumber_s;
	}
	public String getBmpAwbNumber_s() {
		return bmpAwbNumber_s;
	}
	public void setBmpAwbNumber_s(String bmpAwbNumber_s) {
		this.bmpAwbNumber_s = bmpAwbNumber_s;
	}
	public String getPacketid_s() {
		return packetid_s;
	}
	public void setPacketid_s(String packetid_s) {
		this.packetid_s = packetid_s;
	}
	public String getStatus_s() {
		return status_s;
	}
	public void setStatus_s(String status_s) {
		this.status_s = status_s;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getServiceId() {
		return serviceId;
	}
	
	public Long getPickupdate_l() {
		return pickupdate_l;
	}
	public void setPickupdate_l(Long pickupdate_l) {
		this.pickupdate_l = pickupdate_l;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName_s() {
		return serviceName_s;
	}
	public void setServiceName_s(String serviceName_s) {
		this.serviceName_s = serviceName_s;
	}
	public String getServiceType_s() {
		return serviceType_s;
	}
	public void setServiceType_s(String serviceType_s) {
		this.serviceType_s = serviceType_s;
	}
	public BigDecimal getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(BigDecimal serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public BigDecimal getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(BigDecimal serviceTax) {
		this.serviceTax = serviceTax;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount_s(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getPickupCity() {
		return pickupCity;
	}
	public void setPickupCity(String pickupCity) {
		this.pickupCity = pickupCity;
	}
	public String getPickupState() {
		return pickupState;
	}
	public void setPickupState(String pickupState) {
		this.pickupState = pickupState;
	}
	public String getPickupPincode() {
		return pickupPincode;
	}
	public void setPickupPincode(String pickupPincode) {
		this.pickupPincode = pickupPincode;
	}
	public String getPickupSenderName() {
		return pickupSenderName;
	}
	public void setPickupSenderName(String pickupSenderName) {
		this.pickupSenderName = pickupSenderName;
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
	public String getPickupEmaiId_s() {
		return pickupEmaiId_s;
	}
	public void setPickupEmaiId_s(String pickupEmaiId_s) {
		this.pickupEmaiId_s = pickupEmaiId_s;
	}
	public String getConsigneeCity() {
		return consigneeCity;
	}
	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}
	public String getConsigneePincode() {
		return consigneePincode;
	}
	public void setConsigneePincode(String consigneePincode) {
		this.consigneePincode = consigneePincode;
	}
	public String getConsigneeState() {
		return consigneeState;
	}
	public void setConsigneeState(String consigneeState) {
		this.consigneeState = consigneeState;
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
	public String getConsigneeEmailId_s() {
		return consigneeEmailId_s;
	}
	public void setConsigneeEmailId_s(String consigneeEmailId_s) {
		this.consigneeEmailId_s = consigneeEmailId_s;
	}
	public List<CTOCPacketsHistory> getPacketsHistory() {
		return packetsHistory;
	}
	public void setPacketsHistory(List<CTOCPacketsHistory> packetsHistory) {
		this.packetsHistory = packetsHistory;
	}
	public Charges getCharges() {
		return charges;
	}
	public void setCharges(Charges charges) {
		this.charges = charges;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodeSKU() {
		return codeSKU;
	}
	public void setCodeSKU(String codeSKU) {
		this.codeSKU = codeSKU;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getHwlUnit() {
		return hwlUnit;
	}
	public void setHwlUnit(String hwlUnit) {
		this.hwlUnit = hwlUnit;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getPacketPrice() {
		return packetPrice;
	}
	public void setPacketPrice(BigDecimal packetPrice) {
		this.packetPrice = packetPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCodReceiveptNo_s() {
		return codReceiveptNo_s;
	}
	public void setCodReceiveptNo_s(String codReceiveptNo_s) {
		this.codReceiveptNo_s = codReceiveptNo_s;
	}
	public boolean isIdProofMandatory() {
		return idProofMandatory;
	}
	public void setIdProofMandatory(boolean idProofMandatory) {
		this.idProofMandatory = idProofMandatory;
	}
	public String getPickupLongitude() {
		return pickupLongitude;
	}
	public void setPickupLongitude(String pickupLongitude) {
		this.pickupLongitude = pickupLongitude;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getPickupLattitude() {
		return pickupLattitude;
	}
	public void setPickupLattitude(String pickupLattitude) {
		this.pickupLattitude = pickupLattitude;
	}
	public Boolean getPaymentStatus_b() {
		return paymentStatus_b;
	}
	public void setPaymentStatus_b(Boolean paymentStatus_b) {
		this.paymentStatus_b = paymentStatus_b;
	}
	public String getPaymentType_s() {
		return paymentType_s;
	}
	public void setPaymentType_s(String paymentType_s) {
		this.paymentType_s = paymentType_s;
	}
	public String getGiftVoucharCode_s() {
		return giftVoucharCode_s;
	}
	public void setGiftVoucharCode_s(String giftVoucharCode_s) {
		this.giftVoucharCode_s = giftVoucharCode_s;
	}
	public String getGiftVoucharValue_s() {
		return giftVoucharValue_s;
	}
	public void setGiftVoucharValue_s(String giftVoucharValue_s) {
		this.giftVoucharValue_s = giftVoucharValue_s;
	}
	public String getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	public Long getDeliveredDate_l() {
		return deliveredDate_l;
	}
	public void setDeliveredDate_l(Long deliveredDate_l) {
		this.deliveredDate_l = deliveredDate_l;
	}
	
    
}
