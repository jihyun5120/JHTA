package c_control;

public class IfExample {
	
	public static void main(String[] args) { //static�� �پ��ִ� ����� ���������, �پ����� ���� ������� instance��(��ü��, object��)
		IfExample obj = new IfExample(); //<--IfExample��(������)JVM�� �Ű������� ���� �����ڸ� �Ӵ�.(Ŭ������ ��ü�� = new �����ڸ�)
		int k = obj.type1(); //�޼ҵ� ȣ��.
//		System.out.println(k); //0 ���.
//		System.out.println(obj.type1()); //type1()�� �ִ� ���� ��� ���.
		
		String m = obj.type2();
		System.out.println(m);
		
		char c = obj.type3(); //������ �ʿ䰡 ������ ������ ��� ���.
		System.out.println(c);  
//		System.out.println(obj.type3()); ������ �ʿ䰡 ������ �׳� �ٷ� ���.
		
		obj.type4();
	}
	
	//if��
	int type1() { 
		int r = 0;
		int score = 93;
		
		if(score>=90) {
			System.out.println("������ 90�� �̻��Դϴ�.");
			System.out.println("����� A�Դϴ�.");
		}
		
		if(score<90) 
			System.out.println("������ 90�� �̸��Դϴ�.");
			System.out.println("����� B�Դϴ�."); //if���� �߰�ȣ�� ��� �׻� �����.
		
		return r; //return�� �� �޼ҵ� �� 1���� ��밡��. �Ǹ�������. return�� ���� �ڽ��� ȣ���� ������ �ǵ��ư�.
	}
	
	//null : �ּҰ� ����.
	String type2() { 
		String r = null; 
		int score = 89;
		
		if(score>=90) {
			r = "������ 90�̻��̴�.";
			r += "\nA����̴�.";
		} else {
			r = "������ 90�̸��̴�.";
			r += "\nB����̴�.";
		}
		
		return r;
	}
	
	/*
	 * ������ if-else if�� ����Ͽ� ������ ���Ͽ� r�� �����Ͻÿ�.(F��������)
	 */
	char type3() {
		char r = ' '; 
		int score = 77;
		
		if(score>=90) {
			r = 'A';
		} else if(score>=80) {
			r = 'B';
		} else if(score>=70) {
			r = 'C';
		} else if(score>=60) {
			r = 'D';
		} else {
			r = 'F';
		}
		
		return r;
    }
	
	/*
	 * ������ 0~100���� ���� 60�̻��̸� '�հ�', 60�̸��̸� '���հ�'�� ����ϰ�, ������ ���� ���̸� '��������'�� ����Ͻÿ�.
	 */
	void type4(){ //void���� ó���� ���� ��ȯ�� ���� ���ٴ� ������, return�� ������� �ʾƵ� ��.
		int score = 70;
		String result = "";
		
		if(score>=0 && score<=100) {
			if(score>=60) {
			result = "�հ�";
			} else {
			result = "���հ�";
			}
		} else {
			result = "��������";
		}
		System.out.println(result);
	}
}
