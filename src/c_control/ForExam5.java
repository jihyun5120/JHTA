/*
 * 예제5) ForExam5.java
 * 1~1000까지의 합계가 5000이 넘는 순간의 수를 출력하시오.
 */
package c_control;

public class ForExam5 {
	ForExam5(){
		int sum = 0;
		int i = 0;
		
		for(i=1;i<=1000;i++) {
			sum = sum+i;
			if(sum>=5000) {				
				System.out.println(i + ", " + sum);
				break;
			}
		}
		
		//Type2
//		for(i=1; sum<5000; i++) {
//			sum += i;
//		}
//			System.out.println((i-1) + ", " + sum);
	}
}
