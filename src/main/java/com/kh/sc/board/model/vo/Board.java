package com.kh.sc.board.model.vo;

import java.sql.Date;

public class Board {
	private int bno;
	private int btype;
	private int uno;
	private String bCategory;
	private String bTitle;
	private String bContent;
	private Date bDate;
	private int bCount;
	private String bStatus;
	private String writer;
	private int bnum;
	private int cCount;
	
	public Board() {
		super();
		
	}

	
	
	
	public Board(int btype, int uno, String bCategory, String bTitle, String bContent) {
		super();
		this.btype = btype;
		this.uno = uno;
		this.bCategory = bCategory;
		this.bTitle = bTitle;
		this.bContent = bContent;
	}




	public Board(int bno, int btype, int uno, String bCategory, String bTitle, String bContent, Date bDate, int bCount,
			String bStatus, String writer, int bnum, int cCount) {
		super();
		this.bno = bno;
		this.btype = btype;
		this.uno = uno;
		this.bCategory = bCategory;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bCount = bCount;
		this.bStatus = bStatus;
		this.writer = writer;
		this.bnum = bnum;
		this.cCount = cCount;
	}




	public int getBno() {
		return bno;
	}




	public void setBno(int bno) {
		this.bno = bno;
	}




	public int getBtype() {
		return btype;
	}




	public void setBtype(int btype) {
		this.btype = btype;
	}




	public int getUno() {
		return uno;
	}




	public void setUno(int uno) {
		this.uno = uno;
	}




	public String getbCategory() {
		return bCategory;
	}




	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}




	public String getbTitle() {
		return bTitle;
	}




	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}




	public String getbContent() {
		return bContent;
	}




	public void setbContent(String bContent) {
		this.bContent = bContent;
	}




	public Date getbDate() {
		return bDate;
	}




	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}




	public int getbCount() {
		return bCount;
	}




	public void setbCount(int bCount) {
		this.bCount = bCount;
	}




	public String getbStatus() {
		return bStatus;
	}




	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
	}




	public String getWriter() {
		return writer;
	}




	public void setWriter(String writer) {
		this.writer = writer;
	}




	public int getBnum() {
		return bnum;
	}




	public void setBnum(int bnum) {
		this.bnum = bnum;
	}




	public int getcCount() {
		return cCount;
	}




	public void setcCount(int cCount) {
		this.cCount = cCount;
	}




	@Override
	public String toString() {
		return "Board [bno=" + bno + ", btype=" + btype + ", uno=" + uno + ", bCategory=" + bCategory + ", bTitle="
				+ bTitle + ", bContent=" + bContent + ", bDate=" + bDate + ", bCount=" + bCount + ", bStatus=" + bStatus
				+ ", writer=" + writer + ", bnum=" + bnum + ", cCount=" + cCount + ", getBno()=" + getBno()
				+ ", getBtype()=" + getBtype() + ", getUno()=" + getUno() + ", getbCategory()=" + getbCategory()
				+ ", getbTitle()=" + getbTitle() + ", getbContent()=" + getbContent() + ", getbDate()=" + getbDate()
				+ ", getbCount()=" + getbCount() + ", getbStatus()=" + getbStatus() + ", getWriter()=" + getWriter()
				+ ", getBnum()=" + getBnum() + ", getcCount()=" + getcCount() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}








	
	
	

	
	
	
}
