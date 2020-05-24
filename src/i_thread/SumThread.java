package i_thread;

public class SumThread extends Thread{ //1~100까지 합을 계산하는 스레드
	public long sum;
	
	public long getSum() {
		return sum;
	}
	
	public void setSum(long sum) {
		this.sum = sum;
	}
	
	@Override
	public void run() {
		for(int i=0; i<=100; i++) {
			sum += i;
			
			try {
				Thread.sleep(10);
			} catch(Exception ex){}
			
		}
	}
}
