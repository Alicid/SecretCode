package com.kh.sc.tResult.model.vo;

import java.io.Serializable;

public class tResult implements Serializable {

	private int tNo;
	private int tYear;
	private int tWtReg;
	private int tWtGaz;
	private int tWtCan;
	private int tWtAvg;
	private int tPtReg;
	private int tPtGaz;
	private int tPtCan;
	private int tPtAvg;
	private int tFinCan;
	
	public tResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tResult(int tNo, int tYear, int tWtReg, int tWtGaz, int tWtCan, int tWtAvg, int tPtReg, int tPtGaz,
			int tPtCan, int tPtAvg, int tFinCan) {
		super();
		this.tNo = tNo;
		this.tYear = tYear;
		this.tWtReg = tWtReg;
		this.tWtGaz = tWtGaz;
		this.tWtCan = tWtCan;
		this.tWtAvg = tWtAvg;
		this.tPtReg = tPtReg;
		this.tPtGaz = tPtGaz;
		this.tPtCan = tPtCan;
		this.tPtAvg = tPtAvg;
		this.tFinCan = tFinCan;
	}
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	public int gettYear() {
		return tYear;
	}
	public void settYear(int tYear) {
		this.tYear = tYear;
	}
	public int gettWtReg() {
		return tWtReg;
	}
	public void settWtReg(int tWtReg) {
		this.tWtReg = tWtReg;
	}
	public int gettWtGaz() {
		return tWtGaz;
	}
	public void settWtGaz(int tWtGaz) {
		this.tWtGaz = tWtGaz;
	}
	public int gettWtCan() {
		return tWtCan;
	}
	public void settWtCan(int tWtCan) {
		this.tWtCan = tWtCan;
	}
	public int gettWtAvg() {
		return tWtAvg;
	}
	public void settWtAvg(int tWtAvg) {
		this.tWtAvg = tWtAvg;
	}
	public int gettPtReg() {
		return tPtReg;
	}
	public void settPtReg(int tPtReg) {
		this.tPtReg = tPtReg;
	}
	public int gettPtGaz() {
		return tPtGaz;
	}
	public void settPtGaz(int tPtGaz) {
		this.tPtGaz = tPtGaz;
	}
	public int gettPtCan() {
		return tPtCan;
	}
	public void settPtCan(int tPtCan) {
		this.tPtCan = tPtCan;
	}
	public int gettPtAvg() {
		return tPtAvg;
	}
	public void settPtAvg(int tPtAvg) {
		this.tPtAvg = tPtAvg;
	}
	public int gettFinCan() {
		return tFinCan;
	}
	public void settFinCan(int tFinCan) {
		this.tFinCan = tFinCan;
	}
	@Override
	public String toString() {
		return "tResult [tNo=" + tNo + ", tYear=" + tYear + ", tWtReg=" + tWtReg + ", tWtGaz=" + tWtGaz + ", tWtCan="
				+ tWtCan + ", tWtAvg=" + tWtAvg + ", tPtReg=" + tPtReg + ", tPtGaz=" + tPtGaz + ", tPtCan=" + tPtCan
				+ ", tPtAvg=" + tPtAvg + ", tFinCan=" + tFinCan + "]";
	}
	
	
}
