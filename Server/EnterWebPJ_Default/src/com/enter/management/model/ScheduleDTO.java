package com.enter.management.model;

public class ScheduleDTO {
	private String schedule_seq;
	private String name;
	private String art_seq;
	private String member_name;
	private String star_name; // 섭외 관리용
	private String member_seq;
	private String schedule_place;
	private String schedule_start;
	private String schedule_end;
	private String schedule_pay;
	private String schedule_type_name;
	private String schedule_state;
	private String schedule_type;
	
	
	
	public String getSchedule_type() {
		return schedule_type;
	}
	public void setSchedule_type(String schedule_type) {
		this.schedule_type = schedule_type;
	}
	public String getStar_name() {
		return star_name;
	}
	public void setStar_name(String star_name) {
		this.star_name = star_name;
	}
	public String getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}
	public String getSchedule_seq() {
		return schedule_seq;
	}
	public void setSchedule_seq(String schedule_seq) {
		this.schedule_seq = schedule_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArt_seq() {
		return art_seq;
	}
	public void setArt_seq(String art_seq) {
		this.art_seq = art_seq;
	}
	
	
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getSchedule_place() {
		return schedule_place;
	}
	public void setSchedule_place(String schedule_place) {
		this.schedule_place = schedule_place;
	}
	public String getSchedule_start() {
		return schedule_start;
	}
	public void setSchedule_start(String schedule_start) {
		this.schedule_start = schedule_start;
	}
	public String getSchedule_end() {
		return schedule_end;
	}
	public void setSchedule_end(String schedule_end) {
		this.schedule_end = schedule_end;
	}
	public String getSchedule_pay() {
		return schedule_pay;
	}
	public void setSchedule_pay(String schedule_pay) {
		this.schedule_pay = schedule_pay;
	}
	public String getSchedule_type_name() {
		return schedule_type_name;
	}
	public void setSchedule_type_name(String schedule_type_name) {
		this.schedule_type_name = schedule_type_name;
	}
	public String getSchedule_state() {
		return schedule_state;
	}
	public void setSchedule_state(String schedule_state) {
		this.schedule_state = schedule_state;
	}
	
}
