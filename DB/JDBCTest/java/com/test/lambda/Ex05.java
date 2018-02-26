package com.test.lambda;

import java.util.Arrays;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		
		// Ex05.java
		m1();
	}

	private static void m1() {
		
		List<KeyBoard> list = Arrays.asList(
				new KeyBoard("기계식 키보드", 80000, 108, KeyBoard.BLACK),
				new KeyBoard("휴대용 키보드", 50000, 116, KeyBoard.BLACK),
				new KeyBoard("코딩용 키보드", 110000, 128, KeyBoard.WHITE)
		);
	
		// 중간 메소드
		double price = list.stream().filter(k -> k.getColor() == KeyBoard.BLACK).mapToInt(KeyBoard::getPrice).average().getAsDouble();
		System.out.println("블랙 키보드 평균 가격 : " + price);
		
		
	}
}

class KeyBoard {
	
	// 객체 상태를 관리하기 위한 멤버 : enum으로 구현
	public final static int BLACK = 0;
	public final static int WHITE = 1;
	
	private String name;
	private int price;
	private int keys;
	private int color;
	
	
	public KeyBoard(String name, int price, int keys, int color) {
		this.name = name;
		this.price = price;
		this.keys = keys;
		this.color = color;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getKeys() {
		return keys;
	}
	
	public void setKeys(int keys) {
		this.keys = keys;
	}


	@Override
	public String toString() {
		return "KeyBoard [name=" + name + ", price=" + price + ", keys=" + keys + ", color=" + color + "]";
	}


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}

	

}