package com.kh.sc.common;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class PageInfo implements Serializable{
	 private int startPage;
	 private int endPage;
	 private int maxPage;
	 private int currentPage=1;
	 private int limit=10;
	 private int listCount;
	 private int startRow;
	 private int endRow;
	 
	 public PageInfo(){}
	 
	
	 
	 
	public PageInfo(int startPage, int endPage, int maxPage, int currentPage, int limit, int listCount) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
		this.currentPage = currentPage;
		this.limit = limit;
		this.listCount = listCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	
	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	public void calcPage(int listCount) {
		this.listCount = listCount;
		this.maxPage = (int)((double)listCount/this.limit+0.9);
		this.startPage = (int)((double)this.currentPage/this.limit+0.9)*limit-9;
		this.endPage=this.startPage + this.limit -1;
		if(this.maxPage < this.endPage) {
			this.endPage = this.maxPage;
		}
		this.startRow = (this.currentPage-1)*this.limit;
		this.endRow = this.startRow + 10;
		
	}




	@Override
	public String toString() {
		return "PageInfo [startPage=" + startPage + ", endPage=" + endPage + ", maxPage=" + maxPage + ", currentPage="
				+ currentPage + ", limit=" + limit + ", listCount=" + listCount + ", startRow=" + startRow + ", endRow="
				+ endRow + "]";
	}




	
	
	
	
	
}
