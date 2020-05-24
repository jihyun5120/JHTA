package i_thread;

public class ConsumerThread extends Thread{ //데이터를 소비하는(읽는) 스레드
	public DataBox db;
	
	public ConsumerThread(DataBox db) {
		this.db = db; // 공유객체를 필드에 저장.
	}
	
	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			String data = db.getData(); //새로운 데이터를 읽음.
		}
	}
}
