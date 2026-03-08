package com.bmp.oms.service.api;

import java.util.List;
import java.util.Map;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.LogTypes;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.jaxbean.FulfillRequestBean;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.model.app.saleorder.SaleOrderPickupRequest;

public interface VendorApiService {

	ResponseBean getVendorApiCall(String cycle, String logisticId, String courierAwb ) throws Exception;
	public Map<String, VendorApiBean> getVendorApiBean(LogTypes types) throws Exception;
	
	DatatableResponseBean getAllApiConfig(DatatableRequestBean datatableRequestBean);
	ResponseBean createApiConfig(VendorApiBean apiBean);
	ResponseBean updateApiConfig(VendorApiBean apiBean);
	ResponseBean deleteApiConfig(String key);
	ResponseBean checkApiConfigKeyAvailable(String key);
	DatatableResponseBean getAllApiStatusMapping(DatatableRequestBean datatableRequestBean);
	ResponseBean createApiStatusMapping(VendorStatusMappingBean vendorStatusMappingBean);
	ResponseBean checkApiStatusMappingKeyAvailable(String key);
	ResponseBean updateApiStatusMapping(VendorStatusMappingBean vendorStatusMappingBean);
	ResponseBean deleteApiStatusMapping(String key);
	ResponseBean autoPick3plPickupRequest();
	ResponseBean rtoDeclaredApiCall(String awbNumber,String cycle, String logisticId) throws Exception;
	ResponseBean vendorPickupLocationRequest(ClientWarehouse clientWarehouse,String logisticId,String apiCallType);
	ResponseBean vendorPickupRequest(SaleOrderPickupRequest saleOrderPickupRequest,String apiCallType);
	ResponseBean vendorPrintLabelRequest(String awbNumber,String logisticId);
	

	ResponseBean updateOrderAsFulfill(List<FulfillRequestBean> fulfillRequestBeans);
	ResponseBean updateOrderAsFulfillManual(List<String> list);

	ResponseBean vendorWayBillSeriesRequest(Integer count);

	ResponseBean vendorB2cNdrRequest(String awbNumber, String ndrReason) throws Exception;
}
