package admingrade.model;

public class AdminCourseDTO { // 모든 개설 과정
	/*
	 AdminGradeClass
	 - if_grade_test()
	 
	 AdminGradeDAO
	 - course_list()
	 
	  
	 */
	private String course_seq;
	private String course_name;
	private String course_start_date;
	private String course_end_date;
	private String course_stu_num;
	
	public String getCourse_seq() {
		return course_seq;
	}
	public void setCourse_seq(String course_seq) {
		this.course_seq = course_seq;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_start_date() {
		return course_start_date;
	}
	public void setCourse_start_date(String course_start_date) {
		this.course_start_date = course_start_date;
	}
	public String getCourse_end_date() {
		return course_end_date;
	}
	public void setCourse_end_date(String course_end_date) {
		this.course_end_date = course_end_date;
	}
	public String getCourse_stu_num() {
		return course_stu_num;
	}
	public void setCourse_stu_num(String course_stu_num) {
		this.course_stu_num = course_stu_num;
	}

	
}
