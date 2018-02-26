package adminteacher.model;

/*
관리자 - 3. 교사계정관리
AdminTeacherClass
basic_subject_list()에 쓰임

*/
public class AdminBasicSubjectListDTO {

	private String subjectNum;
	private String subjectName;
	
	public String getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(String subjectNum) {
		this.subjectNum = subjectNum;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
	
}
