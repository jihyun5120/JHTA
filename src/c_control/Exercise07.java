/*
 * while���� Scanner�� �̿��ؼ� Ű����κ��� �Էµ� �����ͷ� ����, ��� ��ȸ, ���� ����� �ڵ带 �ۼ��غ�����.
 */
package c_control;

import java.util.Scanner;

public class Exercise07 {
	Exercise07()throws Exception{
		
		boolean run = true;
		int balance = 0; //�ܰ�
		Scanner scanner = new Scanner(System.in); 
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("------------------------------");
			System.out.print("����> ");
			
			int menu = scanner.nextInt();
			
			//while������~
				while(menu == 1) {
					System.out.print("���ݾ�>" );
					int input = scanner.nextInt();
					balance += input;
					break;
				}
				while(menu == 2) {
					System.out.print("��ݾ�>" );
					int output = scanner.nextInt();
						if(balance<output) {
						System.out.println("�ܾ��� �����մϴ�.");
						break;
						}
					balance -= output;
					break;
				}
				while(menu == 3) {
					System.out.println("�ܰ�>" + balance);
					break;
				}
				while(menu == 4) {
					run = false;
					break;
				} //menu while of end
				
			//switch������~
//				switch(menu) {
//				case 1 :
//					System.out.print("���ݾ�>");
//					int input = scanner.nextInt();
//					balance =+ input;
//					break;
//				
//				case 2 :
//					System.out.print("��ݾ�>");
//					int output = scanner.nextInt();
//					 if(balance<output) {
//						System.out.println("�ܾ��� �����մϴ�.");
//				 	 } else {
//					 balance -= output;
//				 	 }
//					 break;
//				
//				case 3 :
//					System.out.println("�ܰ�>" + balance);
//					break;
//					
//				case 4 :
//					run = false;
//					break;
//				} // switch of end
				
		}
		
		System.out.println();
		System.out.println("���α׷� ����");
	}
	
	public static void main(String[]args) throws Exception{
		new Exercise07();
	}
}
