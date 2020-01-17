package com.kh.sc.Question.model.vo;

import java.io.Serializable;
import java.util.List;

public class Questions implements Serializable{
	
	private int qno;
	private int quPkno;
	private String qContent;
	private String qLevel;
	private int qScore;
	private int uno;
	private List<Answer> answer;
	
	
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Questions(int qno, int quPkno, String qContent, String qLevel, int qScore, int uno, List<Answer> answer) {
		super();
		this.qno = qno;
		this.quPkno = quPkno;
		this.qContent = qContent;
		this.qLevel = qLevel;
		this.qScore = qScore;
		this.uno = uno;
		this.answer = answer;
	}


	public int getQno() {
		return qno;
	}


	public void setQno(int qno) {
		this.qno = qno;
	}


	public int getQuPkno() {
		return quPkno;
	}


	public void setQuPkno(int quPkno) {
		this.quPkno = quPkno;
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


	public int getqScore() {
		return qScore;
	}


	public void setqScore(int qScore) {
		this.qScore = qScore;
	}


	public int getUno() {
		return uno;
	}


	public void setUno(int uno) {
		this.uno = uno;
	}


	public List<Answer> getAnswer() {
		return answer;
	}


	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "Questions [qno=" + qno + ", quPkno=" + quPkno + ", qContent=" + qContent + ", qLevel=" + qLevel
				+ ", qScore=" + qScore + ", uno=" + uno + ", answer=" + answer + "]";
	}


	
	
}
