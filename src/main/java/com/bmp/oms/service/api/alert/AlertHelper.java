package com.bmp.oms.service.api.alert;

import java.util.concurrent.ExecutionException;

import com.bmp.bean.common.ResponseBean;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.app.utility.AlertBean;
import com.bmp.model.app.utility.AlertMaster;
import com.bmp.model.app.utility.SmsMailMaster;
import com.bmp.model.base.MongoBaseBean;

public interface AlertHelper {
	
	public void sendSMSAlert(AlertMaster alertMaster, MongoBaseBean baseBean) throws InterruptedException, Exception;
	public void sendEmailAlert(AlertMaster alertMaster, MongoBaseBean baseBean) throws InterruptedException, Exception;
	Boolean sendAlert(String statusFlowKey, StatusMaster fromStatus, StatusMaster toStatus, MongoBaseBean baseBean) throws InterruptedException, ExecutionException;
	public Boolean alertSender(String toStatusKey, MongoBaseBean baseBean);
	public ResponseBean sendManualAlert(AlertBean alertBean);
	public void sendSMSAlert(SmsMailMaster smsMailMaster) throws Exception;
	public void sendEmailAlert(SmsMailMaster smsMailMaster) throws Exception;
	public ResponseBean sendSMS(String smsTemplate, String to, String awb);
	public boolean sendClientSmsTemplate(SaleOrder saleOrder) throws Exception;
	public ResponseBean getProformaInvoice(String awbNumbers, String productSkus) throws Exception;
}
