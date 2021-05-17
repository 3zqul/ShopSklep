package Shop;

import Shop.CustomerPackage.Customer;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Panels extends JPanel implements ActionListener{
	private JPasswordField passwordField;
	private JTextField emailField;
	private JTextField nameField;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JButton logInButton;
	private JButton registerButton;
	private JButton createAccountButton;
	private JButton backButton;
	private JLabel logoLabel;
	private JLabel nameLabel;
	private JLabel selectSizeLabel;
	private JButton catalogButton;
	private JButton accountButton;
	private DefaultListModel<String> sizes;
	private JList<String> list;
	private DefaultListModel<String> model;
	private Customer customer = new Customer();

	ImageIcon logo250 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo250.png");
	ImageIcon logo150 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo150.png");
	ImageIcon logo100 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo100.png");

	public Panels(){
		loginPanel();
	}

	public void loginPanel(){
		setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(368, 366, 448, 45);
		add(passwordField);

		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailField.setToolTipText("");
		emailField.setBounds(368, 285, 448, 45);
		add(emailField);
		emailField.setColumns(10);

		emailLabel = new JLabel("Email adress");
		emailLabel.setFont(new Font("Air Americana", Font.PLAIN, 25));
		emailLabel.setBounds(368, 254, 448, 32);
		add(emailLabel);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Air Americana", Font.PLAIN, 25));
		passwordLabel.setBounds(368, 336, 448, 32);
		add(passwordLabel);

		logInButton = new JButton("Sign In");
		logInButton.setFont(new Font("Air Americana", Font.PLAIN, 25));
		logInButton.setBounds(604, 418, 212, 45);
		var actionListenerLog = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(customer.signIn(emailField.getText(), passwordField.getText()).equals("c")){
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
		logInButton.addActionListener(actionListenerLog);
		logInButton.setBackground(Color.WHITE);
		logInButton.setOpaque(true);
		logInButton.setBorder(null);
		logInButton.setFocusPainted(false);
		add(logInButton);

		createAccountButton = new JButton("Create Account");
		createAccountButton.setFont(new Font("Air Americana", Font.PLAIN, 25));
		createAccountButton.setBounds(368, 418, 212, 45);
		createAccountButton.setBackground(Color.WHITE);
		var actionListenerCreate = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				registerPanel();
				repaint();
				revalidate();
			}
		};
		createAccountButton.addActionListener(actionListenerCreate);
		createAccountButton.setOpaque(true);
		createAccountButton.setBorder(null);
		createAccountButton.setFocusPainted(false);

		add(createAccountButton);

		logoLabel = new JLabel();
		logoLabel.setBounds(469, 10, 250, 250);
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

	public void accountPanel(){
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

		model = new DefaultListModel<>();

		model.addElement("Account");
		model.addElement("Offers");
		model.addElement("Orders");
		model.addElement("Edit Account");

		list = new JList<>(model);
		list.setValueIsAdjusting(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Air Americana", Font.PLAIN, 25));
		list.setBounds(7,122, 119,542);
		list.setFixedCellHeight(40);
		list.setSelectionBackground(Color.LIGHT_GRAY);
		list.setBorder(null);
		list.getSelectionModel().addListSelectionListener(e ->{
			switch( list.getSelectedIndex()){
				case 0:
					changeAccountPanel("Account");

			}

		});

		add(list);
	}

	public void changeAccountPanel(String panel){
		if(panel.equals("Account")){


		}
	}

	public void registerPanel(){
		setLayout(null);

		logoLabel = new JLabel();
		logoLabel.setBounds(517, 25, 150, 150);
		logoLabel.setIcon(logo150);
		add(logoLabel);

		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailField.setToolTipText("");
		emailField.setBounds(368, 204, 448, 45);
		add(emailField);
		emailField.setColumns(10);

		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameField.setColumns(10);
		nameField.setBounds(368, 366, 448, 45);
		add(nameField);

		passwordField = new JPasswordField();
		passwordField.setBounds(368, 285, 448, 45);
		add(passwordField);

		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Air Americana", Font.PLAIN, 25));
		nameLabel.setBounds(368, 334, 448, 32);
		add(nameLabel);


		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Air Americana", Font.PLAIN, 25));
		passwordLabel.setBounds(368, 254, 448, 32);
		add(passwordLabel);

		emailLabel = new JLabel("Email adress");
		emailLabel.setFont(new Font("Air Americana", Font.PLAIN, 25));
		emailLabel.setBounds(368, 173, 448, 32);
		add(emailLabel);


		sizes = new DefaultListModel<>();
		sizes.addElement("38");
		sizes.addElement("39");
		sizes.addElement("40");
		sizes.addElement("41");
		sizes.addElement("42");
		sizes.addElement("43");
		sizes.addElement("44");
		sizes.addElement("45");

		JList<String> sizeList = new JList<>(sizes);
		sizeList.setValueIsAdjusting(true);
		sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sizeList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sizeList.setBounds(528,423, 42,168);
		add(sizeList);

		selectSizeLabel = new JLabel("Select shoe size");
		selectSizeLabel.setFont(new Font("Air Americana", Font.PLAIN, 25));
		selectSizeLabel.setBounds(368, 415, 221, 32);
		add(selectSizeLabel);

		registerButton = new JButton("Sign Up");
		registerButton.setFont(new Font("Air Americana", Font.PLAIN, 25));
		registerButton.setBounds(605, 418, 212, 45);
		registerButton.setBackground(Color.WHITE);
		var actionListenerRegister = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sizeList.getSelectedIndex()!=-1 && emailField.getText()!= null && nameField.getText()!=null && passwordField.getText()!=null) {
					if (customer.signUp(emailField.getText(), nameField.getText(), passwordField.getText(), Integer.parseInt(sizes.getElementAt(sizeList.getSelectedIndex())))) {
						System.out.println("essa");
						removeAll();
						loginPanel();
						repaint();
						revalidate();
					}
				}else{
					System.out.println("Pusto");
				}
			}
		};
		registerButton.addActionListener(actionListenerRegister);
		registerButton.setOpaque(true);
		registerButton.setBorder(null);
		registerButton.setFocusPainted(false);
		add(registerButton);

		backButton = new JButton("Back");
		backButton.setFont(new Font("Air Americana", Font.PLAIN, 25));
		backButton.setBounds(605, 470, 212, 45);
		backButton.setBackground(Color.WHITE);
		var actionListenerBack = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				loginPanel();
				repaint();
				revalidate();
			}
		};
		backButton.addActionListener(actionListenerBack);
		backButton.setOpaque(true);
		backButton.setBorder(null);
		backButton.setFocusPainted(false);
		add(backButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
