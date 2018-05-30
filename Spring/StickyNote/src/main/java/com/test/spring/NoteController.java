package com.test.spring;

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
	public String test() {
		
		return "note";
	}
	
	
	@RequestMapping(method={RequestMethod.POST}, value="/add.note")
	public @ResponseBody int add(NoteDTO dto) {
		
		//ajax 요청 받아서 -> DB 처리 -> 결과 반환(웹페이지X, Ajax반환)
		//add.note?memo=aaa&color=2
		
		int result = note.add(dto);
				
		return result;
		
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
	
}























