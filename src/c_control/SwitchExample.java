package c_control;

public class SwitchExample {
	public SwitchExample() {
		String a = " ";
		int num = 0;
		
		for(int i=0;i<500;i++) {
		    num = (int)(Math.random()*6)+1;

		    if(num<1 || num>6) {
		    	System.out.println("번호에 오류 발생");
		    	System.exit(0); //프로그램 종료 명령어.(출력그만!)
		    }
		    
		    switch(num) {
		    case 1 : 
			   a = "1번이 나왔습니다.";
			   break;
		    case 2 : 
			  a = "2번이 나왔습니다.";
			   break;
		    case 3 : 
			   a = "3번이 나왔습니다.";
		       break;
		    case 4 :
			   a = "4번이 나왔습니다.";
			   break;
		    case 5 :
		       a = "5번이 나왔습니다.";
			   break;
		    default:
			   a = "6번이 나왔습니다.";
			   break; 
		} // switch문 end
		    System.out.println(a);
		} // for문 end
	}
}
