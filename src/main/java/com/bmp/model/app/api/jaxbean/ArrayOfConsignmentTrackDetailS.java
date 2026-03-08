package com.bmp.model.app.api.jaxbean;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bmp.utility.apiUtility.xmlparser.DateAdapter;

@XmlRootElement(name="ArrayOfConsignmentTrackDetailS")
public class ArrayOfConsignmentTrackDetailS {
	private ConsignmentTrackDetailS ConsignmentTrackDetailS;
	
	public ArrayOfConsignmentTrackDetailS(){}
	public ArrayOfConsignmentTrackDetailS(
			ArrayOfConsignmentTrackDetailS.ConsignmentTrackDetailS consignmentTrackDetailS) {
		super();
		ConsignmentTrackDetailS = consignmentTrackDetailS;
	}

	@XmlElement(name="ConsignmentTrackDetailS")
	public ConsignmentTrackDetailS getConsignmentTrackDetailS() {
		return ConsignmentTrackDetailS;
	}

	public void setConsignmentTrackDetailS(ConsignmentTrackDetailS consignmentTrackDetailS) {
		ConsignmentTrackDetailS = consignmentTrackDetailS;
	}

		public static class ConsignmentTrackDetailS{
		private HeaderDetail HeaderDetail;
		private Detail Detail;
		
		public ConsignmentTrackDetailS(){}
		public ConsignmentTrackDetailS(
				ArrayOfConsignmentTrackDetailS.ConsignmentTrackDetailS.HeaderDetail headerDetail,
				ArrayOfConsignmentTrackDetailS.ConsignmentTrackDetailS.Detail detail) {
			super();
			HeaderDetail = headerDetail;
			Detail = detail;
		}
		@XmlElement(name="HeaderDetail")
		public HeaderDetail getHeaderDetail() {
			return HeaderDetail;
		}

		public void setHeaderDetail(HeaderDetail headerDetail) {
			HeaderDetail = headerDetail;
		}
		@XmlElement(name="Detail")
		public Detail getDetail() {
			return Detail;
		}

		public void setDetail(Detail detail) {
			Detail = detail;
		}

		public static class HeaderDetail{
			private String DOCKNO;
			private Date PICKUP_DATE_TIME;
			private String Order_No;
			private String CURRENT_STATUS;
			private String REMARKS;
			private String Current_status_Code;
			private String Current_Location_Code;
			private String Current_Location_Name;
			private String EDD;
			private String Chargeable_Weight;
			private String CUSTOMER_PHOTO4;
			
			public HeaderDetail(){}
			public HeaderDetail(String dOCKNO, Date pICKUP_DATE_TIME, String order_No, String cURRENT_STATUS,
					String rEMARKS, String current_status_Code, String current_Location_Code,
					String current_Location_Name, String eDD, String chargeable_Weight, String cUSTOMER_PHOTO4) {
				super();
				DOCKNO = dOCKNO;
				PICKUP_DATE_TIME = pICKUP_DATE_TIME;
				Order_No = order_No;
				CURRENT_STATUS = cURRENT_STATUS;
				REMARKS = rEMARKS;
				Current_status_Code = current_status_Code;
				Current_Location_Code = current_Location_Code;
				Current_Location_Name = current_Location_Name;
				EDD = eDD;
				Chargeable_Weight = chargeable_Weight;
				CUSTOMER_PHOTO4 = cUSTOMER_PHOTO4;
			}
			@XmlElement(name="DOCKNO")
			public String getDOCKNO() {
				return DOCKNO;
			}
			public void setDOCKNO(String dOCKNO) {
				DOCKNO = dOCKNO;
			}
			@XmlElement(name="PICKUP_DATE_TIME")
			@XmlJavaTypeAdapter(DateAdapter.class)
			public Date getPICKUP_DATE_TIME() {
				return PICKUP_DATE_TIME;
			}
			public void setPICKUP_DATE_TIME(Date pICKUP_DATE_TIME) {
				PICKUP_DATE_TIME = pICKUP_DATE_TIME;
			}
			@XmlElement(name="Order_No")
			public String getOrder_No() {
				return Order_No;
			}
			public void setOrder_No(String order_No) {
				Order_No = order_No;
			}
			@XmlElement(name="CURRENT_STATUS")
			public String getCURRENT_STATUS() {
				return CURRENT_STATUS;
			}
			public void setCURRENT_STATUS(String cURRENT_STATUS) {
				CURRENT_STATUS = cURRENT_STATUS;
			}
			@XmlElement(name="REMARKS")
			public String getREMARKS() {
				return REMARKS;
			}
			public void setREMARKS(String rEMARKS) {
				REMARKS = rEMARKS;
			}
			@XmlElement(name="Current_status_Code")
			public String getCurrent_status_Code() {
				return Current_status_Code;
			}
			public void setCurrent_status_Code(String current_status_Code) {
				Current_status_Code = current_status_Code;
			}
			@XmlElement(name="Current_Location_Code")
			public String getCurrent_Location_Code() {
				return Current_Location_Code;
			}
			public void setCurrent_Location_Code(String current_Location_Code) {
				Current_Location_Code = current_Location_Code;
			}
			@XmlElement(name="Current_Location_Name")
			public String getCurrent_Location_Name() {
				return Current_Location_Name;
			}
			public void setCurrent_Location_Name(String current_Location_Name) {
				Current_Location_Name = current_Location_Name;
			}
			@XmlElement(name="EDD")
			public String getEDD() {
				return EDD;
			}
			public void setEDD(String eDD) {
				EDD = eDD;
			}
			@XmlElement(name="Chargeable_Weight")
			public String getChargeable_Weight() {
				return Chargeable_Weight;
			}
			public void setChargeable_Weight(String chargeable_Weight) {
				Chargeable_Weight = chargeable_Weight;
			}
			@XmlElement(name="CUSTOMER_PHOTO4")
			public String getCUSTOMER_PHOTO4() {
				return CUSTOMER_PHOTO4;
			}
			public void setCUSTOMER_PHOTO4(String cUSTOMER_PHOTO4) {
				CUSTOMER_PHOTO4 = cUSTOMER_PHOTO4;
			}
			
			
		}
		
		public static class Detail{
			private List<ConsignmentTrackS> ConsignmentTrackS;
			
			public Detail(){}
			public Detail(
					List<ArrayOfConsignmentTrackDetailS.ConsignmentTrackDetailS.Detail.ConsignmentTrackS> consignmentTrackS) {
				super();
				ConsignmentTrackS = consignmentTrackS;
			}
			
			@XmlElement(name="ConsignmentTrackS")
			public List<ConsignmentTrackS> getConsignmentTrackS() {
				return ConsignmentTrackS;
			}

			public void setConsignmentTrackS(List<ConsignmentTrackS> consignmentTrackS) {
				ConsignmentTrackS = consignmentTrackS;
			}

			public static  class ConsignmentTrackS{
				private String Current_Status;
				private Date Current_Status_Date_Time;
				private String Remarks;
				private String Current_status_Code;
				private String Current_Location_Code;
				private String Current_Location_Name;
				
				
				public ConsignmentTrackS(){}
				public ConsignmentTrackS(String current_Status, Date current_Status_Date_Time, String remarks,
						String current_status_Code, String current_Location_Code, String current_Location_Name) {
					super();
					Current_Status = current_Status;
					Current_Status_Date_Time = current_Status_Date_Time;
					Remarks = remarks;
					Current_status_Code = current_status_Code;
					Current_Location_Code = current_Location_Code;
					Current_Location_Name = current_Location_Name;
				}
				@XmlElement(name="Current_Status")
				public String getCurrent_Status() {
					return Current_Status;
				}
				public void setCurrent_Status(String current_Status) {
					Current_Status = current_Status;
				}
				@XmlElement(name="Current_Status_Date_Time")
				@XmlJavaTypeAdapter(DateAdapter.class)
				public Date getCurrent_Status_Date_Time() {
					return Current_Status_Date_Time;
				}
				public void setCurrent_Status_Date_Time(Date current_Status_Date_Time) {
					Current_Status_Date_Time = current_Status_Date_Time;
				}
				@XmlElement(name="Remarks")
				public String getRemarks() {
					return Remarks;
				}
				public void setRemarks(String remarks) {
					Remarks = remarks;
				}
				@XmlElement(name="Current_status_Code")
				public String getCurrent_status_Code() {
					return Current_status_Code;
				}
				public void setCurrent_status_Code(String current_status_Code) {
					Current_status_Code = current_status_Code;
				}
				@XmlElement(name="Current_Location_Code")
				public String getCurrent_Location_Code() {
					return Current_Location_Code;
				}
				public void setCurrent_Location_Code(String current_Location_Code) {
					Current_Location_Code = current_Location_Code;
				}
				@XmlElement(name="Current_Location_Name")
				public String getCurrent_Location_Name() {
					return Current_Location_Name;
				}
				public void setCurrent_Location_Name(String current_Location_Name) {
					Current_Location_Name = current_Location_Name;
				}
			
			}
		}
	}
}
