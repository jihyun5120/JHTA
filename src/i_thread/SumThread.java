package i_thread;

public class SumThread extends Thread{ //1~100���� ���� ����ϴ� ������
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
