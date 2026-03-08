package com.bmp.model.app.masters;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.FreightType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.client.RateMatrix;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="rateZoneMatrix")
@AssignKey(assvalue=false)
public class RateZoneMatrix extends MongoBaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String rateZoneTypeKey;
	private List<String> fromZones;
	private List<String> toZones;
	private Map<String, Double> zoneRatesMap;
	
	private FreightType freightType;
	private RateMatrix rateMatrix;
	@Indexed
	private String clientKey;
	@Transient
	private String clientName;
	private String courier;
	@Transient
	private String courierName;
	@Transient
	private String courierLogo;
	
	@Indexed
	private String serviceType;
	@Indexed
	private String serviceMode;
	

	public String getRateZoneTypeKey() {
		return rateZoneTypeKey;
	}

	public void setRateZoneTypeKey(String rateZoneTypeKey) {
		this.rateZoneTypeKey = rateZoneTypeKey;
	}

	public List<String> getFromZones() {
		return fromZones;
	}

	public void setFromZones(List<String> fromZones) {
		this.fromZones = fromZones;
	}

	public List<String> getToZones() {
		return toZones;
	}

	public void setToZones(List<String> toZones) {
		this.toZones = toZones;
	}

	public Map<String, Double> getZoneRatesMap() {
		return zoneRatesMap;
	}

	public void setZoneRatesMap(Map<String, Double> zoneRatesMap) {
		this.zoneRatesMap = zoneRatesMap;
	}

	public RateMatrix getRateMatrix() {
		return rateMatrix;
	}

	public void setRateMatrix(RateMatrix rateMatrix) {
		this.rateMatrix = rateMatrix;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FreightType getFreightType() {
		return freightType;
	}

	public void setFreightType(FreightType freightType) {
		this.freightType = freightType;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public String getCourierLogo() {
		return courierLogo;
	}

	public void setCourierLogo(String courierLogo) {
		this.courierLogo = courierLogo;
	}
	
	

}
