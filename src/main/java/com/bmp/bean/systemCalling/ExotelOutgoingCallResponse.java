package com.bmp.bean.systemCalling;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExotelOutgoingCallResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Call Call;
	private RestException RestException;
	
	public ExotelOutgoingCallResponse() {
		super();
	}
	
	public Call getCall() {
		return Call;
	}

	public void setCall(Call call) {
		this.Call = call;
	}

	public RestException getRestException() {
		return RestException;
	}

	public void setRestException(RestException restException) {
		this.RestException = restException;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Call{
		private String Sid;
		private String ParentCallSid;
		private String DateCreated;
		private String DateUpdated;
		private String AccountSid;
		private String To;
		private String From;
		private String PhoneNumberSid;
		private String Status;
		private String StartTime;
		private String EndTime;
		private String Duration;
		private String Price;
		private String Direction;
		private String AnsweredBy;
		private String ForwardedFrom;
		private String CallerName;
		private String Uri;
		private String RecordingUrl;
		private CallDetails Details;
		
		public Call() {
			super();
		}
		public String getSid() {
			return Sid;
		}
		public void setSid(String sid) {
			Sid = sid;
		}
		public String getParentCallSid() {
			return ParentCallSid;
		}
		public void setParentCallSid(String parentCallSid) {
			ParentCallSid = parentCallSid;
		}
		public String getDateCreated() {
			return DateCreated;
		}
		public void setDateCreated(String dateCreated) {
			DateCreated = dateCreated;
		}
		public String getDateUpdated() {
			return DateUpdated;
		}
		public void setDateUpdated(String dateUpdated) {
			DateUpdated = dateUpdated;
		}
		public String getAccountSid() {
			return AccountSid;
		}
		public void setAccountSid(String accountSid) {
			AccountSid = accountSid;
		}
		public String getTo() {
			return To;
		}
		public void setTo(String to) {
			To = to;
		}
		public String getFrom() {
			return From;
		}
		public void setFrom(String from) {
			From = from;
		}
		public String getPhoneNumberSid() {
			return PhoneNumberSid;
		}
		public void setPhoneNumberSid(String phoneNumberSid) {
			PhoneNumberSid = phoneNumberSid;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getStartTime() {
			return StartTime;
		}
		public void setStartTime(String startTime) {
			StartTime = startTime;
		}
		public String getEndTime() {
			return EndTime;
		}
		public void setEndTime(String endTime) {
			EndTime = endTime;
		}
		public String getDuration() {
			return Duration;
		}
		public void setDuration(String duration) {
			Duration = duration;
		}
		public String getPrice() {
			return Price;
		}
		public void setPrice(String price) {
			Price = price;
		}
		public String getDirection() {
			return Direction;
		}
		public void setDirection(String direction) {
			Direction = direction;
		}
		public String getAnsweredBy() {
			return AnsweredBy;
		}
		public void setAnsweredBy(String answeredBy) {
			AnsweredBy = answeredBy;
		}
		public String getForwardedFrom() {
			return ForwardedFrom;
		}
		public void setForwardedFrom(String forwardedFrom) {
			ForwardedFrom = forwardedFrom;
		}
		public String getCallerName() {
			return CallerName;
		}
		public void setCallerName(String callerName) {
			CallerName = callerName;
		}
		public String getUri() {
			return Uri;
		}
		public void setUri(String uri) {
			Uri = uri;
		}
		public String getRecordingUrl() {
			return RecordingUrl;
		}
		public void setRecordingUrl(String recordingUrl) {
			RecordingUrl = recordingUrl;
		}
		public CallDetails getDetails() {
			return Details;
		}
		public void setDetails(CallDetails details) {
			Details = details;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class CallDetails{
		private String ConversationDuration;
		private String Leg1Status;
		private String Leg2Status;
		
		public CallDetails() {
			super();
		}
		
		public String getConversationDuration() {
			return ConversationDuration;
		}
		public void setConversationDuration(String conversationDuration) {
			ConversationDuration = conversationDuration;
		}
		public String getLeg1Status() {
			return Leg1Status;
		}
		public void setLeg1Status(String leg1Status) {
			Leg1Status = leg1Status;
		}
		public String getLeg2Status() {
			return Leg2Status;
		}
		public void setLeg2Status(String leg2Status) {
			Leg2Status = leg2Status;
		}
		
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class RestException{
		private String Status;
		private String Message;
		
		public RestException() {
			super();
		}

		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		
	}
}
