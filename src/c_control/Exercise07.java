/*
 * while문과 Scanner를 이용해서 키보드로부터 입력된 데이터로 예금, 출금 조회, 종료 기능을 코드를 작성해보세요.
 */
package c_control;

import java.util.Scanner;

public class Exercise07 {
	Exercise07()throws Exception{
		
		boolean run = true;
		int balance = 0; //잔고
		Scanner scanner = new Scanner(System.in); 
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.print("선택> ");
			
			int menu = scanner.nextInt();
			
			//while문으로~
				while(menu == 1) {
					System.out.print("예금액>" );
					int input = scanner.nextInt();
					balance += input;
					break;
				}
				while(menu == 2) {
					System.out.print("출금액>" );
					int output = scanner.nextInt();
						if(balance<output) {
						System.out.println("잔액이 부족합니다.");
						break;
						}
					balance -= output;
					break;
				}
				while(menu == 3) {
					System.out.println("잔고>" + balance);
					break;
				}
				while(menu == 4) {
					run = false;
					break;
				} //menu while of end
				
			//switch문으로~
//				switch(menu) {
//				case 1 :
//					System.out.print("예금액>");
//					int input = scanner.nextInt();
//					balance =+ input;
//					break;
//				
//				case 2 :
//					System.out.print("출금액>");
//					int output = scanner.nextInt();
//					 if(balance<output) {
//						System.out.println("잔액이 부족합니다.");
//				 	 } else {
//					 balance -= output;
//				 	 }
//					 break;
//				
//				case 3 :
//					System.out.println("잔고>" + balance);
//					break;
//					
//				case 4 :
//					run = false;
//					break;
//				} // switch of end
				
		}
		
		System.out.println();
		System.out.println("프로그램 종료");
	}
	
	public static void main(String[]args) throws Exception{
		new Exercise07();
	}
}
