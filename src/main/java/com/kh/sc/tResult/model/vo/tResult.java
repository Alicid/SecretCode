package com.kh.sc.tResult.model.vo;

import java.io.Serializable;

public class tResult implements Serializable {

	private int tNo;
	private int tYear;
	private String tRound;
	private int tCandidate;
	private int tExaminee;
	public tResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tResult(int tNo, int tYear, String tRound, int tCandidate, int tExaminee) {
		super();
		this.tNo = tNo;
		this.tYear = tYear;
		this.tRound = tRound;
		this.tCandidate = tCandidate;
		this.tExaminee = tExaminee;
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
	public String gettRound() {
		return tRound;
	}
	public void settRound(String tRound) {
		this.tRound = tRound;
	}
	public int gettCandidate() {
		return tCandidate;
	}
	public void settCandidate(int tCandidate) {
		this.tCandidate = tCandidate;
	}
	public int gettExaminee() {
		return tExaminee;
	}
	public void settExaminee(int tExaminee) {
		this.tExaminee = tExaminee;
	}
	@Override
	public String toString() {
		return "tResult [tNo=" + tNo + ", tYear=" + tYear + ", tRound=" + tRound + ", tCandidate=" + tCandidate
				+ ", tExaminee=" + tExaminee + "]";
	}
	
	
}
