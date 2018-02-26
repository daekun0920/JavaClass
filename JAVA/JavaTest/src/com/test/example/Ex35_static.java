package com.test.example;

public class Ex35_static {

	public static void main(String[] args) {
		// 정적(공용) <-> 객체(개인)
		// Ex35_static.java
		//m1();
		//m2();
		m3();
		
	}
	
	private static void m3() {
		
		// m1() vs m3()
		
		Mouse m1 = new Mouse();
		Mouse.setWholeCount(Mouse.getWholeCount() + 1); // 대표 변수(정적)로 카운트 
		
		Mouse m2 = new Mouse();
		Mouse.setWholeCount(Mouse.getWholeCount() + 1); // 대표 변수(정적)로 카운트 
		
		Mouse m3 = new Mouse();
		Mouse.setWholeCount(Mouse.getWholeCount() + 1); // 대표 변수(정적)로 카운트 
		
		System.out.println("생산된 마우스 갯수: " + Mouse.getWholeCount());
		
		
	
	
	
	}

/*
	private static void m2() {

		Mouse m1 = new Mouse();
		m1.setTotalCount(m1.getTotalCount() + 1);
		
		Mouse m2 = new Mouse();
		m2.setTotalCount(m2.getTotalCount() + 1);
		
		Mouse m3 = new Mouse();
		m3.setTotalCount(m3.getTotalCount() + 1);
		
		System.out.println("생산된 마우스 갯수 : " + m1.getTotalCount());
		
		
	}*/

	private static void m1() {
		
		int count = 0; // 마우스 갯수
		
		Mouse m1 = new Mouse();
		count++;
		
		Mouse m2 = new Mouse();
		count++;
		
		Mouse m3 = new Mouse();
		count++;
		
		// count가 정말로 마우스 갯수 맞는지?
		System.out.println("생산된 마우스 갯수 : " + count);
		
		
		
	}

}

class Mouse {
	
	// 객체 정보(제 각각 가져야 하는 개인 정보)
	private String model;
	private int price;
	private int buttons;
	
	private int totalCount; // x
	private static int wholeCount; // o // 대표 변수
	
	public static int getWholeCount() {
		return wholeCount;
	}
	public static void setWholeCount(int wholeCount) {
		Mouse.wholeCount = wholeCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getButtons() {
		return buttons;
	}
	public void setButtons(int buttons) {
		this.buttons = buttons;
	}
	
	// 요구사항) 마우스 객체 종류에 상관없이 Mouse라는 설계도로부터 생산된 모든 마우스의 총 갯수를 관리하시오.
	
	
}