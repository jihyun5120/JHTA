/*
 * ������ ����� ���� (���ϸ� : Score4.java)
 * 1. ����, ����, ���� ������ ���������� ������ ������ �� ������ ����� ����Ͽ� ������ ������ �����Ͻÿ�.
 * 2. �� ���� ������ �ϳ��� 40�̸��� ������ '���հ�'ó��
 * 3. ����� 60�̸��̿��� '���հ�'ó���� �Ͽ� ������ ����, ���, �հݿ��θ� ǥ�������ġ�� ����Ͻÿ�.
 * **package b_operator
 * [��¿���]
 * ---------------------
 * �հ� ���� ����
 * ---------------------
 * ���� : 50
 * ���� : 50
 * ���� : 50
 * ���� : 150
 * ��� : 50
 * ��� : ���հ�
 * ---------------------
 */

package b_operator;

public class Score4 {
	/*
	 * int kor = 50;
	 * int eng = 50;
	 * int mat = 50;
	 * int sum = 0;
	 * double avg = 0.0;
	 * boolean b;
	 * String str;
	 */
	
	Score4(){
		/*
		 * this.sum = kor+eng+mat;  �����̸��� ���� ������ this. �� �����ص� ����.
		 * this.avg = (double)sum/3;
		 * b = (kor>=40)&&(eng>=40)&&(mat>=40)&&(avg>=60); �Ǵ� b = (kor<40)||(eng<40)||(mat<40)||(avg<60);
		 * str = (b)?"�հ�":"���հ�;                          �Ǵ� str = (b)?"���հ�":"�հ�; 
		 */
		int kor = 50;
		int eng = 50;
		int mat = 50;
		int sum = kor+eng+mat;
		int avg = sum/3;
		
		boolean b = (kor>=40)&&(eng>=40)&&(mat>=40)&&(avg>=60);
		String str = (b?"�հ�":"���հ�");
		
		System.out.println("-------------------");
		System.out.println("�հ� ���� ����");
		System.out.println("-------------------");
		System.out.println("���� : " + kor + "\n" + "���� : " + eng + "\n" + "���� : " + mat);
		System.out.println("���� : " + sum + "\n" + "��� : " + avg);
		System.out.println("��� : " + str);
		System.out.println("-------------------");
		
	}
	
	public static void main(String[] args) {
		new Score4();
		
		//���Կ�����
		int a = 10;
		int b = 20;
		
		int c = 0;
		c += a; //c = c + a;
		c -= a; //c = c - a;
		c %= 2; //c = c % 2;
	}

}
