package actor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import dataTable.Board;
import dataTable.MemberTable;
import dataTable.Reservation;
import dataTable.StoreTable;
import dataTable.Wish;

public class DataBase {

	//1. 회원리스트
	//2. 맛집리스트
	//3. 게시글리스트
	//4. 예약리스트
	//5. 위시리스트
	
	
	
	static final String memberPath;
	public static ArrayList<MemberTable> memberList;  // Business

	static final String storePath;
	public static ArrayList<StoreTable> storeList; 	  // Business

	static final String boardPath;
	public static ArrayList<Board> boardList;		  // BoardList 게시판 테이블을 저장할 변수

	static final String reservationPath;
	public static ArrayList<Reservation> reserveList; // Reservation eserveList

	static final String wishPath;
	public static ArrayList<Wish> wishList;           // wish wishList
	
	static {
		memberPath = "./src/회원리스트.txt";
		memberList = new ArrayList<MemberTable>();
		
		storePath = "./src/맛집리스트.txt";
		storeList = new ArrayList<StoreTable>();
		
		boardPath = "./src/게시글리스트.txt";
		boardList = new ArrayList<Board>();
		
		reservationPath = "./src/예약리스트.txt";
		reserveList = new ArrayList<Reservation>();
		
		wishPath = "./src/위시리스트.txt";
		wishList = new ArrayList<Wish>();
	}
	
	public static void memberListLoad() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(memberPath));
			String line = "";
			while ((line = reader.readLine()) != null) {
				//knbdq097	rzcjby31	[점주]	황민민	1971년1월23일	010-9818-2342	knbdq097@naver.com
				
				String[] memberArray = line.split("\t");
				//System.out.println(memberArray[0]);
				//System.out.println(memberArray[1]);

				MemberTable m = new MemberTable(memberArray[0].trim()
											  , memberArray[1].trim()
											  , memberArray[2].trim()
											  , memberArray[3].trim()
											  , memberArray[4].trim()
											  , memberArray[5].trim()
											  , memberArray[6].trim());
				memberList.add(m);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("dataLoad : " + e.toString());
		}
		
	} // dataLoad()
	
	public static void storeListLoad() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(storePath));
			String str = "";
			
			while((str = reader.readLine()) != null) {
			
				String[] tmp = str.split("\t");
				StoreTable s = new StoreTable(tmp[0]					//점주아이디
											, tmp[1]					//상호
											, tmp[2]					//주소
											, tmp[3]					//식당분류
											, tmp[4]					//식당전화번호
											, Integer.parseInt(tmp[5])	//favorite
											, tmp[6]					//식당을 나타내는 키워드
											, tmp[7]);					//메뉴1;메뉴2;메뉴
				
				storeList.add(s);
			}
			reader.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static void boardListLoad() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(boardPath));
			String str = "";
			
			
			while((str = reader.readLine()) != null) {
				//0. 게시글 인덱스 1. 회원 아이디 2. 회원 비밀번호 3. 회원 게시글 
				//4. 게시글 작성시간
				String[] temp = str.split("\t"); 
				
				
				Board b = new Board(temp[0], temp[1], temp[2], temp[3], temp[4]);
				
				boardList.add(b);
			
				
			}
			reader.close();
			
		} catch (IOException e) {
			System.out.println("게시글 파일이 존재하지 않습니다.");
		}
	}
	
	public static void reservationListLoad() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(reservationPath));
			String str = "";
			
			while((str = reader.readLine()) != null) {
				//0. 아이디
				//1. 상호
				//2. 주소
				//3. 전화번호
				
				String[] t = str.split("\t");
				Reservation r = new Reservation(t[0], t[1], t[2], t[3]);
				
				reserveList.add(r);
			}
			reader.close();
			
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void wishListLoad() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(wishPath));
			String str = "";
			
			while((str = reader.readLine()) != null) {
				
				String[] t = str.split("\t");
				Wish w = new Wish(t[0], t[1], t[2], t[3], t[4]);
				
				wishList.add(w);
				
			}
			reader.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public static void memberListSave() {
		try {
			
			Writer writer = new BufferedWriter(new FileWriter(memberPath));
			
			for(int i = 0; i < memberList.size(); i++) {
				String line = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\r\n", memberList.get(i).getUserId()
																		    , memberList.get(i).getUserPw()
																		    , memberList.get(i).getMemberType()
																		    , memberList.get(i).getUserName()
																		    , memberList.get(i).getUserBirth()
																		    , memberList.get(i).getUserTel()
																		    , memberList.get(i).getUserEmail());
				writer.write(line);
			}
			writer.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void storeListSave() {
		try {
			Writer writer = new BufferedWriter(new FileWriter(storePath));
			
			/*private String storeId;			//점주 아이디
			private String storeName;		//식당 상호
			private String storeAddress;	//식당 주소
			private String storeCategory;	//식당 분류 (Ex : 한식, 중식, 양식 ...)
			private String storeTel;		//식당 전화번호
			private Integer favorite; 		//회원이 특정 음식점을 위시리스트에 추가하는 경우 +1 되는 멤버변수.
			private String tag;				//식당을 나타내는 키워드
			private String menu;			//메뉴1;메뉴2;메뉴
*/			
			for(int i=0; i<Business.storeList.size(); i++) {
				String line = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\r\n", storeList.get(i).getStoreId()
																			    , storeList.get(i).getStoreName()
																			    , storeList.get(i).getStoreAddress()
																			    , storeList.get(i).getStoreCategory()
																			    , storeList.get(i).getStoreTel()
																			    , storeList.get(i).getFavorite()+""
																			    , storeList.get(i).getTag()
																			    , storeList.get(i).getMenu());
				writer.write(line);
			}
			writer.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		
			e.getMessage();
		}
		
	}
	
	public static void boardListSave() {
		try {
			
			Writer writer = new BufferedWriter(new FileWriter(boardPath));
			
			for(int i=0; i<BoardList.boardList.size(); i++) {
				String line = String.format("%s\t%s\t%s\t%s\t%s\r\n", boardList.get(i).getBoardIndex()
																    , boardList.get(i).getBoardId()
																    , boardList.get(i).getBoardPw()
																    , boardList.get(i).getBoardContent()
																    , boardList.get(i).getWritingTime());
				writer.write(line);
			}
			
			writer.close();
		} catch (Exception e) {
			e.getMessage();
			System.out.println("게시글 파일 저장에 실패하였습니다.");
		}
	}

	public static void reservationListSave() {
		try {
			Writer writer = new BufferedWriter(new FileWriter(reservationPath));
			
			/*private String reserveId; 			//아이디
			private String reserveStoreName; 	//상호
			private String reserveStoreAddr; 	//주소
			private String reserveStoreTel; 	//전화번호
*/			
			for(int i=0; i<Reservation.reserveList.size(); i++) {
				String line = String.format("%s\t%s\t%s\t%s\r\n", reserveList.get(i).getUserId()
															    , reserveList.get(i).getStoreName()
															    , reserveList.get(i).getStoreAddress()
															    , reserveList.get(i).getStoreTel());
				writer.write(line);
			}
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public static void wishListSave() {
		try {
			Writer writer = new BufferedWriter(new FileWriter(wishPath));
			
			/*private String myId; 				//아이디
			private String myStoreName;			//상호
			private String myStoreAddr;			//주소
			private String myStoreCategore;		//음식점 카테고리
			private String myStoreTel; 			//전화번호
			*/	
			
			for(int i=0; i<Wish.wishList.size(); i++) {
				String line = String.format("%s\t%s\t%s\t%s\t%s\r\n", wishList.get(i).getMyId()
																    , wishList.get(i).getMyStoreName()
																    , wishList.get(i).getMyStoreAddress()
																    , wishList.get(i).getMyStoreCategory()
																    , wishList.get(i).getMyStoreTel());
				writer.write(line);
			}
			writer.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
