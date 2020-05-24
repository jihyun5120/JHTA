package f_inheri;

public class Bank {
	static Account1[] ac;
	static int count; //계좌 수
	
	static{
		ac = new Account1[100];
		Account1 a = new Account1("홍", "111-111", 5000);
		ac[0] = a;
		
		a = new Account1("김", "222-222", 10000);
		ac[1] = a;
		
		a = new Account1("이", "333-333", 50000);
		ac[2] = a;
		
		count = 3; //static은 초기화가 1번이라 실행된 뒤 다시 0으로 돌아가지X.
	}
}
