/*
 * 예제 7) ForExam7.java
 * 1~1000사이의 수중 소수만을 구하여 출력하시오.(소수:1과 자신이외의 자연수로 나누어 떨어지지 않는 자연수)
 */
package c_control;

public class ForExam7 {
	ForExam7() {
		int i = 0;
		int s = 0;

		for (i=1; i<=1000; i++) {
			boolean b = true; //i가 소수다.
			for (s=2; s<i; s++) {
				if (i % s == 0) {
					b = false; // 소수가 아니다. 
					break; // 소수가 나왔으니 변수s가 도는 for문을 나와라
				} 
			}
			if (b) {
				System.out.print(i + " ");
			}
		}
	}
}
