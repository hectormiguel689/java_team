import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWIndow {

	protected JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private final String DEFAULTUSER = "hector689";
	private final String DEFAULTPASS = "123456";
	private static boolean isGranted = false;
	private static LoginWIndow window = new LoginWIndow();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		do{
			EventQueue.invokeLater(new Runnable() {
			
				public void run() {
					try {
						
						window.frame.setVisible(true);
						window.frame.setTitle("Login");
					
					} catch (Exception e) {
					
					}
				}
				});
			window.frame.setVisible(false);
		}while(isGranted);
		System.out.println("test");
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public LoginWIndow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrThisProgramIs = new JTextArea();
		txtrThisProgramIs.setBackground(Color.LIGHT_GRAY);
		txtrThisProgramIs.setLineWrap(true);
		txtrThisProgramIs.setEditable(false);
		txtrThisProgramIs.setText("This Program is Designed to Access and Modify Accounts Stored on the Accounts.db File.");
		txtrThisProgramIs.setBounds(77, 23, 290, 30);
		frame.getContentPane().add(txtrThisProgramIs);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setBounds(110, 95, 89, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(110, 122, 89, 15);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username..");
		txtUsername.setBounds(200, 93, 124, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password...");
		pwdPassword.setBounds(200, 120, 124, 19);
		frame.getContentPane().add(pwdPassword);
		
		JLabel Access = new JLabel("");
		Access.setBounds(200, 149, 66, 15);
		frame.getContentPane().add(Access);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = txtUsername.getText();
				String password = pwdPassword.getText();
				if(username.equals(DEFAULTUSER) && password.equals(DEFAULTPASS)){
					Access.setText("Access Granted!");
					
					
				}
				
			}
		});
		btnLogin.setBounds(33, 205, 114, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUsername.setText("");
				pwdPassword.setText("");
			}
		});
		btnClear.setBounds(172, 205, 114, 25);
		frame.getContentPane().add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(314, 205, 114, 25);
		frame.getContentPane().add(btnCancel);
	}
}
