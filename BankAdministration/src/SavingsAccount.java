
public class SavingsAccount extends BankAccount {
	private final static String ACCOUNT_TYPE = "Savings";
	private Double monthlyInterest;
	
	
	SavingsAccount(){
		
	}
	SavingsAccount(String name, Double accountBalance){
		super(name,accountBalance);
	}
	
	public void addInterest(){
		monthlyInterest = getAccountBalance() * getMonthlyInterest();
		Deposit(monthlyInterest);
	}
}
