package com.kh.sc.tResult.model.vo;

import java.io.Serializable;

public class Qunit implements Serializable {

	private int unit1;
	private int unit2;
	private int unit3;
	private int unit4;
	private int unit5;
	private int unit6;
	private int unit7;
	
	public Qunit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Qunit(int unit1, int unit2, int unit3, int unit4, int unit5, int unit6, int unit7) {
		super();
		this.unit1 = unit1;
		this.unit2 = unit2;
		this.unit3 = unit3;
		this.unit4 = unit4;
		this.unit5 = unit5;
		this.unit6 = unit6;
		this.unit7 = unit7;
	}
	public int getUnit1() {
		return unit1;
	}
	public void setUnit1(int unit1) {
		this.unit1 = unit1;
	}
	public int getUnit2() {
		return unit2;
	}
	public void setUnit2(int unit2) {
		this.unit2 = unit2;
	}
	public int getUnit3() {
		return unit3;
	}
	public void setUnit3(int unit3) {
		this.unit3 = unit3;
	}
	public int getUnit4() {
		return unit4;
	}
	public void setUnit4(int unit4) {
		this.unit4 = unit4;
	}
	public int getUnit5() {
		return unit5;
	}
	public void setUnit5(int unit5) {
		this.unit5 = unit5;
	}
	public int getUnit6() {
		return unit6;
	}
	public void setUnit6(int unit6) {
		this.unit6 = unit6;
	}
	public int getUnit7() {
		return unit7;
	}
	public void setUnit7(int unit7) {
		this.unit7 = unit7;
	}
	@Override
	public String toString() {
		return "Qunit [unit1=" + unit1 + ", unit2=" + unit2 + ", unit3=" + unit3 + ", unit4=" + unit4 + ", unit5="
				+ unit5 + ", unit6=" + unit6 + ", unit7=" + unit7 + "]";
	}
	
	
}
