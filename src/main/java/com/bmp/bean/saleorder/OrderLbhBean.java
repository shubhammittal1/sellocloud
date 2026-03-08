package com.bmp.bean.saleorder;

import java.io.Serializable;

public class OrderLbhBean implements Serializable{
	private static final long serialVersionUID = -2266030021184600448L;
	
	private Integer quantity;
	private Double length;
	private Double width;
	private Double height;
	private Double weight;
	private String courierChildAwbNo;
	
	public OrderLbhBean () {
		super();
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getCourierChildAwbNo() {
		return courierChildAwbNo;
	}

	public void setCourierChildAwbNo(String courierChildAwbNo) {
		this.courierChildAwbNo = courierChildAwbNo;
	}
	

	
}
