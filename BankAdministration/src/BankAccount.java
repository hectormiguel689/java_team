import java.util.Date;

import javax.swing.JOptionPane;

public class BankAccount {
	private static final String ACCOUNT_TYPE = "Regular";
	private String name;
	private Integer accountID;
	private Double accountBalance;
	private Date dateCreated;
	private String username;
	private String Password;
	private static Double annualInterestRate;
	private Boolean isError;
	
	BankAccount(){
		JOptionPane.showConfirmDialog(null, "You can not create an Account without account Holder Information.","ERROR!",JOptionPane.OK_OPTION);
		isError = true;
	}
	BankAccount(String name){
		this(name,0.0);
	}
	BankAccount(String name, Double accountBalance){
		this.name           = name;
		this.accountBalance = accountBalance;
		this.accountID      = (10000000 + (int)(Math.random() * 9999999));
		this.dateCreated    = new Date();
		annualInterestRate  = Math.random() * 30.99;
		this.username 		= generateUsername(this.name);
		this.Password 		= generatePassword();
		this.isError 		= false;
	}
	private String generatePassword() {
		String password = "";
		for (int i = 0; i < 8 ; i++){
			int randomNumber = (int)(Math.random() * 10);
			if(randomNumber % 2 == 0){
				String tempChar = ""+(char)(97 + (int)(Math.random() * 123));
				password += tempChar;
			}
			else{
				String tempChar = ""+(char)(65 + (int)(Math.random() * 91));
				password += tempChar;
			}
		}
		
		return password;
	}
	
	private String generateUsername(String name2) {
		// TODO Auto-generated method stub
		String username = name2;
		for (int i = 0; i < 2 ; i++){
			int randomNumber = (int)(Math.random() * 10);
			if(randomNumber % 2 == 0){
				String tempChar = ""+(char)(97 + (int)(Math.random() * 123));
				username += tempChar;
			}
			else{
				String tempChar = ""+(char)(65 + (int)(Math.random() * 91));
				username += tempChar;
			}
		}
		
		return username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public static Double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public static void setAnnualInterestRate(Double annualInterestRate) {
		BankAccount.annualInterestRate = annualInterestRate;
	}
	public Integer getAccountID() {
		return accountID;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return Password;
	}
	public Boolean getIsError() {
		return isError;
	}
	
	public Double getMonthlyInterest(){
		return annualInterestRate / 12;
	}
	public String getAccountType(){
		return ACCOUNT_TYPE;
	}
	public void withdraw(Double amount){
		if(amount < 1){
			isError = true;
			JOptionPane.showConfirmDialog(null, "WithDraw Amount must be Greater than 0","ERROR",JOptionPane.OK_OPTION);
			
		}
		else if(this.accountBalance < amount){
			isError = true;
			JOptionPane.showConfirmDialog(null,"Insufficient Founds in Account " + accountID + "\nCurrent Balance: " + accountBalance,"ERROR",JOptionPane.OK_OPTION);
		}
		else
			accountBalance -= amount;
	}
	public void Deposit(Double amount){
		if(amount < 1){
			isError = true;
			JOptionPane.showConfirmDialog(null, "Deposit Amount must be Greater than 0","ERROR",JOptionPane.OK_OPTION);
		}
		else{
			accountBalance += amount;
		}
	}
	public String accountInfo(){
		return ("Account Type: " + ACCOUNT_TYPE +
				"\nAccount ID: " + accountID + 
				"\nAccount Holder: " + name +
				"\nAccount Balance: " + accountBalance +
				"\nAccount Username: " + username + 
				"\nAccount Password: " + Password + 
				"\nMonthly Interest Rate: " + getMonthlyInterest() +
				"\nDate Created: " + dateCreated);
	}
}
