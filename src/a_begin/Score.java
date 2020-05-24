/*
 * 파일명 : Score.java
 * 조건 : 정수형의 국어점수와 영어점수가 있다. 각각 알맞은 점수에 대입하여 선언하고 다음과 같이 출력하시오.
 * 출력 국어: 90
 *     영어: 90
 *     합계: 180
 */ 

package a_begin;

public class Score {
	public static void main(String[] args) {
		/*
		 * kor = 국어성적, eng = 영어성적, sum = 성적의 합계
		 */
		int kor = 90; //int kor = 90, eng = 90;
		int eng = 90;
		int sum = kor + eng;
		
		System.out.println("국어: " + kor); //System.out.print("국어: " + kor + "\n");
		System.out.println("영어: " + eng);
		System.out.println("합계: " + sum); //System.out.println("합계: "+(kor + eng));
	}
}
