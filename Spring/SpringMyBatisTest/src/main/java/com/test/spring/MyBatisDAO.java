package com.test.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisDAO {

	//1. JDBC
	//2. Spring-JDBC
	//3. MyBatis
	
	
	//1.
	private Connection conn;
	
	//2.
	private DriverManagerDataSource dataSource;
	
	//3. MyBatis
	//root-context.xml 에서 설정
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public MyBatisDAO() {
		//1.
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr","java1234");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//2. Spring-JDBC
		this.dataSource = new DriverManagerDataSource();
		this.dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		this.dataSource.setUsername("hr");
		this.dataSource.setPassword("java1234");
	
	}//Constructor
	
	public void m1() {
		
		//1.JDBC
		
		try {
			
			Statement stat = conn.createStatement();
			
			String sql = "update tblMyBatis set num = num + 1";
			
			stat.executeQuery(sql);
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//2. Spring-JDBC
		JdbcTemplate template = new JdbcTemplate(this.dataSource);
		String sql = "update tblMyBatis set num = num + 1";
		
		template.update(sql);
		
		
		//3. MyBatis
		//session.Template.execute("xml 특정 쿼리 식별자")
		/*sessionTemplate.insert();
		sessionTemplate.update();
		sessionTemplate.delete();
		sessionTemplate.selectOne();
		sessionTemplate.selectList();*/
		
		sessionTemplate.update("test.m1");
	}

	public int m2(int seq) {
		
		
		return sessionTemplate.update("test.m2", seq);
	}

	public int m3(String txt) {
		
		return sessionTemplate.update("test.m3", txt);
	}

	public int m4(MyBatisDTO dto) {
		
		return sessionTemplate.insert("test.m4", dto); //DTO, hashmap 을 제일 많이 사용 그 중에서도 DTO 를 사용함.
	}

	public int m5(HashMap<String, String> map) {
		
		return sessionTemplate.insert("test.m5", map);
	}

	public void m6(MyBatisDTO dto) {
		
		sessionTemplate.insert("test.m4", dto); //DTO, hashmap 을 제일 많이 사용 그 중에서도 DTO 를 사용함.
		
	}
	
	public int m7() {
		// TODO Auto-generated method stub
		
		// sessionTemplate.selectOne()  - 단일 레코드
		// sessionTemplate.selectList() - 다중 레코드 
				
		return sessionTemplate.selectOne("test.m7");
	}

	public MyBatisDTO m8() {
		
		
		
		return sessionTemplate.selectOne("test.m8");
	}

	public List<String> m9() {
		// TODO Auto-generated method stub
		
		
		return sessionTemplate.selectList("test.m9");
	}

	public List<MyBatisDTO> m10() {
		// TODO Auto-generated method stub
		
		return sessionTemplate.selectList("test.m10");
	}

	public List<MyBatisDTO> m11(String order) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("text.m11", order);
		
	}	
	

}
