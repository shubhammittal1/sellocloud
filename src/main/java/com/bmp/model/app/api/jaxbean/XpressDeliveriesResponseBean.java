package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class XpressDeliveriesResponseBean {
	
	private Integer Records;
	private List<Poddata> Poddata;
	
	XpressDeliveriesResponseBean(){
		super();
	}
	public Integer getRecords() {
		return Records;
	}
	public void setRecords(Integer records) {
		Records = records;
	}
	public List<Poddata> getPoddata() {
		return Poddata;
	}
	public void setPoddata(List<Poddata> poddata) {
		Poddata = poddata;
	}

	public static class Poddata{
		private String Awbn;
		private String Reference;
		private String Name;
		private String Pincode;
		private String Status;
		private String Receiver;
		private String Relation;
		private String ReceivedDate;
		private String Reason;
		
		public Poddata() {
			super();
		}
		public String getAwbn() {
			return Awbn;
		}
		public void setAwbn(String awbn) {
			Awbn = awbn;
		}
		public String getReference() {
			return Reference;
		}
		public void setReference(String reference) {
			Reference = reference;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getPincode() {
			return Pincode;
		}
		public void setPincode(String pincode) {
			Pincode = pincode;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getReceiver() {
			return Receiver;
		}
		public void setReceiver(String receiver) {
			Receiver = receiver;
		}
		public String getRelation() {
			return Relation;
		}
		public void setRelation(String relation) {
			Relation = relation;
		}
		public String getReceivedDate() {
			return ReceivedDate;
		}
		public void setReceivedDate(String receivedDate) {
			ReceivedDate = receivedDate;
		}
		public String getReason() {
			return Reason;
		}
		public void setReason(String reason) {
			Reason = reason;
		}
	}
}
