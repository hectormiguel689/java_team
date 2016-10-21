import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginDialog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private String DEFAULTUSER = "hector689";
	private String DEFAULTPASS = "123456";
	private boolean isGranted = false;
	static LoginDialog frame = new LoginDialog();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JTextArea txtrThisProgramIs = new JTextArea();
		txtrThisProgramIs.setEditable(false);
		txtrThisProgramIs.setLineWrap(true);
		txtrThisProgramIs.setText("This Program is Used to Access and Manage Accounts Stored in the Accounts.db file.");
		txtrThisProgramIs.setBounds(82, 12, 286, 30);
		getContentPane().add(txtrThisProgramIs);
		
		JLabel lblPle = new JLabel("Please Login");
		lblPle.setBounds(159, 54, 113, 15);
		getContentPane().add(lblPle);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setBounds(70, 96, 101, 15);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(70, 123, 89, 15);
		getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username...");
		txtUsername.setBounds(160, 94, 124, 19);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password..");
		pwdPassword.setBounds(159, 121, 125, 19);
		getContentPane().add(pwdPassword);
		
		
		JLabel accessGranted = new JLabel("");
		accessGranted.setBounds(154, 150, 130, 15);
		getContentPane().add(accessGranted);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = txtUsername.getText();
				String password = pwdPassword.getText();
			if(username.equals(DEFAULTUSER) && password.equals(DEFAULTPASS)){
				accessGranted.setText("ACCESS GRANTED!");
				isGranted = true;
			}
			else{
				accessGranted.setText("ACCESS DENIED!");
				isGranted = false;
			}
				
			}
		});
		btnLogin.setBounds(82, 188, 114, 25);
		getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(219, 188, 114, 25);
		getContentPane().add(btnCancel);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUsername.setText("");
				pwdPassword.setText("");
			}
		});
		btnClear.setBounds(158, 225, 114, 25);
		getContentPane().add(btnClear);
	
	}

	public boolean isGranted() {
		return isGranted;
	}
	
}
