package c_control;

public class ForExam1 {
	ForExam1(){
		int sum = 0;
		for(int i=1 ; i<=100 ; i++) { //1~100������ ��. Ȧ����+ : (i=1;i<=100;i+=2), ¦����+ : (i=2;i<=100;i+=2).
			sum = sum + i; //sum += i
			System.out.println(i + " ������ �� : " + sum); //���Ѱ����� �� ���� ���� ��.
		}
		System.out.println("1~100������ �� : " + sum); //�������� �� ���Ѱ��� ���� ���� ��.
	}
}
