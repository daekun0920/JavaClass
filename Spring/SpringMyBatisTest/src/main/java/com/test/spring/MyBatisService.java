package com.test.spring;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisService implements IMyBatisService{

	@Autowired
	private MyBatisDAO dao;
	
	@Override
	public void test() {
		
		System.out.println("테스트");
	}
	
	@Override
	public void m1() {
		
		//DAO 고용
		dao.m1();
	}
	
	@Override
	public int m2(int seq) {
		
		return dao.m2(seq);
	}
	
	@Override
	public int m3(String txt) {

		return dao.m3(txt);
	}
	
	@Override
	public int m4(MyBatisDTO dto) {
		
		return dao.m4(dto);
	}
	
	@Override
	public int m5(HashMap<String, String> map) {
		
		return dao.m5(map);
	}
	
	@Override
	public void m6(ArrayList<MyBatisDTO> list) {
		
		//Controller -> (객체 3개) -> Service -> (객체 1개) -> DAO
		//DAO의 업무를 만들 때 규칙
		// - 메소드 1개당 단일 업무를 구현한다. -> 쿼리 1개만 실행시키는 업무
		
		for(MyBatisDTO dto : list) {
			dao.m6(dto);
		}
	}
}
