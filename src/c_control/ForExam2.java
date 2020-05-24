/*----------------------------
 * 구구단 출력
 * 작성자 : 최지현
 * 작성일 : 2019.12
------------------------------ */
package c_control;

public class ForExam2 {
	ForExam2() {
		for (int m = 2; m <= 99; m++) {
			System.out.println(m + "단입니다.");

			for (int n = 1; n <= 9; n++) {
				System.out.println(m + " X " + n + " = " + (m * n));
			}
		}
	}
}
