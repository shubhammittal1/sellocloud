package com.bmp.oms.service.api.alert;

import java.util.Map;

import com.bmp.model.app.utility.AlertMaster;
import com.bmp.model.base.MongoBaseBean;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpResponseBean;

public interface AlertApiHelper {
	
	public HttpRequestBeanNew getAlertRequestBean(AlertMaster alertMaster, MongoBaseBean baseBean) throws Exception;
	
	public HttpResponseBean parseAlertResponseBean(Map<String, StringBuffer> requestResponse);
	
	public Boolean postResponseHandler(Map<String, StringBuffer> requestResponse, HttpResponseBean httpResponseBean,
			String key_s, AlertMaster alertMaster);
}
