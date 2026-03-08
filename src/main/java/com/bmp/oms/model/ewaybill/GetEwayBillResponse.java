package com.bmp.oms.model.ewaybill;

import java.util.List;

public class GetEwayBillResponse {
    private long ewbNo;
    private String ewayBillDate;
    private String genMode;
    private String userGstin;
    private String supplyType;
    private String subSupplyType;
    private String docType;
    private String docNo;
    private String docDate;
    private String fromGstin;
    private String fromTrdName;
    private String fromAddr1;
    private String fromAddr2;
    private String fromPlace;
    private int fromPincode;
    private int fromStateCode;
    private String toGstin;
    private String toTrdName;
    private String toAddr1;
    private String toAddr2;
    private String toPlace;
    private int toPincode;
    private int toStateCode;
    private double totalValue;
    private double totInvValue;
    private double cgstValue;
    private double sgstValue;
    private double igstValue;
    private double cessValue;
    private String transporterId;
    private String transporterName;
    private String status;
    private int actualDist;
    private int noValidDays;
    private String validUpto;
    private int extendedTimes;
    private String rejectStatus;
    private int actFromStateCode;
    private int actToStateCode;
    private String vehicleType;
    private int transactionType;
    private double otherValue;
    private double cessNonAdvolValue;
    private List<EwayBillItem> itemList;
    private List<EwayBillVehicleDetail> vehicleListDetails;

    public long getEwbNo() {
        return ewbNo;
    }

    public void setEwbNo(long ewbNo) {
        this.ewbNo = ewbNo;
    }

    public String getEwayBillDate() {
        return ewayBillDate;
    }

    public void setEwayBillDate(String ewayBillDate) {
        this.ewayBillDate = ewayBillDate;
    }

    public String getGenMode() {
        return genMode;
    }

    public void setGenMode(String genMode) {
        this.genMode = genMode;
    }

    public String getUserGstin() {
        return userGstin;
    }

    public void setUserGstin(String userGstin) {
        this.userGstin = userGstin;
    }

    public String getSupplyType() {
        return supplyType;
    }

    public void setSupplyType(String supplyType) {
        this.supplyType = supplyType;
    }

    public String getSubSupplyType() {
        return subSupplyType;
    }

    public void setSubSupplyType(String subSupplyType) {
        this.subSupplyType = subSupplyType;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getFromGstin() {
        return fromGstin;
    }

    public void setFromGstin(String fromGstin) {
        this.fromGstin = fromGstin;
    }

    public String getFromTrdName() {
        return fromTrdName;
    }

    public void setFromTrdName(String fromTrdName) {
        this.fromTrdName = fromTrdName;
    }

    public String getFromAddr1() {
        return fromAddr1;
    }

    public void setFromAddr1(String fromAddr1) {
        this.fromAddr1 = fromAddr1;
    }

    public String getFromAddr2() {
        return fromAddr2;
    }

    public void setFromAddr2(String fromAddr2) {
        this.fromAddr2 = fromAddr2;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public int getFromPincode() {
        return fromPincode;
    }

    public void setFromPincode(int fromPincode) {
        this.fromPincode = fromPincode;
    }

    public int getFromStateCode() {
        return fromStateCode;
    }

    public void setFromStateCode(int fromStateCode) {
        this.fromStateCode = fromStateCode;
    }

    public String getToGstin() {
        return toGstin;
    }

    public void setToGstin(String toGstin) {
        this.toGstin = toGstin;
    }

    public String getToTrdName() {
        return toTrdName;
    }

    public void setToTrdName(String toTrdName) {
        this.toTrdName = toTrdName;
    }

    public String getToAddr1() {
        return toAddr1;
    }

    public void setToAddr1(String toAddr1) {
        this.toAddr1 = toAddr1;
    }

    public String getToAddr2() {
        return toAddr2;
    }

    public void setToAddr2(String toAddr2) {
        this.toAddr2 = toAddr2;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public int getToPincode() {
        return toPincode;
    }

    public void setToPincode(int toPincode) {
        this.toPincode = toPincode;
    }

    public int getToStateCode() {
        return toStateCode;
    }

    public void setToStateCode(int toStateCode) {
        this.toStateCode = toStateCode;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getTotInvValue() {
        return totInvValue;
    }

    public void setTotInvValue(double totInvValue) {
        this.totInvValue = totInvValue;
    }

    public double getCgstValue() {
        return cgstValue;
    }

    public void setCgstValue(double cgstValue) {
        this.cgstValue = cgstValue;
    }

    public double getSgstValue() {
        return sgstValue;
    }

    public void setSgstValue(double sgstValue) {
        this.sgstValue = sgstValue;
    }

    public double getIgstValue() {
        return igstValue;
    }

    public void setIgstValue(double igstValue) {
        this.igstValue = igstValue;
    }

    public double getCessValue() {
        return cessValue;
    }

    public void setCessValue(double cessValue) {
        this.cessValue = cessValue;
    }

    public String getTransporterId() {
        return transporterId;
    }

    public void setTransporterId(String transporterId) {
        this.transporterId = transporterId;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getActualDist() {
        return actualDist;
    }

    public void setActualDist(int actualDist) {
        this.actualDist = actualDist;
    }

    public int getNoValidDays() {
        return noValidDays;
    }

    public void setNoValidDays(int noValidDays) {
        this.noValidDays = noValidDays;
    }

    public String getValidUpto() {
        return validUpto;
    }

    public void setValidUpto(String validUpto) {
        this.validUpto = validUpto;
    }

    public int getExtendedTimes() {
        return extendedTimes;
    }

    public void setExtendedTimes(int extendedTimes) {
        this.extendedTimes = extendedTimes;
    }

    public String getRejectStatus() {
        return rejectStatus;
    }

    public void setRejectStatus(String rejectStatus) {
        this.rejectStatus = rejectStatus;
    }

    public int getActFromStateCode() {
        return actFromStateCode;
    }

    public void setActFromStateCode(int actFromStateCode) {
        this.actFromStateCode = actFromStateCode;
    }

    public int getActToStateCode() {
        return actToStateCode;
    }

    public void setActToStateCode(int actToStateCode) {
        this.actToStateCode = actToStateCode;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public double getOtherValue() {
        return otherValue;
    }

    public void setOtherValue(double otherValue) {
        this.otherValue = otherValue;
    }

    public double getCessNonAdvolValue() {
        return cessNonAdvolValue;
    }

    public void setCessNonAdvolValue(double cessNonAdvolValue) {
        this.cessNonAdvolValue = cessNonAdvolValue;
    }

    public List<EwayBillItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<EwayBillItem> itemList) {
        this.itemList = itemList;
    }

    public List<EwayBillVehicleDetail> getVehicleListDetails() {
        return vehicleListDetails;
    }

    public void setVehicleListDetails(List<EwayBillVehicleDetail> vehicleListDetails) {
        this.vehicleListDetails = vehicleListDetails;
    }
}
