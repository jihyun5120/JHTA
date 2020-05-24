package i_thread;

public class ProducerThread extends Thread{ //데이터를 생산(저장)하는 스레드
	public DataBox db;
	
	public ProducerThread(DataBox db) {
		this.db = db; // 공유객체를 필드에 저장.
	}

	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			String data = "Data-" + i;
			db.setData(data); // 새로운 데이터 저장.
		}
	}
}
