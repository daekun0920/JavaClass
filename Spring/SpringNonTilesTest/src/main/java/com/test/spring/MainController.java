package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mainController")
public class MainController {

	//회원 업무
	@RequestMapping(value="/member/info.action")	
	public String info() {
		
		return "info"; // jsp가 아닌 definition을 찾는다
	}
	
	@RequestMapping(value="/member/point.action")	
	public String point() {
		
		return "point";// jsp가 아닌 definition을 찾는다
	}
	
	//관리자 업무
	@RequestMapping(value="/admin/data.action")	
	public String data() {
		
		return "data";// jsp가 아닌 definition을 찾는다
	}
	
	@RequestMapping(value="/admin/chart.action")	
	public String chart() {
		
		return "chart";// jsp가 아닌 definition을 찾는다
	}
	
}















