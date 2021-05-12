package Shop.CustomerPackage;

import Shop.FileRead;
import Shop.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Customer extends User implements FileRead {

    protected String userShoeSize;
    protected String userName;
    protected Payout userPayout;
    protected Payment userPayment;
    protected Address userAddress;
    protected Offer userOffer;
    protected Order userOrder;
    private File file = new File("D:\\Shop\\src\\main\\java\\Shop\\essa.xlsx");

    public Customer() {}

    public Customer(String userShoeSize, String userName, Payout userPayout, Payment userPayment, Address userAddress, Offer userOffer, Order userOrder){
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
    public void changePassword(){

    }
    public void changeShoeSize(){

    }

    public Boolean registerCustomer(String password, String userEmail, String userName) {
        Boolean result = null;

        try{
            Workbook userWorkbook;
            Workbook customerWorkbook;
            try (FileInputStream inputFile = new FileInputStream(file)) {
                userWorkbook = new XSSFWorkbook(inputFile);
                customerWorkbook = new XSSFWorkbook(inputFile);
            }
            Sheet userSheet = userWorkbook.getSheet("User");
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
                            } break;
                        default: userMap.get(i).add(" ");
                    }
                }
                for(int j=0; j<userMap.size(); j++){
                    if(userEmail.equals(userMap.get(j).get(0))){
                        result = false;
                        break;
                    }else{
                        Map<String, Object[]> userData = new HashMap<>();
                        userData.put("i+1", new Object[] {userEmail, password, "c", i+1});
                        Set<String> newRows = userData.keySet();
                        int userrownum = userSheet.getLastRowNum();
                        for (String userKey : newRows) {
                                Row row = userSheet.createRow(userrownum++);
                                Object [] objArr = userData.get(userKey);
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
                                }
                            }
                        }
                        FileOutputStream userOs = new FileOutputStream(file);
                        userWorkbook.write(userOs);

                        Sheet customerSheet = customerWorkbook.getSheet("Customer");
                        Map<Integer, List<String>> customerMap = new HashMap<>();
                        int k=0;
                        for(Row customerRow : customerSheet){
                            customerMap.put(k, new ArrayList<>());
                            for(Cell customerCell : customerRow){
                                switch (customerCell.getCellType()){
                                    case STRING:
                                        customerMap.get(k).add(customerCell.getRichStringCellValue().getString());
                                        break;
                                    case NUMERIC:
                                        if (DateUtil.isCellDateFormatted(customerCell)) {
                                            customerMap.get(k).add(customerCell.getDateCellValue() + "");
                                        } else {
                                            customerMap.get(k).add(customerCell.getNumericCellValue() + "");
                                        } break;
                                    default: customerMap.get(k).add(" ");
                                }
                            }
                            k++;
                            Map<String, Object[]> customerData = new HashMap<>();
                            customerData.put("k+1", new Object[] {k+1, , userName});
                            Set<String> newCustomerRows = customerData.keySet();
                            int customerrownum = customerSheet.getLastRowNum();
                            for (String key : newCustomerRows) {
                                Row row = customerSheet.createRow(customerrownum++);
                                Object [] objArr = customerData.get(key);
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
                                    }
                                }
                            }
                            FileOutputStream customerOs = new FileOutputStream("D:\\Shop\\src\\main\\java\\Shop\\essa.xlsx");
                            userWorkbook.write(customerOs);
                        }
                        result = true;
                    }
                }
                i++;
            }

            return result;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean signUp(String userEmail, String userName, String password){



        return true;
    }

    @Override
    public String readUserID(String sheetName, String password, String userEmail) {
        Float converter;
        String result = null;

        try{
            Workbook workbook;
            try (FileInputStream readFile = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(readFile);
            }
            Sheet sheet = workbook.getSheet(sheetName);
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
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String signIn(String password, String userEmail) {

        return readUserID("User", password, userEmail);
    }
}
