/*
 * ����1) Exam1.java
 * 1. ��� ó���� �����ڸ� ����Ͽ� �ذ�.
 * 2. ����, �ּ�, ����ó�� ���ڿ��� �߻��Ѵ�. ������ �����͸� name, address, phone�� ����.
 * 3. ������ ���������� �߻��Ͽ� ���� kor, eng, mat�� ������.
 * 4. ����� ������ ����Ͽ� ����, ����� tot, avg�� ������.
 * 5. if~else if���� ����Ͽ� ��հ��� ����Ͽ� ������ ���ؼ� ������ ���� grade�� ����.
 * 6. ó���� ��� ������ ǥ�� ��� ��ġ�� ���.
 * [��°��]
 * ----------------------
 * ���� ó�� ���
 * ----------------------
 * ���� : xxx
 * �ּ� : xxx
 * ����ó : xxx
 * ���� : xx
 * ���� : xx
 * ���� : xx
 * ���� : xx
 * ��� : xx
 * ���� : x
 * ----------------------
 */

package c_control;

public class Exam1 {
	Exam1(){
		String name = "������";
		String address = "����� ���빮�� ��ε�";
		String phone = "010-8793-0000";
		int kor = 100;
		int eng = 97;
		int mat = 86;
		int tot = kor+eng+mat;
		double avg = (double)tot/3;
		char grade = ' ';
		
		if(avg>=90)      { grade = 'A'; } 
		else if(avg>=80) { grade = 'B'; } 
		else if(avg>=70) { grade = 'C'; } 
		else if(avg>=60) { grade = 'D'; } 
		else             { grade = 'F'; }
		
		System.out.println("------------------------");
		System.out.println("���� ó�� ���");
		System.out.println("------------------------");
		System.out.println("���� : " + name + "\n�ּ� : " + address + "\n����ó : " + phone);
		System.out.println("���� : " + kor + "\n���� : " + eng + "\n���� : " + mat);
		System.out.println("���� : " + tot + "\n��� : " + avg + "\n���� : " + grade);
		System.out.println("------------------------");
		
//		 String msg = "���� : " + name;
//		 msg += "\n�ּ� : " + address;
//		 msg += "\n����ó : " + phone;
//		 msg += "\n���� : " + kor;
//		 msg += "\n���� : " + eng;
//		 msg += "\n���� : " + mat;
//		 msg += "\n���� : " + tot;
//		 msg += "\n��� : " + avg;
//		 msg += "\n���� : " + grade;
//		 System.out.println(msg);
		
	}
	
	public static void main(String[] aegs) {
		new Exam1();
	}
}
