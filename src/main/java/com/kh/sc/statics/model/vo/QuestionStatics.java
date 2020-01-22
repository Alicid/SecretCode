package com.kh.sc.statics.model.vo;

import java.sql.Date;

public class QuestionStatics {
	private int qano;// 시퀀스 번호
	private int uno; //회원번호
	private int cNum;//카테고리번호
	private int qno;//문제번호
	private String isCorrect;// 정답여부
	private Date isWhen;//날짜
	public QuestionStatics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionStatics(int qano, int uno, int cNum, int qno, String isCorrect, Date isWhen) {
		super();
		this.qano = qano;
		this.uno = uno;
		this.cNum = cNum;
		this.qno = qno;
		this.isCorrect = isCorrect;
		this.isWhen = isWhen;
	}
	public int getQano() {
		return qano;
	}
	public void setQano(int qano) {
		this.qano = qano;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(String isCorrect) {
		this.isCorrect = isCorrect;
	}
	public Date getIsWhen() {
		return isWhen;
	}
	public void setIsWhen(Date isWhen) {
		this.isWhen = isWhen;
	}
	@Override
	public String toString() {
		return "QuestionStatics [qano=" + qano + ", uno=" + uno + ", cNum=" + cNum + ", qno=" + qno + ", isCorrect="
				+ isCorrect + ", isWhen=" + isWhen + "]";
	}
	
	
}
