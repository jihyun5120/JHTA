package i_thread;

public class Calculator { //������ü
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	//synchronized --> ��ȣ��Ÿ������ȭ�� ���� (����X : ���� ����, ����O �����۾�X�� ���� ��)
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000); //�����带 2�ʰ� ����
		} catch(InterruptedException ex) {}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
}
