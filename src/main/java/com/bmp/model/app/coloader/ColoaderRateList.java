package com.bmp.model.app.coloader;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.FreightType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.masters.ProductType;
import com.bmp.model.app.masters.RateZone;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="coloaderRateList")
@AssignKey(assvalue=false)
public class ColoaderRateList extends MongoBaseBean implements Serializable{
	
	
	private static final long serialVersionUID = -8103755315803225423L;
	
	private Coloader coloader;
	@Indexed
	private String contractStartDate_l;
	@Indexed
	private String contractEndDate_l;
	private ProductType productType;
	private RateZone rateZone;
	private FreightType freightType;
	private RateMatrix rateMatrix;
	
	public ColoaderRateList(){}
	
	public Coloader getColoader() {
		return coloader;
	}
	public void setColoader(Coloader coloader) {
		this.coloader = coloader;
	}
	public String getContractStartDate_l() {
		return contractStartDate_l;
	}
	public void setContractStartDate_l(String contractStartDate_l) {
		this.contractStartDate_l = contractStartDate_l;
	}
	public String getContractEndDate_l() {
		return contractEndDate_l;
	}
	public void setContractEndDate_l(String contractEndDate_l) {
		this.contractEndDate_l = contractEndDate_l;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public RateZone getRateZone() {
		return rateZone;
	}
	public void setRateZone(RateZone rateZone) {
		this.rateZone = rateZone;
	}
	public FreightType getFreightType() {
		return freightType;
	}
	public void setFreightType(FreightType freightType) {
		this.freightType = freightType;
	}
	public RateMatrix getRateMatrix() {
		return rateMatrix;
	}
	public void setRateMatrix(RateMatrix rateMatrix) {
		this.rateMatrix = rateMatrix;
	}

	
}
