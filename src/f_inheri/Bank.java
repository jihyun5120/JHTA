package f_inheri;

public class Bank {
	static Account1[] ac;
	static int count; //���� ��
	
	static{
		ac = new Account1[100];
		Account1 a = new Account1("ȫ", "111-111", 5000);
		ac[0] = a;
		
		a = new Account1("��", "222-222", 10000);
		ac[1] = a;
		
		a = new Account1("��", "333-333", 50000);
		ac[2] = a;
		
		count = 3; //static�� �ʱ�ȭ�� 1���̶� ����� �� �ٽ� 0���� ���ư���X.
	}
}
