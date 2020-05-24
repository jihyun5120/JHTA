package z_exam;

public class MainThread {
	public static void main(String[] args) {
		System.out.println("메인 스레드 시작");
		SubThread st = new SubThread();
		Thread t = new Thread(st);
		
		try {
			t.start();
			t.join(); //join()을 하지 않으면 메인스레드 종료후에도 부스레드가 계속 돔.
		} catch(Exception ex) {}
		System.out.println("메인 스레드 종료");
	}
}
