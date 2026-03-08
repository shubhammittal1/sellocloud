package com.bmp.model.app.api.jaxbean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Gatiresponse")
public class GatiresponseNew {
		
		private String requid;
		private dktinfo dktinfo;
		
		public GatiresponseNew(){};
		public GatiresponseNew(String requid,
				GatiresponseNew.dktinfo dktinfo) {
			super();
			this.requid = requid;
			this.dktinfo = dktinfo;
		}
		@XmlElement(name="requid")
		public String getRequid() {
			return requid;
		}
		public void setRequid(String requid) {
			this.requid = requid;
		}
		
		@XmlElement(name="dktinfo")
		public dktinfo getDktinfo() {
			return dktinfo;
		}
		public void setDktinfo(dktinfo dktinfo) {
			this.dktinfo = dktinfo;
		}

		public static class dktinfo{
			private String dktno;
			private String result;
			private String DOCKET_NUMBER;
			private String DOCKET_STATUS;
			private String CONSIGNOR_NAME;
			private String CONSIGNEE_NAME;
			private String BOOKING_STATION;
			private String BOOKED_DATETIME;
			private String ACTUAL_WEIGHT;
			private String NO_OF_PKGS;
			private String SERVICE_NAME;
			private String DELIVERY_STATION;
			private String ASSURED_DELIVERY_DATE;
			private String RECEIVER_NAME;
			private String DELIVERY_DATETIME;
			private TRANSIT_DTLS TRANSIT_DTLS;
			
			public dktinfo(){}
			public dktinfo(String dktno, String result, String dOCKET_NUMBER, String dOCKET_STATUS,
					String cONSIGNOR_NAME, String cONSIGNEE_NAME, String bOOKING_STATION, String bOOKED_DATETIME,
					String aCTUAL_WEIGHT, String nO_OF_PKGS, String sERVICE_NAME, String dELIVERY_STATION,
					String aSSURED_DELIVERY_DATE, String rECEIVER_NAME, String dELIVERY_DATETIME,
					GatiresponseNew.dktinfo.TRANSIT_DTLS tRANSIT_DTLS) {
				super();
				this.dktno = dktno;
				this.result = result;
				DOCKET_NUMBER = dOCKET_NUMBER;
				DOCKET_STATUS = dOCKET_STATUS;
				CONSIGNOR_NAME = cONSIGNOR_NAME;
				CONSIGNEE_NAME = cONSIGNEE_NAME;
				BOOKING_STATION = bOOKING_STATION;
				BOOKED_DATETIME = bOOKED_DATETIME;
				ACTUAL_WEIGHT = aCTUAL_WEIGHT;
				NO_OF_PKGS = nO_OF_PKGS;
				SERVICE_NAME = sERVICE_NAME;
				DELIVERY_STATION = dELIVERY_STATION;
				ASSURED_DELIVERY_DATE = aSSURED_DELIVERY_DATE;
				RECEIVER_NAME = rECEIVER_NAME;
				DELIVERY_DATETIME = dELIVERY_DATETIME;
				TRANSIT_DTLS = tRANSIT_DTLS;
			}
			@XmlElement(name="dktno")
			public String getDktno() {
				return dktno;
			}
			public void setDktno(String dktno) {
				this.dktno = dktno;
			}
			@XmlElement(name="result")
			public String getResult() {
				return result;
			}
			public void setResult(String result) {
				this.result = result;
			}
			@XmlElement(name="DOCKET_NUMBER")
			public String getDOCKET_NUMBER() {
				return DOCKET_NUMBER;
			}
			public void setDOCKET_NUMBER(String dOCKET_NUMBER) {
				DOCKET_NUMBER = dOCKET_NUMBER;
			}
			@XmlElement(name="DOCKET_STATUS")
			public String getDOCKET_STATUS() {
				return DOCKET_STATUS;
			}
			public void setDOCKET_STATUS(String dOCKET_STATUS) {
				DOCKET_STATUS = dOCKET_STATUS;
			}
			@XmlElement(name="CONSIGNOR_NAME")
			public String getCONSIGNOR_NAME() {
				return CONSIGNOR_NAME;
			}
			public void setCONSIGNOR_NAME(String cONSIGNOR_NAME) {
				CONSIGNOR_NAME = cONSIGNOR_NAME;
			}
			@XmlElement(name="CONSIGNEE_NAME")
			public String getCONSIGNEE_NAME() {
				return CONSIGNEE_NAME;
			}
			public void setCONSIGNEE_NAME(String cONSIGNEE_NAME) {
				CONSIGNEE_NAME = cONSIGNEE_NAME;
			}
			@XmlElement(name="BOOKING_STATION")
			public String getBOOKING_STATION() {
				return BOOKING_STATION;
			}
			public void setBOOKING_STATION(String bOOKING_STATION) {
				BOOKING_STATION = bOOKING_STATION;
			}
			@XmlElement(name="BOOKED_DATETIME")
			public String getBOOKED_DATETIME() {
				return BOOKED_DATETIME;
			}
			public void setBOOKED_DATETIME(String bOOKED_DATETIME) {
				BOOKED_DATETIME = bOOKED_DATETIME;
			}
			@XmlElement(name="ACTUAL_WEIGHT")
			public String getACTUAL_WEIGHT() {
				return ACTUAL_WEIGHT;
			}
			public void setACTUAL_WEIGHT(String aCTUAL_WEIGHT) {
				ACTUAL_WEIGHT = aCTUAL_WEIGHT;
			}
			@XmlElement(name="NO_OF_PKGS")
			public String getNO_OF_PKGS() {
				return NO_OF_PKGS;
			}
			public void setNO_OF_PKGS(String nO_OF_PKGS) {
				NO_OF_PKGS = nO_OF_PKGS;
			}
			@XmlElement(name="SERVICE_NAME")
			public String getSERVICE_NAME() {
				return SERVICE_NAME;
			}
			public void setSERVICE_NAME(String sERVICE_NAME) {
				SERVICE_NAME = sERVICE_NAME;
			}
			@XmlElement(name="DELIVERY_STATION")
			public String getDELIVERY_STATION() {
				return DELIVERY_STATION;
			}
			public void setDELIVERY_STATION(String dELIVERY_STATION) {
				DELIVERY_STATION = dELIVERY_STATION;
			}
			@XmlElement(name="ASSURED_DELIVERY_DATE")
			public String getASSURED_DELIVERY_DATE() {
				return ASSURED_DELIVERY_DATE;
			}
			public void setASSURED_DELIVERY_DATE(String aSSURED_DELIVERY_DATE) {
				ASSURED_DELIVERY_DATE = aSSURED_DELIVERY_DATE;
			}
			@XmlElement(name="TRANSIT_DTLS")
			public TRANSIT_DTLS getTRANSIT_DTLS() {
				return TRANSIT_DTLS;
			}
			public void setTRANSIT_DTLS(TRANSIT_DTLS tRANSIT_DTLS) {
				TRANSIT_DTLS = tRANSIT_DTLS;
			}
			
			@XmlElement(name="RECEIVER_NAME")
			public String getRECEIVER_NAME() {
				return RECEIVER_NAME;
			}
			public void setRECEIVER_NAME(String rECEIVER_NAME) {
				RECEIVER_NAME = rECEIVER_NAME;
			}
			
			@XmlElement(name="DELIVERY_DATETIME")
			public String getDELIVERY_DATETIME() {
				return DELIVERY_DATETIME;
			}
			public void setDELIVERY_DATETIME(String dELIVERY_DATETIME) {
				DELIVERY_DATETIME = dELIVERY_DATETIME;
			}

			public static class TRANSIT_DTLS{
				private List<ROW>  ROW;
				public TRANSIT_DTLS(){}
				public TRANSIT_DTLS(
						List<GatiresponseNew.dktinfo.TRANSIT_DTLS.ROW> rOW) {
					super();
					ROW = rOW;
				}
				@XmlElement(name="ROW")
				public List<ROW> getROW() {
					return ROW;
				}
				public void setROW(List<ROW> rOW) {
					ROW = rOW;
				}
				public static class ROW{
					private String INTRANSIT_DATE;
					private String INTRANSIT_TIME;
					private String INTRANSIT_LOCATION;
					private String INTRANSIT_STATUS;
					
					public ROW(){}
					public ROW(String iNTRANSIT_DATE, String iNTRANSIT_TIME, String iNTRANSIT_LOCATION,
							String iNTRANSIT_STATUS) {
						super();
						INTRANSIT_DATE = iNTRANSIT_DATE;
						INTRANSIT_TIME = iNTRANSIT_TIME;
						INTRANSIT_LOCATION = iNTRANSIT_LOCATION;
						INTRANSIT_STATUS = iNTRANSIT_STATUS;
					}
					@XmlElement(name="INTRANSIT_DATE")
					public String getINTRANSIT_DATE() {
						return INTRANSIT_DATE;
					}
					public void setINTRANSIT_DATE(String iNTRANSIT_DATE) {
						INTRANSIT_DATE = iNTRANSIT_DATE;
					}
					@XmlElement(name="INTRANSIT_TIME")
					public String getINTRANSIT_TIME() {
						return INTRANSIT_TIME;
					}
					public void setINTRANSIT_TIME(String iNTRANSIT_TIME) {
						INTRANSIT_TIME = iNTRANSIT_TIME;
					}
					@XmlElement(name="INTRANSIT_LOCATION")
					public String getINTRANSIT_LOCATION() {
						return INTRANSIT_LOCATION;
					}
					public void setINTRANSIT_LOCATION(String iNTRANSIT_LOCATION) {
						INTRANSIT_LOCATION = iNTRANSIT_LOCATION;
					}
					@XmlElement(name="INTRANSIT_STATUS")
					public String getINTRANSIT_STATUS() {
						return INTRANSIT_STATUS;
					}
					public void setINTRANSIT_STATUS(String iNTRANSIT_STATUS) {
						INTRANSIT_STATUS = iNTRANSIT_STATUS;
					}
					
				}
			}
		}
}
