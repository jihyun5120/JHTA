package d_array;

import java.util.Scanner;

public class ArrayExam4 {
	String[] n = new String[10];
	int[][] s = new int[10][2];
	int count = 0; //�迭�� �Էµ� �ڷ��� ����
	
	// ���ѷ����� ���鼭 �޴��� ���.
 	ArrayExam4() {
 		Scanner scanner = new Scanner(System.in); //System.in : �ý��ۿ� �ԷµǴ� ��ġ�� ǥ���Է���ġ��.
		boolean run = true;
		
		//���ÿ� �����͸� �迭�� ����.
		n[0] = "kim";
		n[1] = "hong";
		n[2] = "park";
		n[3] = "lee";
		s[0][0] = 90; s[0][1] = 80;
		s[1][0] = 80; s[1][1] = 40;
		s[2][0] = 50; s[2][1] = 60;
		s[3][0] = 60; s[3][1] = 70;
		
		count = 4;
		
		while(run) {
			System.out.println("-----------------------------------");
			System.out.println("1.�Է� | 2.���� | 3.��ȸ �� ��� | 4.����");
			System.out.println("-----------------------------------");
			System.out.print("�޴� ���� : ");
			int menu = scanner.nextInt();
			switch(menu) { //if ������ �ص� ��.
			case 1 :
				this.input();
				break;
				
			case 2 : 	
				this.modify();
				break;
				
			case 3 : 
				this.search();
				break;
				
			case 4 : 
				run = false;
				break;
			} // switch ��.
		} // while ��.
		System.out.println("���α׷��� ����Ǿ����ϴ�.");	
		
}
	// �л��� ���� ������ �迭�� �Է�.
	public void input() {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		int kor = 0;
		int eng = 0;
		int tot = 0;
		double avg = 0;
		
		System.out.print("���� : ");
		name = scanner.nextLine();
		System.out.print("���� : ");
		kor = scanner.nextInt();
		System.out.print("���� : ");
		eng = scanner.nextInt();
		
		tot = kor + eng;
		avg = (double)tot/2;
		
		System.out.println("���� : " + tot);
		System.out.println("��� : " + avg);
		
		n[count] = name;
		s[count][0] = kor;
		s[count][1] = eng;
		count++;
	}
	//�л��� ���� ������ ����.
	/* 1) ������ �л����� �Է¹޾� �˻�
	 * 2) �˻��� ������ ǥ��
	 * 3) ����
	 * 4) �迭 ���� ���� */
	public void modify() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�˻��� ������? ");
		String findName = scanner.nextLine();
		int tot = 0;
		double avg = 0;
		
		for( int i=0; i<count; i++) {
			if((n[i]).equals(findName)){
				tot = s[i][0] + s[i][1];
				avg = tot/2.0;
				System.out.print(n[i] + " ");
				System.out.print(s[i][0] + " ");
				System.out.print(s[i][1] + " ");
				System.out.print(tot + " ");
				System.out.printf("%5.1f", avg);
				System.out.println();
				
				System.out.print("������ ���� ������? ");
				s[i][0] = scanner.nextInt();
				System.out.print("������ ���� ������?");
				s[i][1] = scanner.nextInt();
				System.out.println("�ڷᰡ �����Ǿ����ϴ�.");
				System.out.println();
			} // if�� ��.
		} // for�� ��.
		
		
	}
	//�л��� ���� ������ ��ȸ �� ���.
	public void search() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�˻��� ������? ");
		String findName = scanner.nextLine();
		int tot = 0;
		double avg = 0;
		for( int i=0; i<count; i++) {
			if(n[i].equals(findName)||findName.equals("")) {
				//TODO(����, ����� ����Ͽ� ���)
				tot = s[i][0] + s[i][1];
				avg = tot/2.0;
				
				System.out.print(n[i] + "  ");
				System.out.print(s[i][0] + "  ");
				System.out.print(s[i][1] + "  ");
				System.out.print(tot + "  ");
				System.out.printf("%5.1f", avg);
				System.out.println();
			}
			
				
		}
	}
	
	public static void main(String[] args) {
		new ArrayExam4();
	}
}
