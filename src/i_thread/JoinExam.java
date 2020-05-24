/*
 *  SumThread
 */
package i_thread;

public class JoinExam { //다른 스레드가 종료될 때까지 일시정지상태유지
	public static void main(String[] args) {		
		
		SumThread st = new SumThread();
		
		st.start();
		
		
		try {
			st.join(); //SumThread가 종료될때까지 메인 스레드를 일시정지시킴.
		} catch(Exception ex) {}
		
		System.out.println("1~100의 합계 : " + st.sum);
	}
}
