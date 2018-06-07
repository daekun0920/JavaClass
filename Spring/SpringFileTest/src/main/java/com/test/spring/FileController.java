package com.test.spring;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	//단일 업로드 폼 페이지
	@RequestMapping(method={RequestMethod.GET}, value="/add.action")
	public String add(HttpServletRequest req) {		
				
		return "add";
	}
	
	//단일 업로드 처리 페이지
	@RequestMapping(method={RequestMethod.POST}, value="/addok.action")
	public String addok(HttpServletRequest req, String data) {		
		
		//cos.jar -> MultipartRequest 같은 역할
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		
		//req 사용 X -> multi 사용 O
		
		//첨부 파일 참조
		// - <input type="file" name="attach">
		MultipartFile attach = multi.getFile("attach"); //첨부 파일 참조 객체
		
		System.out.println(attach.getName()); //첨부 파일 컨트롤명(attach)
		System.out.println(attach.getOriginalFilename()); //첨부 파일명
		System.out.println(attach.getSize()); //첨부 파일 크기
		System.out.println(attach.getContentType()); //첨부 파일 형식(MIME)
		
		
		//실제 첨부 파일이 저장되는 폴더		
		// - F:\_NowClass\[2017.11.27-2018.06.25]\_Spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringFileTest\resources\files
		//System.out.println(req.getRealPath("resources/files"));
		
		//cos.jar -> MultiRequest 객체 생성 + 파일 업로드 완료
		//spring -> MultiRequest 객체 생성 + 파일 업로드 미완료 -> 수동으로 작업 완료(스프링이 클라이언트로부터 받아온 파일을 서버의 원하는 위치에 복사(이동))
		
		
		//첨부 파일명이 중복이 되면..
		//1. 아무것도 안하면..
		//		- 덮어쓰기 동작
		//		- 절대 비권장(XXXX)
		
		//2. 유일한 파일명을 생성
		//		- 날짜/시간 + 파일명
		//		- 년월일시분초 or 틱
		
		//3. 인덱싱 구현
		//		- 파일명 중복 -> 숫자 붙이기
		
		
		//1.
		//File file = new File(req.getRealPath("resources/files") + "\\" + attach.getOriginalFilename());
		
		//2.
		// a.zip -> 20180607101520001_a.zip
		//String filename = attach.getOriginalFilename(); //a.zip
		
		//Calendar c = Calendar.getInstance();
		
//		filename = String.format("%d%d%d%d%d%d%d"
//									, c.get(Calendar.YEAR)
//									, c.get(Calendar.MONTH)
//									, c.get(Calendar.DATE)
//									, c.get(Calendar.HOUR)
//									, c.get(Calendar.MINUTE)
//									, c.get(Calendar.SECOND)
//									, c.get(Calendar.MILLISECOND)) + "_" + filename;
		
		//filename = System.currentTimeMillis() + "_" + filename;
		
		//File file = new File(req.getRealPath("resources/files") + "\\" + filename);
		
		
		//3.
		String filename = getFileName(req.getRealPath("resources/files"), attach.getOriginalFilename());
		
		File file = new File(req.getRealPath("resources/files") + "\\" + filename);
		
		try {
			
			//업로드 완료
			attach.transferTo(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return "addok";
	}
	
	
	//중복되는 파일명 처리
	private String getFileName(String path, String filename) {
		
		int n = 1;
		
		//a.zip -> a_1.zip
		int index = filename.lastIndexOf(".");
		String tempName = filename.substring(0, index); // a
		String tempExt = filename.substring(index); // .zip
		
		//중복 검사
		while (true) {
			File file = new File(path + "\\" + filename); //D:\........\files\a.zip
			
			if (file.exists()) {
				//이름 고치기
				filename = tempName + "_" + n + tempExt; //a_1.zip
				n++;
			} else {
				return file.getName(); //중복되지 않다고 판단된 파일명ㄹ
			}
		}	
		
	}
	
	
	
	//다중 업로드 폼 페이지
	@RequestMapping(method={RequestMethod.GET}, value="/addmulti.action")
	public String addmulti(HttpServletRequest req) {		
		
		return "addmulti";
	}
	
	//다중 업로드 처리 페이지
	@RequestMapping(method={RequestMethod.GET}, value="/addmultiok.action")
	public String addmultiok(HttpServletRequest req) {		
		
		return "addmultiok";
	}
	
}











