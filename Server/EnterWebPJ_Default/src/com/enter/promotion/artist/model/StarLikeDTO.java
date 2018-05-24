package com.enter.promotion.artist.model;

public class StarLikeDTO {
	private String star_like_seq;
	private String member_seq;
	private String star_profile_seq;
	private String star_like_state; //(1 : 좋아요(♥) , 0 : 싫어요(♡))
	
	public String getStar_like_seq() {
		return star_like_seq;
	}
	public void setStar_like_seq(String star_like_seq) {
		this.star_like_seq = star_like_seq;
	}
	public String getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}
	public String getStar_profile_seq() {
		return star_profile_seq;
	}
	public void setStar_profile_seq(String star_profile_seq) {
		this.star_profile_seq = star_profile_seq;
	}
	public String getStar_like_state() {
		return star_like_state;
	}
	public void setStar_like_state(String star_like_state) {
		this.star_like_state = star_like_state;
	}

	


}
