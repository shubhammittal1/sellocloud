package com.bmp.model.app.threePL;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="threeplManifest")
@AssignKey(assvalue=false)
public class ThreePLDocketBean extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String threePlName_s;
	@Indexed
	private String threePlNameWithDateTime_s;
	private List<String> awbNumberList;
	@Indexed
	private int shipmentcount_i;
	@Indexed
	private String generatedByHubName_s;
	@Indexed
	private int active_i;
	@Indexed
	private String cd_s;
	@Indexed
	private String cb_s;
	private String md;
	private String mb;
	//private String awbNumberStr_s;
	private StatusMaster status;
	@Indexed
	private Boolean podUpload_b;
	
	public ThreePLDocketBean() {
		super();
	}

	public String getThreePlName_s() {
		return threePlName_s;
	}

	public void setThreePlName_s(String threePlName_s) {
		this.threePlName_s = threePlName_s;
	}

	public String getThreePlNameWithDateTime_s() {
		return threePlNameWithDateTime_s;
	}

	public void setThreePlNameWithDateTime_s(String threePlNameWithDateTime_s) {
		this.threePlNameWithDateTime_s = threePlNameWithDateTime_s;
	}

	public List<String> getAwbNumberList() {
		return awbNumberList;
	}

	public void setAwbNumberList(List<String> awbNumberList) {
		this.awbNumberList = awbNumberList;
	}

	public int getShipmentcount_i() {
		return shipmentcount_i;
	}

	public void setShipmentcount_i(int shipmentcount_i) {
		this.shipmentcount_i = shipmentcount_i;
	}

	public String getGeneratedByHubName_s() {
		return generatedByHubName_s;
	}

	public void setGeneratedByHubName_s(String generatedByHubName_s) {
		this.generatedByHubName_s = generatedByHubName_s;
	}

	public int getActive_i() {
		return active_i;
	}

	public void setActive_i(int active_i) {
		this.active_i = active_i;
	}

	public String getCd_s() {
		return cd_s;
	}

	public void setCd_s(String cd_s) {
		this.cd_s = cd_s;
	}

	public String getCb_s() {
		return cb_s;
	}

	public void setCb_s(String cb_s) {
		this.cb_s = cb_s;
	}

	public String getMd() {
		return md;
	}

	public void setMd(String md) {
		this.md = md;
	}

	public String getMb() {
		return mb;
	}

	public void setMb(String mb) {
		this.mb = mb;
	}

	/*public String getAwbNumberStr_s() {
		return awbNumberStr_s;
	}

	public void setAwbNumberStr_s(String awbNumberStr_s) {
		this.awbNumberStr_s = awbNumberStr_s;
	}*/

	public StatusMaster getStatus() {
		return status;
	}

	public void setStatus(StatusMaster status) {
		this.status = status;
	}

	public Boolean getPodUpload_b() {
		return podUpload_b;
	}

	public void setPodUpload_b(Boolean podUpload_b) {
		this.podUpload_b = podUpload_b;
	}

	
}
