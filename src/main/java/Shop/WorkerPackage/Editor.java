package Shop.WorkerPackage;

import Shop.CustomerPackage.*;
import Shop.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Editor extends User{

    Catalog catalog = new Catalog();
    protected Map<Integer, Order> orderMap;
    protected Map<Integer, Editor> editorMap;

    public Editor(Integer userID, String password, String userEmail, String userType){
        this.userID = userID;
        this.password = password;
        this.userEmail = userEmail;
        this.userType = userType;
    }

    public Editor(){}

    public Map<Integer, Order> returnOrderMap(){
        return orderMap;
    }

    public void readEditorData(){

        editorMap = new HashMap<>();

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
                                map.get(i).add(String.valueOf(cell.getDateCellValue()));
                            } else {
                                map.get(i).add(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        default:
                            map.get(i).add(" ");
                    }
                }
                i++;
            }
            int index=1;
            for(int j=1; j< map.size(); j++){
                if (map.get(j).get(3).equals("e")) {
                    Float converter;
                    converter = new Float(map.get(j).get(0));
                    editorMap.put(index, new Editor(converter.intValue(), map.get(j).get(1), map.get(j).get(2), map.get(j).get(3)));
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readOrderData(){

        readUserData();

        orderMap = new HashMap<>();
        Address orderAddress;

        try {
            Workbook workbook;
            FileInputStream readFile = new FileInputStream(file);
            workbook = new XSSFWorkbook(readFile);
            Sheet sheet = workbook.getSheet("Order");
            Map<Integer, List<String>> map = new HashMap<>();
            int count = 0;
            for (Row row : sheet) {
                map.put(count, new ArrayList<>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            map.get(count).add(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                map.get(count).add(String.valueOf(cell.getDateCellValue()));
                            } else {
                                map.get(count).add(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        default:
                            map.get(count).add(" ");
                    }
                }
                count++;
            }
            Workbook workbook2;
            FileInputStream readFile2 = new FileInputStream(file);
            workbook2 = new XSSFWorkbook(readFile2);
            Sheet sheet2 = workbook2.getSheet("ShoeDetails");
            Map<Integer, List<String>> map2 = new HashMap<>();
            int count2 = 0;
            for (Row row2 : sheet2) {
                map2.put(count2, new ArrayList<>());
                for (Cell cell : row2) {
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
            Workbook workbook3;
            FileInputStream readFile3 = new FileInputStream(file);
            workbook3 = new XSSFWorkbook(readFile3);
            Sheet sheet3 = workbook3.getSheet("OrderAddress");
            Map<Integer, List<String>> map3 = new HashMap<>();
            int count3 = 0;
            for (Row row2 : sheet3) {
                map3.put(count3, new ArrayList<>());
                for (Cell cell : row2) {
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
            orderMap = new HashMap<>();
            for (int k = 1; k < map.size(); k++) {
                ShoeDetails shoeDetails = new ShoeDetails(new Float(map2.get(k).get(2)).intValue(), map2.get(k).get(3), new Float(map2.get(k).get(5)).intValue(), new Float(map2.get(k).get(4)), new Float(map2.get(k).get(1)).intValue());
                orderAddress = new Address(map3.get(k).get(2), map3.get(k).get(3), map3.get(k).get(4), map3.get(k).get(5));
                if (new Float(map.get(k).get(0)).equals(new Float(map2.get(k).get(1)))) {
                    if (new Float(map.get(k).get(0)).equals(new Float(map3.get(k).get(1)))) {
                        orderMap.put(k, new Order(new Float(map.get(k).get(0)).intValue(), map.get(k).get(1), new Float(map.get(k).get(2)).intValue(), new Float(map.get(k).get(3)).intValue(), shoeDetails, orderAddress));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String signIn(String userEmail, String password) {
        readEditorData();
        for(int i=1; i<editorMap.size()+1; i++) {
            if (editorMap.get(i).userEmail.equals(userEmail) && editorMap.get(i).password.equals(password)) {
                this.userID = editorMap.get(i).userID;
                this.password = editorMap.get(i).password;
                this.userEmail = editorMap.get(i).userEmail;
                this.userType = editorMap.get(i).userType;
                return editorMap.get(i).userType;
            }
        }
        return "blad";
    }

    public Shoe toList(int i){
        while(i<catalog.shoeList.size()){
            return catalog.shoeList.get(i);
        }
        return null;
    }

    public List<Shoe> addShoe(String shoeName){
        int index;
        index=catalog.shoeList.size();
        for(int i=1; i<=8; i++){
            catalog.shoeList.add(new Shoe(index+i, shoeName, 37+i, (float) 0, (float) 0, 0, 0));
        }
        return catalog.shoeList;
    }

    public List<Shoe> deleteShoe(String shoeName){
        for(int i=catalog.shoeList.size()-1; i>=1; i--){
            if(catalog.shoeList.get(i).shoeName.equals(shoeName)){
                catalog.shoeList.remove(i);
            }
        }
        return catalog.shoeList;
    }

    public void editOrder(int orderID, String street, String city, String postalCode, String country){
        for(int i=0; i<orderMap.size(); i++){
            if(orderMap.get(i).returnOrderID() == orderID){
                orderMap.get(i).editOrderAddress(new Address(street, city, postalCode, country));
            }
        }
    }

    public void updateCustomerDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("Customer");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> customerData;
            Map<Integer, ArrayList<String>> customerMapData = new HashMap<>();
            customerData = new ArrayList<>();
            customerData.add("userID");
            customerData.add("userName");
            customerData.add("userShoeSize");
            customerMapData.put(0, customerData);
            for(int i=0; i<customerMap.size(); i++) {
                customerData = new ArrayList<>();
                customerData.add(String.valueOf(customerMap.get(i).returnUserID()));
                customerData.add(customerMap.get(i).returnUserName());
                customerData.add(String.valueOf(customerMap.get(i).returnUserShoeSize()));
                customerMapData.put(i+1, customerData);
            }
            Set<Integer> newCustomerRows = customerMapData.keySet();
            int newcustomerrows = 0;
            for (Integer key : newCustomerRows) {
                Row row = sheet.createRow(newcustomerrows++);
                ArrayList<String> objArr = customerMapData.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
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
            FileOutputStream customerWrite = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(customerWrite);
            customerWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateUserDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("User");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> userData;
            Map<Integer, ArrayList<String>> userMapData = new HashMap<>();
            userData = new ArrayList<>();
            userData.add("userID");
            userData.add("userEmail");
            userData.add("password");
            userData.add("userType");
            userMapData.put(0, userData);
            for(int i=0; i<userMap.size(); i++) {
                userData = new ArrayList<>();
                userData.add(String.valueOf(userMap.get(i).returnUserID()));
                userData.add(userMap.get(i).returnUserEmail());
                userData.add(userMap.get(i).returnPassword());
                userData.add(userMap.get(i).returnUserType());
                userMapData.put(i+1, userData);
            }
            Set<Integer> newUserRows = userMap.keySet();
            int newuserrows = 0;
            for (Integer key : newUserRows) {
                Row row = sheet.createRow(newuserrows++);
                ArrayList<String> objArr = userMapData.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
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
            FileOutputStream userWrite = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(userWrite);
            userWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateAddressDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("Address");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> userData;
            Map<Integer, ArrayList<String>> addressMapData = new HashMap<>();
            userData = new ArrayList<>();
            userData.add("userID");
            userData.add("street");
            userData.add("city");
            userData.add("postalCode");
            userData.add("country");
            addressMapData.put(0, userData);
            for(int i=0; i<customerMap.size(); i++) {
                userData = new ArrayList<>();
                userData.add(String.valueOf(customerMap.get(i).returnUserAddress().returnStreet()));
                userData.add(customerMap.get(i).returnUserAddress().returnCity());
                userData.add(customerMap.get(i).returnUserAddress().returnPostalCode());
                userData.add(customerMap.get(i).returnUserAddress().returnCountry());
                addressMapData.put(i+1, userData);
            }
            Set<Integer> newAddressRows = addressMapData.keySet();
            int newaddressrows = 0;
            for (Integer key : newAddressRows) {
                Row row = sheet.createRow(newaddressrows++);
                ArrayList<String> objArr = addressMapData.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
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
            FileOutputStream userWrite = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(userWrite);
            userWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updatePaymentDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("Payment");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> paymentData;
            Map<Integer, ArrayList<String>> paymentDataMap = new HashMap<>();
            paymentData = new ArrayList<>();
            paymentData.add("userID");
            paymentData.add("cardNo");
            paymentData.add("cardName");
            paymentData.add("cardExpiryYear");
            paymentData.add("cardExpiryMonth");
            paymentData.add("cardCVV");
            paymentDataMap.put(0, paymentData);
            for(int i=0; i<customerMap.size(); i++) {
                paymentData = new ArrayList<>();
                paymentData.add(String.valueOf(customerMap.get(i).returnUserID()));
                paymentData.add(String.valueOf(customerMap.get(i).returnUserPayment().returnCardNo()));
                paymentData.add(customerMap.get(i).returnUserPayment().returnCardName());
                paymentData.add(String.valueOf(customerMap.get(i).returnUserPayment().returnCardExpiryYear()));
                paymentData.add(String.valueOf(customerMap.get(i).returnUserPayment().returnCardExpiryMonth()));
                paymentData.add(String.valueOf(customerMap.get(i).returnUserPayment().returnCardCVV()));
                paymentDataMap.put(i+1, paymentData);
            }
            Set<Integer> newPaymentRows = paymentDataMap.keySet();
            int newpaymentrows = 0;
            for (Integer key : newPaymentRows) {
                Row row = sheet.createRow(newpaymentrows++);
                ArrayList<String> objArr = paymentDataMap.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
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
            FileOutputStream userWrite = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(userWrite);
            userWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updatePayoutDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("Payout");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> payoutData;
            Map<Integer, ArrayList<String>> payoutDataMap = new HashMap<>();
            payoutData = new ArrayList<>();
            payoutData.add("userID");
            payoutData.add("accountNo");
            payoutData.add("accountName");
            payoutDataMap.put(0, payoutData);
            for(int i=0; i<customerMap.size(); i++) {
                payoutData = new ArrayList<>();
                payoutData.add(String.valueOf(customerMap.get(i).returnUserID()));
                payoutData.add(String.valueOf(customerMap.get(i).returnUserPayout().returnAccountNo()));
                payoutData.add(customerMap.get(i).returnUserPayout().returnAccountName());
                payoutDataMap.put(i+1, payoutData);
            }
            Set<Integer> newPayoutRows = payoutDataMap.keySet();
            int newpayoutrows = 0;
            for (Integer key : newPayoutRows) {
                Row row = sheet.createRow(newpayoutrows++);
                ArrayList<String> objArr = payoutDataMap.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
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
            FileOutputStream payoutWrite = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(payoutWrite);
            payoutWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("Order");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> orderData;
            Map<Integer, ArrayList<String>> orderDataMap = new HashMap<>();
            orderData = new ArrayList<>();
            orderData.add("orderID");
            orderData.add("orderDate");
            orderData.add("customerID");
            orderData.add("sellerID");
            orderDataMap.put(0, orderData);
            for(int i=0; i<orderMap.size(); i++) {
                orderData = new ArrayList<>();
                orderData.add(String.valueOf(orderMap.get(i).returnOrderID()));
                orderData.add(orderMap.get(i).returnOrderDate());
                orderData.add(String.valueOf(orderMap.get(i).returnCustomerID()));
                orderData.add(String.valueOf(orderMap.get(i).returnSellerID()));
                orderDataMap.put(i + 1, orderData);
            }
            Set<Integer> newOrderRows = orderDataMap.keySet();
            int neworderrows = 0;
            for (Integer key : newOrderRows) {
                Row row = sheet.createRow(neworderrows++);
                ArrayList<String> objArr = orderDataMap.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
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
            FileOutputStream orderWrite = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(orderWrite);
            orderWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateShoeDetailsDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("Shoe Details");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> shoeDetailsData;
            Map<Integer, ArrayList<String>> shoeDetailsMapData = new HashMap<>();
            shoeDetailsData = new ArrayList<>();
            shoeDetailsData.add("userID");
            shoeDetailsData.add("orderID");
            shoeDetailsData.add("shoeID");
            shoeDetailsData.add("shoeName");
            shoeDetailsData.add("shoePrice");
            shoeDetailsData.add("shoeSize");
            shoeDetailsMapData.put(0, shoeDetailsData);
            for(int i=0; i<orderMap.size(); i++) {
                shoeDetailsData = new ArrayList<>();
                shoeDetailsData.add(String.valueOf(orderMap.get(i).returnCustomerID()));
                shoeDetailsData.add(String.valueOf(orderMap.get(i).returnOrderID()));
                shoeDetailsData.add(String.valueOf(orderMap.get(i).returnShoeDetails().returnShoeID()));
                shoeDetailsData.add(orderMap.get(i).returnShoeDetails().returnShoeName());
                shoeDetailsData.add(String.valueOf(orderMap.get(i).returnShoeDetails().returnShoePrice()));
                shoeDetailsData.add(String.valueOf(orderMap.get(i).returnShoeDetails().returnShoeSize()));
                shoeDetailsMapData.put(i + 1, shoeDetailsData);
            }
            Set<Integer> newShoeDetailsRows = shoeDetailsMapData.keySet();
            int newshoedetailsrows = 0;
            for (Integer key : newShoeDetailsRows) {
                Row row = sheet.createRow(newshoedetailsrows++);
                ArrayList<String> objArr = shoeDetailsMapData.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
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
            FileOutputStream orderWrite = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(orderWrite);
            orderWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderAddressDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("Order Address");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> orderAddressData;
            Map<Integer, ArrayList<String>> orderAddressDataMap = new HashMap<>();
            orderAddressData = new ArrayList<>();
            orderAddressData.add("userID");
            orderAddressData.add("orderID");
            orderAddressData.add("street");
            orderAddressData.add("city");
            orderAddressData.add("postalCode");
            orderAddressData.add("country");
            orderAddressDataMap.put(0, orderAddressData);
            for(int i=0; i<orderMap.size(); i++) {
                orderAddressData = new ArrayList<>();
                orderAddressData.add(String.valueOf(orderMap.get(i).returnCustomerID()));
                orderAddressData.add(String.valueOf(orderMap.get(i).returnOrderID()));
                orderAddressData.add(orderMap.get(i).returnOrderAddress().returnStreet());
                orderAddressData.add(orderMap.get(i).returnOrderAddress().returnCity());
                orderAddressData.add(orderMap.get(i).returnOrderAddress().returnPostalCode());
                orderAddressData.add(orderMap.get(i).returnOrderAddress().returnCountry());
                orderAddressDataMap.put(i + 1, orderAddressData);
            }
            Set<Integer> newOrderAddressRows = orderAddressDataMap.keySet();
            int neworderaddressrows = 0;
            for (Integer key : newOrderAddressRows) {
                Row row = sheet.createRow(neworderaddressrows++);
                ArrayList<String> objArr = orderAddressDataMap.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
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
            FileOutputStream orderAddressWrite = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(orderAddressWrite);
            orderAddressWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
