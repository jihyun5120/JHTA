package i_thread;

public class NotifyA extends Thread{ //WorkObject�� methodA()�� �����ϴ� �޼ҵ�
	WorkObject obj;
	
	NotifyA(WorkObject obj){
		this.obj = obj; //������ü�� �Ű������� �޾� �ʵ忡 ����.
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			obj.methodA();
		}
	}
}
