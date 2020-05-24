package i_thread;

public class Calculator { //공유객체
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	//synchronized --> 상호베타적동기화를 구현 (구현X : 값을 공유, 구현O 동시작업X로 각자 값)
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000); //스레드를 2초간 정지
		} catch(InterruptedException ex) {}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
}
