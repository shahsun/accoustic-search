package com.acoustic.assignment.search.response;

import java.util.List;

public class SearchResponse {

	List<String> name;
	long totalNoOfPages;
	long totalNoOfRecords;
	public List<String> getName() {
		return name;
	}
	public void setName(List<String> name) {
		this.name = name;
	}
	public long getTotalNoOfPages() {
		return totalNoOfPages;
	}
	public void setTotalNoOfPages(long totalNoOfPages) {
		this.totalNoOfPages = totalNoOfPages;
	}
	public long getTotalNoOfRecords() {
		return totalNoOfRecords;
	}
	public void setTotalNoOfRecords(long totalNoOfRecords) {
		this.totalNoOfRecords = totalNoOfRecords;
	}
	
	
	

}
