package com.test.spring.board;

import java.util.List;

public interface IBoardDAO {
	
	
	// 목록 보기
	List<BoardDTO> list();
	
	// 글 쓰기
	int add(BoardDTO dto);
	
	// 글 보기
	BoardDTO view(String seq);
	
	// 로그 기록
	void log(LogDTO dto);
}
