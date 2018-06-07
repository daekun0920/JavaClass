package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class Service implements IService {
	
	@Autowired
	private DAO dao;

	// 스프링 트랜잭션은 메소드 단위로 지원한다.
	@Override
	@Transactional
	public int delok() {
		
		// 댓글 삭제
		dao.delcomment();
		
		
		// 글삭제 
		int result = dao.delok();
		
		return result;
	}
	
	
	
}
