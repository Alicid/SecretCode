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
		 
		 public qBuilder(int uNo,int cNo) {
			 this.uNo = uNo;
			 this.cNo = cNo;
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
		
		 public QuestionInsert qBuild() {
			 return new QuestionInsert(this);
		 }
		 
	 }  
	   
}
