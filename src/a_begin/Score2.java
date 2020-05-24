/* 
 * 파일명 : Score2.java
 * 조건 : 하나의 문자열과 실수형 점수, 그리고 하나의 문자로 되어있는 학점이 발생한다. 적당한 변수에 저장한 후 출력하시오.
 * 출력 이름: 홍길동
 *   점수: 100.0
 *   학점: A
 */

package a_begin;

public class Score2 {
	public static void main(String[] args) {
		String name = "홍길동";
		double score = 100; //float score = 100f;
		char grade = 'A'; //String grade = "A";
		
		System.out.println("이름: " + name);
		System.out.println("점수: " + score);
		System.out.println("학점: " + grade);
	}
}
