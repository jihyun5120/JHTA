package z_exam;

public class SubThread implements Runnable{

	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(200); //�׽�Ʈ���ؼ� ��� �Ͻ��������ѳ���.
			} catch(Exception ex) {}
		}	
	}
}
