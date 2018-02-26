package com.test.example;




import java.util.HashSet;
import java.util.Random;

public class DummyData {


	
	public static void main(String[] args) {
		
		
		
		HashSet set = new HashSet<String>();
	
		
		Random rnd = new Random();
		
		int count = 6350;	
		
		
		
	String[] name1 = {"이","김","황","권","강","정","임","최","조"};
	String[] name2 = {"민","채","동","희","수","강","준","재","환","윤","지","정","화","연","현","주","엽","서","장","훈","형","돈","홍","준","표","진","철"};
	
	
	
	String[] id1 = { "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	String[] id2 = { "1","2","3","4","5","6","7","8","9","0"};
	// 8~15선
	String[] p1 = { "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	String[] p2 = { "1","2","3","4","5","6","7","8","9","0"};
	
	// 010 - **** - ****
	String[] t1 = { "1","2","3","4","5","6","7","8","9","0"};
	String[] t2 = { "1","2","3","4","5","6","7","8","9","0"};
	
	// 이메일 - 아이디@도메인
	
	String[] email1 = { "naver.com","naver.com","naver.com","gmail.com","hanmail.net"};
	
	String[] y1 = {"6","7","8",};
	String[] y2 = {"1","2","3","4","5","6","7","8","9","0"};
	
	String[] m1 = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	String[] d1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
	
	

	String[] name = new String[count];
	String[] id = new String[count];
	String[] password = new String[count];
	String[] tel1 = new  String[count];
	String[] tel2 = new  String[count];
	String[] email = new String[count];
	String[] year = new String[count];
	String[] month = new String[count];
	String[] day = new String[count];
	String[] user = new String[count];
	
	
	
	// Id pw <회원/점주> 이름 전화번호 이메일 생년월일 
	
	
	for (int i=0; i<count; i++) {
	
		//이름
		name[i] = name1[rnd.nextInt(name1.length)] + name2[rnd.nextInt(name2.length)] + name2[rnd.nextInt(name2.length)];
		//id 
		id[i] = id1[rnd.nextInt(id1.length)]+id1[rnd.nextInt(id1.length)]+id1[rnd.nextInt(id1.length)]+id1[rnd.nextInt(id1.length)]+id1[rnd.nextInt(id1.length)]+id2[rnd.nextInt(id2.length)]+id2[rnd.nextInt(id2.length)]+id2[rnd.nextInt(id2.length)];
		//password
		password[i] =  p1[rnd.nextInt(p1.length)]+p1[rnd.nextInt(p1.length)]+p1[rnd.nextInt(p1.length)]+p1[rnd.nextInt(p1.length)]+p1[rnd.nextInt(p1.length)]+p1[rnd.nextInt(p1.length)]+p2[rnd.nextInt(p2.length)]+p2[rnd.nextInt(p2.length)];
		
		email[i] = email1[rnd.nextInt(email1.length)];
		
		tel1[i] = t1[rnd.nextInt(t1.length)]+t1[rnd.nextInt(t1.length)]+t1[rnd.nextInt(t1.length)]+t1[rnd.nextInt(t1.length)];

		tel2[i] = t2[rnd.nextInt(t2.length)]+t2[rnd.nextInt(t2.length)]+t2[rnd.nextInt(t2.length)]+t2[rnd.nextInt(t2.length)];
		
		year[i] = y1[rnd.nextInt(y1.length)]+y2[rnd.nextInt(y2.length)];
		
		month[i] = m1[rnd.nextInt(m1.length)];
		
		day[i] = d1[rnd.nextInt(d1.length)];
		
		
			
	}
	
	

	String u = "[점주]";
	
	for (int i=0; i<count; i++) {
		
	System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n",id[i],password[i],u,name[i],"010-"+tel1[i]+"-"+tel2[i],id[i]+"@"+email[i],"19"+year[i]+"년"+month[i]+"월"+day[i]+"일");
	
	}
}
	
}