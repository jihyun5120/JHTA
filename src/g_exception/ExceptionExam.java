package g_exception;

public class ExceptionExam {

	public static void main(String[] args) {
		//NullPointerException
		String data = "";
		try {
			System.out.println(data.toString());		
			System.out.println("������ ���� ��� �����.");
		} catch(NullPointerException ex) { //asending���·� �����ؾ���(���� �ź��� ū ������)
			System.out.println("Null Pointer Error!");
			
			System.out.println(ex.toString());
			ex.printStackTrace(); // �ý����� ������ �ִ� ���� �޼����� �ֿܼ� ���.
			
		} catch(Exception ex2) { //NullPointerException���� ������ ����(Exception�� ���� ū ����).
			System.out.println("���ڿ� ���� data�� ���� ����.");
		} finally { // ������ ������� ������ ����.
			System.out.println("�����߻��� ������� ������ ����.");
		}
		
		//ArrayIndexOutOfBoundsException(÷�ڿ���)
		int[] s = {1, 2, 3};
		try {
			for(int i=0; i<=3; i++) {
				System.out.println(s[i]);			
			}
		} catch(ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
//			System.out.println("�ε��������� �ʰ���.");
		}
		
		//NumberFormatException
		try {
			data = "123a";
			int su = Integer.parseInt(data);
		} catch(NumberFormatException ex) {
			ex.printStackTrace();
//			System.out.println("���ڷ� ��ȯ�� �� ���� ���ڰ� ����.");
		} finally {
			System.out.println("���� ó���� �����.");
		}
		
		//ClassCastException
		try {
			Car myCar = new Car();
			SportsCar c = (SportsCar)myCar; //�θ� ����� �ڽ����� ĳ���� �� ��X.			
		} catch(ClassCastException ex) {
			ex.printStackTrace();
//			System.out.println("Ÿ�Ժ�ȯ�� �� �� ����.");
		} finally {
			System.out.println("��~~~");
		}
	}
}
