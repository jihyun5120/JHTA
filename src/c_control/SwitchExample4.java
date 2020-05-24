package c_control;

public class SwitchExample4 {
	public SwitchExample4() {
		String position = "사장";
		String p = " ";
		
		switch(position) {
		case "사장" :
			p = "1500만원";
			break;
		case "이사" :
			p = "1000만원";
			break;
		case "과장" : 
			p = "700만원";
			break;
		case "부장" :
			p = "500만원";
			break;
		default :
			p = "300만원";
			break;
		}
		System.out.println(position + " : " + p);
	}
}

