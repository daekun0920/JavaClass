package com.test.question;

public class MyQueue {
	// 1. 멤버 변수
	private String[] list;
	private int index;
	private int capacity;
	
	// 2. 생성자
	public MyQueue() {
		this(4);
	}
	
	public MyQueue(int capacity) {
		index = 0;
		this.capacity = capacity;
	}
	
	// 3. toString
	@Override
	public String toString() {
		String dump = "[";
		for (int i = 0; i < index; i++) {
			dump = dump + list[i];
			if (i == index - 1) {
				break;
			}
			dump = dump + ", ";
		}
		dump = dump + "]";
		
		return dump;
	}
	
	// 4. 주업무
	
	// add
	public void add(String s) {
		if (list == null) {
			list = new String[capacity];
		}
		
		doubleArray();
		list[index] = s;
		index++;
		
		
		
	} // add

	private void doubleArray() {
		if (index == capacity) {
			capacity = capacity * 2;
			String[] temp = new String[capacity];
			for (int i = 0; i < index; i++) {
				temp[i] = list[i];
			}
			
			list = temp;
		}
	}
	
	// poll
	public String poll() {
		String poll = list[0];
		for (int i = 0; i < index - 1; i++) {
			list[i] = list[i + 1];
		}
		index--;
		
		return poll;
	}
	
	// size
	public int size() {
		
		
		
		return index;
	}
	
	// peek
	public String peek() {
		
		
		return list[0];
	}
	
	// trimToSize
	public void trimToSize() { // capacity 값도 수정 
		String[] temp = new String[index];
		for (int i = 0; i < index; i++) {
			temp[i] = list[i];
		}
		list = temp;
		capacity = index;
	}
	
}
