package com.bmp.model.app.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="vendorApiBean")
@AssignKey(assvalue=false)
public class VendorApiBean extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = -4591801454453841614L;
	
	@Indexed
	private String vendorname_s;
	@Indexed
	private String action_s;
	@Indexed
	private String url_s;
	private String tokenUrl;
	private List<String> params; //docno=***##~~##orderno=***
	@Indexed
	private String method_s;
	@Indexed
	private int isactive_i;
	private String header_param;
	@Indexed
	private String implclass_s;
	private String jaxbean;
	@Indexed
	private String responseType_s;
	@Indexed
	private String requestType_s;
	@Indexed
	private String customerId_s;
	private Boolean responseArray;
	private String carrierId;
	private boolean tokenBased;
	private String generatedToken;
	private boolean tokenExpired;
	private String jsonString;
	private String apiCallServiceImpl;
	private Date tokenExpiredDate;
	private String extra1;
	private String extra2;
	
	public VendorApiBean(){
		super();
	}

	public String getVendorname_s() {
		return vendorname_s;
	}

	public String getAction_s() {
		return action_s;
	}

	public String getUrl_s() {
		return url_s;
	}

	public List<String> getParams() {
		return params;
	}

	public String getMethod_s() {
		return method_s;
	}

	public int getIsactive_i() {
		return isactive_i;
	}

	public String getHeader_param() {
		return header_param;
	}

	public String getImplclass_s() {
		return implclass_s;
	}

	public String getJaxbean() {
		return jaxbean;
	}

	public String getRequestType_s() {
		return requestType_s;
	}

	public void setRequestType_s(String requestType_s) {
		this.requestType_s = requestType_s;
	}

	public String getResponseType_s() {
		return responseType_s;
	}

	public String getCustomerId_s() {
		return customerId_s;
	}

	public void setVendorname_s(String vendorname_s) {
		this.vendorname_s = vendorname_s;
	}

	public void setAction_s(String action_s) {
		this.action_s = action_s;
	}

	public void setUrl_s(String url_s) {
		this.url_s = url_s;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public void setMethod_s(String method_s) {
		this.method_s = method_s;
	}

	public void setIsactive_i(int isactive_i) {
		this.isactive_i = isactive_i;
	}

	public void setHeader_param(String header_param) {
		this.header_param = header_param;
	}

	public void setImplclass_s(String implclass_s) {
		this.implclass_s = implclass_s;
	}

	public void setJaxbean(String jaxbean) {
		this.jaxbean = jaxbean;
	}

	public void setResponseType_s(String responseType_s) {
		this.responseType_s = responseType_s;
	}

	public void setCustomerId_s(String customerId_s) {
		this.customerId_s = customerId_s;
	}

	public Boolean getResponseArray() {
		return responseArray;
	}

	public void setResponseArray(Boolean responseArray) {
		this.responseArray = responseArray;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public boolean isTokenBased() {
		return tokenBased;
	}

	public void setTokenBased(boolean tokenBased) {
		this.tokenBased = tokenBased;
	}

	public String getGeneratedToken() {
		return generatedToken;
	}

	public void setGeneratedToken(String generatedToken) {
		this.generatedToken = generatedToken;
	}

	public boolean isTokenExpired() {
		return tokenExpired;
	}

	public void setTokenExpired(boolean tokenExpired) {
		this.tokenExpired = tokenExpired;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public String getApiCallServiceImpl() {
		return apiCallServiceImpl;
	}

	public void setApiCallServiceImpl(String apiCallServiceImpl) {
		this.apiCallServiceImpl = apiCallServiceImpl;
	}

	public Date getTokenExpiredDate() {
		return tokenExpiredDate;
	}

	public void setTokenExpiredDate(Date tokenExpiredDate) {
		this.tokenExpiredDate = tokenExpiredDate;
	}

	public String getExtra1() {
		return extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	public String getExtra2() {
		return extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}
	
}