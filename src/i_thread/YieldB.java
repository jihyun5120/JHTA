package i_thread;

public class YieldB extends Thread{
	boolean stop = false; //���� �÷���
	boolean work = true; //�۾� ���� ���� �÷���
	
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
		System.out.println("ThreadB ����");
	}
}