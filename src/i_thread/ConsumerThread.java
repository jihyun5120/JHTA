package i_thread;

public class ConsumerThread extends Thread{ //�����͸� �Һ��ϴ�(�д�) ������
	public DataBox db;
	
	public ConsumerThread(DataBox db) {
		this.db = db; // ������ü�� �ʵ忡 ����.
	}
	
	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			String data = db.getData(); //���ο� �����͸� ����.
		}
	}
}
