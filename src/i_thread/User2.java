package i_thread;

public class User2 extends Thread{ //스레드
	private Calculator calc;
	
	public void setCalc(Calculator calc) {
		this.setName("User2");
		this.calc = calc; //공유 객체에 필드를 저장
	}
	
	@Override
	public void run() {
		calc.setMemory(50);
	}
}
