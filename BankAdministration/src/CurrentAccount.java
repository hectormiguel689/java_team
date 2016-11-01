import javax.swing.JOptionPane;

public class CurrentAccount extends BankAccount {
	private static final String ACCOUNT_TYPE = "Current";
	private static final Double WITHDRAW_LIMIT = 100.00;
	
	
	CurrentAccount(){
		super();
	}
	CurrentAccount(String name, Double accountBalance){
		super(name, accountBalance);
	}
	
	public void withdraw(Double amount){
		if(amount < 1){
			this.isError = true;
			JOptionPane.showConfirmDialog(null, "Withdraw Amount must be greater than 0", "ERROR", JOptionPane.OK_OPTION);
		}
		else if((getAccountBalance() + WITHDRAW_LIMIT) < amount){
			isError = true;
			JOptionPane.showConfirmDialog(null,"Insufficient Founds in Account " + getAccountID() + "\nCurrent Balance: " + getAccountBalance()
			+ "WITHDRAW LIMIT: " + (getAccountBalance() + WITHDRAW_LIMIT),"ERROR",JOptionPane.OK_OPTION);
		}
		else{
			setAccountBalance(getAccountBalance() - amount);
		}
	}
	public String getAccountType(){
		return ACCOUNT_TYPE;
	}
	
}
