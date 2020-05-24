package d_array;

import java.util.Scanner;

public class ArrayExam3 {

	//�޼ҵ� : ������ ��ȯ�� �޼ҵ�� (�Ű�����){...} , ��ȯ���� ������ Ŭ������� ���Ƶ� ������ �޼ҵ�.
	
	//������ 2���� �迭�� �����ϰ� �ʱⰪ�� 4�� 3���� �����͸� �����Ͻÿ�.
	public void test1() { //���ο��� ȣ���ϴ� ���, �ٸ� Ŭ�������� ȣ���ϴ� ���.
		int[][] s = new int[][] {
			{ 1, 2, 2 },
			{ 4, 2, 4 },
			{ 4, 5, 7 },
			{ 7, 8, 9 }
		};
		
		// �迭�� ����� ���.
		System.out.println("��� : " + s.length);
		// ù��° ���� ����.
		System.out.println("ù��° ���� ���� : " + s[0].length);
		// �ι�° ���� ����° ���� ����?
		System.out.println("�ι�° ���� ����° ���� �� : " + s[1][2]);
		// ù��° ���� ������ �հ�	
		int sum = s[0][0] + s[0][1] + s[0][2];
		System.out.println("ù��° ���� �հ� : " + sum);
		// ù��° ���� ������ �հ�
		sum = s[0][0] + s[1][0] + s[2][0] + s[3][0];
		System.out.println("ù��° ���� ������ �հ� : " + sum);
		// �ι�°���� ���� �� ¦����
		if(s[1][0]%2==0) {
			System.out.print(s[1][0] + " ");
		}
		if(s[1][1]%2==0) {
			System.out.print(s[1][1] + " ");
		}
	
		if(s[1][2]%2==0) {
			System.out.println(s[1][2] + " ");
		}
		
//		for(int i=0; i<s[1].length; i++) {
//			if(s[1][i]%2==0) {
//			System.out.print(s[1][i] + " " );	
//			}
//		}
//		System.out.println();	
		
		//����° ���� ¦���� ����� ���
		int hap = 0;
		int count = 0;
		double avg = 0.0;
		
		for(int i=0; i<s.length; i++) {
			if(s[i][2]%2==0) {
				hap += s[i][2];
				count++;
			}
		}
		if(count>0) {
		avg = (double)hap/count;
		}
		System.out.println("�հ� : " + hap);
		System.out.println("¦���� ���� : " + count);
		System.out.println("����° �� ¦���� ��� : " + avg);
	}
	
	public int test2() {
		//���ڿ� 1�����迭(names)�� ������ ���� 5���� ����.
		//������ 2�����迭(s)�� 5���� ����, ������� ����.
		String[] names = new String[] {"��","��","��","��","��"};
		int[][] s = new int[][]{
			{90, 80},
			{95, 100},
			{75, 90},
			{80, 60},
			{85, 90}
			};
			int tot = 0;
			double avg = 0;
		// �迭�� ù��° �л��� �̸��� ���� �� ����, ����� ���
			System.out.println("�̸� : " + names[0]);
			System.out.println("����� : " + s[0][0]);
			System.out.println("����� : " + s[0][1]);
			tot = s[0][0] + s[0][1];
			avg = (double)tot/s[0].length;
			System.out.println("���� : " + tot);
			System.out.println("��� : " + avg);
			
			//����° �л��� ���������� 100������ �����Ͻÿ�.
			s[2][0] = 100;
			//����° �л��� �̸��� ������� ����Ͻÿ�.
			System.out.println("����° �л��� : " + names[2]);
			System.out.println("�������� : " + s[2][0]);
		
			//�л����� "��"�� ����� ����, ����, ����, ����� ����Ͽ� ����ϵ� ������ "�ڷ����"�� ���.
			//�˻�� �Է��Ͽ� �˻��ϰ� �˻��� �����Ϸ��� "quite"�� �Է��ϵ��� ���α׷��� �����Ͻÿ�.
			Scanner scanner = new Scanner(System.in);
			String findStr = "";
			 while(!findStr.equals("quit")) {
				 System.out.println("�˻��� �̸���?");
				 findStr = scanner.nextLine(); //next(); �� ���� �������� ���ڸ� ����, nextLine(); �� ���ڿ� �� �� ��ü�� ����.
				 int p = -1;
				for( int i=0; i<names.length; i++ ) {
					if( names[i].equals(findStr) ) { //names�� String�迭�̹Ƿ� .equals ���.
						p=i;
						tot = s[i][0] + s[i][1];
						avg = (double)tot/s[i].length;
						System.out.println("----�˻����----");
						System.out.println("�̸� : " + names[i]);
						System.out.println("�������� : " + s[i][0]);
						System.out.println("�������� : " + s[i][1]);
						System.out.println("���� : " + tot);
						System.out.println("��� : " + avg);
						break;
					} 
				}
				if(p==-1 || findStr=="quit") {
					System.out.println("�ڷ����");
				}
			}
			
		return 0;
		}
	
	public static void main(String[] args) {
		ArrayExam3 a3 = new ArrayExam3(); //��ü����.
//		a3.test1(); //void�� ��ȯ���� �����Ƿ� ��ȯ���� ��� �������x.
		a3.test2();
	}

}