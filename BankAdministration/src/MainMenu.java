import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class MainMenu {
	static MainMenu window;

	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainMenu();
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
	
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.CYAN);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWhatWouldYou = new JLabel("What Would you like to do:");
		lblWhatWouldYou.setBounds(128, 26, 191, 15);
		frame.getContentPane().add(lblWhatWouldYou);
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CreateAccount create = new CreateAccount();
				create.frame.setVisible(true);
			}
		});
		btnCreateNewAccount.setBounds(94, 67, 244, 25);
		frame.getContentPane().add(btnCreateNewAccount);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(94, 99, 244, 25);
		frame.getContentPane().add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(94, 131, 244, 25);
		frame.getContentPane().add(btnWithdraw);
		
		JButton btnUpdateAccountInformation = new JButton("Update Account Information");
		btnUpdateAccountInformation.setBounds(94, 161, 244, 25);
		frame.getContentPane().add(btnUpdateAccountInformation);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.frame.dispose();
				LoginWIndow login = new LoginWIndow();
				EventQueue.invokeLater(new Runnable() {
					
					public void run() {
						try {
							
							login.frame.setVisible(true);
							login.frame.setTitle("Login");
						
						} catch (Exception e) {
						
						}
					}
					});
				
			}
		
		});
		btnLogout.setBounds(34, 209, 114, 25);
		frame.getContentPane().add(btnLogout);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(284, 209, 114, 25);
		frame.getContentPane().add(btnExit);
	}
}
