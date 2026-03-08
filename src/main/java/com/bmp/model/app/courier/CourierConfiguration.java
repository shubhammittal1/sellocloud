package com.bmp.model.app.courier;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="courierConfiguration")
@AssignKey(assvalue=false)
public class CourierConfiguration extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = -2895853850392968242L;
	
	@Indexed
	private String clientKey_s;
	private List<String> b2bAllowedCourier;
	private List<String> b2cAllowedCourier;
	private List<String> internationalAllowedCourier;
	
	private String b2bCourierPriorityTemplateKey_s;
	private String b2cCourierPriorityTemplateKey_s;
	private String internationalCourierPriorityTemplateKey_s;
	
	private Map<String,List<String>> b2bPickupDropCourierPeriority;
	private Map<String,List<String>> b2cPickupDropCourierPeriority;
	private Map<String,List<String>> internationalPickupDropCourierPeriority;
	
	private Map<String,String> b2bPickupDropZone;
	private Map<String,String> b2cPickupDropZone;
	private Map<String,String> internationalPickupDropZone;
	
	public String getClientKey_s() {
		return clientKey_s;
	}
	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}
	public List<String> getB2bAllowedCourier() {
		return b2bAllowedCourier;
	}
	public void setB2bAllowedCourier(List<String> b2bAllowedCourier) {
		this.b2bAllowedCourier = b2bAllowedCourier;
	}
	public List<String> getB2cAllowedCourier() {
		return b2cAllowedCourier;
	}
	public void setB2cAllowedCourier(List<String> b2cAllowedCourier) {
		this.b2cAllowedCourier = b2cAllowedCourier;
	}
	public String getB2bCourierPriorityTemplateKey_s() {
		return b2bCourierPriorityTemplateKey_s;
	}
	public void setB2bCourierPriorityTemplateKey_s(String b2bCourierPriorityTemplateKey_s) {
		this.b2bCourierPriorityTemplateKey_s = b2bCourierPriorityTemplateKey_s;
	}
	public String getB2cCourierPriorityTemplateKey_s() {
		return b2cCourierPriorityTemplateKey_s;
	}
	public void setB2cCourierPriorityTemplateKey_s(String b2cCourierPriorityTemplateKey_s) {
		this.b2cCourierPriorityTemplateKey_s = b2cCourierPriorityTemplateKey_s;
	}
	public Map<String, List<String>> getB2bPickupDropCourierPeriority() {
		return b2bPickupDropCourierPeriority;
	}
	public void setB2bPickupDropCourierPeriority(Map<String, List<String>> b2bPickupDropCourierPeriority) {
		this.b2bPickupDropCourierPeriority = b2bPickupDropCourierPeriority;
	}
	public Map<String, List<String>> getB2cPickupDropCourierPeriority() {
		return b2cPickupDropCourierPeriority;
	}
	public void setB2cPickupDropCourierPeriority(Map<String, List<String>> b2cPickupDropCourierPeriority) {
		this.b2cPickupDropCourierPeriority = b2cPickupDropCourierPeriority;
	}
	public Map<String, String> getB2bPickupDropZone() {
		return b2bPickupDropZone;
	}
	public void setB2bPickupDropZone(Map<String, String> b2bPickupDropZone) {
		this.b2bPickupDropZone = b2bPickupDropZone;
	}
	public Map<String, String> getB2cPickupDropZone() {
		return b2cPickupDropZone;
	}
	public void setB2cPickupDropZone(Map<String, String> b2cPickupDropZone) {
		this.b2cPickupDropZone = b2cPickupDropZone;
	}
	public List<String> getInternationalAllowedCourier() {
		return internationalAllowedCourier;
	}
	public void setInternationalAllowedCourier(List<String> internationalAllowedCourier) {
		this.internationalAllowedCourier = internationalAllowedCourier;
	}
	public String getInternationalCourierPriorityTemplateKey_s() {
		return internationalCourierPriorityTemplateKey_s;
	}
	public void setInternationalCourierPriorityTemplateKey_s(String internationalCourierPriorityTemplateKey_s) {
		this.internationalCourierPriorityTemplateKey_s = internationalCourierPriorityTemplateKey_s;
	}
	public Map<String, List<String>> getInternationalPickupDropCourierPeriority() {
		return internationalPickupDropCourierPeriority;
	}
	public void setInternationalPickupDropCourierPeriority(
			Map<String, List<String>> internationalPickupDropCourierPeriority) {
		this.internationalPickupDropCourierPeriority = internationalPickupDropCourierPeriority;
	}
	public Map<String, String> getInternationalPickupDropZone() {
		return internationalPickupDropZone;
	}
	public void setInternationalPickupDropZone(Map<String, String> internationalPickupDropZone) {
		this.internationalPickupDropZone = internationalPickupDropZone;
	}
	
	
}
