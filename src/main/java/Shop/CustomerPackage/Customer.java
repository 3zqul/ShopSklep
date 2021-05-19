package Shop.CustomerPackage;

import Shop.Panels;
import Shop.User;
import Shop.WorkerPackage.Shoe;
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

    public Customer(int userID, String password, String userEmail, int userShoeSize, String userName, Payout userPayout, Payment userPayment, Address userAddress, List<Offer> offerList, List<Order> orderList) {
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

        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputFile);
            Sheet userSheet = workbook.getSheet("User");
            Map<Integer, List<String>> userMap = new HashMap<>();
            int i = 0;
            for (Row userRow : userSheet) {
                userMap.put(i, new ArrayList<>());
                for (Cell userCell : userRow) {
                    switch (userCell.getCellType()) {
                        case STRING:
                            userMap.get(i).add(userCell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(userCell)) {
                                userMap.get(i).add(userCell.getDateCellValue() + "");
                            } else {
                                userMap.get(i).add(userCell.getNumericCellValue() + "");
                            }
                            break;
                        default:
                            userMap.get(i).add(" ");
                            break;
                    }
                }
                i++;
            }
            for (int j = 0; j < userMap.size(); ++j) {
                if (userEmail.equals(userMap.get(j).get(1))) {
                    result = true;
                    break;
                }
            }
            ArrayList<String> userDataList = new ArrayList<>();
            userDataList.add(Integer.toString(i));
            userDataList.add(userEmail);
            userDataList.add(password);
            userDataList.add("c");
            Map<Integer, ArrayList<String>> userData = new HashMap<>();
            userData.put(i, userDataList);
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
            customerDataList.add(Integer.toString(i));
            customerDataList.add(userName);
            customerDataList.add(Integer.toString(userShoeSize));
            Map<Integer, ArrayList<String>> customerData = new HashMap<>();
            customerData.put(i, customerDataList);
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
            addressDataList.add(String.valueOf(i));
            addressDataList.add(address.street);
            addressDataList.add(address.city);
            addressDataList.add(address.postalCode);
            addressDataList.add(address.country);
            Map<Integer, ArrayList<String>> addressData = new HashMap<>();
            addressData.put(i, addressDataList);
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
            paymentDataList.add(String.valueOf(i));
            paymentDataList.add(payment.cardNo);
            paymentDataList.add(payment.cardName);
            paymentDataList.add(String.valueOf(payment.cardExpiryYear));
            paymentDataList.add(String.valueOf(payment.cardExpiryMonth));
            paymentDataList.add(payment.cardCVV);
            Map<Integer, ArrayList<String>> paymentData = new HashMap<>();
            paymentData.put(i, paymentDataList);
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
            payoutDataList.add(String.valueOf(i));
            payoutDataList.add(payout.accountNo);
            payoutDataList.add(payout.accountName);
            Map<Integer, ArrayList<String>> payoutData = new HashMap<>();
            payoutData.put(i, payoutDataList);
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

    public String readUserID(String userEmail, String password) {
        Float converter;
        String result=null;

        try {
            Workbook workbook;
            FileInputStream readFile = new FileInputStream(file);
            workbook = new XSSFWorkbook(readFile);
            Sheet sheet = workbook.getSheet("User");
            Map<Integer, List<String>> map = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                map.put(i, new ArrayList<>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            map.get(i).add(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                map.get(i).add(cell.getDateCellValue() + "");
                            } else {
                                map.get(i).add(cell.getNumericCellValue() + "");
                            }
                            break;
                        default:
                            map.get(i).add(" ");
                    }
                }
                i++;
            }
            for (int j = 1; j < map.size(); j++) {
                if (map.get(j).get(2).equals(password) && map.get(j).get(1).equals(userEmail)) {
                    result = "c";
                    converter = new Float(map.get(j).get(0));
                    userID = converter.intValue();
                    this.password = password;
                    this.userEmail = userEmail;
                }else{
                    result = "b";
                }
            }
            try {
                Workbook workbook2;
                FileInputStream readFile2 = new FileInputStream(file);
                workbook2 = new XSSFWorkbook(readFile2);
                Sheet sheet2 = workbook2.getSheet("Customer");
                Map<Integer, List<String>> map2 = new HashMap<>();
                int count2 = 0;
                for (Row row : sheet2) {
                    map2.put(count2, new ArrayList<>());
                    for (Cell cell : row) {
                        switch (cell.getCellType()) {
                            case STRING:
                                map2.get(count2).add(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    map2.get(count2).add(cell.getDateCellValue() + "");
                                } else {
                                    map2.get(count2).add(cell.getNumericCellValue() + "");
                                }
                                break;
                            default:
                                map2.get(count2).add(" ");
                        }
                    }
                    count2++;
                }
                for (int j = 1; j < map2.size() - 1; j++) {
                    if (!map2.get(j).get(0).equals(String.valueOf(userID))) {
                        userName = map2.get(j).get(1);
                        converter = new Float(map2.get(j).get(2));
                        userShoeSize = converter.intValue();
                        break;
                    }
                }
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            try {
                Workbook workbook3;
                FileInputStream readFile3 = new FileInputStream(file);
                workbook3 = new XSSFWorkbook(readFile3);
                Sheet sheet3 = workbook3.getSheet("Address");
                Map<Integer, List<String>> map3 = new HashMap<>();
                int count3 = 0;
                for (Row row : sheet3) {
                    map3.put(count3, new ArrayList<>());
                    for (Cell cell : row) {
                        switch (cell.getCellType()) {
                            case STRING:
                                map3.get(count3).add(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    map3.get(count3).add(cell.getDateCellValue() + "");
                                } else {
                                    map3.get(count3).add(cell.getNumericCellValue() + "");
                                }
                                break;
                            default:
                                map3.get(count3).add(" ");
                        }
                    }
                    count3++;
                }
                for (int j = 1; j < map3.size(); j++) {
                    if (!map3.get(j).get(0).equals(String.valueOf(userID))) {
                        userAddress = new Address(map3.get(j).get(1), map3.get(j).get(2), map3.get(j).get(3), map3.get(j).get(4));
                        break;
                    }
                }
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }

            try {
                Workbook workbook4;
                FileInputStream readFile4 = new FileInputStream(file);
                workbook4 = new XSSFWorkbook(readFile4);
                Sheet sheet4 = workbook4.getSheet("Payment");
                Map<Integer, List<String>> map4 = new HashMap<>();
                int count4 = 0;
                for (Row row : sheet4) {
                    map4.put(count4, new ArrayList<>());
                    for (Cell cell : row) {
                        switch (cell.getCellType()) {
                            case STRING:
                                map4.get(count4).add(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    map4.get(count4).add(cell.getDateCellValue() + "");
                                } else {
                                    map4.get(count4).add(cell.getNumericCellValue() + "");
                                }
                                break;
                            default:
                                map4.get(count4).add(" ");
                        }
                    }
                    count4++;
                }
                for (int j = 1; j < map4.size(); j++) {
                    if (!map4.get(j).get(0).equals(String.valueOf(userID))) {
                        Float converter1 = new Float(map4.get(j).get(3));
                        Float converter2 = new Float(map4.get(j).get(4));
                        userPayment = new Payment(map4.get(j).get(1), map4.get(j).get(2), converter1.intValue(), converter2.intValue(), map4.get(j).get(5));
                        break;
                    }
                }
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }

            try {
                Workbook workbook5;
                FileInputStream readFile5 = new FileInputStream(file);
                workbook5 = new XSSFWorkbook(readFile5);
                Sheet sheet5 = workbook5.getSheet("Payout");
                Map<Integer, List<String>> map5 = new HashMap<>();
                int count5 = 0;
                for (Row row : sheet5) {
                    map5.put(count5, new ArrayList<>());
                    for (Cell cell : row) {
                        switch (cell.getCellType()) {
                            case STRING:
                                map5.get(count5).add(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    map5.get(count5).add(cell.getDateCellValue() + "");
                                } else {
                                    map5.get(count5).add(cell.getNumericCellValue() + "");
                                }
                                break;
                            default:
                                map5.get(count5).add(" ");
                        }
                    }
                    count5++;
                }
                for (int j = 1; j < map5.size(); j++) {
                    if (!map5.get(j).get(0).equals(String.valueOf(userID))) {
                        userPayout = new Payout(map5.get(j).get(1), map5.get(j).get(2));
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Workbook workbook6;
                FileInputStream readFile6 = new FileInputStream(file);
                workbook6 = new XSSFWorkbook(readFile6);
                Sheet sheet6 = workbook6.getSheet("Offer");
                Map<Integer, List<String>> map6 = new HashMap<>();
                int count6 = 0;
                for (Row row : sheet6) {
                    map6.put(count6, new ArrayList<>());
                    for (Cell cell : row) {
                        switch (cell.getCellType()) {
                            case STRING:
                                map6.get(count6).add(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    map6.get(count6).add(cell.getDateCellValue() + "");
                                } else {
                                    map6.get(count6).add(cell.getNumericCellValue() + "");
                                }
                                break;
                            default:
                                map6.get(count6).add(" ");
                        }
                    }
                    count6++;
                }
                offerList = new ArrayList<>();
                for (int j = 1; j < map6.size(); j++) {
                    if (!map6.get(j).get(0).equals(String.valueOf(userID))) {
                        Offer offer = new Offer();
                        converter = new Float(map6.get(j).get(1));
                        offer.offerID = converter.intValue();
                        converter = new Float(map6.get(j).get(2));
                        offer.offerID = converter.intValue();
                        offer.shoeSize = map6.get(j).get(3);
                        converter = new Float(map6.get(j).get(4));
                        offer.offerPrice = converter;
                        offer.offerType = map6.get(j).get(5);
                        offerList.add(offer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Workbook workbook7;
            FileInputStream readFile7 = new FileInputStream(file);
            workbook7 = new XSSFWorkbook(readFile7);
            Sheet sheet7 = workbook7.getSheet("Order");
            Map<Integer, List<String>> map7 = new HashMap<>();
            int count7 = 0;
            for (Row row : sheet7) {
                map7.put(count7, new ArrayList<>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            map7.get(count7).add(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                map7.get(count7).add(cell.getDateCellValue() + "");
                            } else {
                                map7.get(count7).add(cell.getNumericCellValue() + "");
                            }
                            break;
                        default:
                            map7.get(count7).add(" ");
                    }
                }
                count7++;
            }
            Workbook workbook8;
            FileInputStream readFile8 = new FileInputStream(file);
            workbook8 = new XSSFWorkbook(readFile8);
            Sheet sheet8 = workbook8.getSheet("ShoeDetails");
            Map<Integer, List<String>> map8 = new HashMap<>();
            int count8 = 0;
            for (Row row2 : sheet8) {
                map8.put(count8, new ArrayList<>());
                for (Cell cell : row2) {
                    switch (cell.getCellType()) {
                        case STRING:
                            map8.get(count8).add(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                map8.get(count8).add(cell.getDateCellValue() + "");
                            } else {
                                map8.get(count8).add(cell.getNumericCellValue() + "");
                            }
                            break;
                        default:
                            map8.get(count8).add(" ");
                    }
                }
                count8++;
            }
            orderList = new ArrayList<>();
            for (int k = 1; k < map8.size(); k++) {
                if (!map8.get(k).get(0).equals(String.valueOf(userID))) {
                    ShoeDetails shoeDetails = new ShoeDetails();
                    converter = new Float(map8.get(k).get(1));
                    shoeDetails.orderID = converter.intValue();
                    shoeDetails.shoeName = map8.get(k).get(2);
                    converter = new Float(map8.get(k).get(3));
                    shoeDetails.shoePrice = converter;
                    shoeDetails.shoeSize = map8.get(k).get(4);
                    for (int j = 1; j < map7.size(); j++) {
                        if (!map7.get(j).get(0).equals(String.valueOf(userID)) && !map7.get(j).get(1).equals(String.valueOf(shoeDetails.orderID))) {
                            Order order = new Order();
                            converter = new Float(map7.get(j).get(0));
                            order.orderID = converter.intValue();
                            order.orderDate = map7.get(j).get(1);
                            converter = new Float(map7.get(j).get(2));
                            order.sellerID = converter.intValue();
                            order.customerID = this.userID;
                            order.shoeDetails = shoeDetails;
                            orderList.add(order);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String signIn(String userEmail, String password) {
        return readUserID(userEmail, password);
    }
}

