package com.bmp.model.app.saleorder;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="remittanceFrom3PL")
@AssignKey(assvalue=false)
public class RemittanceFrom3PL extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String awbNumber_s;
	@Indexed
	private String courierKey_s;
	@Indexed
	private String courierAWBNumber_s;
	private String remittanceNo;
	private Double receivedAmt;
	private String remittanceBankName;
	private String remittanceBankAccNo;
	private String dueDate;
	
	public RemittanceFrom3PL(){
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAwbNumber_s() {
		return awbNumber_s;
	}

	public String getCourierKey_s() {
		return courierKey_s;
	}

	public String getCourierAWBNumber_s() {
		return courierAWBNumber_s;
	}

	public String getRemittanceNo() {
		return remittanceNo;
	}

	public Double getReceivedAmt() {
		return receivedAmt;
	}

	public String getRemittanceBankName() {
		return remittanceBankName;
	}

	public String getRemittanceBankAccNo() {
		return remittanceBankAccNo;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setAwbNumber_s(String awbNumber_s) {
		this.awbNumber_s = awbNumber_s;
	}

	public void setCourierKey_s(String courierKey_s) {
		this.courierKey_s = courierKey_s;
	}

	public void setCourierAWBNumber_s(String courierAWBNumber_s) {
		this.courierAWBNumber_s = courierAWBNumber_s;
	}

	public void setRemittanceNo(String remittanceNo) {
		this.remittanceNo = remittanceNo;
	}

	public void setReceivedAmt(Double receivedAmt) {
		this.receivedAmt = receivedAmt;
	}

	public void setRemittanceBankName(String remittanceBankName) {
		this.remittanceBankName = remittanceBankName;
	}

	public void setRemittanceBankAccNo(String remittanceBankAccNo) {
		this.remittanceBankAccNo = remittanceBankAccNo;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	

}
