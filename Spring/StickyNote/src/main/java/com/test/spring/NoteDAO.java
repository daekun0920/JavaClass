package com.test.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDAO implements INote {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public int add(NoteDTO dto) {

		return template.insert("note.add", dto);
	}

	@Override
	public List<NoteDTO> list() {

		//DB 작업 -> 쿼리 확인 -> 출력 작업
		
		return template.selectList("note.list");
	}
	
	
	@Override
	public NoteDTO get() {
		
		return template.selectOne("note.get");
	}
	
	
	@Override
	public int del(String seq) {
		
		return template.delete("note.del", seq);
	}
	
}


















