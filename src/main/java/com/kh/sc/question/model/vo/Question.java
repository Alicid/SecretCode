package com.kh.sc.question.model.vo;

public class Question {
	
	private int qno;
	private int qupkno;
	private String qContent; 
	private String qLevel; 
	private int score;
	private int uno;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int qno, int qupkno, String qContent, String qLevel, int score, int uno) {
		super();
		this.qno = qno;
		this.qupkno = qupkno;
		this.qContent = qContent;
		this.qLevel = qLevel;
		this.score = score;
		this.uno = uno;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public int getQupkno() {
		return qupkno;
	}

	public void setQupkno(int qupkno) {
		this.qupkno = qupkno;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	@Override
	public String toString() {
		return "Question [qno=" + qno + ", qupkno=" + qupkno + ", qContent=" + qContent + ", qLevel=" + qLevel
				+ ", score=" + score + ", uno=" + uno + "]";
	}
	
	
	
}
