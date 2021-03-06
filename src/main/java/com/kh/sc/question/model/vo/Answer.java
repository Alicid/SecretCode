package com.kh.sc.question.model.vo;

import java.io.Serializable;

public class Answer implements Serializable {

	private int cno;
	private int qno;
	private int uno;
	private String qancontent;
	private String qstatus;
	private String uName;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int cno, int qno, int uno, String qancontent, String qstatus) {
		super();
		this.cno = cno;
		this.qno = qno;
		this.uno = uno;
		this.qancontent = qancontent;
		this.qstatus = qstatus;
	}
	
	
	public Answer(int cno, int qno, int uno, String qancontent, String qstatus, String uName) {
		super();
		this.cno = cno;
		this.qno = qno;
		this.uno = uno;
		this.qancontent = qancontent;
		this.qstatus = qstatus;
		this.uName = uName;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getQancontent() {
		return qancontent;
	}
	public void setQancontent(String qancontent) {
		this.qancontent = qancontent;
	}
	public String getQstatus() {
		return qstatus;
	}
	public void setQstatus(String qstatus) {
		this.qstatus = qstatus;
	}
	
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	@Override
	public String toString() {
		return "Answer [cno=" + cno + ", qno=" + qno + ", uno=" + uno + ", qancontent=" + qancontent + ", qstatus="
				+ qstatus + ", uName=" + uName + "]";
	}
	
	
	
}
