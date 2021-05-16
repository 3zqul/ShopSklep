package Shop.CustomerPackage;

import Shop.FileRead;
import Shop.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class Customer extends User implements FileRead {

    protected int userShoeSize;
    protected String userName;
    protected Payout userPayout;
    protected Payment userPayment;
    protected Address userAddress;
    protected Offer userOffer;
    protected Order userOrder;

    public Customer(){}

    public Customer(int userShoeSize, String userName, Payout userPayout, Payment userPayment, Address userAddress, Offer userOffer, Order userOrder){
        this.userAddress=userAddress;
        this.userName=userName;
        this.userOffer=userOffer;
        this.userOrder=userOrder;
        this.userPayment=userPayment;
        this.userPayout=userPayout;
        this.userShoeSize=userShoeSize;
    }

    public void displayOrders(){
        
    }
    public void displayAccount(){

    }
    public boolean changePassword(String password){
        boolean result = false;

        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputFile);
            Sheet userSheet = workbook.getSheet("User");
            Map<Integer, List<String>> map = new HashMap<>();
            int i=0;
            for(Row userRow : userSheet){
                map.put(i, new ArrayList<>());
                for(Cell userCell : userRow){
                    switch (userCell.getCellType()){
                        case STRING:
                            map.get(i).add(userCell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(userCell)) {
                                map.get(i).add(userCell.getDateCellValue() + "");
                            } else {
                                map.get(i).add(userCell.getNumericCellValue() + "");
                            }
                            break;
                        default: map.get(i).add(" ");
                            break;
                    }
                }
                i++;
                if(map.get(i).get(3).equals(userID)) {
                    this.password=password;
                    break;
                }
            }
            ArrayList<String> dataList = new ArrayList<>();
            dataList.add(userName);
            dataList.add(String.valueOf(userShoeSize));
            dataList.add(String.valueOf(userID));
            Map<Integer, ArrayList<String>> userData = new HashMap<>();
            userData.put(i, dataList);
            Set<Integer> newCustomerrRows = userData.keySet();
            int customerrownum = userSheet.getLastRowNum();
            for (Integer key : newCustomerrRows) {
                Row row = userSheet.createRow(++customerrownum);
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
            FileOutputStream customerOs = new FileOutputStream(file);
            workbook.write(customerOs);
            customerOs.close();
            result=true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean changeShoeSize(Integer userShoeSize){
        boolean result = false;

        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputFile);
            Sheet userSheet = workbook.getSheet("Customer");
            Map<Integer, List<String>> map = new HashMap<>();
            int i=0;
            for(Row userRow : userSheet){
                map.put(i, new ArrayList<>());
                for(Cell userCell : userRow){
                    switch (userCell.getCellType()){
                        case STRING:
                            map.get(i).add(userCell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(userCell)) {
                                map.get(i).add(userCell.getDateCellValue() + "");
                            } else {
                                map.get(i).add(userCell.getNumericCellValue() + "");
                            }
                            break;
                        default: map.get(i).add(" ");
                            break;
                    }
                }
                i++;
                if(map.get(i).get(2).equals(userID)) {
                    this.userShoeSize=userShoeSize;
                    break;
                }
            }
            ArrayList<String> dataList = new ArrayList<>();
            dataList.add(this.userEmail);
            dataList.add(this.password);
            dataList.add("c");
            dataList.add(Integer.toString(this.userID));
            Map<Integer, ArrayList<String>> userData = new HashMap<>();
            userData.put(i, dataList);
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
            result=true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    public boolean signUp(String userEmail, String userName, String password, int userShoeSize){
        boolean result = false;

        try{
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputFile);
            Sheet userSheet = workbook.getSheet("User");
            Map<Integer, List<String>> userMap = new HashMap<>();
            int i=0;
            for(Row userRow : userSheet){
                userMap.put(i, new ArrayList<>());
                for(Cell userCell : userRow){
                    switch (userCell.getCellType()){
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
                        default: userMap.get(i).add(" ");
                            break;
                    }
                }
                i++;
            }
            for(int j=0; j<userMap.size(); ++j) {
                if (userEmail.equals(userMap.get(j).get(0))) {
                    break;
                } else {
                    result = true;
                }
            }
            ArrayList<String> userDataList = new ArrayList<>();
            userDataList.add(userEmail);
            userDataList.add(password);
            userDataList.add("c");
            userDataList.add(Integer.toString(i));
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
            customerDataList.add(userName);
            customerDataList.add(Integer.toString(userShoeSize));
            customerDataList.add(Integer.toString(i));
            customerDataList.add(String.valueOf(userAddress=new Address("Dupa", "Elo", "eslo", "Polen")));
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
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String readUserID(String userEmail, String password) {
        Float converter;
        String result = null;
        int index=0;

        try{
            Workbook workbook;
            FileInputStream readFile = new FileInputStream(file);
            workbook = new XSSFWorkbook(readFile);
            Sheet sheet = workbook.getSheet("User");
            Map<Integer, List<String>> map = new HashMap<>();
            int i=0;
            for(Row row : sheet){
                map.put(i, new ArrayList<>());
                for(Cell cell : row){
                    switch (cell.getCellType()){
                        case STRING:
                            map.get(i).add(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                map.get(i).add(cell.getDateCellValue() + "");
                            } else {
                                map.get(i).add(cell.getNumericCellValue() + "");
                            } break;
                        default: map.get(i).add(" ");
                    }
                }
                i++;
            }
            for(int j=1; j<map.size(); j++){
                if(map.get(j).get(1).equals(password) && map.get(j).get(0).equals(userEmail)) {
                    converter = new Float(map.get(j).get(3));
                    userID = converter.intValue();
                    this.password=password;
                    this.userEmail=userEmail;
                    switch (map.get(j).get(2)) {
                        case "c" -> result = "c";
                        case "e" -> result = "e";
                        case "a" -> result = "a";
                    }
                    index=j;
                    break;
                }
            }
            if(result.equals("c")){
                Workbook workbook2;
                FileInputStream readFile2 = new FileInputStream(file);
                workbook2 = new XSSFWorkbook(readFile2);
                Sheet sheet2 = workbook2.getSheet("Customer");
                Map<Integer, List<String>> map2 = new HashMap<>();
                int j=0;
                for(Row row : sheet2){
                    map2.put(j, new ArrayList<>());
                    for(Cell cell : row){
                        switch (cell.getCellType()){
                            case STRING:
                                map2.get(j).add(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    map2.get(j).add(cell.getDateCellValue() + "");
                                } else {
                                    map2.get(j).add(cell.getNumericCellValue() + "");
                                }
                                break;
                            default: map2.get(j).add(" ");
                        }
                    }
                    j++;
                }
                this.userName=map2.get(index).get(0);
                this.userShoeSize= Integer.parseInt(map2.get(index).get(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String signIn(String userEmail, String password) {
        return readUserID(userEmail, password);
    }
}
