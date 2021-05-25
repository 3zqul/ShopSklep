package Shop;

import Shop.CustomerPackage.*;
import Shop.WorkerPackage.Administrator;
import Shop.WorkerPackage.Editor;
import Shop.WorkerPackage.Statistics;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public abstract class User{

    protected Integer userID;
    protected String password;
    protected String userEmail;
    protected String userType;
    protected Map<Integer, UserForMap> userMap;
    protected Map<Integer, Customer> customerMap;
    final protected File file = new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx");

    public Integer returnUserID() {
        return userID;
    }

    public String returnPassword() {
        return password;
    }

    public String returnUserEmail() {
        return userEmail;
    }

    public String returnUserType() {
        return userType;
    }

    abstract public String signIn(String userEmail, String password);

    public void readCustomerData(){

        customerMap = new HashMap<>();
        ShoeDetails shoeDetails = null;
        Address orderAddress = null;
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
            Workbook workbook9;
            FileInputStream readFile9 = new FileInputStream(file);
            workbook9 = new XSSFWorkbook(readFile9);
            Sheet sheet9 = workbook9.getSheet("OrderAddress");
            Map<Integer, List<String>> map9 = new HashMap<>();
            int count9 = 0;
            for (Row row2 : sheet9) {
                map9.put(count9, new ArrayList<>());
                for (Cell cell : row2) {
                    switch (cell.getCellType()) {
                        case STRING:
                            map9.get(count9).add(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                map9.get(count9).add(cell.getDateCellValue() + "");
                            } else {
                                map9.get(count9).add(cell.getNumericCellValue() + "");
                            }
                            break;
                        default:
                            map9.get(count9).add(" ");
                    }
                }
                count9++;
            }
            int index=1;
            for(int j = 1; j < map.size(); j++) {
                if (map.get(j).get(3).equals("c")) {
                    List<Offer> offerList = new ArrayList<>();
                    List<Order> orderList = new ArrayList<>();
                    for(int k = 1; k < map2.size(); k++) {
                        if(new Float(map2.get(k).get(0)).intValue() == new Float(map.get(j).get(0)).intValue()) {
                            for (int l = 1; l < map6.size(); l++) {
                                if (new Float(map.get(j).get(0)).intValue() == new Float(map6.get(l).get(0)).intValue()) {
                                    offerList.add(new Offer(new Float(map6.get(l).get(1)).intValue(), new Float(map6.get(l).get(2)).intValue(), new Float(map6.get(l).get(3)).intValue(), new Float(map6.get(l).get(4)), map6.get(l).get(5), map6.get(l).get(6)));
                                }
                            }
                            for (int l = 1; l < map8.size(); l++) {
                                if ((new Float(map8.get(l).get(0)).intValue() == (new Float(map.get(j).get(0)).intValue())) && (new Float(map9.get(l).get(0)).intValue() == new Float(map.get(j).get(0)).intValue())) {
                                    shoeDetails = new ShoeDetails(new Float(map8.get(l).get(2)).intValue(), map8.get(l).get(3), new Float(map8.get(l).get(5)).intValue(), new Float(map8.get(l).get(4)), new Float(map8.get(l).get(1)).intValue());
                                    orderAddress = new Address(map9.get(l).get(2), map9.get(l).get(3), map9.get(l).get(4), map9.get(l).get(5));
                                    for (int m = 1; m < map7.size(); m++) {
                                        if (new Float(map7.get(m).get(2)).intValue() == new Float(map.get(j).get(0)).intValue()) {
                                            if(new Float(map7.get(m).get(0)).intValue() == new Float(map8.get(l).get(1)).intValue()) {
                                                orderList.add(new Order(new Float(map7.get(m).get(0)).intValue(), map7.get(m).get(1), new Float(map7.get(m).get(2)).intValue(), new Float(map7.get(m).get(3)).intValue(), shoeDetails, orderAddress));
                                            }
                                        }
                                    }
                                }
                            }
                            customerMap.put(index, new Customer(map.get(j).get(3), new Float(map.get(j).get(0)).intValue(), map.get(j).get(1), map.get(j).get(2), new Float(map2.get(k).get(2)).intValue(), map2.get(k).get(1), new Payout(map5.get(k).get(1), map5.get(k).get(2)), new Payment(map4.get(k).get(1), map4.get(k).get(2), new Float(map4.get(k).get(3)).intValue(), new Float(map4.get(k).get(4)).intValue(), String.valueOf(new Float(map4.get(k).get(5)).intValue())), new Address(map3.get(k).get(1), map3.get(k).get(2), map3.get(k).get(3), map3.get(k).get(4)), offerList, orderList));
                        }
                    }
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readUserData(){

        userMap = new HashMap<>();

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
            for(int j=1; j< map.size(); j++){
                Float converter;
                converter = new Float(map.get(j).get(0));
                userMap.put(j, new UserForMap(converter.intValue(), map.get(j).get(1), map.get(j).get(2), map.get(j).get(3)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int returnCustomerMapSize(){
        return customerMap.size();
    }
}