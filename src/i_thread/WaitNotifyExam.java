/*
 * ProducerThread, ConsumerThread
 */
package i_thread;

public class WaitNotifyExam { //�� �����带 �����ϰ� �����ϴ� ���� ������

	public static void main(String[] args) {
		DataBox db = new DataBox(); //������ü ����.
		
		ProducerThread t1 = new ProducerThread(db);
		ConsumerThread t2 = new ConsumerThread(db);
		
		t1.start();
		t2.start();
	}

}
