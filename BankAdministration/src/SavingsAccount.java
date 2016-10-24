
public class SavingsAccount extends BankAccount {
	private final static String ACCOUNT_TYPE = "Savings";
	private Double monthlyInterest;
	
	
	SavingsAccount(){
		super();
	}
	SavingsAccount(String name, Double accountBalance){
		super(name,accountBalance);
	}
	
	public void addInterest(){
		monthlyInterest = getAccountBalance() * getMonthlyInterest();
		Deposit(monthlyInterest);
	}
	
	public String accountInfo(){
		return ("Account Type: " + ACCOUNT_TYPE +
				"\nAccount ID: " + getAccountID() + 
				"\nAccount Holder: " + getName() +
				"\nAccount Balance: " + getAccountBalance() +
				"\nAccount Username: " + getUsername() + 
				"\nAccount Password: " + getPassword() + 
				"\nMonthly Interest Rate: " + getMonthlyInterest() +
				"\nDate Created: " + getDateCreated());
	}
}
