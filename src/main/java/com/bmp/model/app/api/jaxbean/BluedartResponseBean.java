package com.bmp.model.app.api.jaxbean;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ShipmentData")
public class BluedartResponseBean {
	
	private List<Shipment> Shipment;
	
	public BluedartResponseBean() {
		super();
	}
	@XmlElement(name="Shipment")
	public List<Shipment> getShipment() {
		return Shipment;
	}
	public void setShipment(List<Shipment> shipment) {
		Shipment = shipment;
	}

	public static class Shipment{
		private Scans Scans;
	    private String Service;
	    private String StatusDate;
	    private String StatusType;
	    private String ReceivedBy;
	    private String PickUpDate;
	    private String WaybillNo;
	    private String Origin;
	    private String SenderName;
	    private String Status;
	    private String PickUpTime;
	    private String Weight;
	    private String StatusTime;
	    private String ProductType;
	    private String ExpectedDeliveryDate;
	    private String OriginAreaCode;
	    private String Instructions;
	    private String RefNo;
	    private String ToAttention;
	    private String Prodcode;
	    private String DestinationAreaCode;
	    private String Destination;
	    
	    public Shipment() {
			super();
		}
	    @XmlElement(name="Scans")
		public Scans getScans() {
			return Scans;
		}
		public void setScans(Scans scans) {
			Scans = scans;
		}
		@XmlElement(name="Service")
		public String getService() {
			return Service;
		}
		public void setService(String service) {
			Service = service;
		}
		@XmlElement(name="StatusDate")
		public String getStatusDate() {
			return StatusDate;
		}
		public void setStatusDate(String statusDate) {
			StatusDate = statusDate;
		}
		@XmlElement(name="StatusType")
		public String getStatusType() {
			return StatusType;
		}
		public void setStatusType(String statusType) {
			StatusType = statusType;
		}
		@XmlElement(name="ReceivedBy")
		public String getReceivedBy() {
			return ReceivedBy;
		}
		public void setReceivedBy(String receivedBy) {
			ReceivedBy = receivedBy;
		}
		@XmlElement(name="PickUpDate")
		public String getPickUpDate() {
			return PickUpDate;
		}
		public void setPickUpDate(String pickUpDate) {
			PickUpDate = pickUpDate;
		}
		@XmlAttribute(name="WaybillNo")
		public String getWaybillNo() {
			return WaybillNo;
		}
		public void setWaybillNo(String waybillNo) {
			WaybillNo = waybillNo;
		}
		@XmlElement(name="Origin")
		public String getOrigin() {
			return Origin;
		}
		public void setOrigin(String origin) {
			Origin = origin;
		}
		@XmlElement(name="SenderName")
		public String getSenderName() {
			return SenderName;
		}
		public void setSenderName(String senderName) {
			SenderName = senderName;
		}
		@XmlElement(name="Status")
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		@XmlElement(name="PickUpTime")
		public String getPickUpTime() {
			return PickUpTime;
		}
		public void setPickUpTime(String pickUpTime) {
			PickUpTime = pickUpTime;
		}
		@XmlElement(name="Weight")
		public String getWeight() {
			return Weight;
		}
		public void setWeight(String weight) {
			Weight = weight;
		}
		@XmlElement(name="StatusTime")
		public String getStatusTime() {
			return StatusTime;
		}
		public void setStatusTime(String statusTime) {
			StatusTime = statusTime;
		}
		@XmlElement(name="ProductType")
		public String getProductType() {
			return ProductType;
		}
		public void setProductType(String productType) {
			ProductType = productType;
		}
		@XmlElement(name="ExpectedDeliveryDate")
		public String getExpectedDeliveryDate() {
			return ExpectedDeliveryDate;
		}
		public void setExpectedDeliveryDate(String expectedDeliveryDate) {
			ExpectedDeliveryDate = expectedDeliveryDate;
		}
		@XmlElement(name="OriginAreaCode")
		public String getOriginAreaCode() {
			return OriginAreaCode;
		}
		public void setOriginAreaCode(String originAreaCode) {
			OriginAreaCode = originAreaCode;
		}
		@XmlElement(name="Instructions")
		public String getInstructions() {
			return Instructions;
		}
		public void setInstructions(String instructions) {
			Instructions = instructions;
		}
		@XmlAttribute(name="RefNo")
		public String getRefNo() {
			return RefNo;
		}
		public void setRefNo(String refNo) {
			RefNo = refNo;
		}
		@XmlElement(name="ToAttention")
		public String getToAttention() {
			return ToAttention;
		}
		public void setToAttention(String toAttention) {
			ToAttention = toAttention;
		}
		@XmlElement(name="Prodcode")
		public String getProdcode() {
			return Prodcode;
		}
		public void setProdcode(String prodcode) {
			Prodcode = prodcode;
		}
		@XmlElement(name="DestinationAreaCode")
		public String getDestinationAreaCode() {
			return DestinationAreaCode;
		}
		public void setDestinationAreaCode(String destinationAreaCode) {
			DestinationAreaCode = destinationAreaCode;
		}
		@XmlElement(name="Destination")
		public String getDestination() {
			return Destination;
		}
		public void setDestination(String destination) {
			Destination = destination;
		}

		public static class Scans{
	    	private List<ScanDetail> ScanDetail;
	    	public Scans() {
				super();
			}
	    	@XmlElement(name="ScanDetail")
			public List<ScanDetail> getScanDetail() {
				return ScanDetail;
			}
			public void setScanDetail(List<ScanDetail> scanDetail) {
				ScanDetail = scanDetail;
			}

			public static class ScanDetail{
	    		private String ScanGroupType;
	    	    private String ScanType;
	    	    private String Scan;
	    	    private String ScannedLocationCode;
	    	    private String ScanCode;
	    	    private String ScanDate;
	    	    private String ScannedLocation;
	    	    private String ScanTime;
	    	    
				public ScanDetail() {
					super();
				}
				@XmlElement(name="ScanGroupType")
				public String getScanGroupType() {
					return ScanGroupType;
				}
				public void setScanGroupType(String scanGroupType) {
					ScanGroupType = scanGroupType;
				}
				@XmlElement(name="ScanType")
				public String getScanType() {
					return ScanType;
				}
				public void setScanType(String scanType) {
					ScanType = scanType;
				}
				@XmlElement(name="Scan")
				public String getScan() {
					return Scan;
				}
				public void setScan(String scan) {
					Scan = scan;
				}
				@XmlElement(name="ScannedLocationCode")
				public String getScannedLocationCode() {
					return ScannedLocationCode;
				}
				public void setScannedLocationCode(String scannedLocationCode) {
					ScannedLocationCode = scannedLocationCode;
				}
				@XmlElement(name="ScanCode")
				public String getScanCode() {
					return ScanCode;
				}
				public void setScanCode(String scanCode) {
					ScanCode = scanCode;
				}
				@XmlElement(name="ScanDate")
				public String getScanDate() {
					return ScanDate;
				}
				public void setScanDate(String scanDate) {
					ScanDate = scanDate;
				}
				@XmlElement(name="ScannedLocation")
				public String getScannedLocation() {
					return ScannedLocation;
				}
				public void setScannedLocation(String scannedLocation) {
					ScannedLocation = scannedLocation;
				}
				@XmlElement(name="ScanTime")
				public String getScanTime() {
					return ScanTime;
				}
				public void setScanTime(String scanTime) {
					ScanTime = scanTime;
				}
	    	    
	    	}
	    }
	}
}
