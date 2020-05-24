/*
 * for문을 이용해서 실행결과와 같은 삼각형을 출력하는 코드를 작성해보세요.
 * [출력예시]
 *  *
 *  **
 *  ***
 *  ****
 *  *****
 */
package c_control;

public class Exercise06 {
	Exercise06(){
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");				
			}
			System.out.println();
		}
		
		System.out.println("---------");
		//반대로 *이 5개, 4개, 3개, 2개, 1개로 출력.
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=(6-i);j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] aegs) {
		new Exercise06();
	}
}
