package b_operator;

public class Exercise04 {
	int pencils = 534;
	int students = 30;
	int ps;
	int pl;
	
	Exercise04(){
	//�л� �� ���� ������ ���� ��
		ps = pencils/students;
		System.out.println("�л� �� ���� ������ ���� �� : " + ps);
		
	//���� ���� ��	
		pl = pencils%students;
		System.out.println("���� ���� �� : " + pl);
	}
	
	public static void main(String[] args) {
		new Exercise04();
	}
}
