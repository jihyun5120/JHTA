/*
 * ���� 6) ForExam6.java
 * 1~1000������ ���� 5�� ����̰ų� 7�� ������� ����Ͻÿ�.
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
