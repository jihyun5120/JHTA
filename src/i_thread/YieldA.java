package i_thread;

public class YieldA extends Thread{
	boolean stop = false; //���� �÷���
	boolean work = true; //�۾� ���� ���� �÷���
	
	public void run() {
		while(!stop) { 
			if(work) {
				System.out.println("YieldA...");
			} else {
				Thread.yield();
			}
			try {
				Thread.sleep(500);
			} catch(Exception ex) {}
		}
		System.out.println("ThreadA ����");
	}
}
