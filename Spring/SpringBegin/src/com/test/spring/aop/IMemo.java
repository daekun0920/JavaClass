package com.test.spring.aop;

public interface IMemo {

	//메모 쓰기
	void add(String memo);
	
	//메모 수정
	void edit(String memo);
	void edit(String memo, String name);
	void editName(String name);
	void checkName();
	
	//메모 읽기
	void read(int seq) throws Exception;
	
	//메모 검색
	int search(String word);
}
