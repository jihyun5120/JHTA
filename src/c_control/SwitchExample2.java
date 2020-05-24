package c_control;

public class SwitchExample2 {
	public SwitchExample2() {
		int time = (int)(Math.random()*4)+8;
		System.out.println("[현재시간: " + time + "시]");
		
		switch(time) {
		case 8 :
			System.out.println("출근을 합니다.");
		case 9 :
			System.out.println("회의를 합니다.");
		case 10 :
			System.out.println("업무를 합니다.");
		default :
			System.out.println("외근을 나갑니다.");
		}
	}
	
}
