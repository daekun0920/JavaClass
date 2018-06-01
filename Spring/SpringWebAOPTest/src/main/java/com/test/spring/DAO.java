package com.test.spring;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {

	@Autowired
	private SqlSessionTemplate template;

	public int getCount() {
		
		return template.selectOne("aop.getCount");
	}
	
}










