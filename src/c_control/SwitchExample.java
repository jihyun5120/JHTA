package c_control;

public class SwitchExample {
	public SwitchExample() {
		String a = " ";
		int num = 0;
		
		for(int i=0;i<500;i++) {
		    num = (int)(Math.random()*6)+1;

		    if(num<1 || num>6) {
		    	System.out.println("��ȣ�� ���� �߻�");
		    	System.exit(0); //���α׷� ���� ��ɾ�.(��±׸�!)
		    }
		    
		    switch(num) {
		    case 1 : 
			   a = "1���� ���Խ��ϴ�.";
			   break;
		    case 2 : 
			  a = "2���� ���Խ��ϴ�.";
			   break;
		    case 3 : 
			   a = "3���� ���Խ��ϴ�.";
		       break;
		    case 4 :
			   a = "4���� ���Խ��ϴ�.";
			   break;
		    case 5 :
		       a = "5���� ���Խ��ϴ�.";
			   break;
		    default:
			   a = "6���� ���Խ��ϴ�.";
			   break; 
		} // switch�� end
		    System.out.println(a);
		} // for�� end
	}
}
