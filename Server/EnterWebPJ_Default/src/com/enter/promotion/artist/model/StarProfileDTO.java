package com.enter.promotion.artist.model;

public class StarProfileDTO {
	
	private String star_profile_seq;
	private String artist_seq;
	private String profile_photo;
	private String star_profile_state; // 글이 등록(1)됬는지 삭제(0)됬는지
	
	//테이블엔 없지만 내가 추가한것
	private String subject; //제목(starname + 첨부파일을 넣을것이다!)
	private String starname; //이름 : 디비에서 받아올것!
	
	//좋아요 총 카운트!!!
	private String likeCount;
	
	private String mycount; //개인 카운트..
	
	
	
	public String getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStarname() {
		return starname;
	}
	public void setStarname(String starname) {
		this.starname = starname;
	}
	public String getStar_profile_seq() {
		return star_profile_seq;
	}
	public void setStar_profile_seq(String star_profile_seq) {
		this.star_profile_seq = star_profile_seq;
	}
	public String getArtist_seq() {
		return artist_seq;
	}
	public void setArtist_seq(String artist_seq) {
		this.artist_seq = artist_seq;
	}
	public String getProfile_photo() {
		return profile_photo;
	}
	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}
	public String getStar_profile_state() {
		return star_profile_state;
	}
	public void setStar_profile_state(String star_profile_state) {
		this.star_profile_state = star_profile_state;
	}
	public String getMycount() {
		return mycount;
	}
	public void setMycount(String mycount) {
		this.mycount = mycount;
	}
	
	

}
