package c_control;

public class WhileExam3 {
	WhileExam3()throws Exception{ //throws Exception는 System.in.read(); 매소드의 예외처리 코드
		boolean run = true;
		int speed = 0;
		int keycode = 0;
		
		while(run) {
			if(keycode!=13 && keycode!=10) { // 엔터키를 누르지않으면.
				System.out.println("--------------------");
				System.out.println("1.증속 || 2.감속 || 3.중지");
				System.out.println("--------------------");
				System.out.print("선택 : ");
			}
			
			keycode = System.in.read();
			
			if(keycode == 49) {
				speed++;
				System.out.println("현재속도 = " + speed);
			} else if(keycode == 50) {
				speed--;
				System.out.println("현재속도 = " + speed);
			} else if(keycode == 51) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
