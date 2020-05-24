/*
 * for문을 사용하여 아래의 요구 사항을 처리할 수 있도록 프로그램 하시오. 모든 처리는 생성자 ForExam8()안에서 처리하고, 실행은 Main.java에서 실행하시오.
 * 1~100사이의 난수 1000개를 발생시켜 
 * s1 : 단자리수(0~9)
 * s10 : 10자리수(10~19)
 * s20 : 20자리수(20~29)
 * s30 : 30자리수(30~39)
 * ...
 * s90 : 90 자리수(90~100)의 변수에 카운트하여 아래의 출력예시와 같이 출력하시오.
 * 단자리 : xx개
 * 10자리 : xx개
 * ...
 * 90자리 : xx개
 */
package c_control;

public class ForExam8 {
	
	ForExam8(){
		int num = 0;
		int s1=0, s10=0, s20=0, s30=0, s40=0, s50=0, s60=0, s70=0, s80=0, s90=0;
		
		for(int i=1;i<=1000;i++) {
			num = (int)(Math.random()*100)+1;
			
			if(num<=9)       { s1++; } 
			else if(num<=19) { s10++; } 
			else if(num<=29) { s20++; } 
			else if(num<=39) { s30++; }
			else if(num<=49) { s40++; } 
			else if(num<=59) { s50++; }
			else if(num<=69) { s60++; }
			else if(num<=79) { s70++; }
			else if(num<=89) { s80++; }
			else             { s90++; }
		}
		System.out.println("단자리 : " + s1 + "개");
		System.out.println("10자리 : " + s10 + "개");
		System.out.println("20자리 : " + s20 + "개");
		System.out.println("30자리 : " + s30 + "개");
		System.out.println("40자리 : " + s40 + "개");
		System.out.println("50자리 : " + s50 + "개");
		System.out.println("60자리 : " + s60 + "개");
		System.out.println("70자리 : " + s70 + "개");
		System.out.println("80자리 : " + s80 + "개");
		System.out.println("90자리 : " + s90 + "개");
	}
} 
