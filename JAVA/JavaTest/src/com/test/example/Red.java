package com.test.example;

public class Red {

	// 오로지 자기 자신만 접근이 가능한 보안 수준을 제공(상속 관계의 자식 클래스조차 접근 불가능)
	private String a = "private";
	
	// 생략하면 default 접근 지정자 
	String b = "default";
	
	protected String c = "protected";
	
	public String d = "public";
	
	// 접근
	public void check() {
		System.out.println(this.a);
		System.out.println(this.d);
		System.out.println(this.b);
	}
	
}
