package com.bmp.oms.service.api;

import com.bmp.bean.common.ResponseBean;

public interface GovtApiService {

	ResponseBean getEwaybill(String awbNumber, String courierKey) throws Exception;
}

