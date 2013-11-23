package ItorToComputers.Midtern;

class Account {
	private String name;
	private double balance;

	public Account(String name, double initialBalance) {
		this.name = name;
		balance = initialBalance;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public void save(double amount) {
		if (amount >= 0)
			balance = balance + amount;
	}

	public double withdraw(double amount) {
		if (amount <= balance) {
			balance = balance - amount;
			return amount;
		} else {
			System.out.printf("%s,您的餘額不足\n", getName());
			return 0;
		}
	}
}

public class M602630096_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc1 = new Account("張三", 1000);
		System.out.printf("%s,您的餘額：%.0f\n", acc1.getName(), acc1.getBalance());
		
		acc1.save(500);
		System.out.printf("%s,您的餘額：%.0f\n", acc1.getName(), acc1.getBalance());
		
		System.out.printf("%s,取款：%.0f\n", acc1.getName(), acc1.withdraw(1200));
		System.out.printf("%s,您的餘額：%.0f\n", acc1.getName(), acc1.getBalance());
		
		System.out.printf("%s,取款：%.0f\n", acc1.getName(), acc1.withdraw(500));
		System.out.printf("%s,您的餘額：%.0f\n", acc1.getName(), acc1.getBalance());
	}

}