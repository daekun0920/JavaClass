package com.test.model;

public class BoardDTO {
	private String regdate;
	private String subject;
	private String content;
	private String name;
	private String views;
	private String board_seq;
	private String naver_seq;
	
	
	public String getNaver_seq() {
		return naver_seq;
	}

	public void setNaver_seq(String naver_seq) {
		this.naver_seq = naver_seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public String getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
}
