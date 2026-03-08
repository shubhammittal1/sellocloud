package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="clientDashboard")
@AssignKey(assvalue=false)
public class ClientDashboard extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -6471942060143896073L;
	@Indexed
	private String clientName_s;
	@Indexed
	private Long scanDate_l;
	
	private Long cloesePckts;
	private Long openPckts;
	
	//Open Packets Report
	private Long inprocess;
	private Long intransit;
	private Long outForDelivery;
	private Long deliveryAttempted;
	private Long rtoInitiated;
	private Long rtoDeclared;
	private Long readyForScan;
	private Long  handoverTo3PL;
	private Long  manifestGenerated3PL;
	private Long  manifestShipped3PL;
	private Long  partnerPendency;
	
	private Long  closedRemittance;
	private Long  generatedRemittance;
	
	//Closed Packets Report 
	private Long delivered;
	private Long lost;
	private Long damaged;
	private Long totalPkt;
	private Long ndrPkt;	
	//Rto Packets Report
	private Long rtoIntransit;
	private Long rtoInprocess;
	private Long rtoOutForDelivery;
	private Long rtoDeliveryAttempted;
	private Long rtoDelivered;
	
	private Long extra1;
	private Long extra2;
	
	//Client Zone Wise Report
	private Long east;
	private Long west;
	private Long north;
	private Long south;
	private Long northEast;
	
	//Rto Reason Report
	private Map<String, Object> rtoResonMap; 
	
	//Excel Report
	private Map<String, Object> openAndCloseMap; 
	private Map<String, Object> zonewiseMap;
	private Map<String, Object> openRtoMap;
	private Map<String, Object> rtoReasonPcktsMap;
	
	public ClientDashboard(){}

	public String getClientName_s() {
		return clientName_s;
	}

	public void setClientName_s(String clientName_s) {
		this.clientName_s = clientName_s;
	}

	public Long getScanDate_l() {
		return scanDate_l;
	}

	public void setScanDate_l(Long scanDate_l) {
		this.scanDate_l = scanDate_l;
	}

	public Long getCloesePckts() {
		return cloesePckts;
	}

	public void setCloesePckts(Long cloesePckts) {
		this.cloesePckts = cloesePckts;
	}

	public Long getOpenPckts() {
		return openPckts;
	}

	public void setOpenPckts(Long openPckts) {
		this.openPckts = openPckts;
	}

	public Long getInprocess() {
		return inprocess;
	}

	public void setInprocess(Long inprocess) {
		this.inprocess = inprocess;
	}

	public Long getIntransit() {
		return intransit;
	}

	public void setIntransit(Long intransit) {
		this.intransit = intransit;
	}

	public Long getOutForDelivery() {
		return outForDelivery;
	}

	public void setOutForDelivery(Long outForDelivery) {
		this.outForDelivery = outForDelivery;
	}

	public Long getDeliveryAttempted() {
		return deliveryAttempted;
	}

	public void setDeliveryAttempted(Long deliveryAttempted) {
		this.deliveryAttempted = deliveryAttempted;
	}

	public Long getRtoInitiated() {
		return rtoInitiated;
	}

	public void setRtoInitiated(Long rtoInitiated) {
		this.rtoInitiated = rtoInitiated;
	}

	public Long getRtoDeclared() {
		return rtoDeclared;
	}

	public void setRtoDeclared(Long rtoDeclared) {
		this.rtoDeclared = rtoDeclared;
	}

	public Long getDelivered() {
		return delivered;
	}

	public void setDelivered(Long delivered) {
		this.delivered = delivered;
	}

	public Long getLost() {
		return lost;
	}

	public void setLost(Long lost) {
		this.lost = lost;
	}

	public Long getDamaged() {
		return damaged;
	}

	public void setDamaged(Long damaged) {
		this.damaged = damaged;
	}

	public Long getRtoIntransit() {
		return rtoIntransit;
	}

	public void setRtoIntransit(Long rtoIntransit) {
		this.rtoIntransit = rtoIntransit;
	}

	public Long getRtoInprocess() {
		return rtoInprocess;
	}

	public void setRtoInprocess(Long rtoInprocess) {
		this.rtoInprocess = rtoInprocess;
	}

	public Long getRtoOutForDelivery() {
		return rtoOutForDelivery;
	}

	public void setRtoOutForDelivery(Long rtoOutForDelivery) {
		this.rtoOutForDelivery = rtoOutForDelivery;
	}

	public Long getRtoDeliveryAttempted() {
		return rtoDeliveryAttempted;
	}

	public void setRtoDeliveryAttempted(Long rtoDeliveryAttempted) {
		this.rtoDeliveryAttempted = rtoDeliveryAttempted;
	}

	public Long getRtoDelivered() {
		return rtoDelivered;
	}

	public void setRtoDelivered(Long rtoDelivered) {
		this.rtoDelivered = rtoDelivered;
	}

	public Long getExtra1() {
		return extra1;
	}

	public void setExtra1(Long extra1) {
		this.extra1 = extra1;
	}

	public Long getExtra2() {
		return extra2;
	}

	public void setExtra2(Long extra2) {
		this.extra2 = extra2;
	}

	public Long getEast() {
		return east;
	}

	public void setEast(Long east) {
		this.east = east;
	}

	public Long getWest() {
		return west;
	}

	public void setWest(Long west) {
		this.west = west;
	}

	public Long getNorth() {
		return north;
	}

	public void setNorth(Long north) {
		this.north = north;
	}

	public Long getSouth() {
		return south;
	}

	public void setSouth(Long south) {
		this.south = south;
	}

	public Long getNorthEast() {
		return northEast;
	}

	public void setNorthEast(Long northEast) {
		this.northEast = northEast;
	}

	public Map<String, Object> getRtoResonMap() {
		return rtoResonMap;
	}

	public void setRtoResonMap(Map<String, Object> rtoResonMap) {
		this.rtoResonMap = rtoResonMap;
	}

	public Map<String, Object> getOpenAndCloseMap() {
		return openAndCloseMap;
	}

	public void setOpenAndCloseMap(Map<String, Object> openAndCloseMap) {
		this.openAndCloseMap = openAndCloseMap;
	}

	public Map<String, Object> getZonewiseMap() {
		return zonewiseMap;
	}

	public void setZonewiseMap(Map<String, Object> zonewiseMap) {
		this.zonewiseMap = zonewiseMap;
	}

	public Map<String, Object> getOpenRtoMap() {
		return openRtoMap;
	}

	public void setOpenRtoMap(Map<String, Object> openRtoMap) {
		this.openRtoMap = openRtoMap;
	}

	public Map<String, Object> getRtoReasonPcktsMap() {
		return rtoReasonPcktsMap;
	}

	public void setRtoReasonPcktsMap(Map<String, Object> rtoReasonPcktsMap) {
		this.rtoReasonPcktsMap = rtoReasonPcktsMap;
	}

	public Long getReadyForScan() {
		return readyForScan;
	}

	public void setReadyForScan(Long readyForScan) {
		this.readyForScan = readyForScan;
	}

	public Long getHandoverTo3PL() {
		return handoverTo3PL;
	}

	public void setHandoverTo3PL(Long handoverTo3PL) {
		this.handoverTo3PL = handoverTo3PL;
	}

	public Long getPartnerPendency() {
		return partnerPendency;
	}

	public void setPartnerPendency(Long partnerPendency) {
		this.partnerPendency = partnerPendency;
	}

	public Long getClosedRemittance() {
		return closedRemittance;
	}

	public void setClosedRemittance(Long closedRemittance) {
		this.closedRemittance = closedRemittance;
	}

	public Long getManifestGenerated3PL() {
		return manifestGenerated3PL;
	}

	public void setManifestGenerated3PL(Long manifestGenerated3PL) {
		this.manifestGenerated3PL = manifestGenerated3PL;
	}

	public Long getGeneratedRemittance() {
		return generatedRemittance;
	}

	public void setGeneratedRemittance(Long generatedRemittance) {
		this.generatedRemittance = generatedRemittance;
	}

	public Long getTotalPkt() {
		return totalPkt;
	}

	public void setTotalPkt(Long totalPkt) {
		this.totalPkt = totalPkt;
	}

	public Long getNdrPkt() {
		return ndrPkt;
	}

	public void setNdrPkt(Long ndrPkt) {
		this.ndrPkt = ndrPkt;
	}

	public Long getManifestShipped3PL() {
		return manifestShipped3PL;
	}

	public void setManifestShipped3PL(Long manifestShipped3PL) {
		this.manifestShipped3PL = manifestShipped3PL;
	}
	
	
}
