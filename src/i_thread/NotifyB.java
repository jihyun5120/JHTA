package i_thread;

public class NotifyB extends Thread{ //WorkObject�� methodB()�� �����ϴ� �޼ҵ�
	WorkObject obj;
	
	NotifyB(WorkObject obj){
		this.obj = obj; //������ü�� �Ű������� �޾� �ʵ忡 ����.
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			obj.methodB();
		}
	}
}
