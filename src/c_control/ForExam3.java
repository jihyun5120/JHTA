/*
 * 예제4) ForExam3.java
 * 아래와 같은 방정식이 있다. x값이 1~100사이인 해를 구하여 출력하시오.
 * 
 * y = 3x + 1;
 * 
 * x=1, y=4
 * x=2, y=7
 */
package c_control;

public class ForExam3 {
	public ForExam3(){
		int x=0;
		int y=0;
		
		for(x=1; x<=100; x++) {
			y = 3 * x + 1;
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.printf("(%4d,%4d) \n", x, y); // %4 : 값을 네칸을 줌, d : 값을 넣는 곳.
		}
	}
}
