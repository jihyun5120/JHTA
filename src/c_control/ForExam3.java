/*
 * ����4) ForExam3.java
 * �Ʒ��� ���� �������� �ִ�. x���� 1~100������ �ظ� ���Ͽ� ����Ͻÿ�.
 * 
 * y = 3x + 1;
 * 
 * x=1, y=4
 * x=2, y=7
 */
package c_control;

public class ForExam3 {
	public ForExam3(){
		int x=0;
		int y=0;
		
		for(x=1; x<=100; x++) {
			y = 3 * x + 1;
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.printf("(%4d,%4d) \n", x, y); // %4 : ���� ��ĭ�� ��, d : ���� �ִ� ��.
		}
	}
}
