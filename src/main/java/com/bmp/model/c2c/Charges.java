package com.bmp.model.c2c;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Charges{
	private BigDecimal courierCharges_d;
	private BigDecimal courierTax_d;
	private BigDecimal totalCharges_d;
	private BigDecimal vendorCharges_d;
	private BigDecimal clientGeofedCharges_d;
	private BigDecimal reconiableCharges_d;
	private BigDecimal codCharges_d;
	private BigDecimal rtoCharges_d;
	private BigDecimal incuranceCharges_d;
	private BigDecimal collectableValue_d;
	private BigDecimal declaredValue_d;

	public BigDecimal getCourierCharges_d() {
		return courierCharges_d;
	}
	public void setCourierCharges_d(BigDecimal courierCharges_d) {
		this.courierCharges_d = courierCharges_d;
	}
	public BigDecimal getCourierTax_d() {
		return courierTax_d;
	}
	public void setCourierTax_d(BigDecimal courierTax_d) {
		this.courierTax_d = courierTax_d;
	}
	public BigDecimal getTotalCharges_d() {
		return totalCharges_d;
	}
	public void setTotalCharges_d(BigDecimal totalCharges_d) {
		this.totalCharges_d = totalCharges_d;
	}
	public BigDecimal getVendorCharges_d() {
		return vendorCharges_d;
	}
	public void setVendorCharges_d(BigDecimal vendorCharges_d) {
		this.vendorCharges_d = vendorCharges_d;
	}
	public BigDecimal getClientGeofedCharges_d() {
		return clientGeofedCharges_d;
	}
	public void setClientGeofedCharges_d(BigDecimal clientGeofedCharges_d) {
		this.clientGeofedCharges_d = clientGeofedCharges_d;
	}
	public BigDecimal getReconiableCharges_d() {
		return reconiableCharges_d;
	}
	public void setReconiableCharges_d(BigDecimal reconiableCharges_d) {
		this.reconiableCharges_d = reconiableCharges_d;
	}
	public BigDecimal getCodCharges_d() {
		return codCharges_d;
	}
	public void setCodCharges_d(BigDecimal codCharges_d) {
		this.codCharges_d = codCharges_d;
	}
	public BigDecimal getRtoCharges_d() {
		return rtoCharges_d;
	}
	public void setRtoCharges_d(BigDecimal rtoCharges_d) {
		this.rtoCharges_d = rtoCharges_d;
	}
	public BigDecimal getIncuranceCharges_d() {
		return incuranceCharges_d;
	}
	public void setIncuranceCharges_d(BigDecimal incuranceCharges_d) {
		this.incuranceCharges_d = incuranceCharges_d;
	}
	public BigDecimal getCollectableValue_d() {
		return collectableValue_d;
	}
	public void setCollectableValue_d(BigDecimal collectableValue_d) {
		this.collectableValue_d = collectableValue_d;
	}
	public BigDecimal getDeclaredValue_d() {
		return declaredValue_d;
	}
	public void setDeclaredValue_d(BigDecimal declaredValue_d) {
		this.declaredValue_d = declaredValue_d;
	}
}