package com.bmp.bean.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorPayOrderCreationResponseBean {
	private String id;
    private String entity;
    private Double amount;
    private Double amount_paid;
    private Double amount_due;
    private String currency;
    private String receipt;
    private String offer_id;
    private String status;
    private Integer attempts;
    private Long created_at;
    
    public RazorPayOrderCreationResponseBean() {
    	
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(Double amount_paid) {
		this.amount_paid = amount_paid;
	}

	public Double getAmount_due() {
		return amount_due;
	}

	public void setAmount_due(Double amount_due) {
		this.amount_due = amount_due;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(String offer_id) {
		this.offer_id = offer_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public Long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Long created_at) {
		this.created_at = created_at;
	}
    
    

}
