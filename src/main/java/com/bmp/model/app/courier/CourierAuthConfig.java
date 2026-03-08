package com.bmp.model.app.courier;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.bean.courier.FieldBean;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.masters.ServiceProvider;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="courierAuthConfig")
@AssignKey(assvalue=false)
public class CourierAuthConfig extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String courier;
	private String description;
	private List<FieldBean> fieldBean;
	
	public CourierAuthConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getter and Setter

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FieldBean> getFieldBean() {
		return fieldBean;
	}

	public void setFieldBean(List<FieldBean> fieldBean) {
		this.fieldBean = fieldBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
