package a_begin;

public class CastingExample {
	public CastingExample(){ //접근제어자 public이 붙으면 다른 패키지에서도 사용o, 생략(default)이면 같은 패키지에서만 사용o
		//int --> char
		int a = 44034;
		char c = (char) a;
		System.out.println(a + " to char type: " + c);
		
		//long --> int
		long l = 500L;
		int b = (int) l;
		System.out.println(b);
		
		//double --> int
		double d = 3.14;
		int e = (int) d;
		System.out.println(d + " to int type: " + e);
		
//		double d2 = 10/3; 정수형 연산은 무조건 정수형으로 계산되어 출력된다.
		double d2 = 10/(double)3; //강제로 실수형을 넣어 실수로 출력. == double d2 = 10/(3*0.1);
		System.out.println(d2);
	}
	
	public static void main(String[]args) {
		new CastingExample();
	}
}
