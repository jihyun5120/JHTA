/*
 * ����5) ForExam5.java
 * 1~1000������ �հ谡 5000�� �Ѵ� ������ ���� ����Ͻÿ�.
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
