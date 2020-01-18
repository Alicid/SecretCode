package com.kh.sc.admin.model.vo;

import java.io.Serializable;

public class Question implements Serializable{

	   private int qNo;
	   private int quPkNo;
	   private int uNo;
	   private String qContent;
	   private String qLevel;
	   private int qScore;
	   private int qnum;
	   private String qTitle;
	   private String qWriter;
	   
	   public Question() {
		super();
		
	}


	public Question(int qNo, int quPkNo, int uNo, String qContent, String qLevel, int qScore) {
		super();
		this.qNo = qNo;
		this.quPkNo = quPkNo;
		this.uNo = uNo;
		this.qContent = qContent;
		this.qLevel = qLevel;
		this.qScore = qScore;
	}


	public Question(int qNo, int quPkNo, int uNo, String qContent, String qLevel, int qScore, int qnum, String qTitle,
			String qWriter) {
		super();
		this.qNo = qNo;
		this.quPkNo = quPkNo;
		this.uNo = uNo;
		this.qContent = qContent;
		this.qLevel = qLevel;
		this.qScore = qScore;
		this.qnum = qnum;
		this.qTitle = qTitle;
		this.qWriter = qWriter;
	}


	public int getqNo() {
		return qNo;
	}


	public void setqNo(int qNo) {
		this.qNo = qNo;
	}


	public int getQuPkNo() {
		return quPkNo;
	}


	public void setQuPkNo(int quPkNo) {
		this.quPkNo = quPkNo;
	}


	public int getuNo() {
		return uNo;
	}


	public void setuNo(int uNo) {
		this.uNo = uNo;
	}


	public String getqContent() {
		return qContent;
	}


	public void setqContent(String qContent) {
		this.qContent = qContent;
	}


	public String getqLevel() {
		return qLevel;
	}


	public void setqLevel(String qLevel) {
		this.qLevel = qLevel;
	}


	public int getqScore() {
		return qScore;
	}


	public void setqScore(int qScore) {
		this.qScore = qScore;
	}


	public int getQnum() {
		return qnum;
	}


	public void setQnum(int qnum) {
		this.qnum = qnum;
	}


	public String getqTitle() {
		return qTitle;
	}


	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}


	public String getqWriter() {
		return qWriter;
	}


	public void setqWriter(String qWriter) {
		this.qWriter = qWriter;
	}


	@Override
	public String toString() {
		return "Question [qNo=" + qNo + ", quPkNo=" + quPkNo + ", uNo=" + uNo + ", qContent=" + qContent + ", qLevel="
				+ qLevel + ", qScore=" + qScore + ", qnum=" + qnum + ", qTitle=" + qTitle + ", qWriter=" + qWriter
				+ "]";
	}


	
	   
	   
	  
	   
}
