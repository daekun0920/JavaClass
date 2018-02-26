package dataTable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class test {

	
	public static void main(String[] args) {
		
		
		boolean a = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", "가지"); 

		System.out.println(a);
		
		ArrayList<String> t = new ArrayList<>();
		
		t.add("가");
		t.add("나");

		String s = "가;나;다";
		
		String[] tmp = s.split(";");
		
		System.out.println(tmp.length);
		
		boolean ck = "가나다".contains("나");
		boolean cc = "나".contains("가나다");
		
		System.out.println(ck);
		System.out.println(cc);
		
		String str = "가나다라마";
		
		String tt = str.substring(str.charAt(4));
		
	}
}
