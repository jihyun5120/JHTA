/*
 *  WorkObject, NotifyA, NotifyB
 */
package i_thread;

public class NotifyExam { //두 스레드를 생성하고 실행하는 메인 스레드
	
	public static void main(String[] args) {
		WorkObject obj = new WorkObject();
		
		NotifyA t1 = new NotifyA(obj);
		NotifyB t2 = new NotifyB(obj);
		
		t1.start();
		t2.start();
	}
}
