package com.test.mvc.memo.model;

public class MemoDTO {
	
	private String seq;
	private String subject;
	private String content;
	private String mseq;
	private String regdate;
	private String mname;
	
	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMseq() {
		return mseq;
	}

	public void setMseq(String mseq) {
		this.mseq = mseq;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
