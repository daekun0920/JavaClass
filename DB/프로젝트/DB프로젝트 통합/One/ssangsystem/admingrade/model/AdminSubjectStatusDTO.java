package admingrade.model;

public class AdminSubjectStatusDTO { // 성적 & 시험날짜 여부 
	/*
	 AdminGradeClass
	 - if_subject_list() 과목별 성적 & 시험날짜 등록 여부 
	 
	 AdminGradeDAO
	 - subject_list()
	  
	 */
	private String subject_name;
	private String subject_start_date;
	private String subject_end_date;
	private String subject_if_grade;
	private String subject_if_test;
	
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_start_date() {
		return subject_start_date;
	}
	public void setSubject_start_date(String subject_start_date) {
		this.subject_start_date = subject_start_date;
	}
	public String getSubject_end_date() {
		return subject_end_date;
	}
	public void setSubject_end_date(String subject_end_date) {
		this.subject_end_date = subject_end_date;
	}
	public String getSubject_if_grade() {
		return subject_if_grade;
	}
	public void setSubject_if_grade(String subject_if_grade) {
		this.subject_if_grade = subject_if_grade;
	}
	public String getSubject_if_test() {
		return subject_if_test;
	}
	public void setSubject_if_test(String subject_if_test) {
		this.subject_if_test = subject_if_test;
	}
	
	
}
