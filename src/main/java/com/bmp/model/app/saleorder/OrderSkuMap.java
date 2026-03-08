package com.bmp.model.app.saleorder;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderSkuMap implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String productSku ;
	
	public OrderSkuMap() {
		super();
	}

	public String getProductSku() {
		return productSku;
	}

	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}

}