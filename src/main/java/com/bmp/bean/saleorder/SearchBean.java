
package com.bmp.bean.saleorder;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String awbNumbers;
	public String getAwbNumbers() {
		return awbNumbers;
	}
	public void setAwbNumbers(String awbNumbers) {
		this.awbNumbers = awbNumbers;
	}
}
