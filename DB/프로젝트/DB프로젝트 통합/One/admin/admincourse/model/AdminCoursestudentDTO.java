package admincourse.model;
//4. 개설과정 학생정보조회 course_student_list();
public class AdminCoursestudentDTO {

	private String courseseq;
	private String stuname;
	private String stussn;
	private String stutel;
	private String sturegdate;
	private String stuing;

	public String getCourseseq() {
		return courseseq;
	}

	public void setCourseseq(String courseseq) {
		this.courseseq = courseseq;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStussn() {
		return stussn;
	}

	public void setStussn(String stussn) {
		this.stussn = stussn;
	}

	public String getStutel() {
		return stutel;
	}

	public void setStutel(String stutel) {
		this.stutel = stutel;
	}

	public String getSturegdate() {
		return sturegdate;
	}

	public void setSturegdate(String sturegdate) {
		this.sturegdate = sturegdate;
	}

	public String getStuing() {
		return stuing;
	}

	public void setStuing(String stuing) {
		this.stuing = stuing;
	}

}
