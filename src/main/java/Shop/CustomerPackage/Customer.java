package Shop.CustomerPackage;

import Shop.User;
import Shop.WorkerPackage.Catalog;
import Shop.WorkerPackage.Shoe;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Customer extends User {

    int userShoeSize;
    String userName;
    Payout userPayout;
    Payment userPayment;
    Address userAddress;
    List<Offer> offerList;
    List<Order> orderList;

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

    public void editCustomer(String password, int userShoeSize, String confirmPassword, Payment payment, Address address) {

        this.userShoeSize = userShoeSize;
        this.userName=userName;

        if (password.equals(confirmPassword) && password != null) {
            this.password = password;
        }
        if (payment.cardNo.length() == 16 && payment.cardExpiryMonth < 13 && payment.cardExpiryYear < 99 && payment.cardCVV.length() == 3) {
            this.userPayment = new Payment(payment.cardNo, this.userName, payment.cardExpiryMonth, payment.cardExpiryYear, payment.cardCVV);
        }
        if (address.street != null && address.city != null && address.postalCode != null && address.country != null) {
            this.userAddress = new Address(address.street, address.city, address.postalCode, address.country);
        }
        System.out.println(userAddress.toString());
        System.out.println(userPayment.toString());
    }

    public boolean signUp(String userEmail, String userName, String password, int userShoeSize, Address address, Payment payment, Payout payout) {
        boolean result = false;
        int index = 1;

        readUserData();

        try {
            for (int j = 1; j < userMap.size() + 1; j++) {
                if (!userEmail.equals(userMap.get(j).userEmail)) {
                    result = true;
                    index++;
                }
            }
            if (result) {
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

                FileInputStream inputFile6 = new FileInputStream(file);
                Workbook workbook6 = new XSSFWorkbook(inputFile6);
                Sheet userSheet6 = workbook6.getSheet("Offer");
                ArrayList<String> offerDataList = new ArrayList<>();
                offerDataList.add(Integer.toString(index));
                offerDataList.add("12");
                offerDataList.add("12");
                offerDataList.add("12");
                offerDataList.add("12.0");
                offerDataList.add("es");
                offerDataList.add("es");
                Map<Integer, ArrayList<String>> offerData = new HashMap<>();
                offerData.put(index, offerDataList);
                Set<Integer> newOfferRows = offerData.keySet();
                int offerrownum = userSheet6.getLastRowNum();
                for (Integer key : newOfferRows) {
                    Row row = userSheet6.createRow(++offerrownum);
                    ArrayList<String> objArr = offerData.get(key);
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
                FileOutputStream offerOs = new FileOutputStream(file);
                workbook6.write(offerOs);
                offerOs.close();

                FileInputStream inputFile7 = new FileInputStream(file);
                Workbook workbook7 = new XSSFWorkbook(inputFile7);
                Sheet userSheet7 = workbook7.getSheet("Order");
                ArrayList<String> orderDataList = new ArrayList<>();
                orderDataList.add("40");
                orderDataList.add("es");
                orderDataList.add(Integer.toString(index));
                orderDataList.add("40");
                Map<Integer, ArrayList<String>> orderData = new HashMap<>();
                orderData.put(index, orderDataList);
                Set<Integer> newOrderRows = orderData.keySet();
                int orderrownum = userSheet7.getLastRowNum();
                for (Integer key : newOrderRows) {
                    Row row = userSheet7.createRow(++orderrownum);
                    ArrayList<String> objArr = orderData.get(key);
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
                FileOutputStream orderOs = new FileOutputStream(file);
                workbook7.write(orderOs);
                orderOs.close();

                FileInputStream inputFile8 = new FileInputStream(file);
                Workbook workbook8 = new XSSFWorkbook(inputFile8);
                Sheet userSheet8 = workbook8.getSheet("ShoeDetails");
                ArrayList<String> shoeDetailsDataList = new ArrayList<>();
                shoeDetailsDataList.add(Integer.toString(index));
                shoeDetailsDataList.add("12");
                shoeDetailsDataList.add("12");
                shoeDetailsDataList.add("es");
                shoeDetailsDataList.add("12.0");
                shoeDetailsDataList.add("40");
                Map<Integer, ArrayList<String>> shoeDetailsData = new HashMap<>();
                shoeDetailsData.put(index, shoeDetailsDataList);
                Set<Integer> newShoeDetailsRows = shoeDetailsData.keySet();
                int shoedetailsrownum = userSheet8.getLastRowNum();
                for (Integer key : newShoeDetailsRows) {
                    Row row = userSheet8.createRow(++shoedetailsrownum);
                    ArrayList<String> objArr = shoeDetailsData.get(key);
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
                FileOutputStream shoeDetailsOs = new FileOutputStream(file);
                workbook8.write(shoeDetailsOs);
                shoeDetailsOs.close();
            }
            } catch(Exception e){
                e.printStackTrace();
            }
        return result;
    }

    public List<Offer> returnOffers() {
        return offerList;
    }

    public List<Order> returnOrders() {
        return orderList;
    }

    public void createOffer(int shoeID, int shoeSize, Float offerPrice, String offerType, String shoeName){
        int index = 0;
        for(int i=1; i<customerMap.size(); i++){
            index += customerMap.get(i).offerList.size();
        }
        Offer offer = new Offer(index, shoeID, shoeSize, offerPrice, offerType, shoeName);
        offerList.add(offer);
    }

    public void deleteOffer(int index){
        offerList.remove(index);
    }

    public void createOrder(String orderDate, int customerID, int sellerID, ShoeDetails shoeDetails){
        int index = 0;
        for(int i=1; i<customerMap.size(); i++){
            index += customerMap.get(i).orderList.size();
        }
        Order order = new Order(index, orderDate, customerID, sellerID, new ShoeDetails(shoeDetails.shoeID, shoeDetails.shoeName, shoeDetails.shoeSize, shoeDetails.shoePrice, index), userAddress);
        orderList.add(order);
    }

    public void deleteOrder(int index){
        orderList.remove(index);
    }

    @Override
    public String signIn(String userEmail, String password) {
        readCustomerData();
        for(int i=1; i<customerMap.size()+1; i++) {
            if (customerMap.get(i).userEmail.equals(userEmail) && customerMap.get(i).password.equals(password)) {
                this.userAddress = customerMap.get(i).userAddress;
                this.userName = customerMap.get(i).userName;
                this.offerList = customerMap.get(i).offerList;
                this.orderList = customerMap.get(i).orderList;
                this.userPayment = customerMap.get(i).userPayment;
                this.userPayout = customerMap.get(i).userPayout;
                this.userShoeSize = customerMap.get(i).userShoeSize;
                this.userID = customerMap.get(i).userID;
                this.password = customerMap.get(i).password;
                this.userEmail = customerMap.get(i).userEmail;
                this.userType = customerMap.get(i).userType;
                return customerMap.get(i).userType;
            }
        }
        return "blad";
    }
}