/*
 *  ����1) ��ȯ�� Exam1.java
 *  1. �� ������ ���� �޾� �հ踦 ��ȯ�ϴ� �޼ҵ� ����(sum)
 *  2. �� ����(x, y)�� ���� �޾� x~y������ �հ踦 ���Ͽ� ����(sum2)
 *  3. ����, ���ΰ��� �Ǽ������� ���޹޾� �簢���� ���̸� ����Ͽ� ����(sum3)
 *  4. ������ ���� �ϳ� ���޹޾� �������� �ϳ��� ���ڿ��� ����� ����(gugudan)
 *  
 */
package e_class;

public class Exam1 {
	
	int sum(int x, int y) {
		int sum = x+y;
		System.out.println(x + "+" + y + "�� ���� : " + sum);
		return sum;
	}
	int sum2(int x, int y) {
		int sum2 = 0;
		for(int i=x; i<=y;i++) {
			sum2 += i;			
		}
		System.out.println(x + "~" + y + "������ �հ�� : " + sum2);
		return sum2;
	}
	double sum3(double x, double y) {
		double sum3 = x*y;
		System.out.println("�簢�� ������ ���� : " + sum3);
		return sum3;
	}
	String gugudan(int s) {
		String gugudan = "";
		for(int i=1; i<=9; i++) {
			int gugu=s*i;
			gugudan = (s + "*" + i + "=" + gugu);
			System.out.println(gugudan);
		}
		return gugudan;
	}
}
