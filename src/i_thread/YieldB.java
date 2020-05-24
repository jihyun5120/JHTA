package i_thread;

public class YieldB extends Thread{
	boolean stop = false; //종료 플래그
	boolean work = true; //작업 진행 여부 플래그
	
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("YieldB...");
			} else {
				Thread.yield();
			}
			try {
				Thread.sleep(500);
			} catch(Exception ex) {}
		}
		System.out.println("ThreadB 종료");
	}
}
