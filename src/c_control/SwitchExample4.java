package c_control;

public class SwitchExample4 {
	public SwitchExample4() {
		String position = "����";
		String p = " ";
		
		switch(position) {
		case "����" :
			p = "1500����";
			break;
		case "�̻�" :
			p = "1000����";
			break;
		case "����" : 
			p = "700����";
			break;
		case "����" :
			p = "500����";
			break;
		default :
			p = "300����";
			break;
		}
		System.out.println(position + " : " + p);
	}
}

