/*
 * ���� 7) ForExam7.java
 * 1~1000������ ���� �Ҽ����� ���Ͽ� ����Ͻÿ�.(�Ҽ�:1�� �ڽ��̿��� �ڿ����� ������ �������� �ʴ� �ڿ���)
 */
package c_control;

public class ForExam7 {
	ForExam7() {
		int i = 0;
		int s = 0;

		for (i=1; i<=1000; i++) {
			boolean b = true; //i�� �Ҽ���.
			for (s=2; s<i; s++) {
				if (i % s == 0) {
					b = false; // �Ҽ��� �ƴϴ�. 
					break; // �Ҽ��� �������� ����s�� ���� for���� ���Ͷ�
				} 
			}
			if (b) {
				System.out.print(i + " ");
			}
		}
	}
}
