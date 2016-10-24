import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Bank {
	protected static ArrayList<BankAccount> bankAccounts =  new ArrayList<BankAccount>();
	private Integer REGULAR = 1;
	private Integer SAVINGS = 2;
	protected Boolean error;
	
	public void openAccount(Integer accountType, String name, Double initBalance){
		if(accountType == REGULAR){
			bankAccounts.add(new BankAccount(name,initBalance));
		}
		else if(accountType == SAVINGS){
			bankAccounts.add(new SavingsAccount(name, initBalance));
		}
		else
			bankAccounts.add(new CurrentAccount(name, initBalance));
	}
	public void closeAccount(Integer accountID, String user, String pwd){
		Boolean removed = false;
		for (int i = 0; i < bankAccounts.size(); i++){
			if(bankAccounts.get(i).getUsername().equals(user)
					&& bankAccounts.get(i).getPassword().equals(pwd)
					&& bankAccounts.get(i).getAccountID() == accountID){
				bankAccounts.remove(i);
				removed = true;
			}
		}
		if(!removed){
			error = true;
			JOptionPane.showConfirmDialog(null, "No account Matched Provided Information, No Accounts Removed!", "No Accounts Removed",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public void updateAccounts(){
		for (int i = 0; i < bankAccounts.size();i++){
			if(bankAccounts.get(i) instanceof SavingsAccount){
				((SavingsAccount) bankAccounts.get(i)).addInterest();
			}
			else if(bankAccounts.get(i) instanceof CurrentAccount){
				if(bankAccounts.get(i).getAccountBalance() < 0){
					JOptionPane.showConfirmDialog(null, "Account: "  + bankAccounts.get(i).getAccountID() + " belonging to " + bankAccounts.get(i).getName()
							+ " is currently overdrafted. Current Account Balance: " + bankAccounts.get(i).getAccountBalance(),
							"Account Overfrafted", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	public String accountInfo(Integer Index){
			return ("Account Type: " + bankAccounts.get(Index).getAccountType() +
					"\nAccount ID: " + bankAccounts.get(Index).getAccountID() + 
					"\nAccount Holder: " + bankAccounts.get(Index).getName() +
					"\nAccount Balance: " + bankAccounts.get(Index).getAccountBalance() +
					"\nAccount Username: " + bankAccounts.get(Index).getUsername() + 
					"\nAccount Password: " + bankAccounts.get(Index).getPassword() + 
					"\nMonthly Interest Rate: " + bankAccounts.get(Index).getMonthlyInterest() +
					"\nDate Created: " + bankAccounts.get(Index).getDateCreated());
		}
	public String accountInfo(){
		String accountsInfo = "";
		for (int i = 0; i < bankAccounts.size(); i++){
			accountsInfo += accountInfo(i) + "\n";
		}
		return accountsInfo;
		
	}
	public Boolean getError() {
		return error;
	}
	
	
}
