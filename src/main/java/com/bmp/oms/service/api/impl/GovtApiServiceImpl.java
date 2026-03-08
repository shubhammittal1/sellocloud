package com.bmp.oms.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.MessageConstant;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.VendorApiDao;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.oms.model.ewaybill.GetEwayBillRequest;
import com.bmp.oms.model.ewaybill.GetEwayBillResponse;
import com.bmp.oms.service.api.GovtApiService;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.logger.AsyncLogger;

@Service
@Qualifier("govtApiServiceImpl")
public class GovtApiServiceImpl implements GovtApiService {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;

	@Autowired
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;

	@Autowired
	@Qualifier("vendorApiDaoImpl")
	private VendorApiDao vendorApiDao;

	private static final String GOVT_EWAYBILL_CONFIG_KEY = "GOVT_EWAYBILL";
	private static final String EWAYBILL_API_PATH = "/ewayapi/GetEwayBill";

	@Override
	public ResponseBean getEwaybill(String awbNumber, String courierKey) throws Exception {
		ResponseBean responseBean = new ResponseBean();
		try {
			logger.info(this.getClass(), "Fetching eWaybill for AWB: " + awbNumber);

			SaleOrder saleOrder = saleOrderDao.getObjectById(awbNumber, SaleOrder.class);
			if (saleOrder == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage(messageSource.getMessage(MessageConstant.RECORD_NOT_FOUND, null, null));
				logger.error(this.getClass(), "SaleOrder not found for AWB: " + awbNumber);
				return responseBean;
			}

			VendorApiBean govtApiBean = vendorApiDao.getObjectById(GOVT_EWAYBILL_CONFIG_KEY, VendorApiBean.class);
			if (govtApiBean == null || govtApiBean.getIsactive_i() == 0) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Government eWaybill API configuration not found or inactive");
				logger.error(this.getClass(), "Govt API configuration not found or inactive");
				return responseBean;
			}

			logger.info(this.getClass(), "Making POST request to government eWaybill API using HttpUtilittyNew");

			HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
			httpRequestBeanNew.setRequestURL(govtApiBean.getUrl_s() + EWAYBILL_API_PATH);
			httpRequestBeanNew.setRequestMethod("POST");

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
			headers.add(HttpHeaders.ACCEPT, "application/json");

			if (govtApiBean.getHeader_param() != null && !"".equals(govtApiBean.getHeader_param().trim())) {
				String headerParams[] = govtApiBean.getHeader_param().split(",");
				for (int i = 0; i < headerParams.length; i++) {
					String[] parts = headerParams[i].split("=");
					if (parts.length == 2) {
						headers.add(parts[0].trim(), parts[1].trim());
					}
				}
			}

			GetEwayBillRequest ewayBillRequest = new GetEwayBillRequest();
			try {
				ewayBillRequest.setEwbNo(Long.parseLong(awbNumber));
			} catch (NumberFormatException e) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Invalid AWB Number format for ewbNo: " + awbNumber);
				logger.error(this.getClass(), "Invalid AWB Number format: " + awbNumber +" "+ e);
				return responseBean;
			}

			ObjectMapper objectMapper = new ObjectMapper();
			String requestBodyJson = objectMapper.writeValueAsString(ewayBillRequest);
			httpRequestBeanNew.setRequestBody(requestBodyJson);

			ResponseBean apiResponseBean = new HttpUtilittyNew().PostApiCall(httpRequestBeanNew, headers);

			if (ResponseStatus.FAIL.equals(apiResponseBean.getStatus())) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("API call failed: " + apiResponseBean.getMessage());
				logger.error(this.getClass(), "Govt API call failed for AWB: " + awbNumber + ", Error: " + apiResponseBean.getMessage());
				return responseBean;
			}

			String responseData = apiResponseBean.getResponse() != null ? apiResponseBean.getResponse().toString() : "";
			
			GetEwayBillResponse getEwayBillResponse = objectMapper.readValue(responseData, GetEwayBillResponse.class);

			if (getEwayBillResponse == null) { 
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error parsing government API response: Response was null");
				logger.error(this.getClass(), "Failed to parse govt API response for AWB: " + awbNumber + ", Raw Response: " + responseData);
				return responseBean;
			}

			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(getEwayBillResponse);
			responseBean.setMessage("eWaybill details fetched successfully");
			logger.info(this.getClass(), "Successfully fetched eWaybill for AWB: " + awbNumber);

		} catch (Exception e) {
			logger.error(this.getClass(), "Exception in getEwaybill for AWB: " + awbNumber + ", Error: " + e.getMessage());
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("Exception occurred: " + e.getMessage());
		}
		return responseBean;
	}
}