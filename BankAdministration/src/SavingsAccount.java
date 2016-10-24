
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
	public String getAccountType(){
		return ACCOUNT_TYPE;
	}
}
