package com.test.spring;

public class Ex07DAO {
	
	public void add(Ex07DTO dto) {
		
		System.out.println("INSERT 작업");
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		System.out.println(dto.getAddress());
		System.out.println(dto.getTel());
	}
	
}
