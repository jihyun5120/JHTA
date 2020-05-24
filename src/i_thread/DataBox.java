package i_thread;

public class DataBox { //�� �������� �۾� ������ ����ȭ �޼ҵ�� �ۼ��� ���� ��ü
	public String data;
	
	public synchronized String getData() {
		if(this.data == null) { //data �ʵ尡 null�̸� Consumer�����带 �Ͻ��������·� ����.
			try {
				wait();
			}catch(Exception ex) {}
		}		
			String returnValue = data;
			System.out.println("ConsumerThread�� ���� ������ : " +  returnValue);
			data = null;
			notify();
			return returnValue;
	}
	
	public synchronized void setData(String data) {
		if(this.data != null) { //data�ʵ尡 null�� �ƴϸ� Consumer�����带 �Ͻ��������·� ����.
			try {
				wait();
			} catch(Exception ex) {}
		}
		this.data = data;
		System.out.println("ProducerThread�� ������ ������ : " + data);
		notify();
	}
}
