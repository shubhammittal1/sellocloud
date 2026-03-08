package com.bmp.oms.service.api;

import javax.servlet.http.HttpServletResponse;

import com.bmp.bean.common.ResponseBean;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.saleorder.SaleOrder;

public interface VendorPrintLavelService {
	public ResponseBean VendorCreatePrintLabel(SaleOrder saleOrder,VendorApiBean vendorApiBean, HttpServletResponse response);

}
