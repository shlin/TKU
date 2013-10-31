package ST;

public class FlowExAccount {
	private double balance = 0;
	
	public FlowExAccount(double initialBalance){
		balance = initialBalance > 0 ? initialBalance : 0;
	}
	
	public void credit(double amount){
		balance += amount > 0 ? amount : 0;
	}
	
	public double debit(double amount){
		if(amount > balance){
			System.out.println("餘額不足");
			return 0;
		}
		
		balance -= amount > 0 ? amount : 0;
		return amount;
	}
	
	public double getBalance(){
		return balance;
	}
}
