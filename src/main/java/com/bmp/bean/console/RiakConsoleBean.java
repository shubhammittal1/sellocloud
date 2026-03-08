package com.bmp.bean.console;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiakConsoleBean implements Serializable {
	
	private static final long serialVersionUID = 800549608904459137L;
	
	private List<String> bucketTypes;
	private String selectedBucketType;
	private List<String> buckets;
	private String selectedBucket;
	private String Key;
	private String selectedKey;
	private Map<String, List<String>> bucketTypeBuckets;
	private String bucketTypeBucketsStr;
	private String jsonResponce;
	private JsonResponceType jsonResponceType;
	private List<String> allKeys;
	private Map<String, String> keyData;
	private Operation operation;
	private String operationStr;
	
	public static enum JsonResponceType {
		ALL_KEYS, KEY_DATA, ALL_BUCKETS
	}
	public static enum Operation{
		SEARCH,ADD,UPDATE,DELETE,REFRESHINDEX
	}
	
	public RiakConsoleBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String getOperationStr() {
		return operationStr;
	}
	public void setOperationStr(String operationStr) {
		this.operationStr = operationStr;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public String getBucketTypeBucketsStr() {
		return bucketTypeBucketsStr;
	}
	public void setBucketTypeBucketsStr(String bucketTypeBucketsStr) {
		this.bucketTypeBucketsStr = bucketTypeBucketsStr;
	}
	public Map<String, String> getKeyData() {
		return keyData;
	}
	public void setKeyData(Map<String, String> keyData) {
		this.keyData = keyData;
	}
	public List<String> getAllKeys() {
		return allKeys;
	}
	public void setAllKeys(List<String> allKeys) {
		this.allKeys = allKeys;
	}
	public JsonResponceType getJsonResponceType() {
		return jsonResponceType;
	}
	public void setJsonResponceType(JsonResponceType jsonResponceType) {
		this.jsonResponceType = jsonResponceType;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public String getSelectedBucketType() {
		return selectedBucketType;
	}
	public void setSelectedBucketType(String selectedBucketType) {
		this.selectedBucketType = selectedBucketType;
	}
	public String getSelectedBucket() {
		return selectedBucket;
	}
	public void setSelectedBucket(String selectedBucket) {
		this.selectedBucket = selectedBucket;
	}
	public String getSelectedKey() {
		return selectedKey;
	}
	public void setSelectedKey(String selectedKey) {
		this.selectedKey = selectedKey;
	}
	public List<String> getBucketTypes() {
		return bucketTypes;
	}
	public void setBucketTypes(List<String> bucketTypes) {
		this.bucketTypes = bucketTypes;
	}
	public List<String> getBuckets() {
		return buckets;
	}
	public void setBuckets(List<String> buckets) {
		this.buckets = buckets;
	}
	public Map<String, List<String>> getBucketTypeBuckets() {
		return bucketTypeBuckets;
	}
	public void setBucketTypeBuckets(Map<String, List<String>> bucketTypeBuckets) {
		this.bucketTypeBuckets = bucketTypeBuckets;
	}
	public String getJsonResponce() {
		return jsonResponce;
	}
	public void setJsonResponce(String jsonResponce) {
		this.jsonResponce = jsonResponce;
	}
	
}
