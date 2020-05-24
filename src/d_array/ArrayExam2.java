/*
 * 예제1) ArrayExam2.java
 * 초기값으로 정수형 성적이 10개 발생하였다. 이를 배열에 저장한 후 성적중 최대값과 최소값을 검사하여 출력하시오.
 */
package d_array;

public class ArrayExam2 {
	ArrayExam2(){
		int[] scores = new int[] {155,267,3867,47,5,686,76,88,9,108}; // 1.  정수형 배열 선언, 임의의 초기값 10개 대입.
		int max = scores[0]; // 2. 배열의 첫번째값을 최대값으로 판정하고 시작.
		int min = scores[0]; // 3. 배열의 첫번째값을 최소값으로 판정하고 시작.
		
		// 4. 최대값을 찾기위한 루핑~
		for(int i=1; i<scores.length; i++) {
			if(scores[i] > max) {
				max = scores[i];
			}	
		}
		
		// 5. 최소값을 찾기위한 루핑~
		for(int i=1; i<scores.length; i++) {
			if(scores[i] < min) {
				min = scores[i];
			}
		}
		
		//6. 최대값과 최소값을 출력.
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void main(String[] args) {
		new ArrayExam2();
	}
}
