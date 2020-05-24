/*정수형 2차원배열을 5행 5열을 만들어 100~200 사이의 임의의 정수값을 Math.random()을 사용하여 대입 한 후
* 1) 배열 전체 출력(5행5열로)
* 2) 전체 값들의 합계
* 3) 전체 최소값
* 4) 전체 최대값
* 5) 각행의 최대값
   을 출력하시오. */
package d_array;

public class Exam8 {
	Exam8() {
		int s[][] = new int[5][5];
		int h = 0; // 행
		int a = 0; // 열
		int tot = 0; // 합계
		int min = 200; // 최소값
		int max = 100; // 최대값

		for (h = 0; h < s.length; h++) {
			for (a = 0; a < s[h].length; a++) {
				s[h][a] = (int) (Math.random() * 101) + 100;

				tot += s[h][a]; // 전체 값들의 합계

				System.out.print(s[h][a] + "  ");
				// 전체 최소값과 최대값
				if (s[h][a] < min) {
					min = s[h][a];
				} else if (s[h][a] > max) {
					max = s[h][a];
				  }
			} //a for문 끝

			System.out.println();
		} //h for문 끝
		System.out.println("전체 값들의 합계 : " + tot);
		System.out.println("전체 최소값 : " + min);
		System.out.println("전체 최대값 : " + max);

		// 각 행의 최대값
		for (h = 0; h < s.length; h++) {
			max = 0;
			for (a = 0; a < s[h].length; a++) {
				if (s[h][a] > max) {
					max = s[h][a];
				}
			} // 각 행의 최대값 a for문 끝
			System.out.println((h+1) + "행의 최대값은 : " + max);
		} // 각 행의 최대값 j for문 끝
	} // 생성자 끝.

	public static void main(String[] args) {
		new Exam8();
	}
}
