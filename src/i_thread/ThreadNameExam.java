package i_thread;

public class ThreadNameExam {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("���� ������� : " + mainThread.getName());
		
		//��ü����
		Thread t1 = new ThreadA();
		Thread t2 = new ThreadB();
		
		//��ü����
		t1.start();
		t2.start();
		
	}

}
