package com.bmp.model.c2c;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="c2cStandardParcel")
@AssignKey(assvalue=true)
public class StandardParcel extends MongoBaseBean implements Serializable,Comparable<StandardParcel>{
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String name_s;
	private BigDecimal length;
	private BigDecimal width;
	private BigDecimal height;
	private BigDecimal weight;
	
	@Indexed
	private Boolean isActive_b;
	
	private Long hitCount_i;
	private String parcelType;
	
	public StandardParcel() {
	}
	
	public String getName_s() {
		return name_s;
	}
	public void setName_s(String name_s) {
		this.name_s = name_s;
	}
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public Boolean getIsActive_b() {
		return isActive_b;
	}
	public void setIsActive_b(Boolean isActive_b) {
		this.isActive_b = isActive_b;
	}
	public String getParcelType() {
		return parcelType;
	}
	public void setParcelType(String parcelType) {
		this.parcelType = parcelType;
	}
	public Long getHitCount_i() {
		return hitCount_i;
	}

	public void setHitCount_i(Long hitCount_i) {
		this.hitCount_i = hitCount_i;
	}

	@Override
	public int compareTo(StandardParcel o) {
		return this.getName_s().compareTo(o.getName_s());
	}
	
}
