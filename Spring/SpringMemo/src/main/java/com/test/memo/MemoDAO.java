package com.test.memo;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MemoDAO implements IMemo {
	//JDBC -> Spring JDBC
	
	private DriverManagerDataSource dataSource; // Connection 역할
	private JdbcTemplate template; // Statement + ResultSet 역할
	
	public MemoDAO() {
		// DB연결 -> 나중에 XML 변환
		this.dataSource = new DriverManagerDataSource();
		this.dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		this.dataSource.setUsername("hr");
		this.dataSource.setPassword("java1234");
		
		// Template 객체
		this.template = new JdbcTemplate(this.dataSource);
		// 수정가능 -> this.template.setDataSource(this.dataSource);
	}
	
	@Override
	public int add(MemoDTO dto) {
		
		// Spring JDBC 방식 == PreparedStatement 방식 업그레이드
		String sql = "INSERT INTO tblSpringMemo VALUES(memo_seq.nextval, ?, ?, default, ?)";
		
		// SQL 실행(+ 매개변수 전달 포함)
		// template.update() == stat.executeUpdate()
		// template.query() == stat.executeQuery()
		
		return template.update(sql, new Object[] {dto.getId(), dto.getMemo(), dto.getCategory()});
	}

	@Override
	public List<MemoDTO> list() {
		
		String sql = "SELECT m.*, (SELECT name FROM tblSpringMember WHERE id = m.id) as name, (SELECT name FROM tblSpringCategory WHERE seq = m.category) as categoryName FROM tblSpringMemo m";
		
		return template.query(sql, new BeanPropertyRowMapper<MemoDTO>(MemoDTO.class));
		
	}

	@Override
	public MemoDTO get(String seq) {
		
		// Spring-JDBC
		// 1. 인자값 -> Object[] 전달
		// 2. 반환값 -> 단일 레코드 -> BeanPropertyRowMapper -> queryForObject()
		// 			 -> 다중 레코드 -> BeanPropertyRowMapper -> template.query()
		
		// seq -> DTO
		String sql = "SELECT * FROM tblSpringMemo WHERE seq = ?";
		
		
		
		return template.queryForObject(sql, new Object[] {seq}, new BeanPropertyRowMapper<MemoDTO>(MemoDTO.class));
		
	}

	@Override
	public int editmemo(MemoDTO dto) {
		
		String sql = "UPDATE tblSpringMemo SET memo = ?, category = ? WHERE seq = ?";
		
		
		
		return template.update(sql, new Object[] {dto.getMemo(), dto.getCategory(), dto.getSeq()});
	}

}
