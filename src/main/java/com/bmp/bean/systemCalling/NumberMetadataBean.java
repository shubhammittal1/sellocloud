package com.bmp.bean.systemCalling;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NumberMetadataBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Numbers  Numbers ; 
	private RestException RestException;
	
	public NumberMetadataBean() {
		super();
	}
	
	public Numbers getNumbers() {
		return Numbers;
	}

	public void setNumbers(Numbers numbers) {
		Numbers = numbers;
	}
	
	public RestException getRestException() {
		return RestException;
	}

	public void setRestException(RestException restException) {
		RestException = restException;
	}



	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Numbers{
		
		private String PhoneNumber;
		private String Circle;
		private String CircleName;
		private String Type;
		private String Operator;
		private String OperatorName;
		private String DND;
		
		public Numbers() {
			super();
		}

		public String getPhoneNumber() {
			return PhoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			PhoneNumber = phoneNumber;
		}

		public String getCircle() {
			return Circle;
		}

		public void setCircle(String circle) {
			Circle = circle;
		}

		public String getCircleName() {
			return CircleName;
		}

		public void setCircleName(String circleName) {
			CircleName = circleName;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}

		public String getOperator() {
			return Operator;
		}

		public void setOperator(String operator) {
			Operator = operator;
		}

		public String getOperatorName() {
			return OperatorName;
		}

		public void setOperatorName(String operatorName) {
			OperatorName = operatorName;
		}

		public String getDND() {
			return DND;
		}

		public void setDND(String dND) {
			DND = dND;
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
 