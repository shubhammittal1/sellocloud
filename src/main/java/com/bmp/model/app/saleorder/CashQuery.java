package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.CashQueryName;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="cashQuery")
@AssignKey(assvalue=false)
public class CashQuery extends MongoBaseBean implements Serializable{
	
	private Map<CashQueryName, Object> queryResult;

	
	public Map<CashQueryName, Object> getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(Map<CashQueryName, Object> queryResult) {
		this.queryResult = queryResult;
	}

}
