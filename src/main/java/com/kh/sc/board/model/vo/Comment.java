package com.kh.sc.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable{
	
	private int cno;
	private int bno;
	private int uno;
	private int cRef;
	private String cContent;
	private int cLevel;
	private Date cDate;
	private String cStatus;
	private String writer;
	private String writer2;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Comment(int uno, int cRef, String cContent, int cLevel) {
		super();
		this.uno = uno;
		this.cRef = cRef;
		this.cContent = cContent;
		this.cLevel = cLevel;
	}



	



	public Comment(int cno, int bno, int uno, int cRef, String cContent, int cLevel, Date cDate, String cStatus,
			String writer, String writer2) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.uno = uno;
		this.cRef = cRef;
		this.cContent = cContent;
		this.cLevel = cLevel;
		this.cDate = cDate;
		this.cStatus = cStatus;
		this.writer = writer;
		this.writer2 = writer2;
	}



	public int getCno() {
		return cno;
	}



	public void setCno(int cno) {
		this.cno = cno;
	}



	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public int getUno() {
		return uno;
	}



	public void setUno(int uno) {
		this.uno = uno;
	}



	public int getcRef() {
		return cRef;
	}



	public void setcRef(int cRef) {
		this.cRef = cRef;
	}



	public String getcContent() {
		return cContent;
	}



	public void setcContent(String cContent) {
		this.cContent = cContent;
	}



	public int getcLevel() {
		return cLevel;
	}



	public void setcLevel(int cLevel) {
		this.cLevel = cLevel;
	}



	public Date getcDate() {
		return cDate;
	}



	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}



	public String getcStatus() {
		return cStatus;
	}



	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getWriter2() {
		return writer2;
	}



	public void setWriter2(String writer2) {
		this.writer2 = writer2;
	}



	@Override
	public String toString() {
		return "Comment [cno=" + cno + ", bno=" + bno + ", uno=" + uno + ", cRef=" + cRef + ", cContent=" + cContent
				+ ", cLevel=" + cLevel + ", cDate=" + cDate + ", cStatus=" + cStatus + ", writer=" + writer
				+ ", writer2=" + writer2 + "]";
	}



	



	
	
	
	
}
