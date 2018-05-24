package com.test.spring.di;

public class Ex03_DAO {

	public int getCount() {

		// DAO 데이터 처리 중심 객체
		// -> 더 세부적인 데이터 처리는 다른 객체에게 위임
		// 1. Ex03_DB : 현장 담당.
		// 2. Ex03_File : 현장 담당.
		
		//Ex03_DB data = new Ex03_DB();
		
		Ex03_File data = new Ex03_File();
		
		return data.getCount();
		
	}

}
