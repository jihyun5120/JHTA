package z_exam;

public class Child extends MyClass{
	//�������� ����ϴ� ���� : ���������� �ڽ�Ŭ������ �Ļ��Ǿ� �����Ǿ��� �� �θ�Ÿ���� �Ű������� ���� �޼ҵ� �ϳ������� ��� �ڽ�Ŭ������
	//���޹޾� ����ϱ� ���ؼ�.
	public MyClass method1(MyClass mc) {
		MyClass m = new MyClass();
		return m;
	}
	
	public Child method2(Child c) {
		Child myC = new Child();
		return myC;
	}
	
	public static void main(String[] args) {
		MyClass mc = new Child(); //�������� ���� �⺻���� ����.
		Child c = (Child)mc;
		
		Child c2 = new Child(); //c�� ������ �ִ� �Ͱ� �Ȱ��� �������� ��������X.
	
		c2.method1(mc); //MyClass mc = mc; ,  MyClass mc = c2;(O) �θ�Ÿ�Կ��� �ڽ�Ÿ���� ������ ���� ��O.
						//MyClass mc=mc; -> MyClass mc = new Child(); : mc��  new Child()�� �������.
		c2.method1(c);  //MyClass mc=c; -> MyClass mc = new Child(); : �ᱹ�� new Child()�� �������.
					    //method1�� �Ű����� Ÿ���� MyClass�̱� ������ MyClass�� ���� mc�� c ��밡��.
		
		//c2.method2(mc); //Child c = mc;(X) �ڽ�Ÿ���� �Ű������� �θ�Ÿ���� ������ ���� ��X.
		c2.method2(c);
	}
}
