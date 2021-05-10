package Shop;

import Shop.*;
import Shop.CustomerPackage.Customer;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Panels extends JPanel implements ActionListener{
	private JPasswordField passwordField;
	private JTextField emailField;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JButton logInButton;
	private JButton createAccountButton;
	private JLabel logoLabel;
	ImageIcon logo = new ImageIcon("C:\\Users\\bigos\\IdeaProjects\\ShopSklep\\src\\main\\java\\Images\\logo250");

	public Panels(){
		loginPanel();
	}

	public void loginPanel(){
		setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(359, 361, 448, 45);
		add(passwordField);

		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailField.setToolTipText("");
		emailField.setBounds(359, 285, 448, 45);
		add(emailField);
		emailField.setColumns(10);

		emailLabel = new JLabel("Email adress");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailLabel.setBounds(359, 254, 448, 32);
		add(emailLabel);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLabel.setBounds(359, 329, 448, 32);
		add(passwordLabel);

		logInButton = new JButton("Sign In");
		logInButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logInButton.setBounds(595, 411, 212, 45);
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				if(customer.readUserID("User", passwordField.getText(), emailField.getText())){
					System.out.println("elo");
				}else{
					System.out.println("dupa");
				}
			}
		};
		logInButton.addActionListener(actionListener);
		logInButton.setBackground(Color.WHITE);
		logInButton.setOpaque(true);
		logInButton.setBorder(null);
		add(logInButton);

		createAccountButton = new JButton("Create Account");
		createAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createAccountButton.setBounds(359, 411, 212, 45);
		createAccountButton.setBackground(Color.WHITE);
		createAccountButton.setOpaque(true);
		createAccountButton.setBorder(null);
		add(createAccountButton);

		logoLabel = new JLabel();
		logoLabel.setBounds(520, 90, 250, 250);
		logoLabel.setIcon(logo);
		add(logoLabel);
	}

	public void catalogPanel(){

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
