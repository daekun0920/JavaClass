package main;

import java.util.Scanner;

import main.auth.Auth;
import main.view.MainView;

public class MainClass {
	
	public static void main(String[] args) {
		Auth auth = new Auth();
		MainView view = new MainView();
		Scanner scan = new Scanner(System.in);
		
		view.intro();
		String num = scan.nextLine();
		
		while (true) {
				
			if (num.equals("1")) {
				auth.login();
			} else if (num.equals("2")) {
				
			} else if (num.equals("0")) {
				break;
			} else {
				System.out.println("올바르지 않은 번호 입니다.");
				continue;
			}
			
		} // while
		
	}
	
}
