package admincourse.model;

//4. 개설과정 등록 private void course_add()
public class AdminCourseAddDTO {

	private String basiccourse;
	private String coursestart;
	private String courseend;
	private String basicclassroom;

	public AdminCourseAddDTO() {
	}

	public AdminCourseAddDTO(String basiccourse, String coursestart, String courseend,
			String basicclassroom) {

		this.basiccourse = basiccourse;
		this.coursestart = coursestart;
		this.courseend = courseend;
		this.basicclassroom = basicclassroom;
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
