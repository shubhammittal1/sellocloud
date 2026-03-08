package com.bmp.bean.client;

import java.io.Serializable;

public class ClientDashBoardBean implements Serializable {

	private static final long serialVersionUID = -128560521667229399L;

	private String rtoName;
	private Long count;
	
	public ClientDashBoardBean() {
		super();
	}

	public String getRtoName() {
		return rtoName;
	}

	public Long getCount() {
		return count;
	}

	public void setRtoName(String rtoName) {
		this.rtoName = rtoName;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
}
