package actor;

public class Main_TastyRoad {
	
	public static void main(String[] args) {
		
		DataBase.memberListLoad();
		DataBase.storeListLoad();
		DataBase.boardListLoad();
		DataBase.reservationListLoad();
		DataBase.wishListLoad();
		
		//모든 데이터 로딩
		
		
		Owner o = new Owner("lrnxb699", "sdtbaq47", "점주");
		//점주 회원 로그인
		
		//o.storeAdd();

		//System.out.println(DataBase.storeLis곰t.get(DataBase.storeList.size()-1));
		
		//o.storeDel();
		
		//o.menuAdd();
		
		//o.menuDel();
		
		//o.tagAdd();
		//System.out.println(o.toString());
		
		o.tagDel();
		
		
	}
}
