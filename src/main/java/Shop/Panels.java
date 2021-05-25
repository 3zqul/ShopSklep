package Shop;

import Shop.CustomerPackage.*;
import Shop.WorkerPackage.*;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
	private JList<Shoe> shoeList;
	private DefaultListModel<String> sizes;
	private DefaultListModel<Shoe> shoes;
	private Customer customer = new Customer();
	private Editor editor = new Editor();
	private Administrator admin = new Administrator();
	private Catalog catalog= new Catalog();
	private JList<String> list;
	private DefaultListModel<String> model;
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
	private JLabel accountNameLabel;
	private JLabel cardNameLabel;
	private JPasswordField confirmPasswordField;
	private JTextField accountNoField;
	private JTextField streetField ;
	private JTextField cityField ;
	private JTextField postalCodeField;
	private JTextField countryField ;
	private JTextField cardField ;
	private JTextField monthField ;
	private JTextField yearField ;
	private JTextField cvvField;
	private JTextField accountNameField;
	private JTextField cardNameField;
	private JButton confirmButton;
	private JFrame frame;
	private JSplitPane splitPane;
	private JLabel shoeLabel;
	private JButton buyNowButton;
	private JButton quickSellButton;
	private JButton bidButton;
	private JButton askButton;
	private JTextField shoeNameField;
	private JButton searchShoeButton;
	private ArrayList<Shoe> catalogList;
	private DefaultListModel<Offer> offerModel;
	private JList<Offer> offerList;
	private DefaultListModel<Order> orderModel;
	private JList<Order> orderList;
	private JButton deleteButton;
	private JButton editOrderButton;
	private JButton editCatalogButton;
	private JButton customerOffersButton;
	private JButton statisticsButton;
	private JLabel shoeNameLabel;
	private JButton deleteShoeButton;
	private JButton addShoeButton;
	private JTextField shoeName;
	private JList<Customer> customerList;
	private DefaultListModel<Customer> customerModel;
	private JLabel offersLabel;
	private JLabel ordersLabel;
	private JButton saveButton;
	private String loggedUser;
	private Statistics statistics = new Statistics();

	ImageIcon logo250 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo250.png");
	ImageIcon logo350 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo350.png");
	ImageIcon logo100 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\logo100.png");


	public Panels(JFrame frame){
		this.frame= frame;
		loginPanel();
		statistics.updateMostPopularShoe();
	}

	public void loginPanel(){
		setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(368, 366, 448, 45);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(passwordField);

		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 25));
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
		ActionListener actionListenerLog = e -> {
			if (customer.signIn(passwordField.getText(), emailField.getText()).equals("c")) {
				loggedUser = "c";
				removeAll();
				catalogPanel();
				repaint();
				revalidate();
			} else if (editor.signIn(passwordField.getText(), emailField.getText()).equals("e")) {
				loggedUser = "e";
				removeAll();
				editorMenu();
				repaint();
				revalidate();
			} else if (admin.signIn(passwordField.getText(), emailField.getText()).equals("a")) {
				loggedUser = "a";
				removeAll();
				adminMenu();
				repaint();
				revalidate();
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

		emailLabel = new JLabel("Email: ");
		emailLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		emailLabel.setBounds(638, 146, 448, 43);
		add(emailLabel);

		cardLabel = new JLabel("Card number:");
		cardLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		cardLabel.setBounds(114, 415, 180, 42);
		add(cardLabel);

		accountNoLabel = new JLabel("Bank account no:");
		accountNoLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		accountNoLabel.setBounds(114, 253, 228, 43);
		add(accountNoLabel);

		accountNameLabel = new JLabel("Acc Name:");
		accountNameLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		accountNameLabel.setBounds(638, 253, 180, 43);
		add(accountNameLabel);

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

		cardNameLabel = new JLabel("Card name:");
		cardNameLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		cardNameLabel.setBounds(114, 471, 180, 43);
		add(cardNameLabel);

		selectSizeLabel = new JLabel("Size:");
		selectSizeLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		selectSizeLabel.setBounds(114, 523, 180, 42);
		add(selectSizeLabel);

		nameField = new JTextField();
		nameField.setBounds(337, 146, 276, 43);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(nameField);
		nameField.setColumns(10);

		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		emailField.setBounds(756, 146, 303, 43);
		add(emailField);
		emailField.setColumns(10);

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

		cvvField = new JTextField();
		cvvField.setBounds(756, 470, 113, 43);
		cvvField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(cvvField);
		cvvField.setColumns(10);

		cardNameField = new JTextField();
		cardNameField.setBounds(337, 470, 276, 43);
		cardNameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(cardNameField);
		cardNameField.setColumns(10);

		accountNameField = new JTextField();
		accountNameField.setBounds(783, 253, 276, 43);
		accountNameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(accountNameField);
		accountNameField.setColumns(10);

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

		registerButton = new JButton("register");
		registerButton.setOpaque(true);
		registerButton.setFont(new Font("Air Americana", Font.PLAIN, 30));
		registerButton.setFocusPainted(false);
		registerButton.setBackground(SystemColor.control);
		registerButton.setBounds(834, 543, 205, 69);
		ActionListener actionListerRegister = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(customer.signUp(emailField.getText(), nameField.getText(), passwordField.getText(), Integer.parseInt(sizes.getElementAt(sizeList.getSelectedIndex())), new Address(streetField.getText(), cityField.getText(), postalCodeField.getText(), countryField.getText()), new Payment(cardField.getText(), cardNameField.getText(), Integer.parseInt(yearField.getText()), Integer.parseInt(monthField.getText()), cvvField.getText()), new Payout(accountNoField.getText(), accountNameField.getText()))){
					removeAll();
					setBackground(new Color(240,240,240));
					loginPanel();
					repaint();
					revalidate();
				}
			}
		};
		registerButton.addActionListener(actionListerRegister);
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
		accountLabel.setVerticalTextPosition(SwingConstants.TOP);
		accountLabel.setVerticalAlignment(SwingConstants.TOP);
		accountLabel.setBounds(177, 141, 1000, 500);
		accountLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		add(accountLabel);

		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		nameLabel.setBounds(166, 146, 180, 43);
		nameLabel.setVisible(false);
		add(nameLabel);

		accountNoLabel = new JLabel("Bank account no:");
		accountNoLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		accountNoLabel.setBounds(166, 253, 228, 43);
		add(accountNoLabel);

		accountNameLabel = new JLabel("Acc Name:");
		accountNameLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		accountNameLabel.setBounds(690, 253, 180, 43);
		accountNameLabel.setVisible(false);
		add(accountNameLabel);

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

		cardLabel = new JLabel("Card number:");
		cardLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		cardLabel.setBounds(166, 417, 180, 42);
		add(cardLabel);

		cardNameLabel = new JLabel("Card name:");
		cardNameLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		cardNameLabel.setBounds(166, 470, 180, 43);
		cardNameLabel.setVisible(false);
		add(cardNameLabel);

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

		accountNameField = new JTextField();
		accountNameField.setBounds(835, 253, 276, 43);
		accountNameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(accountNameField);
		accountNameField.setColumns(10);

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

		cardNameField = new JTextField();
		cardNameField.setBounds(389, 470, 276, 43);
		cardNameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(cardNameField);
		cardNameField.setColumns(10);

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

		cvvField = new JTextField();
		cvvField.setBounds(808, 470, 113, 43);
		cvvField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(cvvField);
		cvvField.setColumns(10);

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

		confirmButton = new JButton("confirm");
		confirmButton.setOpaque(true);
		confirmButton.setFont(new Font("Air Americana", Font.PLAIN, 30));
		confirmButton.setFocusPainted(false);
		confirmButton.setBackground(SystemColor.control);
		confirmButton.setBounds(866, 523, 245, 69);
		ActionListener actionListerConfirm = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customer.editCustomer(nameField.getText(), passwordField.getText(), Integer.parseInt(sizes.getElementAt(sizeList.getSelectedIndex())), confirmPasswordField.getText(), new Payout(accountNoField.getText(), accountNameField.getText()), new Payment(cardField.getText(), cardNameField.getText(), Integer.parseInt(monthField.getText()),Integer.parseInt(yearField.getText()), cvvField.getText()), new Address(streetField.getText(), cityField.getText() , postalCodeField.getText(), countryField.getText()));
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

		deleteButton = new JButton("delete");
		deleteButton.setOpaque(true);
		deleteButton.setFont(new Font("Air Americana", Font.PLAIN, 30));
		deleteButton.setFocusPainted(false);
		deleteButton.setBackground(SystemColor.control);
		deleteButton.setBounds(896, 543, 245, 69);
		deleteButton.setVisible(false);
		add(deleteButton);

		offerModel = new DefaultListModel<>();
		List<Offer> customerOffers;

		customerOffers = customer.returnOffers();

		for(int i = 0; i< customerOffers.size(); i++){
			offerModel.add(i, customerOffers.get(i));
		}

		offerList = new JList<>(offerModel);
		offerList.setFont(new Font("Air Americana", Font.PLAIN, 30));
		offerList.setFixedCellHeight(50);

		JScrollPane offerPanel = new JScrollPane(offerList);
		offerPanel.setBounds(136, 122, 1040, 400);
		offerPanel.setBackground(Color.WHITE);
		offerPanel.setBorder(null);
		offerPanel.setVisible(false);
		add(offerPanel);

		orderModel = new DefaultListModel<>();
		List<Order> customerOrders;

		customerOrders = customer.returnOrders();

		for(int i = 0; i< customerOrders.size(); i++){

			orderModel.add(i, customerOrders.get(i));
		}

		orderList = new JList<>(orderModel);
		orderList.setFont(new Font("Air Americana", Font.PLAIN, 30));
		orderList.setFixedCellHeight(50);

		JScrollPane orderPanel = new JScrollPane(orderList);
		orderPanel.setBounds(136, 122, 1040, 515);
		orderPanel.setBackground(Color.WHITE);
		orderPanel.setBorder(null);
		orderPanel.setVisible(false);
		add(orderPanel);

		JPanel panel = new JPanel();
		panel.setBounds(136, 122, 1040, 515);
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		add(panel);

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
					offerPanel.setVisible(false);
					orderPanel.setVisible(false);
					deleteButton.setVisible(false);
					break;
				case 1:
					orderPanel.setVisible(false);
					offerPanel.setVisible(true);
					accountLabel.setVisible(false);
					editAccountVisibility(false);
					deleteButton.setVisible(true);
					break;
				case 2:
					orderPanel.setVisible(true);
					offerPanel.setVisible(false);
					accountLabel.setVisible(false);
					editAccountVisibility(false);
					deleteButton.setVisible(false);
					break;
				case 3:
					orderPanel.setVisible(false);
					offerPanel.setVisible(false);
					accountLabel.setVisible(false);
					editAccountVisibility(true);
					deleteButton.setVisible(false);
					break;
			}
		});

		list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		add(list);

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
		accountButton.setBounds(646, 11, 530, 100);
		accountButton.setFont(new Font("Air Americana", Font.PLAIN, 40));
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

		catalogList = catalog.returnCatalog();
		shoes = new DefaultListModel<>();
		if(catalogList.isEmpty()) {
			admin.readOfferData();
			catalog.readShoeList(admin.returnOfferMap());
		}
		for (int i = 0; i < catalogList.size(); i++) {
			shoes.add(i, catalogList.get(i));
		}

		shoeList=new JList<>(shoes);
		shoeList.setFont(new Font("Air Americana", Font.PLAIN, 25));
		shoeList.getSelectionModel().addListSelectionListener(e ->{

			if(shoeList.getSelectedIndex()!=-1) {
				Shoe shoe = shoeList.getSelectedValue();
				shoeLabel.setText(shoe.toString());
				if (Float.toString(shoe.returnShoeBuyPrice()).equals("0.0")) {
					buyNowButton.setText("no offers yet");
				} else {
					buyNowButton.setText("buy now: " + Float.toString(shoe.returnShoeBuyPrice()) + "pln");
				}
				if (Float.toString(shoe.returnShoeSellPrice()).equals("0.0")) {
					quickSellButton.setText("no asks yet");
				} else {
					quickSellButton.setText("quick sell: " + Float.toString(shoe.returnShoeSellPrice()) + "pln");
				}

				shoeLabel.setVisible(true);
				buyNowButton.setVisible(true);
				quickSellButton.setVisible(true);
				askButton.setVisible(true);
				bidButton.setVisible(true);
			}else{
				shoeLabel.setVisible(false);
				buyNowButton.setVisible(false);
				quickSellButton.setVisible(false);
				askButton.setVisible(false);
				bidButton.setVisible(false);
			}
		});
		DefaultListCellRenderer renderer = (DefaultListCellRenderer)shoeList.getCellRenderer();
		renderer.setVerticalAlignment(JLabel.BOTTOM);
		shoeList.setCellRenderer(renderer);
		shoeList.setFixedCellHeight(40);

		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setBorder(null);
		splitPane.setDividerLocation(300);

		JScrollPane scrollPane= new JScrollPane(shoeList);
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getVerticalScrollBar().setOpaque(true);
		scrollPane.getVerticalScrollBar().setBorder(null);
		scrollPane.setBorder(null);
		splitPane.setBounds(7, 122, 1169, 515);
		splitPane.setLeftComponent(scrollPane);
		add(splitPane);

		JPanel panel = new JPanel();

		splitPane.setRightComponent(panel);
		panel.setLayout(null);

		buyNowButton = new JButton("Buy now");
		buyNowButton.setBounds(29, 396, 318, 80);
		buyNowButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		buyNowButton.setBackground(new Color(0, 98, 64));
		buyNowButton.setForeground(Color.WHITE);
		buyNowButton.setOpaque(true);
		buyNowButton.setBorder(null);
		buyNowButton.setFocusPainted(false);
		buyNowButton.setVisible(false);
		panel.add(buyNowButton);

		quickSellButton = new JButton("quick sell");
		quickSellButton.setBounds(516, 396, 318, 80);
		quickSellButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		quickSellButton.setBackground(new Color(255, 90, 95));
		quickSellButton.setForeground(Color.WHITE);
		quickSellButton.setOpaque(true);
		quickSellButton.setBorder(null);
		quickSellButton.setFocusPainted(false);
		quickSellButton.setVisible(false);
		panel.add(quickSellButton);

		bidButton = new JButton("place bid");
		bidButton.setBounds(29, 262, 318, 80);
		bidButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		bidButton.setBackground(new Color(0, 98, 64));
		bidButton.setForeground(Color.WHITE);
		bidButton.setOpaque(true);
		bidButton.setBorder(null);
		bidButton.setFocusPainted(false);
		bidButton.setVisible(false);
		panel.add(bidButton);

		askButton = new JButton("place ask");
		askButton.setBounds(516, 262, 318, 80);
		askButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		askButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		askButton.setBackground(new Color(255, 90, 95));
		askButton.setForeground(Color.WHITE);
		askButton.setOpaque(true);
		askButton.setBorder(null);
		askButton.setFocusPainted(false);
		askButton.setVisible(false);
		panel.add(askButton);

		shoeLabel = new JLabel();
		shoeLabel.setBounds(29, 70, 607, 80);
		shoeLabel.setFont(new Font("Air Americana", Font.PLAIN, 55));
		shoeLabel.setVisible(false);
		panel.add(shoeLabel);

		shoeName = new JTextField();
		shoeName.setBounds(29, 11, 644, 48);
		shoeName.setColumns(10);
		panel.add(shoeName);

		searchShoeButton = new JButton("Search");
		searchShoeButton.setBounds(683, 11, 151, 48);
		searchShoeButton.setFont(new Font("Air Americana", Font.PLAIN, 30));
		searchShoeButton.setBackground(Color.WHITE);
		searchShoeButton.setOpaque(true);
		searchShoeButton.setBorder(null);
		searchShoeButton.setFocusPainted(false);
		ActionListener actionListenerSearch = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shoeList.clearSelection();
				shoes.removeAllElements();
				if(shoeName.getText().equals("")){
					catalogList = catalog.searchShoe("all");
				}else {
					catalogList = catalog.searchShoe(shoeName.getText());
				}
				for(int i = 0; i< catalogList.size(); i++) {
					shoes.add(i, catalogList.get(i));
					repaint();
					revalidate();
				}
			}
		};
		searchShoeButton.addActionListener(actionListenerSearch);
		panel.add(searchShoeButton);
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
		cvvField.setVisible(status);
		confirmButton.setVisible(status);
		sizeList.setVisible(status);
		accountNameField.setVisible(status);
		cardNameField.setVisible(status);
		cardNameLabel.setVisible(status);
		accountNameLabel.setVisible(status);
	}

	public void adminMenu(){
		setLayout(null);

		logoLabel = new JLabel("");
		logoLabel.setBounds(121, 145, 350, 350);
		logoLabel.setIcon(logo350);
		add(logoLabel);

		editOrderButton = new JButton("edit orders");
		editOrderButton.setBounds(585, 119, 458, 92);
		editOrderButton.setOpaque(true);
		editOrderButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		editOrderButton.setFocusPainted(false);
		editOrderButton.setBackground(Color.WHITE);
		add(editOrderButton);

		editCatalogButton = new JButton("edit catalog");
		editCatalogButton.setBounds(585, 222, 458, 92);
		editCatalogButton.setOpaque(true);
		editCatalogButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		editCatalogButton.setFocusPainted(false);
		editCatalogButton.setBackground(Color.WHITE);
		ActionListener actionListenerCatalog = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				editCatalogPanel();
				repaint();
				revalidate();
			}
		};
		editCatalogButton.addActionListener(actionListenerCatalog);
		add(editCatalogButton);

		customerOffersButton = new JButton("customer offers");
		customerOffersButton.setBounds(585, 325, 458, 92);
		customerOffersButton.setOpaque(true);
		customerOffersButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		customerOffersButton.setFocusPainted(false);
		customerOffersButton.setBackground(Color.WHITE);
		ActionListener actionListenerOffers = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				seeCustomersPanel();
				repaint();
				revalidate();
			}
		};
		customerOffersButton.addActionListener(actionListenerOffers);
		add(customerOffersButton);

		statisticsButton = new JButton("statistics");
		statisticsButton.setBounds(585, 428, 458, 92);
		statisticsButton.setOpaque(true);
		statisticsButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		statisticsButton.setFocusPainted(false);
		statisticsButton.setBackground(Color.WHITE);
		add(statisticsButton);
	}

	public void editorMenu(){
		setLayout(null);

		logoLabel = new JLabel("");
		logoLabel.setBounds(121, 145, 350, 350);
		logoLabel.setIcon(logo350);
		add(logoLabel);

		editOrderButton = new JButton("edit orders");
		editOrderButton.setBounds(585, 222, 458, 92);
		editOrderButton.setOpaque(true);
		editOrderButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		editOrderButton.setFocusPainted(false);
		editOrderButton.setBackground(Color.WHITE);
		ActionListener actionListenerOrder = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				editOrderPanel();
				repaint();
				revalidate();
			}
		};
		editOrderButton.addActionListener(actionListenerOrder);
		add(editOrderButton);

		editCatalogButton = new JButton("edit catalog");
		editCatalogButton.setBounds(585, 325, 458, 92);
		editCatalogButton.setOpaque(true);
		editCatalogButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		editCatalogButton.setFocusPainted(false);
		editCatalogButton.setBackground(Color.WHITE);
		ActionListener actionListenerCatalog = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				editCatalogPanel();
				repaint();
				revalidate();
			}
		};
		editCatalogButton.addActionListener(actionListenerCatalog);
		add(editCatalogButton);
	}

	public void editCatalogPanel(){
		setLayout(null);
		admin.readOfferData();

		catalogList = catalog.returnCatalog();
		shoes = new DefaultListModel<>();
		if(catalogList.isEmpty()) {
			catalog.readShoeList(admin.returnOfferMap());
		}
		for (int i = 0; i < catalogList.size(); i++) {
			shoes.add(i, catalogList.get(i));
		}
		shoeList=new JList<>(shoes);
		shoeList.setFont(new Font("Air Americana", Font.PLAIN, 25));
		shoeList.setFixedCellHeight(40);

		JScrollPane scrollPane= new JScrollPane(shoeList);
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getVerticalScrollBar().setOpaque(true);
		scrollPane.getVerticalScrollBar().setBorder(null);
		scrollPane.setBorder(null);
		scrollPane.setBounds(7, 1, 300, 635);
		add(scrollPane);

		deleteShoeButton = new JButton("remove shoe");
		deleteShoeButton.setBounds(317, 544, 265, 85);
		deleteShoeButton.setOpaque(true);
		deleteShoeButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		deleteShoeButton.setFocusPainted(false);
		deleteShoeButton.setBackground(Color.WHITE);
		add(deleteShoeButton);

		backButton = new JButton("back");
		backButton.setBounds(912, 544, 265, 85);
		backButton.setOpaque(true);
		backButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		backButton.setFocusPainted(false);
		backButton.setBackground(Color.WHITE);
		ActionListener actionListenerBack = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(loggedUser.equals("e")) {
					removeAll();
					editorMenu();
					repaint();
					revalidate();
				}else{
					removeAll();
					adminMenu();
					repaint();
					revalidate();
				}
			}
		};
		backButton.addActionListener(actionListenerBack);
		add(backButton);

		shoeNameLabel = new JLabel("New shoe name:");
		shoeNameLabel.setBounds(317, 16, 181, 53);
		shoeNameLabel.setFont(new Font("Air Americana", Font.PLAIN, 30));
		add(shoeNameLabel);

		shoeNameField = new JTextField();
		shoeNameField.setBounds(500, 13, 472, 51);
		shoeNameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shoeNameField.setColumns(10);
		add(shoeNameField);


		addShoeButton = new JButton("add shoe");
		addShoeButton.setBounds(978, 12, 199, 52);
		addShoeButton.setOpaque(true);
		addShoeButton.setFont(new Font("Air Americana", Font.PLAIN, 24));
		addShoeButton.setFocusPainted(false);
		addShoeButton.setBackground(Color.WHITE);
		add(addShoeButton);

		logoLabel = new JLabel();
		logoLabel.setBounds(572, 135, 350, 350);
		logoLabel.setIcon(logo350);
		add(logoLabel);
	}

	public void editOrderPanel(){
		editor.readOrderData();

		logoLabel = new JLabel();
		logoLabel.setBounds(749, 11, 250, 250);
		logoLabel.setIcon(logo250);
		add(logoLabel);

		setLayout(null);
		streetLabel = new JLabel("Street:");
		streetLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		streetLabel.setBounds(633, 292, 228, 43);
		add(streetLabel);

		cityLabel = new JLabel("city:");
		cityLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		cityLabel.setBounds(633, 400, 166, 43);
		add(cityLabel);

		postalCodeLabel = new JLabel("postal code:");
		postalCodeLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		postalCodeLabel.setBounds(633, 346, 190, 43);
		add(postalCodeLabel);

		countryLabel = new JLabel("country:");
		countryLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		countryLabel.setBounds(633, 454, 119, 43);
		add(countryLabel);

		streetField = new JTextField();
		streetField.setColumns(10);
		streetField.setBounds(840, 291, 276, 43);
		streetField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(streetField);

		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(840, 399, 276, 43);
		cityField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(cityField);

		postalCodeField = new JTextField();
		postalCodeField.setBounds(840, 346, 276, 43);
		postalCodeField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(postalCodeField);
		postalCodeField.setColumns(10);

		countryField = new JTextField();
		countryField.setColumns(10);
		countryField.setBounds(840, 453, 276, 43);
		countryField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(countryField);

		backButton = new JButton("back");
		backButton.setBounds(912, 544, 265, 85);
		backButton.setOpaque(true);
		backButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		backButton.setFocusPainted(false);
		backButton.setBackground(Color.WHITE);
		ActionListener actionListenerBack = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(loggedUser.equals("e")) {
					removeAll();
					editorMenu();
					repaint();
					revalidate();
				}else{
					removeAll();
					adminMenu();
					repaint();
					revalidate();
				}
			}
		};
		backButton.addActionListener(actionListenerBack);
		add(backButton);

		orderModel = new DefaultListModel<>();
		for(int i = 1; i<=editor.returnOrderMap().size(); i++){
			orderModel.add(i-1, editor.returnOrderMap().get(i));
		}

		orderList = new JList(orderModel);
		orderList.setFont(new Font("Air Americana", Font.PLAIN, 30));
		orderList.setFixedCellHeight(50);

		JScrollPane scrollPane = new JScrollPane(orderList);
		scrollPane.setBounds(10, 11, 558, 653);
		add(scrollPane);

		saveButton = new JButton("save changes");
		saveButton.setOpaque(true);
		saveButton.setFont(new Font("Air Americana", Font.PLAIN, 35));
		saveButton.setFocusPainted(false);
		saveButton.setBackground(Color.WHITE);
		saveButton.setBounds(637, 544, 265, 85);
		ActionListener actionListenerSave = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editor.editOrder(orderList.getSelectedIndex()+1, streetField.getText(), cityField.getText(), postalCodeField.getText(), countryField.getText());
				removeAll();
				editorMenu();
				repaint();
				revalidate();
			}
		};
		saveButton.addActionListener(actionListenerSave);
		add(saveButton);
	}

	public void seeCustomersPanel(){
		setLayout(null);

		customer.readCustomerData();
		customerModel = new DefaultListModel<>();
		for(int i = 1; i<=customer.customerMap.size(); i++){
			customerModel.add(i-1, customer.customerMap.get(i));
		}

		customerList = new JList<>(customerModel);
		customerList.setFont(new Font("Air Americana", Font.PLAIN, 30));
		customerList.setFixedCellHeight(50);
		customerList.setSelectedIndex(0);

		ArrayList<DefaultListModel> offerModels = new ArrayList<>();
		ArrayList<DefaultListModel> orderModels = new ArrayList<>();

		for(int i = 0 ; i<customer.customerMap.size(); i++){

			offerModel = new DefaultListModel<>();
			List<Offer> customerOffers = customer.customerMap.get(i+1).returnOffers();
			for(int j = 0; j< customerOffers.size(); j++){
				offerModel.add(j, customerOffers.get(j));
			}
			offerModels.add(offerModel);
		}
		offerList = new JList<>(offerModels.get(customerList.getSelectedIndex()));
		offerList.setFont(new Font("Air Americana", Font.PLAIN, 30));
		offerList.setFixedCellHeight(50);
		offerList.setSelectionBackground(null);

		for(int i = 0 ; i<customer.customerMap.size(); i++){

			orderModel = new DefaultListModel<>();
			List<Order> customerOrders = customer.customerMap.get(i+1).returnOrders();
			for(int j = 0; j< customerOrders.size(); j++){
				orderModel.add(j, customerOrders.get(j));
			}
			orderModels.add(orderModel);
		}

		orderList = new JList<>(orderModels.get(customerList.getSelectedIndex()));
		orderList.setFont(new Font("Air Americana", Font.PLAIN, 30));
		orderList.setFixedCellHeight(50);
		orderList.setSelectionBackground(null);

		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setBorder(null);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(300);
		splitPane.setBounds(7, 0, 1019, 637);
		add(splitPane);

		JScrollPane scrollPane= new JScrollPane(customerList);
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getVerticalScrollBar().setOpaque(true);
		scrollPane.getVerticalScrollBar().setBorder(null);
		scrollPane.setBorder(null);
		splitPane.setLeftComponent(scrollPane);

		JSplitPane panel = new JSplitPane();
		panel.setLayout(null);
		panel.setEnabled(false);
		panel.setDividerLocation(318);
		panel.setDividerSize(1);
		panel.setOrientation(JSplitPane.VERTICAL_SPLIT);

		JScrollPane scrollPane1= new JScrollPane(orderList);
		scrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane1.getVerticalScrollBar().setOpaque(true);
		scrollPane1.getVerticalScrollBar().setBorder(null);
		scrollPane1.setBorder(null);

		JScrollPane scrollPane2= new JScrollPane(offerList);
		scrollPane2.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane2.getVerticalScrollBar().setOpaque(true);
		scrollPane2.getVerticalScrollBar().setBorder(null);
		scrollPane2.setBorder(null);

		panel.setTopComponent(scrollPane1);
		panel.setBottomComponent(scrollPane2);

		splitPane.setRightComponent(panel);

		offersLabel = new JLabel("offers");
		offersLabel.setBounds(1036, 470, 136, 40);
		offersLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		add(offersLabel);

		ordersLabel = new JLabel("orders");
		ordersLabel.setBounds(1036, 155, 136, 40);
		ordersLabel.setFont(new Font("Air Americana", Font.PLAIN, 35));
		add(ordersLabel);

		customerList.getSelectionModel().addListSelectionListener(e -> {
			orderList.setModel(orderModels.get(customerList.getSelectedIndex()));
			offerList.setModel(offerModels.get(customerList.getSelectedIndex()));
		});

		backButton = new JButton("back");
		backButton.setBounds(1036, 573, 136, 57);
		backButton.setOpaque(true);
		backButton.setFont(new Font("Air Americana", Font.PLAIN, 25));
		backButton.setFocusPainted(false);
		backButton.setBackground(Color.WHITE);
		ActionListener actionListenerBack = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				adminMenu();
				repaint();
				revalidate();
			}
		};
		backButton.addActionListener(actionListenerBack);
		add(backButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}