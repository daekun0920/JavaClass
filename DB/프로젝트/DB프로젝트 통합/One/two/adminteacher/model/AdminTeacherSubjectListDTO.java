package adminteacher.model;
/*
관리자 - 3. 교사계정관리
AdminTeacherClass
subject_list()에 쓰임

*/
public class AdminTeacherSubjectListDTO {

	private String seq;
	private String name;
	private String subjectName;
	
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
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
	
	
}
