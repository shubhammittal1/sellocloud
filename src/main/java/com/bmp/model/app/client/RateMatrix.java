package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.bmp.constant.ChargeCalculationType;
import com.bmp.model.app.client.RateMatrix.OtherCharge;

public class RateMatrix implements Serializable {

	private static final long serialVersionUID = -5537796509740841356L;

	private FlatFreight flatFreight;
	private List<SlabFreight> slabFreights;

	private Double awbCharge;				//mandate, unit value
	private Double minCodCharge;			//mandate, unit value
	private Integer totalSlabs;
	private Double minCharge;
	private Double codChargePercent;		//mandate, unit percent
	private Double fsc;						//mandate, unit percent
	private Double fscChargePercent;
	//private Double serviceTax;
	private Double gst;						//mandate, unit percent
	private Double rovCharge;				//optional, unit percent
	private Double fov;						//optional, unit percent
	private Double handlingCharges;			//optional, unit value
	//private Double extraDeliveryCharges;
	private Double oda;						//mandate, unit value
	private Double insuranceCharges;		//mandate, unit percent
	//private Double lastMileCharges;
	//private Double lastMileWeight;
	//private Double otherCharges;			//optional, unit value
	private Double otherCharges2;			//optional, unit percent
	
	private Boolean isCodFixedCharge;
	private Double codFixedCharge;
	private Boolean isFscFixedCharge;
	private Double fscFixedCharge;
	private Map<String, OtherCharge> otherCharges;
	

	public RateMatrix() {
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

	public Map<String, OtherCharge> getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(Map<String, OtherCharge> otherCharges) {
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

	/*public Double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(Double serviceTax) {
		this.serviceTax = serviceTax;
	}*/

	public Double getHandlingCharges() {
		return handlingCharges;
	}

	public void setHandlingCharges(Double handlingCharges) {
		this.handlingCharges = handlingCharges;
	}

	/*public Double getExtraDeliveryCharges() {
		return extraDeliveryCharges;
	}

	public void setExtraDeliveryCharges(Double extraDeliveryCharges) {
		this.extraDeliveryCharges = extraDeliveryCharges;
	}*/

	public Double getInsuranceCharges() {
		return insuranceCharges;
	}

	public void setInsuranceCharges(Double insuranceCharges) {
		this.insuranceCharges = insuranceCharges;
	}

	/*public Double getLastMileCharges() {
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
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getOda() {
		return oda;
	}

	public void setOda(Double oda) {
		this.oda = oda;
	}

	public Double getFscChargePercent() {
		return fscChargePercent;
	}
	public void setFscChargePercent(Double fscChargePercent) {
		this.fscChargePercent = fscChargePercent;
	}

	public Boolean getIsCodFixedCharge() {
		return isCodFixedCharge;
	}

	public void setIsCodFixedCharge(Boolean isCodFixedCharge) {
		this.isCodFixedCharge = isCodFixedCharge;
	}

	public Double getCodFixedCharge() {
		return codFixedCharge;
	}

	public void setCodFixedCharge(Double codFixedCharge) {
		this.codFixedCharge = codFixedCharge;
	}

	public Boolean getIsFscFixedCharge() {
		return isFscFixedCharge;
	}

	public void setIsFscFixedCharge(Boolean isFscFixedCharge) {
		this.isFscFixedCharge = isFscFixedCharge;
	}

	public Double getFscFixedCharge() {
		return fscFixedCharge;
	}

	public void setFscFixedCharge(Double fscFixedCharge) {
		this.fscFixedCharge = fscFixedCharge;
	}

	public Integer getTotalSlabs() {
		return totalSlabs;
	}

	public void setTotalSlabs(Integer totalSlabs) {
		this.totalSlabs = totalSlabs;
	}

	public Double getMinCharge() {
		return minCharge;
	}

	public void setMinCharge(Double minCharge) {
		this.minCharge = minCharge;
	}
	

	
	public static class OtherCharge {
		private String biilingOtherChargeKey;
		private Double miniumCharge;
		private Double persentCharge;
		private Double perKgCharge;
		private ChargeCalculationType chargeCalculationType;
		
		public String getBiilingOtherChargeKey() {
			return biilingOtherChargeKey;
		}
		public void setBiilingOtherChargeKey(String biilingOtherChargeKey) {
			this.biilingOtherChargeKey = biilingOtherChargeKey;
		}
		public Double getMiniumCharge() {
			return miniumCharge;
		}
		public void setMiniumCharge(Double miniumCharge) {
			this.miniumCharge = miniumCharge;
		}
		public Double getPersentCharge() {
			return persentCharge;
		}
		public void setPersentCharge(Double persentCharge) {
			this.persentCharge = persentCharge;
		}
		public Double getPerKgCharge() {
			return perKgCharge;
		}
		public void setPerKgCharge(Double perKgCharge) {
			this.perKgCharge = perKgCharge;
		}
		public ChargeCalculationType getChargeCalculationType() {
			return chargeCalculationType;
		}
		public void setChargeCalculationType(ChargeCalculationType chargeCalculationType) {
			this.chargeCalculationType = chargeCalculationType;
		}
		
	}
}
