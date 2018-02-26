package actor;

import java.util.ArrayList;

import dataTable.StoreTable;

public class Search {
	static final String strMember;
	
	static {
		strMember = "회원";
	}
	
	public static int localSearch(Member m) { // 지역 별 맛집 검색
		title("지역 별 맛집 검색");
		String dist = Title.localSearchPt();
		
		clearScreen();
		System.out.printf("   \"%s\" 검색 결과입니다.\n", dist);
		
		int i = 0; // 인덱스 붙혀주기 
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> listNames = new ArrayList<String>();
		for (StoreTable s : DataBase.storeList) {
			if (s.getStoreAddress().contains(dist)) { // 입력한 지역과 객체의 지역이 같다면 
				i = checkPush(i, list, listNames, s);
				
			}
		}
		
		if (m.getMemberType().equals(strMember)) { // 회원 
			BoardList.pageView(list, listNames, m);
			return 0;
		} 
		BoardList.pageView(list, listNames, m); // 비회원
		return 0;
	}
	public static void categorySearch(Member m) {
		while (true) {
			title("음식 종류별 검색");
			String category = Title.categorySearchPt();
			if (category.equals("1")) {
				category = "한식";
			} else if (category.equals("2")) {
				category = "일식";
			} else if (category.equals("3")) {
				category = "중식";
			} else if (category.equals("4")) {
				category = "양식";
			} else if (category.equals("5")) {
				category = "분식";
			} 
			System.out.printf("   \"%s\" 검색 결과입니다.\n", category);
			clearScreen();
			int i = 0; // 인덱스 붙혀주기 
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> listNames = new ArrayList<String>();
			for (StoreTable s : DataBase.storeList) {
				
				if (s.getStoreCategory().equals(category)) {
					i = checkPush(i, list, listNames, s);
				}
			}
			BoardList.pageView(list, listNames, m);	
			break;
		}
	}
	
	public static int checkPush(int i, ArrayList<String> list, ArrayList<String> listNames, StoreTable s) {
		i++; // 인덱스 증가
		String comp = i + ". " + s.toString(); // 1. [toString] 
		listNames.add(s.getStoreName()); // 나중에 찾기 위해 이름만 따로 저장 
		list.add(comp); // 존재 검사를 위한 리스트에 저장 
		return i;
	} // checkPush
	
	public static void title(String title) { // 텍스트 헤드 찍어주기 
		System.out.println("==============================");
		System.out.printf("\t%s\n", title);
		System.out.println("==============================");
		
		
	} // title


	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}


}
