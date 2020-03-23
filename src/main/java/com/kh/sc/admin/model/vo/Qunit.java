package com.kh.sc.admin.model.vo;

import java.io.Serializable;

public class Qunit implements Serializable {

	private int qu_pkno;
	private int qc_no;
	private String qu_name;
	public Qunit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qunit(int qu_pkno, int qc_no, String qu_name) {
		super();
		this.qu_pkno = qu_pkno;
		this.qc_no = qc_no;
		this.qu_name = qu_name;
	}
	public int getQu_pkno() {
		return qu_pkno;
	}
	public void setQu_pkno(int qu_pkno) {
		this.qu_pkno = qu_pkno;
	}
	public int getQc_no() {
		return qc_no;
	}
	public void setQc_no(int qc_no) {
		this.qc_no = qc_no;
	}
	public String getQu_name() {
		return qu_name;
	}
	public void setQu_name(String qu_name) {
		this.qu_name = qu_name;
	}
	@Override
	public String toString() {
		return "Qunit [qu_pkno=" + qu_pkno + ", qc_no=" + qc_no + ", qu_name=" + qu_name + "]";
	}
	
	
}
