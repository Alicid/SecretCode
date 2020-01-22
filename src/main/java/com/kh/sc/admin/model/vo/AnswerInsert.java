package com.kh.sc.admin.model.vo;

import java.io.Serializable;

public class AnswerInsert implements Serializable {

	private int qno;//문제번호
	private int uno;// 작성자
	
	
	private int cno;//문제 시퀀스번호
	private String qancontent;//문제 내용
	private String qstatus;// 정답여부
	
	
	private AnswerInsert(aBuilder aBuilder) {
		this.uno = aBuilder.uno;
	}
	
	public static class aBuilder{
		
		private int uno;// 작성자
		
		private int qno = 0;
		private int cno=0;//문제 시퀀스번호
		private String qancontent=null;//문제 내용
		private String qstatus=null;// 정답여부
		
		public aBuilder(int uno) {
			
			this.uno = uno;
		}
		
		public aBuilder cno(int value) {
			this.cno = value;
			return this;
		}
		public aBuilder qanCotent(String value) {
			this.qancontent = value;
			return this;
		}
		public aBuilder qstatus(String value) {
			this.qstatus = value;
			return this;
		}
		
		public AnswerInsert aBuild() {
			return new AnswerInsert(this);
		}
		
		
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

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
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

	@Override
	public String toString() {
		return "AnswerInsert [qno=" + qno + ", uno=" + uno + ", cno=" + cno + ", qancontent=" + qancontent
				+ ", qstatus=" + qstatus + "]";
	}
	
	
	
}
