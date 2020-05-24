package i_thread;

public class WorkObject { //두 스레드의 작업 내용을 동기화 메소드로 작성한 공유 객체
	public synchronized void methodA() {
		System.out.println("Thread의 methodA() 작업실행....");
		notify(); //실행중지되어 있는 ThreadB를 깨움.
		try {
			wait(); //ThreadA를 일시 정지 상태로 만듬.
		}catch(Exception ex) {}
	}
	
	public synchronized void methodB() {
		System.out.println("Thread의 methodB() 작업실행....");
		notify(); //실행중지되어 있는 ThreadA를 깨움.
		try {
			wait(); //ThreadB를 일시 정지 상태로 만듬.
		} catch(Exception ex) {}
	}
}
