/*
 * ProducerThread, ConsumerThread
 */
package i_thread;

public class WaitNotifyExam { //두 스레드를 생성하고 실행하는 메인 스레드

	public static void main(String[] args) {
		DataBox db = new DataBox(); //공유객체 생성.
		
		ProducerThread t1 = new ProducerThread(db);
		ConsumerThread t2 = new ConsumerThread(db);
		
		t1.start();
		t2.start();
	}

}
