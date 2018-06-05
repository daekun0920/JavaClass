package com.test.spring;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	
	@Autowired
	private SqlSessionTemplate template;

	public int delok() {
		

		
		// 글 삭제
		return template.delete("tran.delok");
	}
	
	public int delcomment() {
		
		return template.delete("tran.delcomment");
	}
	
}
