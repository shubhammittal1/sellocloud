package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DtdcTrackingResponseBean {
	private Integer statusCode;
    private Boolean statusFlag;
    private String status;
    public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Boolean getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(Boolean statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TrackDetails> getTrackDetails() {
		return trackDetails;
	}

	public void setTrackDetails(List<TrackDetails> trackDetails) {
		this.trackDetails = trackDetails;
	}

	public TrackHeader getTrackHeader() {
		return trackHeader;
	}

	public void setTrackHeader(TrackHeader trackHeader) {
		this.trackHeader = trackHeader;
	}

	private List<TrackDetails> trackDetails;
    private TrackHeader trackHeader;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TrackDetails{
        private String strCode;
        private String strAction;
        private String strManifestNo;
        private String strOrigin;
        private String strDestination;
        private String strOriginCode;
        private String strDestinationCode;
        private String strActionDate;
        private String strActionTime;
        private String sTrRemarks;
        private String strLatitude;
        private String strLongitude;
        @JsonProperty("id")
        private String strNDCOTP;
		public String getStrCode() {
			return strCode;
		}
		public void setStrCode(String strCode) {
			this.strCode = strCode;
		}
		public String getStrAction() {
			return strAction;
		}
		public void setStrAction(String strAction) {
			this.strAction = strAction;
		}
		public String getStrManifestNo() {
			return strManifestNo;
		}
		public void setStrManifestNo(String strManifestNo) {
			this.strManifestNo = strManifestNo;
		}
		public String getStrOrigin() {
			return strOrigin;
		}
		public void setStrOrigin(String strOrigin) {
			this.strOrigin = strOrigin;
		}
		public String getStrDestination() {
			return strDestination;
		}
		public void setStrDestination(String strDestination) {
			this.strDestination = strDestination;
		}
		public String getStrOriginCode() {
			return strOriginCode;
		}
		public void setStrOriginCode(String strOriginCode) {
			this.strOriginCode = strOriginCode;
		}
		public String getStrDestinationCode() {
			return strDestinationCode;
		}
		public void setStrDestinationCode(String strDestinationCode) {
			this.strDestinationCode = strDestinationCode;
		}
		public String getStrActionDate() {
			return strActionDate;
		}
		public void setStrActionDate(String strActionDate) {
			this.strActionDate = strActionDate;
		}
		public String getStrActionTime() {
			return strActionTime;
		}
		public void setStrActionTime(String strActionTime) {
			this.strActionTime = strActionTime;
		}
		public String getsTrRemarks() {
			return sTrRemarks;
		}
		public void setsTrRemarks(String sTrRemarks) {
			this.sTrRemarks = sTrRemarks;
		}
		public String getStrLatitude() {
			return strLatitude;
		}
		public void setStrLatitude(String strLatitude) {
			this.strLatitude = strLatitude;
		}
		public String getStrLongitude() {
			return strLongitude;
		}
		public void setStrLongitude(String strLongitude) {
			this.strLongitude = strLongitude;
		}
		public String getStrNDCOTP() {
			return strNDCOTP;
		}
		public void setStrNDCOTP(String strNDCOTP) {
			this.strNDCOTP = strNDCOTP;
		}

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TrackHeader{
        private String strShipmentNo;
        private String strRefNo;
        @JsonProperty("strCNType")
        private String strCNType;
        @JsonProperty("strCNTypeCode")
        private String strCNTypeCode;
        @JsonProperty("strCNActCustCode")
        private String strCNActCustCode;
        @JsonProperty("strCNTypeName")
        private String strCNTypeName;
        @JsonProperty("strCNProduct")
        private String strCNProduct;
        @JsonProperty("strCNProdCODFOD")
        private String strCNProdCODFOD;
        private String strWeightUnit;
        private String strWeight;
        private String strStatus;
        private String strActualServiceType;
        private String strBookingType;
        private String strExpectedDeliveryDate;
        private String strRevExpectedDeliveryDate;
        
        public String getStrShipmentNo() {
			return strShipmentNo;
		}
		public void setStrShipmentNo(String strShipmentNo) {
			this.strShipmentNo = strShipmentNo;
		}
		public String getStrRefNo() {
			return strRefNo;
		}
		public void setStrRefNo(String strRefNo) {
			this.strRefNo = strRefNo;
		}
		public String getStrCNType() {
			return strCNType;
		}
		public void setStrCNType(String strCNType) {
			this.strCNType = strCNType;
		}
		public String getStrCNTypeCode() {
			return strCNTypeCode;
		}
		public void setStrCNTypeCode(String strCNTypeCode) {
			this.strCNTypeCode = strCNTypeCode;
		}
		public String getStrCNActCustCode() {
			return strCNActCustCode;
		}
		public void setStrCNActCustCode(String strCNActCustCode) {
			this.strCNActCustCode = strCNActCustCode;
		}
		public String getStrCNTypeName() {
			return strCNTypeName;
		}
		public void setStrCNTypeName(String strCNTypeName) {
			this.strCNTypeName = strCNTypeName;
		}
		public String getStrCNProduct() {
			return strCNProduct;
		}
		public void setStrCNProduct(String strCNProduct) {
			this.strCNProduct = strCNProduct;
		}
		public String getStrCNProdCODFOD() {
			return strCNProdCODFOD;
		}
		public void setStrCNProdCODFOD(String strCNProdCODFOD) {
			this.strCNProdCODFOD = strCNProdCODFOD;
		}
		public String getStrWeightUnit() {
			return strWeightUnit;
		}
		public void setStrWeightUnit(String strWeightUnit) {
			this.strWeightUnit = strWeightUnit;
		}
		public String getStrWeight() {
			return strWeight;
		}
		public void setStrWeight(String strWeight) {
			this.strWeight = strWeight;
		}
		public String getStrActualServiceType() {
			return strActualServiceType;
		}
		public void setStrActualServiceType(String strActualServiceType) {
			this.strActualServiceType = strActualServiceType;
		}
		public String getStrBookingType() {
			return strBookingType;
		}
		public void setStrBookingType(String strBookingType) {
			this.strBookingType = strBookingType;
		}
		public String getStrExpectedDeliveryDate() {
			return strExpectedDeliveryDate;
		}
		public void setStrExpectedDeliveryDate(String strExpectedDeliveryDate) {
			this.strExpectedDeliveryDate = strExpectedDeliveryDate;
		}
		public String getStrRevExpectedDeliveryDate() {
			return strRevExpectedDeliveryDate;
		}
		public void setStrRevExpectedDeliveryDate(String strRevExpectedDeliveryDate) {
			this.strRevExpectedDeliveryDate = strRevExpectedDeliveryDate;
		}
		public String getStrStatus() {
			return strStatus;
		}
		public void setStrStatus(String strStatus) {
			this.strStatus = strStatus;
		}
		
    }

}
