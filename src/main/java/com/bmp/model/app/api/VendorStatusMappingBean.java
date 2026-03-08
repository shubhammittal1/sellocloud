package com.bmp.model.app.api;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="vendorStatusMappingBean")
@AssignKey(assvalue=false)
public class VendorStatusMappingBean extends MongoBaseBean {

    private static final long serialVersionUID = -8366413967253810585L;

    private String vendorname;
    private Map<String, String> statusMap;

    public VendorStatusMappingBean() {
	super();
    }

    public String getVendorname() {
	return vendorname;
    }

    public void setVendorname(String vendorname) {
	this.vendorname = vendorname;
    }

    public Map<String, String> getStatusMap() {
	return statusMap;
    }

    public void setStatusMap(Map<String, String> statusMap) {
	this.statusMap = statusMap;
    }

}
