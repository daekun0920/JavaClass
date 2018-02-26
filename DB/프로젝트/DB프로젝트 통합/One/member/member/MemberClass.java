package member;

import java.util.Scanner;

import member.auth.Auth;
import member.view.MemberView;

public class MemberClass {

	private MemberView view;
	private Scanner scan;
	
	public MemberClass() {
		
		view = new MemberView();
		scan = new Scanner(System.in);
	}

	public Auth start(Auth auth) {
		
		boolean loop = true;
		
		while(loop) {
			view.menu();
			switch(scan.nextInt()) {
				case 1:
					if(!Auth.isAuth) {
						auth.login();
						break;
					} else {
						view.center("이미 로그인한 상태입니다.");
						System.out.println();
						break;
					}
				case 2:
					if(Auth.isAuth) {
						auth.logout();
						break;
					} else {
						view.center("로그인하지 않은 상태입니다. 로그인하세요.");
						System.out.println();
					}
				default :
					loop = false;
					break;
			}
		view.close();
		}
		return auth;
		
	}
	
	
}
