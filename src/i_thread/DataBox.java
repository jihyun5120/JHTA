package i_thread;

public class DataBox { //두 스레드의 작업 내용을 동기화 메소드로 작성한 공유 객체
	public String data;
	
	public synchronized String getData() {
		if(this.data == null) { //data 필드가 null이면 Consumer스레드를 일시정지상태로 만듬.
			try {
				wait();
			}catch(Exception ex) {}
		}		
			String returnValue = data;
			System.out.println("ConsumerThread가 읽은 데이터 : " +  returnValue);
			data = null;
			notify();
			return returnValue;
	}
	
	public synchronized void setData(String data) {
		if(this.data != null) { //data필드가 null이 아니면 Consumer스레드를 일시정지상태로 만듬.
			try {
				wait();
			} catch(Exception ex) {}
		}
		this.data = data;
		System.out.println("ProducerThread가 생성한 데이터 : " + data);
		notify();
	}
}
