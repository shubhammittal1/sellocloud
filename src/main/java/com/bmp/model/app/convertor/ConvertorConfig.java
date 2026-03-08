package com.bmp.model.app.convertor;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bmp.bean.convertor.ConvertorHeader;
import com.bmp.constant.ConvertorType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="convertorConfig")
@AssignKey(assvalue=false)
@Component("com.bmp.model.app.convertor.Convertor")
public class ConvertorConfig extends MongoBaseBean {
	
	private static final long serialVersionUID = 1L;
	
	private MultipartFile files;
	private String convertorName;
	private ConvertorType convertorType;
	private String convertorImpl;
	private String clientKey;
	private String headerSequence;
	private List<ConvertorHeader> headers;
	
/*	private Map<String,String> clientBmpHeaderMap;
	private Map<String,String> headerConcatMap;
	private Map<String,String> headerStaticValueMap;*/
	
	public ConvertorConfig() {
		super();
	}

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}

	public String getHeaderSequence() {
		return headerSequence;
	}

	public void setHeaderSequence(String headerSequence) {
		this.headerSequence = headerSequence;
	}
	
	public String getConvertorName() {
		return convertorName;
	}
	public void setConvertorName(String convertorName) {
		this.convertorName = convertorName;
	}
	
	public ConvertorType getConvertorType() {
		return convertorType;
	}

	public void setConvertorType(ConvertorType convertorType) {
		this.convertorType = convertorType;
	}
	
	public String getConvertorImpl() {
		return convertorImpl;
	}

	public void setConvertorImpl(String convertorImpl) {
		this.convertorImpl = convertorImpl;
	}

	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	/*public Map<String, String> getClientBmpHeaderMap() {
		return clientBmpHeaderMap;
	}
	public void setClientBmpHeaderMap(Map<String, String> clientBmpHeaderMap) {
		this.clientBmpHeaderMap = clientBmpHeaderMap;
	}

	public Map<String, String> getHeaderConcatMap() {
		return headerConcatMap;
	}

	public void setHeaderConcatMap(Map<String, String> headerConcatMap) {
		this.headerConcatMap = headerConcatMap;
	}

	public Map<String, String> getHeaderStaticValueMap() {
		return headerStaticValueMap;
	}

	public void setHeaderStaticValueMap(Map<String, String> headerStaticValueMap) {
		this.headerStaticValueMap = headerStaticValueMap;
	}*/

	public List<ConvertorHeader> getHeaders() {
		return headers;
	}

	public void setHeaders(List<ConvertorHeader> headers) {
		this.headers = headers;
	}
	
	

}
