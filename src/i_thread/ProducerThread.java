package i_thread;

public class ProducerThread extends Thread{ //�����͸� ����(����)�ϴ� ������
	public DataBox db;
	
	public ProducerThread(DataBox db) {
		this.db = db; // ������ü�� �ʵ忡 ����.
	}

	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			String data = "Data-" + i;
			db.setData(data); // ���ο� ������ ����.
		}
	}
}
