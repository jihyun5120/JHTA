/*
 * Calculator, User1, User2
 */
package i_thread;

public class SyncThreadExam {

	public static void main(String[] args) {
		//공유객체 호출
		Calculator calc = new Calculator();
		
		//스레드 생성
		User1 u1 = new User1();
		User2 u2 = new User2();
		
		//공유 객체 설정
		u1.setCalc(calc);
		u2.setCalc(calc);
		
		//스레드 시작
		u1.start();
		u2.start();
	}

}
