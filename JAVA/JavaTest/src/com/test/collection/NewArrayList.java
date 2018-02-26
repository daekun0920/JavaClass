package com.test.collection;

public class NewArrayList {

	// 1. 멤버 변수
	private String[] list;  //
	private int index; 	//***
	private int capacity;  //
	
	// 2. 생성자
	public NewArrayList() {
		this(4);
	}
	
	public NewArrayList(int capacity) {
		this.capacity = capacity;
		this.index = 0;
	}

	// 3. add
	public void add(String s) {
		
		if (this.list == null) {
			this.list = new String[this.capacity];
		}
		doubleArray();
		this.list[this.index] = s;
		this.index++;
	}

	private void doubleArray() {
		// 배열의 크기(this.list.length) == 요소의 개수(this.index)
		if (this.list.length == this.index) {
			
			// 2배 크기 생성 + 깊은 복사
			String[] temp = new String[this.list.length * 2];
			
			for (int i = 0; i < this.list.length; i++) {
				temp[i] = this.list[i];
			}
			
			this.list = temp;
			
		}
	}
	
	public String get(int index) {
		
		// 요소가 존재하지 않는 방번호를 요청하면?
		if (this.index <= index || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		return this.list[index];
	
		
	} // get
	
	public int size() {
		
		return this.index;
	}
	
	public void set(int index, String s) {
		
		if (this.index <= index || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		this.list[index] = s;
	}
	
	public void remove(int index) {
		
		// [빨강] - [파랑] - [노랑] - [검정]
		// list.remove(1);
		// [빨강] - [노랑] - [노랑] - [검정]
		// [빨강] - [노랑] - [검정] - [검정]
		// [빨강] - [노랑] - [검정] - [null]
		
		for (int i = index; i < this.index - 1; i++) {
			this.list[i] = this.list[i + 1];
			
		}
		// this.list[this.index - 1] = null; // 예외처리라서 지울필요없음
		
		this.index--;
	}
	
	public void remove(String s) {
		
		// 검색 -> 지울 방 번호 알아내기 -> remove(index) 진행
		int index = -1;
		
		for (int i = 0; i < this.index; i++) {
			if (this.list[i].equals(s)) {
				index = i;
				break;
			}
		}
		
		// index <- 지울 방 번호
		if (index != -1) {
			remove(index);
		}
	}// remove
	
	public void add(int index, String s) {
		
		if (index >= this.index) {
			throw new IndexOutOfBoundsException();
		}
		
		
		
		
		for (int i = this.index; i > index; i--) {
			doubleArray();
			this.list[i] = this.list[i - 1];
		}
		
		this.list[index] = s;
		this.index++;
	}
	public int length() {
		return capacity;
		
		
	}
	
	public void trimToSize() {
		
		String[] temp = new String[this.index]; // ***
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}
}
