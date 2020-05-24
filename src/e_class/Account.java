package e_class;

public class Account {
	void deposit(int amt) {
		Bank.amount += amt;
		prn();
	}
	void withdraw(int amt) {
		Bank.amount -= amt;
		prn();
	}
	void prn() {
		System.out.println("ภÜพื : " + Bank.amount);
	}
}
