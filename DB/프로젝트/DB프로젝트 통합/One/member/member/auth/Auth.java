package member.auth;

import java.util.Scanner;

import member.model.MemberDAO;
import member.model.MemberDTO;
import teacher.view.TeacherView;

public class Auth {

	private MemberDAO dao;
	private Scanner scan;
	private TeacherView view;
	
	public static boolean isAuth = false;
	public static String mseq;
	public static String type;
	
	public Auth() {
		dao = new MemberDAO();
		scan = new Scanner(System.in);
		view = new TeacherView();
	}
	
	public void logout() {
		
		Auth.isAuth = false;
		Auth.mseq = null;
		
		view.center("[로그아웃 성공]");
	}
	
	
	/*
	 * id/pw 입력받은 뒤 일치하는 레코드를 DB에서 찾는 경우
	 * 인증이 성공한 것이며 회원번호와 타입을 가져온다.
	 */
	public void login() {
		view.center("[회원 로그인]");
		
		view.inputcenter(">> 아이디 : ");
		String id = scan.nextLine();
		
		view.inputcenter(">> 비밀번호 : ");
		String pw = scan.nextLine();
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		if(dao.auth(dto) == 1) {
			//일치하는 회원 정보가 DB에 존재
			Auth.isAuth = true;
			Auth.type = dao.getType(dto);
			Auth.mseq = dao.getMseq(dto);
			
			view.inputcenter(">> 비밀번호 : ");
			System.out.printf("[%s] (으)로 로그인하셨습니다.\n", Auth.type);
		
		} else {
			//실패
			Auth.isAuth = false;
			view.center("[로그인 실패]");
		}
		
	}
	public static void main(String[] args) {
		Auth auth = new Auth();
		auth.login();
	}
}
