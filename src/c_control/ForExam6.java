/*
 * 예제 6) ForExam6.java
 * 1~1000까지의 수중 5의 배수이거나 7의 배수만을 출력하시오.
 */
package c_control;

public class ForExam6 {
	ForExam6(){
		for(int i=1;i<=1000;i++) {
			if(i%5==0 || i%7==0) {
				System.out.println(i);
			}
		}
		
		//Type2
		for(int i=5; i<=1000; i=i+5) {
			System.out.println(i);
		}
		for(int a=7; a<=1000; a=a+7) {
			System.out.println(a);
		}
	}
}
