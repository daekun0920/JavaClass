package com.test.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoteController {

	@Autowired //의존 객체 주입(DI)
	private INote note; //dao
	
	
	//시작 페이지
	@RequestMapping(method={RequestMethod.GET}, value="/test.note")
	public String test(HttpServletRequest req) {
		
		//목록 가져오기
		List<NoteDTO> list = note.list();		
		
		req.setAttribute("list", list);
		
		return "note";
	}
	
	
	@RequestMapping(method={RequestMethod.POST}, value="/add.note")
	public @ResponseBody NoteDTO add(NoteDTO dto) {
		
		//ajax 요청 받아서 -> DB 처리 -> 결과 반환(웹페이지X, Ajax반환)
		//add.note?memo=aaa&color=2
		
		int result = note.add(dto);
		NoteDTO resultDTO = null;
	
		if (result == 1) {
			//select
			resultDTO = note.get();
		} else {
			//실패 
		}
		
		return resultDTO;
		
//		List<NoteDTO> list = new ArrayList<NoteDTO>();
//		NoteDTO dto1 = new NoteDTO();
//		NoteDTO dto2 = new NoteDTO();
//		NoteDTO dto3 = new NoteDTO();
//		dto1.setMemo("하나");
//		dto2.setMemo("둘");
//		dto3.setMemo("셋");
//		list.add(dto1);
//		list.add(dto2);
//		list.add(dto3);
//		
//		return list;
		
		
	}
	
	
	
	
	
	
	@RequestMapping(method={RequestMethod.GET}, value="/del.note")
	public @ResponseBody int del(HttpServletRequest req, String seq) {
		
		//Ajax 요청
		int result = note.del(seq);
		
		return result;
		
	}
	
	
}























