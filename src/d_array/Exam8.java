/*������ 2�����迭�� 5�� 5���� ����� 100~200 ������ ������ �������� Math.random()�� ����Ͽ� ���� �� ��
* 1) �迭 ��ü ���(5��5����)
* 2) ��ü ������ �հ�
* 3) ��ü �ּҰ�
* 4) ��ü �ִ밪
* 5) ������ �ִ밪
   �� ����Ͻÿ�. */
package d_array;

public class Exam8 {
	Exam8() {
		int s[][] = new int[5][5];
		int h = 0; // ��
		int a = 0; // ��
		int tot = 0; // �հ�
		int min = 200; // �ּҰ�
		int max = 100; // �ִ밪

		for (h = 0; h < s.length; h++) {
			for (a = 0; a < s[h].length; a++) {
				s[h][a] = (int) (Math.random() * 101) + 100;

				tot += s[h][a]; // ��ü ������ �հ�

				System.out.print(s[h][a] + "  ");
				// ��ü �ּҰ��� �ִ밪
				if (s[h][a] < min) {
					min = s[h][a];
				} else if (s[h][a] > max) {
					max = s[h][a];
				  }
			} //a for�� ��

			System.out.println();
		} //h for�� ��
		System.out.println("��ü ������ �հ� : " + tot);
		System.out.println("��ü �ּҰ� : " + min);
		System.out.println("��ü �ִ밪 : " + max);

		// �� ���� �ִ밪
		for (h = 0; h < s.length; h++) {
			max = 0;
			for (a = 0; a < s[h].length; a++) {
				if (s[h][a] > max) {
					max = s[h][a];
				}
			} // �� ���� �ִ밪 a for�� ��
			System.out.println((h+1) + "���� �ִ밪�� : " + max);
		} // �� ���� �ִ밪 j for�� ��
	} // ������ ��.

	public static void main(String[] args) {
		new Exam8();
	}
}
