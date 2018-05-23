package com.test.spring;

public class Ex05_Student {
	
	private String name;
	private int age;
	
	public Ex05_Student() {
		
		this("미정", 0);
	
	}
	
	public Ex05_Student(String name, int age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
