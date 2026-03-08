package com.bmp.model.app.client;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="clientProductSkuRate")
@AssignKey(assvalue=false)
public class ClientProductSkuRate extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -4677577840752533287L;
	
	@Indexed
	private String clientKey;
	@Indexed
	private String productSKU;
	private String hsnCode;
	private Double productMRP;
	private Double basicRate;
	//private Double basicValue;
	private Double productDiscount;
	//private Double taxableValue;
	private Double cgstRate;
	private Double sgstRate;
	private Double igstRate;
	
	public ClientProductSkuRate() {
		super();
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Double getProductMRP() {
		return productMRP;
	}

	public void setProductMRP(Double productMRP) {
		this.productMRP = productMRP;
	}

	public Double getBasicRate() {
		return basicRate;
	}

	public void setBasicRate(Double basicRate) {
		this.basicRate = basicRate;
	}

	/*public Double getBasicValue() {
		return basicValue;
	}

	public void setBasicValue(Double basicValue) {
		this.basicValue = basicValue;
	}*/

	public Double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}

	/*public Double getTaxableValue() {
		return taxableValue;
	}

	public void setTaxableValue(Double taxableValue) {
		this.taxableValue = taxableValue;
	}*/

	public Double getCgstRate() {
		return cgstRate;
	}

	public void setCgstRate(Double cgstRate) {
		this.cgstRate = cgstRate;
	}

	public Double getSgstRate() {
		return sgstRate;
	}

	public void setSgstRate(Double sgstRate) {
		this.sgstRate = sgstRate;
	}

	public Double getIgstRate() {
		return igstRate;
	}

	public void setIgstRate(Double igstRate) {
		this.igstRate = igstRate;
	}

}
