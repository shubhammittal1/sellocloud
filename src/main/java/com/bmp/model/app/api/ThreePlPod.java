package com.bmp.model.app.api;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="threePlPod")
@AssignKey(assvalue=false)
public class ThreePlPod extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String courierKey;
	@Indexed
	private String courierAwb;
	@Indexed
	private String awb;
	private String pickUpDate;
	private String receivedBy;
	private String reciverRelation;
	private String idType;
	private String idNumber;
	private String idImage;
	private String signature;
	private String latitude;
	private String longitude;
	private String podImage;
	private String dcImage;
	
	
	public String getCourierKey() {
		return courierKey;
	}
	public void setCourierKey(String courierKey) {
		this.courierKey = courierKey;
	}
	public String getCourierAwb() {
		return courierAwb;
	}
	public void setCourierAwb(String courierAwb) {
		this.courierAwb = courierAwb;
	}
	public String getAwb() {
		return awb;
	}
	public void setAwb(String awb) {
		this.awb = awb;
	}
	public String getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public String getReceivedBy() {
		return receivedBy;
	}
	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}
	public String getReciverRelation() {
		return reciverRelation;
	}
	public void setReciverRelation(String reciverRelation) {
		this.reciverRelation = reciverRelation;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getIdImage() {
		return idImage;
	}
	public void setIdImage(String idImage) {
		this.idImage = idImage;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getPodImage() {
		return podImage;
	}
	public void setPodImage(String podImage) {
		this.podImage = podImage;
	}
	public String getDcImage() {
		return dcImage;
	}
	public void setDcImage(String dcImage) {
		this.dcImage = dcImage;
	}
	
	
}
