package z_exam;

public class SubThread implements Runnable{

	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(200); //테스트위해서 잠시 일시정지시켜놓음.
			} catch(Exception ex) {}
		}	
	}
}
