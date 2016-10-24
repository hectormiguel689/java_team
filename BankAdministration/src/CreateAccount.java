import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class CreateAccount extends Bank {

	protected JFrame frame;
	private JTextField name;
	private JTextField initBalance;
	static CreateAccount window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new CreateAccount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton regular = new JRadioButton("Regular");
		regular.setBackground(Color.LIGHT_GRAY);
		regular.setBounds(8, 0, 137, 55);
		frame.getContentPane().add(regular);
		
		JRadioButton savings = new JRadioButton("Savings");
		savings.setBackground(Color.LIGHT_GRAY);
		savings.setBounds(150, 0, 145, 55);
		frame.getContentPane().add(savings);
		
		JRadioButton current = new JRadioButton("Current");
		current.setBackground(Color.LIGHT_GRAY);
		current.setBounds(300, 0, 150, 55);
		frame.getContentPane().add(current);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(79, 63, 66, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblInitialBalance = new JLabel("Initial Balance:");
		lblInitialBalance.setBounds(21, 103, 124, 15);
		frame.getContentPane().add(lblInitialBalance);
		
		JTextArea errorMessage = new JTextArea();
		errorMessage.hide();
		errorMessage.setForeground(Color.RED);
		errorMessage.setBackground(Color.LIGHT_GRAY);
		errorMessage.setLineWrap(true);
		errorMessage.setEditable(false);
		errorMessage.setText("Please make sure you selected an account type, entered your name, and an initial balance");
		errorMessage.setBounds(42, 132, 373, 33);
		frame.getContentPane().add(errorMessage);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Double startBalance = null; 
				if(regular.isSelected()){
					try{
					startBalance = Double.parseDouble(initBalance.getText());
					}
					catch(NumberFormatException exception){
						errorMessage.show();
						errorMessage.setText("The Input for Initial Balance is not Correct, Please enter a Number for Initial Balance.");
						initBalance.setText("");
					}
					if(name.getText().isEmpty()){
						errorMessage.show();
						errorMessage.setText("Please Enter A Valid Name!");
					}
					
					else{
						Bank.bankAccounts.add(new BankAccount(name.getText(),startBalance));
					}
				}
				else if(savings.isSelected()){
					try{
						startBalance = Double.parseDouble(initBalance.getText());
						}
						catch(NumberFormatException exception){
							errorMessage.show();
							errorMessage.setText("The Input for Initial Balance is not Correct, Please enter a Number for Initial Balance.");
							initBalance.setText("");
						}
						if(name.getText().isEmpty()){
							errorMessage.show();
							errorMessage.setText("Please Enter A Valid Name!");
						}
						
						else{
							Bank.bankAccounts.add(new SavingsAccount(name.getText(),startBalance));
						}
				}
				else if(current.isSelected()){
					try{
						startBalance = Double.parseDouble(initBalance.getText());
						}
						catch(NumberFormatException exception){
							errorMessage.show();
							errorMessage.setText("The Input for Initial Balance is not Correct, Please enter a Number for Initial Balance.");
							initBalance.setText("");
						}
						if(name.getText().isEmpty()){
							errorMessage.show();
							errorMessage.setText("Please Enter A Valid Name!");
						}
						
						else{
							Bank.bankAccounts.add(new CurrentAccount(name.getText(),startBalance));
						}
				}
				else{
					errorMessage.show();
				}
						
			}
			
		});
		createAccount.setBounds(38, 177, 145, 25);
		frame.getContentPane().add(createAccount);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.frame.dispose();
			}
		});
		btnCancel.setBounds(301, 177, 114, 25);
		frame.getContentPane().add(btnCancel);
		
		name = new JTextField();
		name.setText("Enter your name...");
		name.setBounds(150, 61, 288, 19);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		initBalance = new JTextField();
		initBalance.setText("Intial Account Balance...");
		initBalance.setBounds(150, 101, 288, 19);
		frame.getContentPane().add(initBalance);
		initBalance.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
				initBalance.setText("");
				savings.setSelected(false);
				current.setSelected(false);
				regular.setSelected(false);
			}
		});
		btnClear.setBounds(181, 227, 114, 25);
		frame.getContentPane().add(btnClear);
				
	}
}
