package com.bmp.model.app.api.jaxbean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryResponseBean {
	
	private ShipmentData[] ShipmentData;
	private String Error;
	
    public ShipmentData[] getShipmentData ()
    {
        return ShipmentData;
    }

    public void setShipmentData (ShipmentData[] ShipmentData)
    {
        this.ShipmentData = ShipmentData;
    }

    public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ShipmentData
    {
        private Shipment Shipment;

        public Shipment getShipment ()
        {
            return Shipment;
        }

        public void setShipment (Shipment Shipment)
        {
            this.Shipment = Shipment;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Shipment
        {
            private Scans[] Scans;

            private String DestRecieveDate;

            private String OutDestinationDate;

            private String PickUpDate;

            private String Origin;

            private Consignee Consignee;

            private String SenderName;

            private String ReverseInTransit;

            private String ReferenceNo;

            private String ChargedWeight;

            private String DispatchCount;

            private Status Status;

            private String InvoiceAmount;

            private String AWB;

            private String ReturnedDate;

            private String OrderType;

            private String CODAmount;

            private String FirstAttemptDate;

            private String OriginRecieveDate;

            private String Destination;

            public Scans[] getScans ()
            {
                return Scans;
            }

            public void setScans (Scans[] Scans)
            {
                this.Scans = Scans;
            }

            public String getDestRecieveDate ()
            {
                return DestRecieveDate;
            }

            public void setDestRecieveDate (String DestRecieveDate)
            {
                this.DestRecieveDate = DestRecieveDate;
            }

            public String getOutDestinationDate ()
            {
                return OutDestinationDate;
            }

            public void setOutDestinationDate (String OutDestinationDate)
            {
                this.OutDestinationDate = OutDestinationDate;
            }

            public String getPickUpDate ()
            {
                return PickUpDate;
            }

            public void setPickUpDate (String PickUpDate)
            {
                this.PickUpDate = PickUpDate;
            }

            public String getOrigin ()
            {
                return Origin;
            }

            public void setOrigin (String Origin)
            {
                this.Origin = Origin;
            }

            public Consignee getConsignee ()
            {
                return Consignee;
            }

            public void setConsignee (Consignee Consignee)
            {
                this.Consignee = Consignee;
            }

            public String getSenderName ()
            {
                return SenderName;
            }

            public void setSenderName (String SenderName)
            {
                this.SenderName = SenderName;
            }

            public String getReverseInTransit ()
            {
                return ReverseInTransit;
            }

            public void setReverseInTransit (String ReverseInTransit)
            {
                this.ReverseInTransit = ReverseInTransit;
            }

            public String getReferenceNo ()
            {
                return ReferenceNo;
            }

            public void setReferenceNo (String ReferenceNo)
            {
                this.ReferenceNo = ReferenceNo;
            }

            public String getChargedWeight ()
            {
                return ChargedWeight;
            }

            public void setChargedWeight (String ChargedWeight)
            {
                this.ChargedWeight = ChargedWeight;
            }

            public String getDispatchCount ()
            {
                return DispatchCount;
            }

            public void setDispatchCount (String DispatchCount)
            {
                this.DispatchCount = DispatchCount;
            }

            public Status getStatus ()
            {
                return Status;
            }

            public void setStatus (Status Status)
            {
                this.Status = Status;
            }

            public String getInvoiceAmount ()
            {
                return InvoiceAmount;
            }

            public void setInvoiceAmount (String InvoiceAmount)
            {
                this.InvoiceAmount = InvoiceAmount;
            }

            public String getAWB ()
            {
                return AWB;
            }

            public void setAWB (String AWB)
            {
                this.AWB = AWB;
            }

            public String getReturnedDate ()
            {
                return ReturnedDate;
            }

            public void setReturnedDate (String ReturnedDate)
            {
                this.ReturnedDate = ReturnedDate;
            }

            public String getOrderType ()
            {
                return OrderType;
            }

            public void setOrderType (String OrderType)
            {
                this.OrderType = OrderType;
            }

            public String getCODAmount ()
            {
                return CODAmount;
            }

            public void setCODAmount (String CODAmount)
            {
                this.CODAmount = CODAmount;
            }

            public String getFirstAttemptDate ()
            {
                return FirstAttemptDate;
            }

            public void setFirstAttemptDate (String FirstAttemptDate)
            {
                this.FirstAttemptDate = FirstAttemptDate;
            }

            public String getOriginRecieveDate ()
            {
                return OriginRecieveDate;
            }

            public void setOriginRecieveDate (String OriginRecieveDate)
            {
                this.OriginRecieveDate = OriginRecieveDate;
            }

            public String getDestination ()
            {
                return Destination;
            }

            public void setDestination (String Destination)
            {
                this.Destination = Destination;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Scans
            {
                private ScanDetail ScanDetail;

                public ScanDetail getScanDetail ()
                {
                    return ScanDetail;
                }

                public void setScanDetail (ScanDetail ScanDetail)
                {
                    this.ScanDetail = ScanDetail;
                }
                
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class GeoLocation{
                	private Double lat;
                	@SerializedName("long")
                	private Double lang;
					public Double getLat() {
						return lat;
					}
					public void setLat(Double lat) {
						this.lat = lat;
					}
					public Double getLang() {
						return lang;
					}
					public void setLang(Double lang) {
						this.lang = lang;
					}
					
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class ScanDetail
                {
                    private String StatusCode;

                    private String ScanType;

                    private String Scan;

                    private String ScanDateTime;
                    @SerializedName("geo_location")
                    private GeoLocation geoLocation;

                    private String StatusDateTime;

                    private String Instructions;

                    private String ScannedLocation;

                    public String getStatusCode ()
                    {
                        return StatusCode;
                    }

                    public void setStatusCode (String StatusCode)
                    {
                        this.StatusCode = StatusCode;
                    }

                    public String getScanType ()
                    {
                        return ScanType;
                    }

                    public void setScanType (String ScanType)
                    {
                        this.ScanType = ScanType;
                    }

                    public String getScan ()
                    {
                        return Scan;
                    }

                    public void setScan (String Scan)
                    {
                        this.Scan = Scan;
                    }

                    public String getScanDateTime ()
                    {
                        return ScanDateTime;
                    }

                    public void setScanDateTime (String ScanDateTime)
                    {
                        this.ScanDateTime = ScanDateTime;
                    }

                    public String getStatusDateTime ()
                    {
                        return StatusDateTime;
                    }

                    public void setStatusDateTime (String StatusDateTime)
                    {
                        this.StatusDateTime = StatusDateTime;
                    }

                    public String getInstructions ()
                    {
                        return Instructions;
                    }

                    public void setInstructions (String Instructions)
                    {
                        this.Instructions = Instructions;
                    }

                    public String getScannedLocation ()
                    {
                        return ScannedLocation;
                    }

                    public void setScannedLocation (String ScannedLocation)
                    {
                        this.ScannedLocation = ScannedLocation;
                    }

					public GeoLocation getGeoLocation() {
						return geoLocation;
					}

					public void setGeoLocation(GeoLocation geoLocation) {
						this.geoLocation = geoLocation;
					}

                }
            }
        
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Consignee
            {
                private String PinCode;

                private String Name;

                private String State;

                private String Address3;

                private String[] Address2;

                private String[] Address1;

                private String Country;

                //private String[] Telephone1;

                private String Telephone2;

                private String City;

                public String getPinCode ()
                {
                    return PinCode;
                }

                public void setPinCode (String PinCode)
                {
                    this.PinCode = PinCode;
                }

                public String getName ()
                {
                    return Name;
                }

                public void setName (String Name)
                {
                    this.Name = Name;
                }

                public String getState ()
                {
                    return State;
                }

                public void setState (String State)
                {
                    this.State = State;
                }

                public String getAddress3 ()
                {
                    return Address3;
                }

                public void setAddress3 (String Address3)
                {
                    this.Address3 = Address3;
                }

                public String[] getAddress2 ()
                {
                    return Address2;
                }

                public void setAddress2 (String[] Address2)
                {
                    this.Address2 = Address2;
                }

                public String[] getAddress1 ()
                {
                    return Address1;
                }

                public void setAddress1 (String[] Address1)
                {
                    this.Address1 = Address1;
                }

                public String getCountry ()
                {
                    return Country;
                }

                public void setCountry (String Country)
                {
                    this.Country = Country;
                }

                /*public String[] getTelephone1 ()
                {
                    return Telephone1;
                }

                public void setTelephone1 (String[] Telephone1)
                {
                    this.Telephone1 = Telephone1;
                }*/

                public String getTelephone2 ()
                {
                    return Telephone2;
                }

                public void setTelephone2 (String Telephone2)
                {
                    this.Telephone2 = Telephone2;
                }

                public String getCity ()
                {
                    return City;
                }

                public void setCity (String City)
                {
                    this.City = City;
                }
            }
            
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Status
            {
                private String StatusCode;

                private String Status;

                private String StatusType;

                private String StatusDateTime;

                private String Instructions;

                private String RecievedBy;

                private String StatusLocation;

                public String getStatusCode ()
                {
                    return StatusCode;
                }

                public void setStatusCode (String StatusCode)
                {
                    this.StatusCode = StatusCode;
                }

                public String getStatus ()
                {
                    return Status;
                }

                public void setStatus (String Status)
                {
                    this.Status = Status;
                }

                public String getStatusType ()
                {
                    return StatusType;
                }

                public void setStatusType (String StatusType)
                {
                    this.StatusType = StatusType;
                }

                public String getStatusDateTime ()
                {
                    return StatusDateTime;
                }

                public void setStatusDateTime (String StatusDateTime)
                {
                    this.StatusDateTime = StatusDateTime;
                }

                public String getInstructions ()
                {
                    return Instructions;
                }

                public void setInstructions (String Instructions)
                {
                    this.Instructions = Instructions;
                }

                public String getRecievedBy ()
                {
                    return RecievedBy;
                }

                public void setRecievedBy (String RecievedBy)
                {
                    this.RecievedBy = RecievedBy;
                }

                public String getStatusLocation ()
                {
                    return StatusLocation;
                }

                public void setStatusLocation (String StatusLocation)
                {
                    this.StatusLocation = StatusLocation;
                }

            }
            		
        }
    }
    			
    	
    
}
