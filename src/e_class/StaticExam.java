package e_class;

public class StaticExam {
	
	public static void main(String[] args) {
	Account p = new Account();
	p.prn();
	p.withdraw(500);
	
	Account m = new Account();
	m.prn();
	p.withdraw(1000);
	
	p.prn();
	
	Account c1 = new Account();
	c1.prn();
	c1.deposit(5000);
	
	p.prn();
	}
}
