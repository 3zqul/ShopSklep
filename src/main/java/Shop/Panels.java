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
	private JButton catalogButton;
	private JButton accountButton;
	ImageIcon logo250 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo250.png");
	ImageIcon logo100 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo250.png");

	public Panels(){
		loginPanel();
	}

	public void loginPanel(){
		setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(359, 366, 448, 45);
		add(passwordField);

		emailField = new JTextField();
		emailField.setFont(new Font("Air Americana", Font.PLAIN, 20));
		emailField.setToolTipText("");
		emailField.setBounds(359, 285, 448, 45);
		add(emailField);
		emailField.setColumns(10);

		emailLabel = new JLabel("Email adress");
		emailLabel.setFont(new Font("Air Americana", Font.PLAIN, 25));
		emailLabel.setBounds(359, 254, 448, 32);
		add(emailLabel);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Air Americana", Font.PLAIN, 25));
		passwordLabel.setBounds(359, 336, 448, 32);
		add(passwordLabel);

		logInButton = new JButton("Sign In");
		logInButton.setFont(new Font("Air Americana", Font.PLAIN, 25));
		logInButton.setBounds(595, 418, 212, 45);
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				if(customer.readUserID("User", passwordField.getText(), emailField.getText())){
					System.out.println("elo");
					removeAll();
					catalogPanel();
					repaint();
					revalidate();
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
		createAccountButton.setFont(new Font("Air Americana", Font.PLAIN, 25));
		createAccountButton.setBounds(359, 418, 212, 45);
		createAccountButton.setBackground(Color.WHITE);
		createAccountButton.setOpaque(true);
		createAccountButton.setBorder(null);
		createAccountButton.setVerticalAlignment(JButton.CENTER);
		add(createAccountButton);

		logoLabel = new JLabel();
		logoLabel.setBounds(460, 10, 250, 250);
		logoLabel.setIcon(logo250);
		add(logoLabel);
	}

	public void catalogPanel(){
		setLayout(null);

		logoLabel = new JLabel();
		logoLabel.setBounds(542, 11, 100, 100);
		logoLabel.setIcon(logo100);
		add(logoLabel);

		catalogButton = new JButton("CATALOG");
		catalogButton.setFont(new Font("Air Americana", Font.PLAIN, 40));
		catalogButton.setBounds(7, 11, 530, 100);
		catalogButton.setBackground(Color.WHITE);
		catalogButton.setOpaque(true);
		catalogButton.setBorder(null);
		catalogButton.setFocusPainted(false);

		add(catalogButton);

		accountButton =new JButton("ACCOUNT");
		accountButton.setFont(new Font("Air Americana", Font.PLAIN, 40));
		accountButton.setBounds(646, 11, 530, 100);
		accountButton.setBackground(Color.WHITE);
		accountButton.setOpaque(true);
		accountButton.setBorder(null);
		accountButton.setFocusPainted(false);

		add(accountButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
