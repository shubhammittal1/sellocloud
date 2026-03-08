package com.bmp.model.app.coloader;

import java.io.Serializable;
import java.util.List;

public class RateMatrix implements Serializable {

	private static final long serialVersionUID = -5537796509740841356L;

	private FixedFreight fixedFreight;
	private FlatFreight flatFreight;
	private List<SlabFreight> slabFreights;

	private Double awbCharge;
	private Double minCodCharge;
	private Double codChargePercent;
	private Double fsc;
	private Double serviceTax;
	private Double rovCharge;
	private Double fov;
	private Double handlingCharges;
	private Double extraDeliveryCharges;
	private Double insuranceCharges;
	private Double lastMileCharges;
	private Double lastMileWeight;
	private Double otherCharges;
	private Double otherCharges2;

	public RateMatrix() {
	}

	public FixedFreight getFixedFreight() {
		return fixedFreight;
	}

	public void setFixedFreight(FixedFreight fixedFreight) {
		this.fixedFreight = fixedFreight;
	}

	public FlatFreight getFlatFreight() {
		return flatFreight;
	}

	public void setFlatFreight(FlatFreight flatFreight) {
		this.flatFreight = flatFreight;
	}

	public List<SlabFreight> getSlabFreights() {
		return slabFreights;
	}

	public void setSlabFreights(List<SlabFreight> slabFreights) {
		this.slabFreights = slabFreights;
	}

	public Double getAwbCharge() {
		return awbCharge;
	}

	public void setAwbCharge(Double awbCharge) {
		this.awbCharge = awbCharge;
	}

	public Double getCodChargePercent() {
		return codChargePercent;
	}

	public void setCodChargePercent(Double codChargePercent) {
		this.codChargePercent = codChargePercent;
	}

	public Double getFsc() {
		return fsc;
	}

	public void setFsc(Double fsc) {
		this.fsc = fsc;
	}

	public Double getRovCharge() {
		return rovCharge;
	}

	public void setRovCharge(Double rovCharge) {
		this.rovCharge = rovCharge;
	}

	public Double getFov() {
		return fov;
	}

	public void setFov(Double fov) {
		this.fov = fov;
	}

	public Double getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(Double otherCharges) {
		this.otherCharges = otherCharges;
	}

	public Double getOtherCharges2() {
		return otherCharges2;
	}

	public void setOtherCharges2(Double otherCharges2) {
		this.otherCharges2 = otherCharges2;
	}

	public Double getMinCodCharge() {
		return minCodCharge;
	}

	public void setMinCodCharge(Double minCodCharge) {
		this.minCodCharge = minCodCharge;
	}

	public Double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(Double serviceTax) {
		this.serviceTax = serviceTax;
	}

	public Double getHandlingCharges() {
		return handlingCharges;
	}

	public void setHandlingCharges(Double handlingCharges) {
		this.handlingCharges = handlingCharges;
	}

	public Double getExtraDeliveryCharges() {
		return extraDeliveryCharges;
	}

	public void setExtraDeliveryCharges(Double extraDeliveryCharges) {
		this.extraDeliveryCharges = extraDeliveryCharges;
	}

	public Double getInsuranceCharges() {
		return insuranceCharges;
	}

	public void setInsuranceCharges(Double insuranceCharges) {
		this.insuranceCharges = insuranceCharges;
	}

	public Double getLastMileCharges() {
		return lastMileCharges;
	}

	public void setLastMileCharges(Double lastMileCharges) {
		this.lastMileCharges = lastMileCharges;
	}

	public Double getLastMileWeight() {
		return lastMileWeight;
	}

	public void setLastMileWeight(Double lastMileWeight) {
		this.lastMileWeight = lastMileWeight;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
