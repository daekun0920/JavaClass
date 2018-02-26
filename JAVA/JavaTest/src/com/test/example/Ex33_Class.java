package com.test.example;
import java.util.Calendar;

public class Ex33_Class {
	
	public static void main(String[] args) {
		//Ex33_Class.java
		
		
		
		Book b1 = new Book();
		b1.setPrice(30000);
		
		
		System.out.println(b1.getPrice());
		System.out.println(b1.getTitle());
		
		b1.setPubdate(2014);
		
		System.out.println(b1.getOld());
	}
	
	
}

class Note {
	
	private String title;   // 노트 제목
	private int pages;      // 페이지수
	private int price;		 // 가격
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPages() {
		return pages;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}








class Book {
	
	// 멤버의 읽기 / 쓰기 작업을 제어하는 메소드
	//   - getter / setter
	//   - 자바에서는 이들을 프로퍼티(Property)라고 부른다.
	
	private String title = "이것이 자바다."; 		// 제목
	private	 int price;			// 가격
	private String author;		// 작가
	private String publisher; 	// 출판사
	private int pubdate;		// 발간일(연도)
	
	// 읽기 / 쓰기 멤버
	public void setPrice(int price) {
		if (price > 0) {
			this.price = price;
		}
		
	}
	
	public int getPrice() {
		return this.price;
		
	}
	
	// 읽기 전용 멤버
	public String getTitle() {
		return this.title;
	}
	
	// 쓰기 전용 멤버
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPubdate(int pubdate) {
		this.pubdate = pubdate;
	}
	
	// 가상 멤버
	// 계산된 멤버 
	public int getOld() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR) - this.pubdate;
	}
}














