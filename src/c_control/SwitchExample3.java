package c_control;

public class SwitchExample3 {
	public SwitchExample3() {
		char grade = 'a';
		String g = " ";
		
		switch(grade) {
		 case 'A' : 
		 case 'a' :
		    g = "���ȸ���Դϴ�.";
		    break;
		 case 'B' :
		 case 'b' :
			g = "�Ϲ�ȸ���Դϴ�.";
			break;
		 default :
			g = "�մ��Դϴ�.";
			break;
		}
		System.out.println(g);
	}
}
