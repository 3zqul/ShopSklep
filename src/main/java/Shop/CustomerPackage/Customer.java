package Shop.CustomerPackage;

import Shop.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class Customer extends User {

    protected int userShoeSize;
    protected String userName;
    protected Payout userPayout;
    protected Payment userPayment;
    protected Address userAddress;
    protected List<Offer> offerList;
    protected List<Order> orderList;

    public Customer() {
    }

    public Customer(String userType, int userID, String password, String userEmail, int userShoeSize, String userName, Payout userPayout, Payment userPayment, Address userAddress, List<Offer> offerList, List<Order> orderList) {
        this.userAddress = userAddress;
        this.userName = userName;
        this.offerList = offerList;
        this.orderList = orderList;
        this.userPayment = userPayment;
        this.userPayout = userPayout;
        this.userShoeSize = userShoeSize;
        this.userID = userID;
        this.password = password;
        this.userEmail = userEmail;
        this.userType = userType;
    }

    public void displayOrders() {}

    public void displayOffers() {}

    public String displayAccount() {

        return "<html>Name: " + this.userName + "<br/> E- mail: " + this.userEmail + "<br/>Payment: " + userPayment.toString() + "<br/>Payout:  " + userPayout.toString() + "<br/> Adress: " + userAddress.toString() + "</html>";
    }

    public void editCustomer(String name, String password, int size, String confirmPass, String cardNo, int month, int year, String cvv, String street, String city, String postalCode, String country) {

        this.userShoeSize = size;
        this.userName=name;

        if (password.equals(confirmPass) && password != null) {
            this.password = password;
        }
        if (cardNo.length() == 16 && month < 13 && year < 99 && cvv.length() == 3) {
            this.userPayment = new Payment(cardNo, userName, month, year, cvv);
        }
        if (street != null && city != null && postalCode != null && country != null) {
            this.userAddress = new Address(street, city, postalCode, country);
        }
        System.out.println(userAddress.toString());
        System.out.println(userPayment.toString());
    }


    public boolean signUp(String userEmail, String userName, String password, int userShoeSize, Address address, Payment payment, Payout payout) {
        boolean result = false;
        int index = 0;

        try {
            for (int j = 0; j < customerMap.size(); ++j) {
                if (userEmail.equals(customerMap.get(j).userEmail)) {
                    result = true;
                    index = j;
                    break;
                }
            }
            FileInputStream inputFile1 = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(inputFile1);
            Sheet userSheet = workbook.getSheet("User");
            ArrayList<String> userDataList = new ArrayList<>();
            userDataList.add(Integer.toString(index));
            userDataList.add(userEmail);
            userDataList.add(password);
            userDataList.add("c");
            Map<Integer, ArrayList<String>> userData = new HashMap<>();
            userData.put(index, userDataList);
            Set<Integer> newUserRows = userData.keySet();
            int userrownum = userSheet.getLastRowNum();
            for (Integer key : newUserRows) {
                Row row = userSheet.createRow(++userrownum);
                ArrayList<String> objArr = userData.get(key);
                int cellnum1 = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum1++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Boolean) {
                        cell.setCellValue((Boolean) obj);
                    } else if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }
                }
            }
            FileOutputStream userOs = new FileOutputStream(file);
            workbook.write(userOs);
            userOs.close();

            Workbook workbook2;
            FileInputStream inputFile2 = new FileInputStream(file);
            workbook2 = new XSSFWorkbook(inputFile2);
            Sheet customerSheet = workbook2.getSheet("Customer");
            ArrayList<String> customerDataList = new ArrayList<>();
            customerDataList.add(Integer.toString(index));
            customerDataList.add(userName);
            customerDataList.add(Integer.toString(userShoeSize));
            Map<Integer, ArrayList<String>> customerData = new HashMap<>();
            customerData.put(index, customerDataList);
            Set<Integer> newCustomerRows = customerData.keySet();
            int customerrownum = customerSheet.getLastRowNum();
            for (Integer key : newCustomerRows) {
                Row row = customerSheet.createRow(++customerrownum);
                ArrayList<String> objArr = customerData.get(key);
                int cellnum2 = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum2++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Boolean) {
                        cell.setCellValue((Boolean) obj);
                    } else if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }
                }
            }
            FileOutputStream customerOs = new FileOutputStream(file);
            workbook2.write(customerOs);
            customerOs.close();

            Workbook workbook3;
            FileInputStream inputFile3 = new FileInputStream(file);
            workbook3 = new XSSFWorkbook(inputFile3);
            Sheet addressSheet = workbook3.getSheet("Address");
            ArrayList<String> addressDataList = new ArrayList<>();
            addressDataList.add(String.valueOf(index));
            addressDataList.add(address.street);
            addressDataList.add(address.city);
            addressDataList.add(address.postalCode);
            addressDataList.add(address.country);
            Map<Integer, ArrayList<String>> addressData = new HashMap<>();
            addressData.put(index, addressDataList);
            Set<Integer> newAddressRows = addressData.keySet();
            int addressrownum = addressSheet.getLastRowNum();
            for (Integer key : newAddressRows) {
                Row row = addressSheet.createRow(++addressrownum);
                ArrayList<String> objArr = addressData.get(key);
                int cellnum3 = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum3++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Boolean) {
                        cell.setCellValue((Boolean) obj);
                    } else if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }
                }
            }
            FileOutputStream addressOs = new FileOutputStream(file);
            workbook3.write(addressOs);
            addressOs.close();

            Workbook workbook4;
            FileInputStream inputFile4 = new FileInputStream(file);
            workbook4 = new XSSFWorkbook(inputFile4);

            Sheet paymentSheet = workbook4.getSheet("Payment");
            ArrayList<String> paymentDataList = new ArrayList<>();
            paymentDataList.add(String.valueOf(index));
            paymentDataList.add(payment.cardNo);
            paymentDataList.add(payment.cardName);
            paymentDataList.add(String.valueOf(payment.cardExpiryYear));
            paymentDataList.add(String.valueOf(payment.cardExpiryMonth));
            paymentDataList.add(payment.cardCVV);
            Map<Integer, ArrayList<String>> paymentData = new HashMap<>();
            paymentData.put(index, paymentDataList);
            Set<Integer> newPaymentRows = paymentData.keySet();
            int paymentnewrows = paymentSheet.getLastRowNum();
            for (Integer key : newPaymentRows) {
                Row row = paymentSheet.createRow(++paymentnewrows);
                ArrayList<String> objArr = paymentData.get(key);
                int cellnum4 = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum4++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Boolean) {
                        cell.setCellValue((Boolean) obj);
                    } else if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }
                }
            }
            FileOutputStream paymentOs = new FileOutputStream(file);
            workbook4.write(paymentOs);
            paymentOs.close();

            Workbook workbook5;
            FileInputStream inputFile5 = new FileInputStream(file);
            workbook5 = new XSSFWorkbook(inputFile5);

            Sheet payoutSheet = workbook5.getSheet("Payout");
            ArrayList<String> payoutDataList = new ArrayList<>();
            payoutDataList.add(String.valueOf(index));
            payoutDataList.add(payout.accountNo);
            payoutDataList.add(payout.accountName);
            Map<Integer, ArrayList<String>> payoutData = new HashMap<>();
            payoutData.put(index, payoutDataList);
            Set<Integer> newPayoutRows = payoutData.keySet();
            int payoutnewrows = payoutSheet.getLastRowNum();
            for (Integer key : newPayoutRows) {
                Row row = payoutSheet.createRow(++payoutnewrows);
                ArrayList<String> objArr = payoutData.get(key);
                int cellnum5 = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum5++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Boolean) {
                        cell.setCellValue((Boolean) obj);
                    } else if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }
                }
            }
            FileOutputStream payoutOs = new FileOutputStream(file);
            workbook5.write(payoutOs);
            payoutOs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String signIn(String userEmail, String password) {
        readCustomerData();
        for(int i=1; i<customerMap.size()+1; i++) {
            if (customerMap.get(1).userEmail.equals(userEmail) && customerMap.get(1).password.equals(password)) {
                this.userAddress = customerMap.get(1).userAddress;
                this.userName = customerMap.get(1).userName;
                this.offerList = customerMap.get(1).offerList;
                this.orderList = customerMap.get(1).orderList;
                this.userPayment = customerMap.get(1).userPayment;
                this.userPayout = customerMap.get(1).userPayout;
                this.userShoeSize = customerMap.get(1).userShoeSize;
                this.userID = customerMap.get(1).userID;
                this.password = customerMap.get(1).password;
                this.userEmail = customerMap.get(1).userEmail;
                this.userType = customerMap.get(1).userType;
                return customerMap.get(i).userType;
            }
        }
        return "blad";
    }
}

