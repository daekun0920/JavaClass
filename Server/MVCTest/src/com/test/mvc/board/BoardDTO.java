package com.test.mvc.board;

public class BoardDTO {
	
	private String seq;
	private String subject;
	private String content;
	private String id;
	private String regdate;
	private String tag;
	private String name;
	private String filename;
	private String orgfilename;
	private String downloadcount;
	private String notice;
	private String secret;
	private String movie;
	private int ccount;
	private int thread;
	private int depth;
	private int readcount;
	
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getDownloadcount() {
		return downloadcount;
	}
	public void setDownloadcount(String downloadcount) {
		this.downloadcount = downloadcount;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOrgfilename() {
		return orgfilename;
	}
	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}
	public int getThread() {
		return thread;
	}
	public void setThread(int thread) {
		this.thread = thread;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getCcount() {
		return ccount;
	}
	public void setCcount(int ccount) {
		this.ccount = ccount;
	}
	private int gap;
	
	public int getGap() {
		return gap;
	}
	public void setGap(int gap) {
		this.gap = gap;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	
}
