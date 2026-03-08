package com.bmp.bean.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatatableRequestBean implements Serializable {
	private int end;
	private int length;
	private int page;
	private int pages;
	private int recordsDisplay;
	private int recordsTotal;
	private int start;
	private int draw;
	private int recordsFiltered;
	private String search;
	private List<List<String>> order;
	private Map<String, String> data;
	
	public DatatableRequestBean () {
		// TODO Auto-generated constructor stub
	}
	
	public List<List<String>> getOrder() {
		return order;
	}

	public void setOrder(List<List<String>> order) {
		this.order = order;
	}


	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getRecordsDisplay() {
		return recordsDisplay;
	}

	public void setRecordsDisplay(int recordsDisplay) {
		this.recordsDisplay = recordsDisplay;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

}
