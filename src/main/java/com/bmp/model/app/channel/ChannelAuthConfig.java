package com.bmp.model.app.channel;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.bean.courier.FieldBean;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection = "channelAuthConfig")
@AssignKey(assvalue = false)
public class ChannelAuthConfig extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String channel;
	private String description;
	private List<FieldBean> fieldBean;

	// Constructor from super class
	public ChannelAuthConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getter and Setter
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
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
