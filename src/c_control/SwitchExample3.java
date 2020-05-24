package c_control;

public class SwitchExample3 {
	public SwitchExample3() {
		char grade = 'a';
		String g = " ";
		
		switch(grade) {
		 case 'A' : 
		 case 'a' :
		    g = "우수회원입니다.";
		    break;
		 case 'B' :
		 case 'b' :
			g = "일반회원입니다.";
			break;
		 default :
			g = "손님입니다.";
			break;
		}
		System.out.println(g);
	}
}
