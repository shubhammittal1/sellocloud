package com.bmp.oms.service.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;

public interface WebHookService {
	ResponseEntity saleOrderPushCallBack (HttpServletRequest request, Object payload);
    ResponseEntity getVendorOrderHistory(HttpServletRequest request, Object payload);
    DatatableResponseBean getAllTrackingWebhook(DatatableRequestBean datatableRequestBean);
    ResponseEntity updateDelhiveryLr ();
    ResponseEntity printlabelCallBack(HttpServletRequest request, Object payload);
    
    ResponseEntity shopifyOrderWebhook (HttpServletRequest request, Object payload);

}
