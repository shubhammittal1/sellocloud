package com.bmp.oms.service.api;

import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.saleorder.SaleOrder;


public interface VendorService {

	public VendorStatusBean statusMapping(Object mappedVendorBean, SaleOrder saleOrder,VendorStatusMappingBean vendorStatusMappingBean);
}
