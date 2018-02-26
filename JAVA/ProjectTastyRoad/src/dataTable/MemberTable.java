package dataTable;

public class MemberTable {
	private String userId;
	private String userPw;
	private String memberType;
	private String userName;
	private String userBirth;
	private String userTel;
	private String userEmail;
	
	public MemberTable(String userId
					 , String userPw
					 , String memberType
					 , String userName
					 , String userBirth
					 , String userTel
					 , String userEmail) {
		
		this.userId = userId;
		this.userPw = userPw;
		this.memberType = memberType;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userTel = userTel;
		this.userEmail = userEmail;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	/*
	 (String userId) 아이디
	 (String userPw)비밀번호
	 (String memberType) 회원종류
	 (String userName)이름
	 (String userBirth) 생년월일
	 (String userTel) 전화번호
	 (String userEmail) 이메일

	 */
	@Override
	public String toString() {
		return String.format("%s / %s / %s / %s / %s / %s / %s"
							 , userId
							 , userPw
							 , memberType
							 , userName
							 , userBirth
							 , userTel
							 , userEmail);
	}
}
