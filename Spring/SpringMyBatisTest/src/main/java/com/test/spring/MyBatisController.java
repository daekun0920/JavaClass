package com.test.spring;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.net.aso.a;


//Controller <-> DAO <-> JDBC <-> Oracle							: 이전 방식
//Controller <-> DAO <-> Spring-JDBC <-> Oracle 			: 어제 방식
//Controller <-> DAO <-> MyBatis <-> Oracle					: 오늘 방식
//Controller <-> Service <-> DAO <-> MyBatis <-> Oralce : 추천


@Controller
public class MyBatisController {

	//서비스 객체 참조 변수
	@Autowired
	private IMyBatisService service;
	
	//생성자를 통해 의존 객체를 직접 만들어서 사용
	/*public MyBatisController() {
		this.service = new MyBatisService();
	}*/
	
	//의존 주입으로 전환 xml 을 통해 의존주입을 하지 않기 위해 이렇게 하지 않는다.
	/*public MyBatisController(IMyBatisService service) {
		this.service = service;
	}*/
	
	//테스트용
	@RequestMapping(value="/test.action")
	public String test(HttpServletRequest req) {
		
		this.service.test();
		
		return "result";
	}
	
	
	//DB 입출력 정리
	@RequestMapping(value="/m1.action")
	public String m1(HttpServletRequest req) {
		
		//반환값X, 인자값X -> 정적 쿼리
		this.service.m1();
		
		return "result";
	}
	
	@RequestMapping(value="/m2.action")
	public String m2(HttpServletRequest req) {
		
		int seq = 1;	//인자값
		
		int result = service.m2(seq);
		
		req.setAttribute("result", result);
		
		return "result";
	}
	
	@RequestMapping(value="/m3.action")
	public String m3(HttpServletRequest req) {
		
		String txt = "아주 조금 있음";	//인자값
		
		int result = service.m3(txt);
		
		req.setAttribute("result", result);
		
		return "result";
	}
	
	@RequestMapping(value="/m4.action")
	public String m4(HttpServletRequest req) {
		
		//반환값X, 인자값O -> 다중값
		//1. 다중 컬럼값
		/*
		 a. DTO
		 b. HashMap
		 c. List(X)
		*/
		
		//2. 다중 레코드 = 단일레코드 X 루프
		// num(1000000), txt(아주 아주 아주 많음)
		
		String num  = "1000000";
		String txt = "아주아주아주 많음";
		
		MyBatisDTO dto = new MyBatisDTO();
		dto.setNum(num);
		dto.setTxt(txt);
		
		int result = service.m4(dto);
		
		req.setAttribute("result", result);
		
		return "result";
	}
	
	@RequestMapping(value="/m5.action")
	public String m5(HttpServletRequest req) {
		
		//반환값X, 인자값O -> 다중값
		//1. 다중 컬럼값
		/*
		 a. DTO
		 b. HashMap
		 c. List(X)
		*/
		
		//2. 다중 레코드 = 단일레코드 X 루프
		// num(1000000), txt(아주 아주 아주 많음)
		
		String num  = "123456789415";
		String txt = "엄청 많음";
		
		//DTO를 만들 상황이 아닌 경우를 위해서 Hashmap 으로 데이터를 가져오는 경우
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("num", num);
		map.put("txt", txt);
		
		int result = service.m5(map);
		
		req.setAttribute("result", result);
		
		return "result";
	}
	
	@RequestMapping(value="/m6.action")
	public String m6(HttpServletRequest req) {
		
		//클라이언트부터
		
		String num1 = "50";
		String txt1 = "조금";
		
		String num2 = "500";
		String txt2 = "조조금";
		
		String num3 = "5000";
		String txt3 = "조조조금";
		
		//Mybatis -> 한번에 하나의 insert만 실행
		//컨트롤러가 반복 수행해서 insert를 실행하지는 않고 주로 Service 에서 반복한다.
		ArrayList<MyBatisDTO> list = new ArrayList<MyBatisDTO>();
		MyBatisDTO dto1 = new MyBatisDTO(num1, txt1);
		MyBatisDTO dto2 = new MyBatisDTO(num2, txt2);
		MyBatisDTO dto3 = new MyBatisDTO(num3, txt3);
		
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		service.m6(list);
		
		return "result";
	}
	
	
}

















