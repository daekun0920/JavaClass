package adminattendance.model;

public class AdminAttendanceDTO {
	/*
	 관리자의 학생 출결 조회 
	 
	 AdminAttendanceClass
	 - course_attendance() 과정별 출결
	 - personal_attendance() 학생 개인 출결
	 
	 AdminAttendanceDAO
	 - course_attendance()
	 - personal_attendance
	 
	 
	 */
	private String seq;
	private String name;
	private String tel;
	private String course_name;
	private String inTime;
	private String outTime;
	private String status;
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return seq + "\t" + name + "\t" + tel + "\t" + inTime + "\t" + outTime + "\t" + status;
	}
	
	
}
