import java.util.Date;

import javax.swing.JOptionPane;

public class BankAccount {
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
	
	
	
}
