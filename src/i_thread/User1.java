package i_thread;

public class User1 extends Thread{ //������
	private Calculator calc;
	
	public void setCalc(Calculator calc) {
		this.setName("User1");
		this.calc = calc; //���� ��ü�� �ʵ带 ����
	}
	
	@Override
	public void run() {
		calc.setMemory(100);
	}
}
