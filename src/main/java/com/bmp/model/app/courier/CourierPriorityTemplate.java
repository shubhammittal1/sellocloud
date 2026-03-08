package com.bmp.model.app.courier;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.bean.courier.PickupDropPeriorityTemplateMatrix;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.BaseBean;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="courierPriorityTemplate")
@AssignKey(assvalue=false)
public class CourierPriorityTemplate extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -4677577840752533287L;
	
	private String name;
	private String desc;
	private List<String> pickupGroup;
	private List<String> dropGroup;
	private Map<String, PickupDropPeriorityTemplateMatrix > pickupDropPeriorityTemplateMatrix;
	
	public CourierPriorityTemplate() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<String> getPickupGroup() {
		return pickupGroup;
	}
	public void setPickupGroup(List<String> pickupGroup) {
		this.pickupGroup = pickupGroup;
	}
	public List<String> getDropGroup() {
		return dropGroup;
	}
	public void setDropGroup(List<String> dropGroup) {
		this.dropGroup = dropGroup;
	}
	public Map<String, PickupDropPeriorityTemplateMatrix> getPickupDropPeriorityTemplateMatrix() {
		return pickupDropPeriorityTemplateMatrix;
	}
	public void setPickupDropPeriorityTemplateMatrix(
			Map<String, PickupDropPeriorityTemplateMatrix> pickupDropPeriorityTemplateMatrix) {
		this.pickupDropPeriorityTemplateMatrix = pickupDropPeriorityTemplateMatrix;
	}
	
	
}
