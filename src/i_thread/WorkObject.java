package i_thread;

public class WorkObject { //�� �������� �۾� ������ ����ȭ �޼ҵ�� �ۼ��� ���� ��ü
	public synchronized void methodA() {
		System.out.println("Thread�� methodA() �۾�����....");
		notify(); //���������Ǿ� �ִ� ThreadB�� ����.
		try {
			wait(); //ThreadA�� �Ͻ� ���� ���·� ����.
		}catch(Exception ex) {}
	}
	
	public synchronized void methodB() {
		System.out.println("Thread�� methodB() �۾�����....");
		notify(); //���������Ǿ� �ִ� ThreadA�� ����.
		try {
			wait(); //ThreadB�� �Ͻ� ���� ���·� ����.
		} catch(Exception ex) {}
	}
}
