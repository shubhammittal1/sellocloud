
package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="receiving3plRto")
@AssignKey(assvalue=false)
public class Receiving3plRto extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String courierKey_s;
	@Indexed
	private String branchKey_s;
	private String rtoAwbNumber;
	@Indexed
	private List<String> successList_ss;
	@Indexed
	private List<String> errorList_ss;
	private Map<String, String> rtoAwbMessage;
	private Boolean status;
	@Indexed
	private Boolean editable_b;
	private String invoiceNo;
	private String rtoRejectReason;
	private Map<String, String> terminalStatusPackets;
	@Indexed
	private List<String> terminalList;
	
	public Receiving3plRto(){
		super();
	}

	public String getCourierKey_s() {
		return courierKey_s;
	}

	public void setCourierKey_s(String courierKey_s) {
		this.courierKey_s = courierKey_s;
	}

	public String getBranchKey_s() {
		return branchKey_s;
	}

	public void setBranchKey_s(String branchKey_s) {
		this.branchKey_s = branchKey_s;
	}

	public String getRtoAwbNumber() {
		return rtoAwbNumber;
	}

	public void setRtoAwbNumber(String rtoAwbNumber) {
		this.rtoAwbNumber = rtoAwbNumber;
	}

	public List<String> getSuccessList_ss() {
		return successList_ss;
	}

	public void setSuccessList_ss(List<String> successList_ss) {
		this.successList_ss = successList_ss;
	}

	public List<String> getErrorList_ss() {
		return errorList_ss;
	}

	public void setErrorList_ss(List<String> errorList_ss) {
		this.errorList_ss = errorList_ss;
	}

	public Map<String, String> getRtoAwbMessage() {
		return rtoAwbMessage;
	}

	public void setRtoAwbMessage(Map<String, String> rtoAwbMessage) {
		this.rtoAwbMessage = rtoAwbMessage;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getEditable_b() {
		return editable_b;
	}

	public void setEditable_b(Boolean editable_b) {
		this.editable_b = editable_b;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getRtoRejectReason() {
		return rtoRejectReason;
	}

	public void setRtoRejectReason(String rtoRejectReason) {
		this.rtoRejectReason = rtoRejectReason;
	}

	public Map<String, String> getTerminalStatusPackets() {
		return terminalStatusPackets;
	}

	public void setTerminalStatusPackets(Map<String, String> terminalStatusPackets) {
		this.terminalStatusPackets = terminalStatusPackets;
	}

	public List<String> getTerminalList() {
		return terminalList;
	}

	public void setTerminalList(List<String> terminalList) {
		this.terminalList = terminalList;
	}
	
}
