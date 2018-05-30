package com.test.spring;

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
	
}
















