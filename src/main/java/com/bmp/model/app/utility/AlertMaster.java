package com.bmp.model.app.utility;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.AlertType;
import com.bmp.constant.SubAlertType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="alertMaster")
@AssignKey(assvalue=false)
public class AlertMaster extends MongoBaseBean {
	
	private static final long serialVersionUID = 6381211981474998143L;
	private String templateName;
	@Indexed
	private AlertType alertType;
	@Indexed
	private SubAlertType subAlertType;
	private String templateDetails;
	private String subject;
	private String fromEmailId;
	private String to;
	private String ccEmailIds;
	private String implClass;
	private String params;
	private boolean realTimeAlert;
	@Indexed
	private String client;
	private Map<String,String> clientProduct;
	@Indexed
	private Boolean clientTemplate;
	private List<String> ndrList;
	@Indexed
	private String status;
	private String extra;
	
	public AlertMaster() {
		super();
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public AlertType getAlertType() {
		return alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	public String getTemplateDetails() {
		return templateDetails;
	}

	public void setTemplateDetails(String templateDetails) {
		this.templateDetails = templateDetails;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFromEmailId() {
		return fromEmailId;
	}

	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCcEmailIds() {
		return ccEmailIds;
	}

	public void setCcEmailIds(String ccEmailIds) {
		this.ccEmailIds = ccEmailIds;
	}

	public SubAlertType getSubAlertType() {
		return subAlertType;
	}

	public void setSubAlertType(SubAlertType subAlertType) {
		this.subAlertType = subAlertType;
	}

	public String getImplClass() {
		return implClass;
	}

	public void setImplClass(String implClass) {
		this.implClass = implClass;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public boolean isRealTimeAlert() {
		return realTimeAlert;
	}

	public void setRealTimeAlert(boolean realTimeAlert) {
		this.realTimeAlert = realTimeAlert;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Map<String, String> getClientProduct() {
		return clientProduct;
	}

	public void setClientProduct(Map<String, String> clientProduct) {
		this.clientProduct = clientProduct;
	}

	public Boolean getClientTemplate() {
		return clientTemplate;
	}

	public void setClientTemplate(Boolean clientTemplate) {
		this.clientTemplate = clientTemplate;
	}

	public List<String> getNdrList() {
		return ndrList;
	}

	public void setNdrList(List<String> ndrList) {
		this.ndrList = ndrList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	

	/*public String getNdr() {
		return ndr;
	}

	public void setNdr(String ndr) {
		this.ndr = ndr;
	}*/
	
	
}