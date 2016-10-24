
public class CurrentAccount extends BankAccount {
	private static final String ACCOUNT_TYPE = "Current";
	private static final Double WITHDRAW_LIMIT = 100.00;
	
	CurrentAccount(){
		super();
	}
	CurrentAccount(String name, Double accountBalance){
		super(name, accountBalance);
	}
	
	
}
