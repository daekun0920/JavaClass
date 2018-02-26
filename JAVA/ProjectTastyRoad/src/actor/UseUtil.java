package actor;

public class UseUtil {
	/**
	 * 작성자 : 김동근
	 * @param input : 사용자가 입력한 값
	 * @return : 숫자면 true 문자면 false
	 */
	public static boolean isNum(String input) {
		if(input == null || input.equals("")) {
			//유효성 검사 : 입력값이 null 이거나 빈 문자열인 경우
			return false;
		}
		for(int i=0; i<input.length(); i++) {
			//문자열이 숫자가 맞으면 true 아니면 false
			char ch = input.charAt(i);
			
			if(ch<'0' || ch > '9') {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 작성자 : 김동근
	 * 입력값이 문자열로 이루어졌다면 true 숫자가 존재한다면 false
	 */
	public static boolean isString(String input) {
		if(input == null || input.equals("")) {
			//유효성 검사 : 입력값이 null 이거나 빈 문자열인 경우
			return true;
		}
		for(int i=0; i<input.length(); i++) {
			//문자열이 숫자가 맞으면 true 아니면 false
			char ch = input.charAt(i);
			
			if(ch<'0' || ch > '9') {
				return true;
			}
		}
		return false;
	}
}
