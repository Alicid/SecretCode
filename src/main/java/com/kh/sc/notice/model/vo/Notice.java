package com.kh.sc.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable {

	private int nNo;
	private int uNo;
	private String nTitle;
	private String nContent;
	private Date nEnrolldate;
	private int nCount;
	private String nStatus;
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(int nNo, int uNo, String nTitle, String nContent, Date nEnrolldate, int nCount, String nStatus) {
		super();
		this.nNo = nNo;
		this.uNo = uNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nEnrolldate = nEnrolldate;
		this.nCount = nCount;
		this.nStatus = nStatus;
	}

	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public Date getnEnrolldate() {
		return nEnrolldate;
	}

	public void setnEnrolldate(Date nEnrolldate) {
		this.nEnrolldate = nEnrolldate;
	}

	public int getnCount() {
		return nCount;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	public String getnStatus() {
		return nStatus;
	}

	public void setnStatus(String nStatus) {
		this.nStatus = nStatus;
	}

	@Override
	public String toString() {
		return "Notice [nNo=" + nNo + ", uNo=" + uNo + ", nTitle=" + nTitle + ", nContent=" + nContent
				+ ", nEnrolldate=" + nEnrolldate + ", nCount=" + nCount + ", nStatus=" + nStatus + "]";
	}
	
	
}
