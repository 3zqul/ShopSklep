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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	private JLabel accountLabel;
	private JList<String> sizeList;
	private DefaultListModel<String> sizes;
	private Customer customer = new Customer();
	private JList<String> list;
	private DefaultListModel<String> model;
	private JLabel backgroundLabel;
	private JLabel cardLabel;
	private JLabel accountNoLabel;
	private JLabel streetLabel;
	private JLabel cityLabel;
	private JLabel confirmLabel;
	private JLabel postalCodeLabel;
	private JLabel countryLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	private JLabel CvvLabel;
	private JPasswordField confirmPasswordField;
	private JTextField accountNoField;
	private JTextField streetField ;
	private JTextField cityField ;
	private JTextField postalCodeField;
	private JTextField countryField ;
	private JTextField cardField ;
	private JTextField monthField ;
	private JTextField yearField ;
	private JTextField CvvField ;
	private JButton confirmButton;
	private JFrame frame;







	ImageIcon background = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\background.png");
	ImageIcon logo250 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo250.png");
	ImageIcon logo150 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo150.png");
	ImageIcon logo100 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo100.png");

	public Panels(JFrame frame){
		this.frame= frame;
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
		ActionListener actionListenerLog = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(customer.signIn(passwordField.getText(), emailField.getText()).equals("c")){
					System.out.println(customer.userID);
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
		ActionListener actionListenerCreate = new ActionListener() {
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



	public void registerPanel(){

		setBackground(Color.WHITE);


		setLayout(null);
		logoLabel = new JLabel();
		logoLabel.setBounds(542, 11, 100, 100);
		logoLabel.setIcon(logo100);
		add(logoLabel);



		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		nameLabel.setBounds(114, 146, 180, 43);
		add(nameLabel);

		cardLabel = new JLabel("Card number:");
		cardLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		cardLabel.setBounds(114, 415, 180, 42);
		add(cardLabel);

		accountNoLabel = new JLabel("Bank account no:");
		accountNoLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		accountNoLabel.setBounds(114, 253, 228, 43);
		add(accountNoLabel);

		streetLabel = new JLabel("Street:");
		streetLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		streetLabel.setBounds(114, 307, 228, 43);
		add(streetLabel);

		passwordLabel = new JLabel("password:");
		passwordLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		passwordLabel.setBounds(114, 200, 219, 42);
		add(passwordLabel);

		confirmLabel = new JLabel("confirm:");
		confirmLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		confirmLabel.setBounds(638, 200, 119, 42);
		add(confirmLabel);

		cityLabel = new JLabel("city:");
		cityLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		cityLabel.setBounds(114, 361, 228, 43);
		add(cityLabel);

		postalCodeLabel = new JLabel("postal code:");
		postalCodeLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		postalCodeLabel.setBounds(638, 307, 166, 43);
		add(postalCodeLabel);

		countryLabel = new JLabel("country:");
		countryLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		countryLabel.setBounds(638, 361, 119, 43);
		add(countryLabel);

		monthLabel = new JLabel("month:");
		monthLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		monthLabel.setBounds(638, 415, 119, 42);
		add(monthLabel);

		yearLabel = new JLabel("Year:");
		yearLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		yearLabel.setBounds(879, 415, 70, 42);
		add(yearLabel);

		CvvLabel = new JLabel("CVV:");
		CvvLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		CvvLabel.setBounds(638, 471, 180, 42);
		add(CvvLabel);

		selectSizeLabel = new JLabel("Size:");
		selectSizeLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		selectSizeLabel.setBounds(114, 523, 180, 42);
		add(selectSizeLabel);

		nameField = new JTextField();
		nameField.setBounds(337, 146, 276, 43);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(nameField);
		nameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(337, 199, 276, 43);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(passwordField);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setColumns(10);
		confirmPasswordField.setBounds(756, 199, 303, 43);
		confirmPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(confirmPasswordField);

		accountNoField = new JTextField();
		accountNoField.setColumns(10);
		accountNoField.setBounds(337, 252, 276, 43);
		accountNoField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(accountNoField);

		streetField = new JTextField();
		streetField.setColumns(10);
		streetField.setBounds(337, 307, 276, 43);
		streetField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(streetField);

		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(337, 361, 276, 43);
		cityField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(cityField);

		postalCodeField = new JTextField();
		postalCodeField.setBounds(804, 306, 255, 43);
		postalCodeField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(postalCodeField);
		postalCodeField.setColumns(10);

		countryField = new JTextField();
		countryField.setColumns(10);
		countryField.setBounds(756, 360, 303, 43);
		countryField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(countryField);

		cardField = new JTextField();
		cardField.setColumns(10);
		cardField.setBounds(337, 414, 276, 43);
		cardField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(cardField);

		monthField = new JTextField();
		monthField.setColumns(10);
		monthField.setBounds(756, 414, 113, 43);
		monthField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(monthField);

		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(959, 414, 100, 43);
		yearField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(yearField);

		CvvField = new JTextField();
		CvvField.setBounds(756, 470, 113, 43);
		CvvField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(CvvField);
		CvvField.setColumns(10);

		sizes = new DefaultListModel<>();
		sizes.addElement("38");
		sizes.addElement("39");
		sizes.addElement("40");
		sizes.addElement("41");
		sizes.addElement("42");
		sizes.addElement("43");
		sizes.addElement("44");
		sizes.addElement("45");

		sizeList = new JList<>(sizes);
		sizeList.setValueIsAdjusting(true);
		sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sizeList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sizeList.setBounds(347,523, 245,40);
		sizeList.setVisibleRowCount(-1);
		sizeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		add(sizeList);

		registerButton = new JButton("Register");
		registerButton.setOpaque(true);
		registerButton.setFont(new Font("Air Americana", Font.PLAIN, 30));
		registerButton.setFocusPainted(false);
		registerButton.setBackground(SystemColor.control);
		registerButton.setBounds(834, 543, 205, 69);
		ActionListener actionListerConfirm = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				revalidate();

			}
		};
		registerButton.addActionListener(actionListerConfirm);
		add(registerButton);



		backButton = new JButton("Back");
		backButton.setFont(new Font("Air Americana", Font.PLAIN, 30));
		backButton.setBounds(618, 543, 205, 69);
		backButton.setBackground(Color.WHITE);
		ActionListener actionListenerBack = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				setBackground(new Color(240,240,240));
				loginPanel();
				repaint();
				revalidate();
			}
		};
		backButton.addActionListener(actionListenerBack);
		backButton.setOpaque(true);
		backButton.setFocusPainted(false);
		backButton.setBackground(SystemColor.control);
		add(backButton);


	}

	public void accountPanel(){
		setLayout(null);
		logoLabel = new JLabel();
		logoLabel.setBounds(542, 11, 100, 100);
		logoLabel.setIcon(logo100);
		add(logoLabel);



		accountLabel = new JLabel(customer.displayAccount());
		accountLabel.setBounds(177, 131, 1000, 220);
		accountLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		add(accountLabel);

		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		nameLabel.setBounds(166, 146, 180, 43);
		nameLabel.setVisible(false);
		add(nameLabel);

		cardLabel = new JLabel("Card number:");
		cardLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		cardLabel.setBounds(166, 417, 180, 42);
		add(cardLabel);

		accountNoLabel = new JLabel("Bank account no:");
		accountNoLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		accountNoLabel.setBounds(166, 253, 228, 43);
		add(accountNoLabel);

		streetLabel = new JLabel("Street:");
		streetLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		streetLabel.setBounds(166, 307, 228, 43);
		add(streetLabel);

		passwordLabel = new JLabel("password:");
		passwordLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		passwordLabel.setBounds(166, 200, 219, 42);
		add(passwordLabel);

		confirmLabel = new JLabel("confirm:");
		confirmLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		confirmLabel.setBounds(690, 200, 119, 42);
		add(confirmLabel);

		cityLabel = new JLabel("city:");
		cityLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		cityLabel.setBounds(166, 361, 228, 43);
		add(cityLabel);

		postalCodeLabel = new JLabel("postal code:");
		postalCodeLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		postalCodeLabel.setBounds(690, 307, 166, 43);
		add(postalCodeLabel);

		countryLabel = new JLabel("country:");
		countryLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		countryLabel.setBounds(690, 361, 119, 43);
		add(countryLabel);

		monthLabel = new JLabel("month:");
		monthLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		monthLabel.setBounds(690, 417, 119, 42);
		add(monthLabel);

		yearLabel = new JLabel("Year:");
		yearLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		yearLabel.setBounds(931, 417, 70, 42);
		add(yearLabel);

		CvvLabel = new JLabel("CVV:");
		CvvLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		CvvLabel.setBounds(690, 470, 180, 42);
		add(CvvLabel);

		selectSizeLabel = new JLabel("Size:");
		selectSizeLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		selectSizeLabel.setBounds(166, 523, 180, 42);
		add(selectSizeLabel);

		nameField = new JTextField();
		nameField.setBounds(389, 146, 276, 43);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(nameField);
		nameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(389, 200, 276, 43);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(passwordField);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setColumns(10);
		confirmPasswordField.setBounds(808, 200, 303, 43);
		confirmPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(confirmPasswordField);

		accountNoField = new JTextField();
		accountNoField.setColumns(10);
		accountNoField.setBounds(389, 253, 276, 43);
		accountNoField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(accountNoField);

		streetField = new JTextField();
		streetField.setColumns(10);
		streetField.setBounds(389, 307, 276, 43);
		streetField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(streetField);

		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(389, 361, 276, 43);
		cityField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(cityField);

		postalCodeField = new JTextField();
		postalCodeField.setBounds(856, 307, 255, 43);
		postalCodeField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(postalCodeField);
		postalCodeField.setColumns(10);

		countryField = new JTextField();
		countryField.setColumns(10);
		countryField.setBounds(808, 361, 303, 43);
		countryField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(countryField);

		cardField = new JTextField();
		cardField.setColumns(10);
		cardField.setBounds(389, 416, 276, 43);
		cardField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(cardField);

		monthField = new JTextField();
		monthField.setColumns(10);
		monthField.setBounds(808, 417, 113, 43);
		monthField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(monthField);

		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(1011, 417, 100, 43);
		yearField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(yearField);

		CvvField = new JTextField();
		CvvField.setBounds(808, 470, 113, 43);
		CvvField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(CvvField);
		CvvField.setColumns(10);

		sizes = new DefaultListModel<>();
		sizes.addElement("38");
		sizes.addElement("39");
		sizes.addElement("40");
		sizes.addElement("41");
		sizes.addElement("42");
		sizes.addElement("43");
		sizes.addElement("44");
		sizes.addElement("45");

		sizeList = new JList<>(sizes);
		sizeList.setValueIsAdjusting(true);
		sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sizeList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sizeList.setBounds(399,523, 245,40);;
		sizeList.setVisibleRowCount(-1);
		sizeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		add(sizeList);

		confirmButton = new JButton("Confirm");
		confirmButton.setOpaque(true);
		confirmButton.setFont(new Font("Air Americana", Font.PLAIN, 30));
		confirmButton.setFocusPainted(false);
		confirmButton.setBackground(SystemColor.control);
		confirmButton.setBounds(866, 523, 245, 69);
		ActionListener actionListerConfirm = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customer.editCustomer(passwordField.getText(), Integer.parseInt(sizes.getElementAt(sizeList.getSelectedIndex())) ,confirmPasswordField.getText(), cardField.getText(), Integer.parseInt(monthField.getText()),Integer.parseInt(yearField.getText()),CvvField.getText(), streetField.getText(), cityField.getText() , postalCodeField.getText(), countryField.getText());
				repaint();
				revalidate();
				System.out.println("essa");

			}
		};
		confirmButton.addActionListener(actionListerConfirm);
		add(confirmButton);

		editAccountVisibility(false);

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
		list.setSelectedIndex(0);
		list.getSelectionModel().addListSelectionListener(e ->{
			switch( list.getSelectedIndex()){
				case 0:
					accountLabel.setVisible(true);
					editAccountVisibility(false);
					repaint();
					revalidate();
					break;
				case 1:
					accountLabel.setVisible(false);
					editAccountVisibility(false);
					repaint();
					revalidate();
					break;
				case 2:
					accountLabel.setVisible(false);
					editAccountVisibility(false);
					repaint();
					revalidate();
					break;
				case 3:
					accountLabel.setVisible(false);
					editAccountVisibility(true);
					repaint();
					revalidate();
					break;

			}

		});

		list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

			}
		});

		add(list);

		backgroundLabel = new JLabel();
		backgroundLabel.setBounds(136, 122, 1040, 515);
		backgroundLabel.setIcon(background);
		add(backgroundLabel);

		catalogButton = new JButton("CATALOG");
		catalogButton.setFont(new Font("Air Americana", Font.PLAIN, 40));
		catalogButton.setBounds(7, 11, 530, 100);
		catalogButton.setBackground(Color.WHITE);
		catalogButton.setOpaque(true);
		catalogButton.setBorder(null);
		catalogButton.setFocusPainted(false);
		ActionListener actionListenerCatalog = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				catalogPanel();
				repaint();
				revalidate();

			}
		};
		catalogButton.addActionListener(actionListenerCatalog);

		add(catalogButton);

		accountButton =new JButton("ACCOUNT");
		accountButton.setFont(new Font("Air Americana", Font.PLAIN, 40));
		accountButton.setBounds(646, 11, 530, 100);
		accountButton.setBackground(Color.WHITE);
		accountButton.setOpaque(true);
		accountButton.setBorder(null);
		accountButton.setFocusPainted(false);

		add(accountButton);

		catalogButton.setBackground(Color.WHITE);
		accountButton.setBackground(Color.LIGHT_GRAY);
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
		catalogButton.setBackground(Color.LIGHT_GRAY);
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
		ActionListener actionListenerAccount = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				accountPanel();
				repaint();
				revalidate();

			}
		};
		accountButton.addActionListener(actionListenerAccount);

		add(accountButton);

	}

	public void editAccountVisibility(boolean status){


		nameLabel.setVisible(status);
		passwordLabel.setVisible(status);
		confirmLabel.setVisible(status);
		cardLabel.setVisible(status);
		accountNoLabel.setVisible(status);
		streetLabel.setVisible(status);
		cityLabel.setVisible(status);
		confirmLabel.setVisible(status);
		postalCodeLabel.setVisible(status);
		countryLabel.setVisible(status);
		monthLabel.setVisible(status);
		yearLabel.setVisible(status);
		CvvLabel.setVisible(status);
		selectSizeLabel.setVisible(status);
		nameField.setVisible(status);
		passwordField.setVisible(status);
		confirmPasswordField.setVisible(status);
		accountNoField.setVisible(status);
		streetField.setVisible(status);
		cityField.setVisible(status);
		postalCodeField.setVisible(status);
		countryField.setVisible(status);
		cardField.setVisible(status);
		monthField.setVisible(status);
		yearField.setVisible(status);
		CvvField.setVisible(status);
		confirmButton.setVisible(status);
		sizeList.setVisible(status);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
