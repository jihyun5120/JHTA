/*
 *  예제1) 반환형 Exam1.java
 *  1. 두 정수를 전달 받아 합계를 반환하는 메소드 구현(sum)
 *  2. 두 정수(x, y)를 전달 받아 x~y까지의 합계를 구하여 리턴(sum2)
 *  3. 가로, 세로값을 실수형으로 전달받아 사각형의 넓이를 계산하여 리턴(sum3)
 *  4. 구구단 수를 하나 전달받아 구구단을 하나의 문자열로 만들어 리턴(gugudan)
 *  
 */
package e_class;

public class Exam1 {
	
	int sum(int x, int y) {
		int sum = x+y;
		System.out.println(x + "+" + y + "의 값은 : " + sum);
		return sum;
	}
	int sum2(int x, int y) {
		int sum2 = 0;
		for(int i=x; i<=y;i++) {
			sum2 += i;			
		}
		System.out.println(x + "~" + y + "까지의 합계는 : " + sum2);
		return sum2;
	}
	double sum3(double x, double y) {
		double sum3 = x*y;
		System.out.println("사각형 넓이의 값은 : " + sum3);
		return sum3;
	}
	String gugudan(int s) {
		String gugudan = "";
		for(int i=1; i<=9; i++) {
			int gugu=s*i;
			gugudan = (s + "*" + i + "=" + gugu);
			System.out.println(gugudan);
		}
		return gugudan;
	}
}
