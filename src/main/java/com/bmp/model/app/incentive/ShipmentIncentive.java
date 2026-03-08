package com.bmp.model.app.incentive;

import java.util.List;
import java.util.Map;

import com.bmp.constant.Status;

public class ShipmentIncentive {

	Map<String, List<String>> pickSheetMap;   //key=PickSheetKey, value = ListOfPickRequest
	Map<String, Integer> fwdPickIncMap;  // key=pickReqKey, value=totalShipmentCount
	Map<String, Status> rvpPickIncMap;        //key=pickReqKey, value=status=picked/not
	private Double fwdPickAmount;
	private Double rvpPickAmount;
	Map<String, List<String>> drsMap;         //key=DrsKey, val = ListOfShipment
	Map<String, Status> fwdDrsIncMap;         //key=shipKey, value=status=del/not
	Map<String, Integer> rtoDrsIncMap;        //key=shipKey, value=totalShipmentCount
	private Double fwdDrsAmount;
	private Double rtoDrsAmount;
	
	public ShipmentIncentive(){
		super();
	}
	
	public Map<String, List<String>> getPickSheetMap() {
		return pickSheetMap;
	}
	public Map<String, Status> getRvpPickIncMap() {
		return rvpPickIncMap;
	}
	public Double getFwdPickAmount() {
		return fwdPickAmount;
	}
	public Double getRvpPickAmount() {
		return rvpPickAmount;
	}
	public Map<String, List<String>> getDrsMap() {
		return drsMap;
	}
	public Map<String, Status> getFwdDrsIncMap() {
		return fwdDrsIncMap;
	}
	public Map<String, Integer> getRtoDrsIncMap() {
		return rtoDrsIncMap;
	}
	public Double getFwdDrsAmount() {
		return fwdDrsAmount;
	}
	public Double getRtoDrsAmount() {
		return rtoDrsAmount;
	}
	public void setPickSheetMap(Map<String, List<String>> pickSheetMap) {
		this.pickSheetMap = pickSheetMap;
	}
	public void setRvpPickIncMap(Map<String, Status> rvpPickIncMap) {
		this.rvpPickIncMap = rvpPickIncMap;
	}
	public void setFwdPickAmount(Double fwdPickAmount) {
		this.fwdPickAmount = fwdPickAmount;
	}
	public void setRvpPickAmount(Double rvpPickAmount) {
		this.rvpPickAmount = rvpPickAmount;
	}
	public void setDrsMap(Map<String, List<String>> drsMap) {
		this.drsMap = drsMap;
	}
	public void setFwdDrsIncMap(Map<String, Status> fwdDrsIncMap) {
		this.fwdDrsIncMap = fwdDrsIncMap;
	}
	public void setRtoDrsIncMap(Map<String, Integer> rtoDrsIncMap) {
		this.rtoDrsIncMap = rtoDrsIncMap;
	}
	public void setFwdDrsAmount(Double fwdDrsAmount) {
		this.fwdDrsAmount = fwdDrsAmount;
	}
	public void setRtoDrsAmount(Double rtoDrsAmount) {
		this.rtoDrsAmount = rtoDrsAmount;
	}

	public Map<String, Integer> getFwdPickIncMap() {
		return fwdPickIncMap;
	}

	public void setFwdPickIncMap(Map<String, Integer> fwdPickIncMap) {
		this.fwdPickIncMap = fwdPickIncMap;
	}
	
}
