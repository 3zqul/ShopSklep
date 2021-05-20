package Shop;

import Shop.CustomerPackage.*;
import Shop.WorkerPackage.Administrator;
import Shop.WorkerPackage.Editor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class User {

    protected Integer userID;
    protected String password;
    protected String userEmail;
    protected String userType;
    protected Map<Integer, Customer> customerMap = new HashMap<>();
    protected Map<Integer, Editor> editorMap = new HashMap<>();
    protected Map<Integer, Administrator> administratorMap;
    final protected File file = new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx");

    abstract public String signIn(String userEmail, String password);

    public void readCustomerData(){
        List<Float> converter1;
        List<Float> converter2;
        List<Float> converter3;
        List<Float> converter4;
        ShoeDetails shoeDetails = null;
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
                            break; case NUMERIC: if (DateUtil.isCellDateFormatted(cell)) {
                            map2.get(count2).add(String.valueOf(cell.getDateCellValue()));
                        } else {
                            map2.get(count2).add(String.valueOf(cell.getNumericCellValue()));
                        }
                            break; default: map2.get(count2).add(" ");
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
            for(int j=1; j<map.size(); j++) {
                if (map.get(j).get(3).equals("c")) {
                    converter1 = new ArrayList<>();
                    converter1.add(new Float(map.get(j).get(0)));
                    converter1.add(new Float(map2.get(j).get(2)));
                    converter1.add(new Float(map4.get(j).get(3)));
                    converter1.add(new Float(map4.get(j).get(4)));
                    converter1.add(new Float(map4.get(j).get(5)));
                    List<Offer> offerList = new ArrayList<>();
                    for (int k = 1; k < map6.size(); k++) {
                        if (map6.get(k).get(0).equals(map.get(j).get(0))) {
                            converter2 = new ArrayList<>();
                            converter2.add(new Float(map6.get(k).get(1)));
                            converter2.add(new Float(map6.get(k).get(2)));
                            converter2.add(new Float(map6.get(k).get(4)));
                            offerList.add(new Offer(converter2.get(0).intValue(), converter2.get(1).intValue(), map6.get(k).get(3), converter2.get(2), map6.get(k).get(5)));
                        }
                    }
                    List<Order> orderList = new ArrayList<>();
                    for (int k = 1; k < map8.size(); k++) {
                        if (map8.get(k).get(1).equals(map7.get(k).get(0))) {
                            converter3 = new ArrayList<>();
                            converter3.add(new Float(map8.get(k).get(2)));
                            converter3.add(new Float(map8.get(k).get(5)));
                            converter3.add(new Float(map8.get(k).get(1)));
                            shoeDetails = new ShoeDetails(converter3.get(0).intValue(), map8.get(k).get(3), map8.get(k).get(5), converter3.get(1), converter3.get(2).intValue());
                            for (int l = 0; l < map7.size(); l++) {
                                if (map7.get(l).get(2).equals(map.get(j).get(0))) {
                                    converter4 = new ArrayList<>();
                                    converter4.add(new Float(map7.get(k).get(0)));
                                    converter4.add(new Float(map7.get(k).get(2)));
                                    converter4.add(new Float(map7.get(k).get(3)));
                                    orderList.add(new Order(converter4.get(0).intValue(), map7.get(k).get(1), converter4.get(1).intValue(), converter4.get(2).intValue(), shoeDetails));
                                }
                            }
                        }
                    }
                    customerMap.put(j, new Customer(map.get(j).get(3), converter1.get(0).intValue(), map.get(j).get(1), map.get(j).get(2), converter1.get(1).intValue(), map2.get(j).get(1), new Payout(map5.get(j).get(1), map5.get(j).get(2)), new Payment(map4.get(j).get(1), map4.get(j).get(2), converter1.get(2).intValue(), converter1.get(3).intValue(), String.valueOf(converter1.get(4).intValue())), new Address(map3.get(j).get(1), map3.get(j).get(2), map3.get(j).get(3), map3.get(j).get(4)), offerList, orderList));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readEditorData(){

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
            for(int j=0; j< map.size(); j++){
                if (map.get(j).get(3).equals("e")) {
                    Float converter;
                    converter = new Float(map.get(j).get(0));
                    editorMap.put(j, new Editor(converter.intValue(), map.get(j).get(1), map.get(j).get(2), map.get(j).get(3)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAdministratorData(){

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
            for(int j=0; j< map.size(); j++){
                if (map.get(j).get(3).equals("a")) {
                    Float converter;
                    converter = new Float(map.get(j).get(0));
                    editorMap.put(j, new Editor(converter.intValue(), map.get(j).get(1), map.get(j).get(2), map.get(j).get(3)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}