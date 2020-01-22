package com.kh.sc.admin.model.vo;

import java.io.Serializable;

public class QuestionInsert implements Serializable{
	private int uNo; 
	private int cNo;
	
	
	 private int qNo;
	 private int quPkNo;   
	 private String qContent;
	 private String qLevel;
	 private int qScore;
	 private int qnum;
	 private String qTitle;
	 private String qWriter;
	 private int unitNum;
	 
	 
	 private QuestionInsert(qBuilder qBuilder) {
		 this.uNo = qBuilder.uNo;
	 }
	  
	   
	 // 정적 내부 클래스
	 public static class qBuilder{
		 
		 private int uNo;
		 
		 private int cNo;
		 private int qNo = 0;
		 private int quPkNo=0;   
		 private String qContent=null;
		 private String qLevel=null;
		 private int qScore=0;
		 private int qnum=0;
		 private String qTitle=null;
		 private String qWriter=null;
		 private int unitNum=0;
		 
		 public qBuilder(int uNo) {
			 this.uNo = uNo;
			 //this.cNo = cNo;
		 }
		 
		 public qBuilder qno(int value) {
			 this.qNo = value;
			return this;
		 }
		 public qBuilder quPkNo(int value) {
			 this.quPkNo = value;
			 return this;
		 }
		 public qBuilder qContent(String value) {
			 this.qContent = value;
			 return this;
		 }
		 public qBuilder qLevel(String value) {
			 this.qLevel = value;
			 return this;
		 }
		 public qBuilder qScore(int value) {
			 this.qScore = value;
			 return this;
		 }
		 public qBuilder qnum(int value) {
			 this.qnum = value;
			 return this;
		 }
		 public qBuilder qTitle(String value) {
			 this.qTitle = value;
			 return this;
		 }
		 public qBuilder qWriter(String value) {
			 this.qWriter = value;
			 return this;
		 }
		 public qBuilder unitNum(int value) {
			 this.unitNum = value;
			 return this;
		 }
		 public qBuilder cNo(int value) {
			 this.cNo = value;
			 return this;
		 }
		
		 public QuestionInsert qBuild() {
			 return new QuestionInsert(this);
		 }
		 
	 }


	public int getuNo() {
		return uNo;
	}


	public void setuNo(int uNo) {
		this.uNo = uNo;
	}


	public int getcNo() {
		return cNo;
	}


	public void setcNo(int cNo) {
		this.cNo = cNo;
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


	public int getUnitNum() {
		return unitNum;
	}


	public void setUnitNum(int unitNum) {
		this.unitNum = unitNum;
	}


	@Override
	public String toString() {
		return "QuestionInsert [uNo=" + uNo + ", cNo=" + cNo + ", qNo=" + qNo + ", quPkNo=" + quPkNo + ", qContent="
				+ qContent + ", qLevel=" + qLevel + ", qScore=" + qScore + ", qnum=" + qnum + ", qTitle=" + qTitle
				+ ", qWriter=" + qWriter + ", unitNum=" + unitNum + "]";
	}  
	 
	 
	   
}
