package com.test.spring;

public class MyBatisDTO {

	private String seq;
	private String num;
	private String txt;
	
	public MyBatisDTO() {
		
	}
	
	public MyBatisDTO(String num, String txt) {
		this.num = num;
		this.txt = txt;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	@Override
	public String toString() {
		return "MyBatisDTO [seq=" + seq + ", num=" + num + ", txt=" + txt + "]";
	}
	
	
	
}
