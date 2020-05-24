package i_thread;

public class PriorityExam {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			Thread t = new CalcThread("thread" + i);

			if(i!=10) {
				t.setPriority(Thread.MIN_PRIORITY); //thread1~9���� ���� ���� �켱������ ��.
			} else {
				t.setPriority(Thread.MAX_PRIORITY); //thread10���� ���� ���� �켱������ ��.
			}
			t.start();
		}
	}

}
