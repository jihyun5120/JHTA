package i_thread;

public class PriorityExam {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			Thread t = new CalcThread("thread" + i);

			if(i!=10) {
				t.setPriority(Thread.MIN_PRIORITY); //thread1~9에는 가장 낮은 우선순위를 줌.
			} else {
				t.setPriority(Thread.MAX_PRIORITY); //thread10에만 가장 높은 우선순위인 줌.
			}
			t.start();
		}
	}

}
