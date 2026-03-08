package com.bmp.model.app.client;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="clientSKUWeigthLooker")
@AssignKey(assvalue=false)
public class ClientSKUWeigthLooker extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -4677577840752533287L;
	@Indexed
	private String awbNumber_s;
	@Indexed
	private String sku_s;
	@Indexed
	private String clientKey_s;
	@Indexed
	private Boolean skuWeightApproved_b;
	
	private Double clientLength;
	private Double clientwidth;
	private Double clientHeight;
	private Double clientDeadWeight;
	@Indexed
	private Double clientApplicableWeight_d;
	
	private Double measuredLength;
	private Double measuredwidth;
	private Double measuredHeight;
	private Double measuredDeadWieght;
	@Indexed
	private Double measuredApplicableWeight_d;
	
	private Double partnerLength;
	private Double partnerwidth;
	private Double partnerHeight;
	private Double partnerDeadWeight;
	@Indexed
	private Double partnerApplicableWeight_d;
	
	private Double approvedLength;
	private Double approvedwidth;
	private Double approvedHight;
	private Double approvedDeadWeight;
	@Indexed
	private Double approvedApplicableWeight_d;

	public ClientSKUWeigthLooker(){
		
	}

	public String getAwbNumber_s() {
		return awbNumber_s;
	}

	public void setAwbNumber_s(String awbNumber_s) {
		this.awbNumber_s = awbNumber_s;
	}

	public String getSku_s() {
		return sku_s;
	}

	public void setSku_s(String sku_s) {
		this.sku_s = sku_s;
	}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	public Boolean getSkuWeightApproved_b() {
		return skuWeightApproved_b;
	}

	public void setSkuWeightApproved_b(Boolean skuWeightApproved_b) {
		this.skuWeightApproved_b = skuWeightApproved_b;
	}

	public Double getClientLength() {
		return clientLength;
	}

	public void setClientLength(Double clientLength) {
		this.clientLength = clientLength;
	}

	public Double getClientwidth() {
		return clientwidth;
	}

	public void setClientwidth(Double clientwidth) {
		this.clientwidth = clientwidth;
	}

	public Double getClientHeight() {
		return clientHeight;
	}

	public void setClientHeight(Double clientHeight) {
		this.clientHeight = clientHeight;
	}

	public Double getClientDeadWeight() {
		return clientDeadWeight;
	}

	public void setClientDeadWeight(Double clientDeadWeight) {
		this.clientDeadWeight = clientDeadWeight;
	}

	public Double getClientApplicableWeight_d() {
		return clientApplicableWeight_d;
	}

	public void setClientApplicableWeight_d(Double clientApplicableWeight_d) {
		this.clientApplicableWeight_d = clientApplicableWeight_d;
	}

	public Double getMeasuredLength() {
		return measuredLength;
	}

	public void setMeasuredLength(Double measuredLength) {
		this.measuredLength = measuredLength;
	}

	public Double getMeasuredwidth() {
		return measuredwidth;
	}

	public void setMeasuredwidth(Double measuredwidth) {
		this.measuredwidth = measuredwidth;
	}

	public Double getMeasuredHeight() {
		return measuredHeight;
	}

	public void setMeasuredHeight(Double measuredHeight) {
		this.measuredHeight = measuredHeight;
	}

	public Double getMeasuredDeadWieght() {
		return measuredDeadWieght;
	}

	public void setMeasuredDeadWieght(Double measuredDeadWieght) {
		this.measuredDeadWieght = measuredDeadWieght;
	}

	public Double getMeasuredApplicableWeight_d() {
		return measuredApplicableWeight_d;
	}

	public void setMeasuredApplicableWeight_d(Double measuredApplicableWeight_d) {
		this.measuredApplicableWeight_d = measuredApplicableWeight_d;
	}

	public Double getPartnerLength() {
		return partnerLength;
	}

	public void setPartnerLength(Double partnerLength) {
		this.partnerLength = partnerLength;
	}

	public Double getPartnerwidth() {
		return partnerwidth;
	}

	public void setPartnerwidth(Double partnerwidth) {
		this.partnerwidth = partnerwidth;
	}

	public Double getPartnerHeight() {
		return partnerHeight;
	}

	public void setPartnerHeight(Double partnerHeight) {
		this.partnerHeight = partnerHeight;
	}

	public Double getPartnerDeadWeight() {
		return partnerDeadWeight;
	}

	public void setPartnerDeadWeight(Double partnerDeadWeight) {
		this.partnerDeadWeight = partnerDeadWeight;
	}

	public Double getPartnerApplicableWeight_d() {
		return partnerApplicableWeight_d;
	}

	public void setPartnerApplicableWeight_d(Double partnerApplicableWeight_d) {
		this.partnerApplicableWeight_d = partnerApplicableWeight_d;
	}

	public Double getApprovedLength() {
		return approvedLength;
	}

	public void setApprovedLength(Double approvedLength) {
		this.approvedLength = approvedLength;
	}

	public Double getApprovedwidth() {
		return approvedwidth;
	}

	public void setApprovedwidth(Double approvedwidth) {
		this.approvedwidth = approvedwidth;
	}

	public Double getApprovedHight() {
		return approvedHight;
	}

	public void setApprovedHight(Double approvedHight) {
		this.approvedHight = approvedHight;
	}

	public Double getApprovedDeadWeight() {
		return approvedDeadWeight;
	}

	public void setApprovedDeadWeight(Double approvedDeadWeight) {
		this.approvedDeadWeight = approvedDeadWeight;
	}

	public Double getApprovedApplicableWeight_d() {
		return approvedApplicableWeight_d;
	}

	public void setApprovedApplicableWeight_d(Double approvedApplicableWeight_d) {
		this.approvedApplicableWeight_d = approvedApplicableWeight_d;
	}

}