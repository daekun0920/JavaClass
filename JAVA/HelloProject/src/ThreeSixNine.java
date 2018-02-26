
public class ThreeSixNine {
	public static String hello = "";
	private static String bye = "";
	
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			String num = i + "";
			if (num.length() == 1) {
				int numInt = Integer.parseInt(num);
		
				if (numInt % 3 == 0) {
					System.out.print("짝 ");
				} else {
					System.out.print(numInt + " ");
				}
			} else if (num.length() == 2) {
			   int num1	= Integer.parseInt(num.charAt(0) + "");
			   int num2 = Integer.parseInt(num.charAt(1) + "");
			   
			   if ((num1 == 3 || num1 == 6 || num1 == 9) 
				&& (num2 == 3 || num2 == 6 || num2 == 9)) {
				  System.out.print("짝짝 ");
			   } else if ((num1 == 3 || num1 == 6 || num1 == 9)
					   || (num2 == 3 || num2 == 6 || num2 == 9)) {
				  System.out.print("짝 ");
			   } else {
				  System.out.print(num + " ");
			   }
			} else if (num.length() == 3) {
				int numInt = Integer.parseInt(num);
				System.out.print(numInt + " ");
			} // if 
		} // for
	} // main()
} // class
