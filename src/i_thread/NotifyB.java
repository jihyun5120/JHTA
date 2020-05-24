package i_thread;

public class NotifyB extends Thread{ //WorkObject의 methodB()를 실행하는 메소드
	WorkObject obj;
	
	NotifyB(WorkObject obj){
		this.obj = obj; //공유객체를 매개값으로 받아 필드에 저장.
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			obj.methodB();
		}
	}
}
