/*
 * 예제2) Exam2.java
 * 1. 주행거리에 따른 택시요금을 계산하여 출력.
 * 2. 기본 2000mm 까지는 기본요금이 3000원.
 * 3. 200mm당 추가요금 500원씩 과금됨.
 * 4. 현재 손님의 주행거리가 4530mm인 경우 택시 요금을 계산하시오.
 * - 기본거리 : base
 * - 기본요금 : basePrice
 * - 주행거리 : totM
 * - 추가거리 : m
 * - 추가요금 :mPrice
 * - 총금액 : totPrice
 */

package c_control;

public class Exam2 {
	Exam2(){
		int base = 2000; // 기본거리
		int basePrice = 3000; //기본요금
		int totM = 4350; //주행거리
		int m = totM-base; //추가거리
		int mPrice = 500; //추가요금
		int totPrice = 0; //총금액
		
		if(m>0) {
			int v = m/200;
			if(m%200>0) {
				v++;				
			}
		    totPrice = basePrice + (mPrice*v);
		}else {
			totPrice = 3000;
		}
		System.out.println(totPrice + "원");

// 밑에 코딩은 2200은 출력값이 생기지않음.		
//		int base = 2000; // 기본거리
//		int basePrice = 3000; //기본요금
//		int totM = 4350; //주행거리
//		int m = totM-base; //추가거리
//		int mPrice = 500; //추가요금
//		int totPrice = basePrice+(m/200)*mPrice+mPrice; //총금액
//		
//		if(m>0) {
//			if(m%200>0) {System.out.println(totPrice + "원");}
//		} else { System.out.println(basePrice + "원"); }
	}
	public static void main(String[] args) {
		new Exam2();
	}
}
