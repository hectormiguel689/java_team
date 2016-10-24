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

public class CreateAccount {

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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton regular = new JRadioButton("Regular");
		regular.setBounds(0, 0, 145, 55);
		frame.getContentPane().add(regular);
		
		JRadioButton savings = new JRadioButton("Savings");
		savings.setBounds(150, 0, 145, 55);
		frame.getContentPane().add(savings);
		
		JRadioButton current = new JRadioButton("Current");
		current.setBounds(300, 0, 150, 55);
		frame.getContentPane().add(current);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(79, 63, 66, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblInitialBalance = new JLabel("Initial Balance:");
		lblInitialBalance.setBounds(21, 103, 124, 15);
		frame.getContentPane().add(lblInitialBalance);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(38, 177, 145, 25);
		frame.getContentPane().add(createAccount);
		
		JButton btnCancel = new JButton("Cancel");
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
