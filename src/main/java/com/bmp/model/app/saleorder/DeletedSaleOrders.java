package com.bmp.model.app.saleorder;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="deletedSaleOrders")
@AssignKey(assvalue=false)
public class DeletedSaleOrders extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = -2266030021184600448L;
	
	private String deletedby;
	private String deletedatetime;
	private String remark;
	private String remoteAdd;
	private SaleOrder saleOrder;
	private SaleOrderExtra saleOrderExtra;
	
	public DeletedSaleOrders() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDeletedby() {
		return deletedby;
	}

	public String getDeletedatetime() {
		return deletedatetime;
	}

	public String getRemark() {
		return remark;
	}

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setDeletedby(String deletedby) {
		this.deletedby = deletedby;
	}

	public void setDeletedatetime(String deletedatetime) {
		this.deletedatetime = deletedatetime;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public String getRemoteAdd() {
		return remoteAdd;
	}

	public void setRemoteAdd(String remoteAdd) {
		this.remoteAdd = remoteAdd;
	}

	public SaleOrderExtra getSaleOrderExtra() {
		return saleOrderExtra;
	}

	public void setSaleOrderExtra(SaleOrderExtra saleOrderExtra) {
		this.saleOrderExtra = saleOrderExtra;
	}
	
	
	
}
