package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.bean.saleorder.BillingOtherCharge;
import com.bmp.bean.saleorder.OrderLbhBean;
import com.bmp.constant.ClientQCStatus;
import com.bmp.constant.DeliveryType;
import com.bmp.constant.QCStatus;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.masters.QCMaster;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="saleOrderExtra")
@AssignKey(assvalue=false)
public class SaleOrderExtra extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = 1;
	
	private String deliveredPresonName;
	private String deliveredPresonMobileNo;
	private String userSignature;
	private String userIdimage;
	private String idProofType;
	private String idProofNo;
	private String receiverRelation;
	private String deliveryOtp;
	private Double collectableAmount;
	private Double lat;
	private Double lng;
	private Map<String , QCMaster> qclist;
	private String remittanceNo;
	@Indexed
	private String billingNo_s;
	@Indexed
	private boolean lbhdone_b;
	private Long rescheduleDate;
	
	private String ratezone;
	private String fromToZone;;
	//private Boolean weightApproved_b;
	private Double approvedLength;
	private Double approvedWidth;
	private Double approvedHeight;
	private Double approvedDeadWeight;
	private Double approvedDimensionalWeight;
	@Indexed
	private Double approvedChargeableWeight_d;
	private Double amountDeducted;
	private String rtoReceivedBy;
	private String rtoReceivedBranch;
	private String rtoReceivedDate;
	@Indexed
	private Boolean rtoError_b;
	private String rtoError;
	private Boolean rtoRejected;
	private String sourceLatLong;               //optional
	private String destLatLong; //optional
	private String otp; //optional
	
	@Indexed
	private String clientKey_s;
	private String bankName;          //optional
	private String applicationNo;     //optional
	private String memberId;          //optional
	@Indexed
	private String reportType;  
	private String code;
	
	private String serviceLevel;
	@Indexed
	private QCStatus qcStatus;
	@Indexed
	private ClientQCStatus clientQcStatus;
	
	private String complaintNumber;
	@Indexed
	private Long dispatchDate;
	private Boolean delayDeliverySms;
	
	private DeliveryType deliveryType;
	private Long threeplEDD;
	private Boolean threeplPodPresent;
	private Double discount;
	
	//BFEL Extra Fields
	private String smName;
	private String smNumber;
	private String bmName;
	private String bmNumber;
	private String clientUniqueID;
	private String centerLatLong;
	private String rdspID;
	private String bfilDeliveryType;
	private String bfilDeliveryModel;
	private String un1;
	private String un2;
	private String un3;
	
	@Indexed
	private String diallerPin1;
	@Indexed
	private String diallerPin2;
	
	//private PodType clientPodType;
	private Double pickUpLat;
	private Double pickUpLong;
	private String un4;
	
	@Indexed
	private Boolean invoiceCancel;
	private Long invoiceCancelDate;
	
	private Double codCharge;
	private Double codChargeReversal;
	private Double courierWeight;
	private List<CourierWeightBean> courierWeightBeanList;
	private Map<String, BillingOtherCharge> billingOtherChargeMap;
	private List<OrderLbhBean> dimensions;
	private List<OrderLbhBean> actualDimensions;
	private String warehouseKey;
	private String labelString;
	private List<String>courierChildAwbNoList;
	private String saleOrderInvoiceDoc;
	private String saleOrderEwayBillDoc;
	public SaleOrderExtra() {
		super();
	}
	
	public String getRemittanceNo() {
		return remittanceNo;
	}
	
	public String getBillingNo_s() {
		return billingNo_s;
	}

	public void setBillingNo_s(String billingNo_s) {
		this.billingNo_s = billingNo_s;
	}


	public void setRemittanceNo(String remittanceNo) {
		this.remittanceNo = remittanceNo;
	}

	public String getDeliveredPresonName() {
		return deliveredPresonName;
	}

	public String getDeliveredPresonMobileNo() {
		return deliveredPresonMobileNo;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public String getUserIdimage() {
		return userIdimage;
	}

	public void setDeliveredPresonName(String deliveredPresonName) {
		this.deliveredPresonName = deliveredPresonName;
	}

	public void setDeliveredPresonMobileNo(String deliveredPresonMobileNo) {
		this.deliveredPresonMobileNo = deliveredPresonMobileNo;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public void setUserIdimage(String userIdimage) {
		this.userIdimage = userIdimage;
	}

	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdProofNo() {
		return idProofNo;
	}

	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}
	
	public String getReceiverRelation() {
		return receiverRelation;
	}

	public void setReceiverRelation(String receiverRelation) {
		this.receiverRelation = receiverRelation;
	}

	public String getDeliveryOtp() {
		return deliveryOtp;
	}

	public void setDeliveryOtp(String deliveryOtp) {
		this.deliveryOtp = deliveryOtp;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getCollectableAmount() {
		return collectableAmount;
	}

	public void setCollectableAmount(Double collectableAmount) {
		this.collectableAmount = collectableAmount;
	}

	public Map<String, QCMaster> getQclist() {
		return qclist;
	}

	public void setQclist(Map<String, QCMaster> qclist) {
		this.qclist = qclist;
	}

	public boolean isLBHDone_b() {
		return lbhdone_b;
	}

	public void setLBHDone_b(boolean lBHDone_b) {
		lbhdone_b = lBHDone_b;
	}

	public Long getRescheduleDate() {
		return rescheduleDate;
	}

	public void setRescheduleDate(Long rescheduleDate) {
		this.rescheduleDate = rescheduleDate;
	}

	public Double getApprovedLength() {
		return approvedLength;
	}

	public void setApprovedLength(Double approvedLength) {
		this.approvedLength = approvedLength;
	}

	public Double getApprovedWidth() {
		return approvedWidth;
	}

	public void setApprovedWidth(Double approvedWidth) {
		this.approvedWidth = approvedWidth;
	}

	public Double getApprovedHeight() {
		return approvedHeight;
	}

	public void setApprovedHeight(Double approvedHeight) {
		this.approvedHeight = approvedHeight;
	}

	public Double getApprovedChargeableWeight_d() {
		return approvedChargeableWeight_d;
	}

	public void setApprovedChargeableWeight_d(Double approvedChargeableWeight_d) {
		this.approvedChargeableWeight_d = approvedChargeableWeight_d;
	}

	public Double getApprovedDeadWeight() {
		return approvedDeadWeight;
	}

	public void setApprovedDeadWeight(Double approvedDeadWeight) {
		this.approvedDeadWeight = approvedDeadWeight;
	}

	public Double getApprovedDimensionalWeight() {
		return approvedDimensionalWeight;
	}

	public void setApprovedDimensionalWeight(Double approvedDimensionalWeight) {
		this.approvedDimensionalWeight = approvedDimensionalWeight;
	}

	public String getRatezone() {
		return ratezone;
	}

	public void setRatezone(String ratezone) {
		this.ratezone = ratezone;
	}

	public Double getAmountDeducted() {
		return amountDeducted;
	}

	public void setAmountDeducted(Double amountDeducted) {
		this.amountDeducted = amountDeducted;
	}

	public Boolean getRtoError_b() {
		return rtoError_b;
	}

	public void setRtoError_b(Boolean rtoError_b) {
		this.rtoError_b = rtoError_b;
	}

	public String getRtoError() {
		return rtoError;
	}

	public void setRtoError(String rtoError) {
		this.rtoError = rtoError;
	}

	public Boolean getRtoRejected() {
		return rtoRejected;
	}

	public void setRtoRejected(Boolean rtoRejected) {
		this.rtoRejected = rtoRejected;
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

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getRtoReceivedBy() {
		return rtoReceivedBy;
	}

	public String getRtoReceivedBranch() {
		return rtoReceivedBranch;
	}

	public void setRtoReceivedBy(String rtoReceivedBy) {
		this.rtoReceivedBy = rtoReceivedBy;
	}

	public void setRtoReceivedBranch(String rtoReceivedBranch) {
		this.rtoReceivedBranch = rtoReceivedBranch;
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

	public String getClientKey_s() {
		return clientKey_s;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public QCStatus getQcStatus() {
		return qcStatus;
	}

	public void setQcStatus(QCStatus qcStatus) {
		this.qcStatus = qcStatus;
	}

	public ClientQCStatus getClientQcStatus() {
		return clientQcStatus;
	}

	public void setClientQcStatus(ClientQCStatus clientQcStatus) {
		this.clientQcStatus = clientQcStatus;
	}

	public String getComplaintNumber() {
		return complaintNumber;
	}

	public void setComplaintNumber(String complaintNumber) {
		this.complaintNumber = complaintNumber;
	}

	public Long getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Long dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Boolean getDelayDeliverySms() {
		return delayDeliverySms;
	}

	public void setDelayDeliverySms(Boolean delayDeliverySms) {
		this.delayDeliverySms = delayDeliverySms;
	}

	public String getSmName() {
		return smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
	}

	public String getSmNumber() {
		return smNumber;
	}

	public void setSmNumber(String smNumber) {
		this.smNumber = smNumber;
	}

	public String getBmName() {
		return bmName;
	}

	public void setBmName(String bmName) {
		this.bmName = bmName;
	}

	public String getBmNumber() {
		return bmNumber;
	}

	public void setBmNumber(String bmNumber) {
		this.bmNumber = bmNumber;
	}

	public String getClientUniqueID() {
		return clientUniqueID;
	}

	public void setClientUniqueID(String clientUniqueID) {
		this.clientUniqueID = clientUniqueID;
	}

	public String getRtoReceivedDate() {
		return rtoReceivedDate;
	}

	public void setRtoReceivedDate(String rtoReceivedDate) {
		this.rtoReceivedDate = rtoReceivedDate;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Long getThreeplEDD() {
		return threeplEDD;
	}

	public void setThreeplEDD(Long threeplEDD) {
		this.threeplEDD = threeplEDD;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getCenterLatLong() {
		return centerLatLong;
	}

	public void setCenterLatLong(String centerLatLong) {
		this.centerLatLong = centerLatLong;
	}

	public String getRdspID() {
		return rdspID;
	}

	public void setRdspID(String rdspID) {
		this.rdspID = rdspID;
	}

	public String getBfilDeliveryType() {
		return bfilDeliveryType;
	}

	public void setBfilDeliveryType(String bfilDeliveryType) {
		this.bfilDeliveryType = bfilDeliveryType;
	}

	public String getBfilDeliveryModel() {
		return bfilDeliveryModel;
	}

	public void setBfilDeliveryModel(String bfilDeliveryModel) {
		this.bfilDeliveryModel = bfilDeliveryModel;
	}

	public String getUn1() {
		return un1;
	}

	public void setUn1(String un1) {
		this.un1 = un1;
	}

	public String getUn2() {
		return un2;
	}

	public void setUn2(String un2) {
		this.un2 = un2;
	}

	public String getUn3() {
		return un3;
	}

	public void setUn3(String un3) {
		this.un3 = un3;
	}

	public String getDiallerPin1() {
		return diallerPin1;
	}

	public void setDiallerPin1(String diallerPin1) {
		this.diallerPin1 = diallerPin1;
	}

	public String getDiallerPin2() {
		return diallerPin2;
	}

	public void setDiallerPin2(String diallerPin2) {
		this.diallerPin2 = diallerPin2;
	}

	public Double getPickUpLat() {
		return pickUpLat;
	}

	public void setPickUpLat(Double pickUpLat) {
		this.pickUpLat = pickUpLat;
	}

	public Double getPickUpLong() {
		return pickUpLong;
	}

	public void setPickUpLong(Double pickUpLong) {
		this.pickUpLong = pickUpLong;
	}

	public String getUn4() {
		return un4;
	}

	public void setUn4(String un4) {
		this.un4 = un4;
	}

	public Boolean getInvoiceCancel() {
		return invoiceCancel;
	}

	public void setInvoiceCancel(Boolean invoiceCancel) {
		this.invoiceCancel = invoiceCancel;
	}

	public Long getInvoiceCancelDate() {
		return invoiceCancelDate;
	}

	public void setInvoiceCancelDate(Long invoiceCancelDate) {
		this.invoiceCancelDate = invoiceCancelDate;
	}

	public Boolean getThreeplPodPresent() {
		return threeplPodPresent;
	}

	public void setThreeplPodPresent(Boolean threeplPodPresent) {
		this.threeplPodPresent = threeplPodPresent;
	}

	public Double getCodCharge() {
		return codCharge;
	}

	public void setCodCharge(Double codCharge) {
		this.codCharge = codCharge;
	}

	public Double getCodChargeReversal() {
		return codChargeReversal;
	}

	public void setCodChargeReversal(Double codChargeReversal) {
		this.codChargeReversal = codChargeReversal;
	}

	public Double getCourierWeight() {
		return courierWeight;
	}

	public void setCourierWeight(Double courierWeight) {
		this.courierWeight = courierWeight;
	}

	public List<CourierWeightBean> getCourierWeightBeanList() {
		return courierWeightBeanList;
	}

	public void setCourierWeightBeanList(List<CourierWeightBean> courierWeightBeanList) {
		this.courierWeightBeanList = courierWeightBeanList;
	}

	public Map<String, BillingOtherCharge> getBillingOtherChargeMap() {
		return billingOtherChargeMap;
	}

	public void setBillingOtherChargeMap(Map<String, BillingOtherCharge> billingOtherChargeMap) {
		this.billingOtherChargeMap = billingOtherChargeMap;
	}

	public List<OrderLbhBean> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<OrderLbhBean> dimensions) {
		this.dimensions = dimensions;
	}

	public List<OrderLbhBean> getActualDimensions() {
		return actualDimensions;
	}

	public void setActualDimensions(List<OrderLbhBean> actualDimensions) {
		this.actualDimensions = actualDimensions;
	}

	public String getFromToZone() {
		return fromToZone;
	}

	public void setFromToZone(String fromToZone) {
		this.fromToZone = fromToZone;
	}

	public String getWarehouseKey() {
		return warehouseKey;
	}

	public void setWarehouseKey(String warehouseKey) {
		this.warehouseKey = warehouseKey;
	}

	public String getLabelString() {
		return labelString;
	}

	public void setLabelString(String labelString) {
		this.labelString = labelString;
	}

	public List<String> getCourierChildAwbNoList() {
		return courierChildAwbNoList;
	}

	public void setCourierChildAwbNoList(List<String> courierChildAwbNoList) {
		this.courierChildAwbNoList = courierChildAwbNoList;
	}

	public String getSaleOrderInvoiceDoc() {
		return saleOrderInvoiceDoc;
	}

	public void setSaleOrderInvoiceDoc(String saleOrderInvoiceDoc) {
		this.saleOrderInvoiceDoc = saleOrderInvoiceDoc;
	}

	public String getSaleOrderEwayBillDoc() {
		return saleOrderEwayBillDoc;
	}

	public void setSaleOrderEwayBillDoc(String saleOrderEwayBillDoc) {
		this.saleOrderEwayBillDoc = saleOrderEwayBillDoc;
	}
	
	
}
