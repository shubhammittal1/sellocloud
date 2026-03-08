package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BluedartPodConsumeBean {

	private List<Statustracking> statustracking;
	
	public List<Statustracking> getStatustracking() {
		return statustracking;
	}
	public void setStatustracking(List<Statustracking> statustracking) {
		this.statustracking = statustracking;
	}


	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Statustracking{
		
		@JsonProperty("Shipment")
		private Shipment Shipment;
		
		public Shipment getShipment() {
			return Shipment;
		}
		public void setShipment(Shipment shipment) {
			Shipment = shipment;
		}


		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class Shipment{
			@JsonProperty("SenderID")
			private String SenderID;
			
			@JsonProperty("ReceiverID")
		    private String ReceiverID;
			
			@JsonProperty("WaybillNo")
		    private String WaybillNo;
			
			@JsonProperty("RefNo")
		    private String RefNo;
			
			@JsonProperty("Prodcode")
		    private String Prodcode;
			
			@JsonProperty("SubProductCode")
		    private String SubProductCode;
			
			@JsonProperty("Feature")
		    private String Feature;
			
			@JsonProperty("Origin")
		    private String Origin;
			
			@JsonProperty("OriginAreaCode")
		    private String OriginAreaCode;
			
			@JsonProperty("Destination")
		    private String Destination;
			
			@JsonProperty("DestinationAreaCode")
		    private String DestinationAreaCode;
			
			@JsonProperty("PickUpDate")
		    private String PickUpDate;
			
			@JsonProperty("PickUpTime")
		    private String PickUpTime;
			
			@JsonProperty("Weight")
		    private String Weight;
			
			@JsonProperty("ShipmentMode")
		    private String ShipmentMode;
			
			@JsonProperty("ExpectedDeliveryDate")
		    private String ExpectedDeliveryDate;
			
			@JsonProperty("Scans")
		    private Scans Scans;
			
		    public String getSenderID() {
				return SenderID;
			}
			public void setSenderID(String senderID) {
				SenderID = senderID;
			}
			public String getReceiverID() {
				return ReceiverID;
			}
			public void setReceiverID(String receiverID) {
				ReceiverID = receiverID;
			}
			public String getWaybillNo() {
				return WaybillNo;
			}
			public void setWaybillNo(String waybillNo) {
				WaybillNo = waybillNo;
			}
			public String getRefNo() {
				return RefNo;
			}
			public void setRefNo(String refNo) {
				RefNo = refNo;
			}
			public String getProdcode() {
				return Prodcode;
			}
			public void setProdcode(String prodcode) {
				Prodcode = prodcode;
			}
			public String getSubProductCode() {
				return SubProductCode;
			}
			public void setSubProductCode(String subProductCode) {
				SubProductCode = subProductCode;
			}
			public String getFeature() {
				return Feature;
			}
			public void setFeature(String feature) {
				Feature = feature;
			}
			public String getOrigin() {
				return Origin;
			}
			public void setOrigin(String origin) {
				Origin = origin;
			}
			public String getOriginAreaCode() {
				return OriginAreaCode;
			}
			public void setOriginAreaCode(String originAreaCode) {
				OriginAreaCode = originAreaCode;
			}
			public String getDestination() {
				return Destination;
			}
			public void setDestination(String destination) {
				Destination = destination;
			}
			public String getDestinationAreaCode() {
				return DestinationAreaCode;
			}
			public void setDestinationAreaCode(String destinationAreaCode) {
				DestinationAreaCode = destinationAreaCode;
			}
			public String getPickUpDate() {
				return PickUpDate;
			}
			public void setPickUpDate(String pickUpDate) {
				PickUpDate = pickUpDate;
			}
			public String getPickUpTime() {
				return PickUpTime;
			}
			public void setPickUpTime(String pickUpTime) {
				PickUpTime = pickUpTime;
			}
			public String getWeight() {
				return Weight;
			}
			public void setWeight(String weight) {
				Weight = weight;
			}
			public String getShipmentMode() {
				return ShipmentMode;
			}
			public void setShipmentMode(String shipmentMode) {
				ShipmentMode = shipmentMode;
			}
			public String getExpectedDeliveryDate() {
				return ExpectedDeliveryDate;
			}
			public void setExpectedDeliveryDate(String expectedDeliveryDate) {
				ExpectedDeliveryDate = expectedDeliveryDate;
			}
			public Scans getScans() {
				return Scans;
			}
			public void setScans(Scans scans) {
				Scans = scans;
			}

			@JsonIgnoreProperties(ignoreUnknown = true)
		    public static class Scans{
		    	@JsonProperty("DeliveryDetails")
		    	private DeliveryDetails DeliveryDetails;
		    	
		    	@JsonProperty("PODDCImages")
		    	private PODDCImages PODDCImages;
		    	
		    	@JsonProperty("ScanDetail")
		    	private List<ScanDetail> ScanDetail;
		    	
		    	//Not any used if future required please enable
		    	/*@JsonProperty("QCFailed")
		        private QCFailed QCFailed;
		    	
		    	@JsonProperty("Reweigh")
		        private List<String> Reweigh;
		    	
		    	@JsonProperty("CallLogs")
		        private List<String> CallLogs;
		        */
		        
		        public DeliveryDetails getDeliveryDetails() {
					return DeliveryDetails;
				}
				public void setDeliveryDetails(DeliveryDetails deliveryDetails) {
					DeliveryDetails = deliveryDetails;
				}
				public List<ScanDetail> getScanDetail() {
					return ScanDetail;
				}
				public void setScanDetail(List<ScanDetail> scanDetail) {
					ScanDetail = scanDetail;
				}
				public PODDCImages getPODDCImages() {
					return PODDCImages;
				}
				public void setPODDCImages(PODDCImages pODDCImages) {
					PODDCImages = pODDCImages;
				}


				@JsonIgnoreProperties(ignoreUnknown = true)
		        public static class DeliveryDetails{
		        	@JsonProperty("ReceivedBy")
		        	private String ReceivedBy;
		        	
		        	@JsonProperty("Relation")
		            private String Relation;
		        	
		        	@JsonProperty("IDType")
		            private String IDType;
		        	
		        	@JsonProperty("IDNumber")
		            private String IDNumber;
		        	
		        	@JsonProperty("IDImage")
		            private String IDImage;
		        	
		        	@JsonProperty("Signature")
		            private String Signature;

					public String getReceivedBy() {
						return ReceivedBy;
					}
					public void setReceivedBy(String receivedBy) {
						ReceivedBy = receivedBy;
					}
					public String getRelation() {
						return Relation;
					}
					public void setRelation(String relation) {
						Relation = relation;
					}
					public String getIDType() {
						return IDType;
					}
					public void setIDType(String iDType) {
						IDType = iDType;
					}
					public String getIDNumber() {
						return IDNumber;
					}
					public void setIDNumber(String iDNumber) {
						IDNumber = iDNumber;
					}
					public String getIDImage() {
						return IDImage;
					}
					public void setIDImage(String iDImage) {
						IDImage = iDImage;
					}
					public String getSignature() {
						return Signature;
					}
					public void setSignature(String signature) {
						Signature = signature;
					}
		        }
				
				@JsonIgnoreProperties(ignoreUnknown = true)
				public static class PODDCImages{
					@JsonProperty("PODImage")
		        	private String PODImage;
					
					@JsonProperty("DCImage")
		        	private String DCImage;

					public String getPODImage() {
						return PODImage;
					}

					public void setPODImage(String pODImage) {
						PODImage = pODImage;
					}

					public String getDCImage() {
						return DCImage;
					}

					public void setDCImage(String dCImage) {
						DCImage = dCImage;
					}
					
					
				}
		        
		        @JsonIgnoreProperties(ignoreUnknown = true)
		        public static class ScanDetail{
		        	@JsonProperty("ScanType")
		        	private String ScanType;
		        	
		        	@JsonProperty("ScanGroupType")
		            private String ScanGroupType;
		        	
		        	@JsonProperty("ScanCode")
		            private String ScanCode;
		        	
		        	@JsonProperty("Scan")
		            private String Scan;
		        	
		        	@JsonProperty("ScanDate")
		            private String ScanDate;
		        	
		        	@JsonProperty("ScanTime")
		            private String ScanTime;
		        	
		        	@JsonProperty("ScannedLocationCode")
		            private String ScannedLocationCode;
		        	
		        	@JsonProperty("ScannedLocation")
		            private String ScannedLocation;
		        	
		        	@JsonProperty("ScannedLocationStateCode")
		            private String ScannedLocationStateCode;
		        	
		        	@JsonProperty("StatusTimeZone")
		            private String StatusTimeZone;
		        	
		        	@JsonProperty("Comments")
		            private String Comments;
		        	
		        	@JsonProperty("StatusLatitude")
		            private String StatusLatitude;
		        	
		        	@JsonProperty("StatusLongitude")
		            private String StatusLongitude;

					public String getScanType() {
						return ScanType;
					}
					public void setScanType(String scanType) {
						ScanType = scanType;
					}
					public String getScanGroupType() {
						return ScanGroupType;
					}
					public void setScanGroupType(String scanGroupType) {
						ScanGroupType = scanGroupType;
					}
					public String getScanCode() {
						return ScanCode;
					}
					public void setScanCode(String scanCode) {
						ScanCode = scanCode;
					}
					public String getScan() {
						return Scan;
					}
					public void setScan(String scan) {
						Scan = scan;
					}
					public String getScanDate() {
						return ScanDate;
					}
					public void setScanDate(String scanDate) {
						ScanDate = scanDate;
					}
					public String getScanTime() {
						return ScanTime;
					}
					public void setScanTime(String scanTime) {
						ScanTime = scanTime;
					}
					public String getScannedLocationCode() {
						return ScannedLocationCode;
					}
					public void setScannedLocationCode(String scannedLocationCode) {
						ScannedLocationCode = scannedLocationCode;
					}
					public String getScannedLocation() {
						return ScannedLocation;
					}
					public void setScannedLocation(String scannedLocation) {
						ScannedLocation = scannedLocation;
					}
					public String getScannedLocationStateCode() {
						return ScannedLocationStateCode;
					}
					public void setScannedLocationStateCode(String scannedLocationStateCode) {
						ScannedLocationStateCode = scannedLocationStateCode;
					}
					public String getStatusTimeZone() {
						return StatusTimeZone;
					}
					public void setStatusTimeZone(String statusTimeZone) {
						StatusTimeZone = statusTimeZone;
					}
					public String getComments() {
						return Comments;
					}
					public void setComments(String comments) {
						Comments = comments;
					}
					public String getStatusLatitude() {
						return StatusLatitude;
					}
					public void setStatusLatitude(String statusLatitude) {
						StatusLatitude = statusLatitude;
					}
					public String getStatusLongitude() {
						return StatusLongitude;
					}
					public void setStatusLongitude(String statusLongitude) {
						StatusLongitude = statusLongitude;
					}
		        	
		        }
		        
		        /*@JsonIgnoreProperties(ignoreUnknown = true)
		        public static class QCFailed{
		        	@JsonProperty("Reason")
		        	private String Reason;
		        	
		        	@JsonProperty("Pictures")
		            private List<String> Pictures;
		        }*/
		    }
		}
	}
}
