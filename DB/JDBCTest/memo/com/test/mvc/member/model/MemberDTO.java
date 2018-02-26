package com.test.mvc.member.model;

// DTO, Data Transfer Object or VO, Value Object
// 계층간에 회원 정보를 전달할 때 사용
public class MemberDTO {
	
	// DTO의 멤버변수명 = 테이블의 컬럼명
	private String seq;
	private String name;
	private String age;
	private String tel;
	private String email;
	private int point;
	private String pw;
	private String ing;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getIng() {
		return ing;
	}
	public void setIng(String ing) {
		this.ing = ing;
	}
	
	
	
}
