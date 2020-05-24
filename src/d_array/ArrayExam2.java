/*
 * ����1) ArrayExam2.java
 * �ʱⰪ���� ������ ������ 10�� �߻��Ͽ���. �̸� �迭�� ������ �� ������ �ִ밪�� �ּҰ��� �˻��Ͽ� ����Ͻÿ�.
 */
package d_array;

public class ArrayExam2 {
	ArrayExam2(){
		int[] scores = new int[] {155,267,3867,47,5,686,76,88,9,108}; // 1.  ������ �迭 ����, ������ �ʱⰪ 10�� ����.
		int max = scores[0]; // 2. �迭�� ù��°���� �ִ밪���� �����ϰ� ����.
		int min = scores[0]; // 3. �迭�� ù��°���� �ּҰ����� �����ϰ� ����.
		
		// 4. �ִ밪�� ã������ ����~
		for(int i=1; i<scores.length; i++) {
			if(scores[i] > max) {
				max = scores[i];
			}	
		}
		
		// 5. �ּҰ��� ã������ ����~
		for(int i=1; i<scores.length; i++) {
			if(scores[i] < min) {
				min = scores[i];
			}
		}
		
		//6. �ִ밪�� �ּҰ��� ���.
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void main(String[] args) {
		new ArrayExam2();
	}
}
