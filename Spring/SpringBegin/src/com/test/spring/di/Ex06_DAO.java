package com.test.spring.di;

public class Ex06_DAO {

	private IData data;
	public Ex06_DAO() {
		
		
	}
	
	// 생성자를 통한 객체 주입
	public Ex06_DAO(IData data) {
		
		this.data = data;
		
	}
	
	// setter를 통한 의족 객체 주입
	public void setData(IData data) {
		
		this.data = data;
		
	}
	
	public int getCount() {

		// DAO 데이터 처리 중심 객체
		// -> 더 세부적인 데이터 처리는 다른 객체에게 위임
		// 1. Ex04_DB : 현장 담당.
		// 2. Ex04_File : 현장 담당.
		
		// Ex04_DB data = new Ex04_DB();
		
		// Ex04_File data = new Ex04_File();
		
		// IData data = new Ex04_DB();
		
		
		return data.getCount();
		
	}

}
