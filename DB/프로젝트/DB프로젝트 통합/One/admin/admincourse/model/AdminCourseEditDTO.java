package admincourse.model;
//4. 개설과정 수정 course_edit()

public class AdminCourseEditDTO {

	private String courseseq;
	private String basiccourse;
	private String coursestart;
	private String courseend;
	private String basicclassroom;

	public String getCourseseq() {
		return courseseq;
	}

	public void setCourseseq(String courseseq) {
		this.courseseq = courseseq;
	}

	public String getBasiccourse() {
		return basiccourse;
	}

	public void setBasiccourse(String basiccourse) {
		this.basiccourse = basiccourse;
	}

	public String getCoursestart() {
		return coursestart;
	}

	public void setCoursestart(String coursestart) {
		this.coursestart = coursestart;
	}

	public String getCourseend() {
		return courseend;
	}

	public void setCourseend(String courseend) {
		this.courseend = courseend;
	}

	public String getBasicclassroom() {
		return basicclassroom;
	}

	public void setBasicclassroom(String basicclassroom) {
		this.basicclassroom = basicclassroom;
	}

}
