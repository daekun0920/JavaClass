package main.auth;

import java.util.Scanner;

import main.model.MainDAO;
import main.model.MainDTO;

public class Auth {
	private Scanner scan;
	private MainDAO dao;
	private MainDTO dto;
	private String id;
	private String pw;
	
	
	public Auth() {
		scan = new Scanner(System.in);
		dao = new MainDAO();
		
		
	}
	
	
	public void login() {
		
		
		while (true) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("     아이디를 입력해주세요.");
			id = scan.nextLine();
			
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("     암호를 입력해주세요.");
			pw = scan.nextLine();
			
			break;
		}
		
		
		
		
	}
}
