/*
 * for���� �̿��ؼ� 1~100������ ���� �߿��� 3�� ����� ������ ���ϴ� �ڵ带 �ۼ��ϼ���.
 */
package c_control;

public class Exercise03 {
 Exercise03(){
	 int i = 0;
	 int sum = 0;
	 
	 for(i=3;i<=100;i=i+3) {
		 sum+=i;
	 }
	 System.out.println("3�� ����� �� : " + sum);
 }
	public static void main(String[] args) {
	 new Exercise03();
 }
}
