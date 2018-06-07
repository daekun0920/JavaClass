package com.test.spring.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements IBoardDAO {

	
	// 의존 객체 주입 > MyBatis
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO view(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

	// 귀찮아서 잠시 임시로 넣은 보조업무 객체의 메소드(나중에 정식으로 클래스 분리해서 구현할 것)
	@Override
	public void log(LogDTO dto) {
		
		
		
		template.insert("log.add", dto);
	}
	
	
}
