class Ex08_Casting {

	public static void main(String[] args) {
		
		// Ex08_Casting // ¼Õ ÄÚµù ¿¬½À

		// Çüº¯È¯
		// 1. ¾Ï½ÃÀûÀÎ Çüº¯È¯
		// 2. ¸í½ÃÀûÀÎ Çüº¯È¯

		// Á¤¼ö -> Á¤¼ö

		byte b1 = 10; // ¿øº»   1 byte
		long l1;	  // º¹»çº» 8 byte
		
		// ¾Ï½ÃÀûÀÎ Çüº¯È¯(¿øº» ¼Õ½Ç x)
		// l1 = b1;
		l1 = (long)b1; //ÄÄÆÄÀÏ·¯°¡ ÀÚµ¿ÀûÀ¸·Î ÇÏÁö¸¸ º¸ÆíÀûÀ¸·Î (long) ¾²´Â°ÍÀ» ±ÇÀå
		
		System.out.println(l1); // 10 // º¹»çº» È®ÀÎ 

		// ½Ç¼öÇü
		float f1 = 3.14F;  // ¿øº»
		double d1;		  // º¹»çº»
		
		// ¾Ï½ÃÀûÀÎ Çüº¯È¯
		d1 = f1;
		
		// Å° ¸ÅÅ©·Î alt + 1
		
		System.out.println(d1);

		double d2 = 1.23456789012345; // ¿øº»
		float f2;					  // º¹»çº»
		
		System.out.println(d2);      // 1.23456789012345

		f2 = (float)d2;

		System.out.println(f2);      // 1.2345679 (¹İ¿Ã¸² µÊ)

		// ½Ç¼ö <-> Á¤¼ö
		
		double d3 = 3.994;	// ¿øº»
 		int n3;				// º¹»çº»
		
		// ¸í½ÃÀûÀÎ Çüº¯È¯ (8 byte -> 4 byte)
		n3 = (int)d3;

		System.out.println(n3);   // 3  // ¼Ò¼ö°ª ¹«Á¶°Ç ¹ö¸²(floor, trunc)

		float f4 = 3.14F;
		long l4;
		
		// Å«Çü(8) = ÀÛÀºÇü(4) //f4°¡ ´õ Å«ÇüÀÓ ( Ç¥ÇöÀ» ÇÒ¼öÀÖ´Â ¼öÀÇ ¹üÀ§°¡ ÈÎ¾À ³ĞÀ½) // ¸í½ÃÀûÀÎ Çüº¯È¯
		// ¼öÀÇ ¹üÀ§(O), ¹ÙÀÌÆ® Å©±â ºñ±³(X)
		l4 = (long)f4;

		System.out.println(l4); // 3.140000104904175

		// ±âº»ÇüÀÇ ¹üÀ§ ºñ±³ 
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		//           char(2)
		// boolean(1)
		// ** ±âº»Çü°ú ÂüÁ¶Çü³¢¸®´Â º¯È¯ÀÌ ºÒ°¡´É(¸Ş¸ğ¸® ±¸Á¶ ¶§¹®¿¡)
		
		// booleanÀº Çüº¯È¯ÀÇ ´ë»óÀÌ µÉ ¼ö ¾ø´Ù.

		// ¹®ÀÚÇü Çüº¯È¯
		//  - 'A' -> 65(¹®ÀÚ ÄÚµå°ª)  // ¹®ÀÚÇüÀº Á¤¼öÇüÀ¸·Î¸¸ ¹Ù²Ü¼ö ÀÖ´Ù.
		
		char c5 = '°¡'; // 2 byte
		short s5;      // 2 byte
		// ¼ıÀÚ = ¹®ÀÚ
		s5 = (short)c5; // -21504  // ¸í½ÃÀû 
		// char´Â ºÎÈ£±âÈ£¸¦ »ç¿ëÇÏÁö ¾Ê¾Æ¼­ 2 byte ¸ğµÎ »ç¿ëÇÏ°Ô µÇ¼­ ÃÖ´ë ¼ö´Â 60000(¾ç¼ö) ÀÌÁö¸¸
		// short ´Â ºÎÈ£±âÈ£¸¦ »ç¿ëÇÏ¹Ç·Î ÃÖ´ë ¾ç¼ö°¡ ´ë·« 30000ÀÌ¶ó¼­ ¾²·¹±â°ªÀÌ ³ª¿Â´Ù.

		System.out.println(s5); // 65
		

		System.out.println((char)66); // B

		char c6 = '°¡'; // 2 byte
		int n6; // 4 byte
		
		n6 = c6;
		System.out.println(n6);  // 44032

		int n7 = 5;
		char c7 = '5';

		System.out.println(n7);
		System.out.println((int)c7);

		System.out.println((int)'A');   // 65
		System.out.println((int)'Z');	// 90	
		System.out.println((int)'a');	// 97
		System.out.println((int)'z');	// 122 
		System.out.println((int)'0');	// 48
		System.out.println((int)'9');	// 57
		
		System.out.println((int)'°¡');	// 44032
		System.out.println((int)'ÆR');	// 55203
		
		// 'A' 'a' '0'

		
















	}

}
