package com.kh.sc.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	private int uNo;
	private String userId;
	private String userPwd;
	private String nickName;
	private String email;
	private Date enrollDate;
	private String userStatus;
	private int aNo;
	
	public Member() {
		super();
	}

	public Member(int uNo, String userId, String userPwd, String nickName, String email, Date enrollDate,
			String userStatus, int aNo) {
		super();
		this.uNo = uNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.nickName = nickName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.userStatus = userStatus;
		this.aNo = aNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	@Override
	public String toString() {
		return "Member [uNo=" + uNo + ", userId=" + userId + ", userPwd=" + userPwd + ", nickName=" + nickName
				+ ", email=" + email + ", enrollDate=" + enrollDate + ", userStatus=" + userStatus + ", aNo=" + aNo
				+ "]";
	}
	
	
	
	

}
