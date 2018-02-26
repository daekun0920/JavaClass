package admincourse.model;
//4.개설과정 특정개설과정조회 course_selected_list()
public class AdminCourseSelectedListDTO {

	private String courseseq;
	private String subjectseq;
	private String subjectname;
	private String subjectstart;
	private String subjectend;
	private String basicbook;
	private String teaname;

	public String getCourseseq() {
		return courseseq;
	}

	public void setCourseseq(String courseseq) {
		this.courseseq = courseseq;
	}

	public String getSubjectseq() {
		return subjectseq;
	}

	public void setSubjectseq(String subjectseq) {
		this.subjectseq = subjectseq;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getSubjectstart() {
		return subjectstart;
	}

	public void setSubjectstart(String subjectstart) {
		this.subjectstart = subjectstart;
	}

	public String getSubjectend() {
		return subjectend;
	}

	public void setSubjectend(String subjectend) {
		this.subjectend = subjectend;
	}

	public String getBasicbook() {
		return basicbook;
	}

	public void setBasicbook(String basicbook) {
		this.basicbook = basicbook;
	}

	public String getTeaname() {
		return teaname;
	}

	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}

}
