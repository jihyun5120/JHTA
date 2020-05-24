package a_begin;

public class CastingExample {
	public CastingExample(){ //���������� public�� ������ �ٸ� ��Ű�������� ���o, ����(default)�̸� ���� ��Ű�������� ���o
		//int --> char
		int a = 44034;
		char c = (char) a;
		System.out.println(a + " to char type: " + c);
		
		//long --> int
		long l = 500L;
		int b = (int) l;
		System.out.println(b);
		
		//double --> int
		double d = 3.14;
		int e = (int) d;
		System.out.println(d + " to int type: " + e);
		
//		double d2 = 10/3; ������ ������ ������ ���������� ���Ǿ� ��µȴ�.
		double d2 = 10/(double)3; //������ �Ǽ����� �־� �Ǽ��� ���. == double d2 = 10/(3*0.1);
		System.out.println(d2);
	}
	
	public static void main(String[]args) {
		new CastingExample();
	}
}
