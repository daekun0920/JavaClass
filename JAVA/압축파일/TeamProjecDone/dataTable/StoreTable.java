package dataTable;

public class StoreTable {
	private String storeId;
	private String storeName;
	private String storeAddress;
	private String storeCategory;
	private String storeTel;
	private Integer favorite;
	private String tag;
	private String menu;
	
	
	public StoreTable(String storeId
				    , String storeName
				    , String storeAddress
				    , String storeCategory
				    , String storeTel
				    , Integer favorite
				    , String tag
				    , String menu) {

		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storeCategory = storeCategory;
		this.storeTel = storeTel;
		this.favorite = favorite;
		this.tag = tag;
		this.menu = menu;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}
	public String getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	public Integer getFavorite() {
		return favorite;
	}
	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	/*
	  (String storeId) 점주아이디
	  (String storePw) 점주 비밀번호 
	  (String storeName) 상호
	  (String storeAddress) 주소
	  (String storeCategory) 음식점 카테고리
	  (String storeTel) 전화번호
	  (Integer favorite) 회원이 위시리스트에 추가
	  (String tag) 맛집을 나타내는 키워드

	 */
	
	@Override
	public String toString() {

		return String.format("%s / %s / %s / %s / %d / %s / %s"
							, storeName
							, storeAddress
							, storeCategory
							, storeTel
							, favorite
							, tag
							, menu);
	}
}
