package com.bmp.bean;

import java.util.List;

public class TwoTreadResponse {
	private String status;
	private List<List<TwoTreadOrder>> data;
	
	public TwoTreadResponse() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<List<TwoTreadOrder>> getData() {
		return data;
	}

	public void setData(List<List<TwoTreadOrder>> data) {
		this.data = data;
	}

}
