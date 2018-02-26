package com.test.question;

public class MyArrayList {
	
	// 1. 멤버 변수
	private String[] list;  // 데이터 저장
	private int index;      // 입출력 요소의 위치
	private int capacity;	// 배열 초기 크기
	
	
	// 2. 생성자
	public MyArrayList() {
		this(4);
		
	}
	
	public MyArrayList(int capacity) {
		index = 0;
		this.capacity = capacity;
	}
	
	// 3. toString() 재정의 -> 배열 데이터 덤프 (홍길동, 하하하, 아무개)
	@Override
	public String toString() {
		String dump = "[";
		
		for (int i = 0; i < index; i++) {
			dump = dump + this.list[i]; 
			if (i == index - 1) {
				break;
			}
			dump = dump + ", ";
		}
		dump = dump + "]";
		return dump;
	}
	
	
	// 4. 주업무
	public void add(String s) {
		if (list == null) {
			list = new String[capacity];
		}
		
		if (index == this.list.length) {
			capacity = capacity * 2;
			String[] temp = new String[capacity];
			for (int i = 0; i < this.list.length; i++) {
				temp[i] = this.list[i];
			}
			temp[index] = s;
			index++;
			this.list = temp;
		} else {
			this.list[index] = s;
			index++;
			
		}
		
		
	} // add
	
	public String get(int index) {
	
		return this.list[index]; 
	}
	
	public void remove(int remove) {
		String[] temp = new String[capacity];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = this.list[i];
		}
		for (int i = remove; i < temp.length - 1; i++) {
			this.list[i] = temp[i + 1];
		}
		
		index--;
			
	}
	
	
	public void set(int index, String s) {
		this.list[index] = s;
	}
	
	public void add (int index1, String s) {
		String[] temp = new String[capacity];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = this.list[i];
		}
		for (int i = index1; i < list.length - 1; i++) {
			this.list[i + 1] = temp[i];
		}
		this.list[index1] = s;
		
		index++;
	}
	
	public int size() {
		return index;
	}
	
	public void trimToSize() {
		String[] temp = new String[index];
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = this.list[i];
		}
		this.list = temp;
		
	}
}













