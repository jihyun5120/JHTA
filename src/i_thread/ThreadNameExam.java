package i_thread;

public class ThreadNameExam {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("메인 스레드명 : " + mainThread.getName());
		
		//객체생성
		Thread t1 = new ThreadA();
		Thread t2 = new ThreadB();
		
		//객체실행
		t1.start();
		t2.start();
		
	}

}
