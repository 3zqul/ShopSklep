package Shop.WorkerPackage;

import Shop.CustomerPackage.*;
import Shop.User;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
            List<Float> converter2;
            List<Float> converter3;
            Float convert1;
            Float convert2;
            Float convert3;
            for (int k = 1; k < map.size(); k++) {
                convert1 = new Float(map2.get(k).get(1));
                convert2 = new Float(map3.get(k).get(1));
                converter2 = new ArrayList<>();
                converter2.add(new Float(map2.get(k).get(2)));
                converter2.add(new Float(map2.get(k).get(4)));
                converter2.add(new Float(map2.get(k).get(1)));
                ShoeDetails shoeDetails = new ShoeDetails(converter2.get(0).intValue(), map2.get(k).get(3), map2.get(k).get(5), converter2.get(1), converter2.get(2).intValue());
                orderAddress = new Address(map3.get(k).get(2), map3.get(k).get(3), map3.get(k).get(4), map3.get(k).get(5));
                convert3 = new Float(map.get(k).get(0));
                if (convert3.intValue() == convert1.intValue()) {
                    if (convert3.intValue() == convert2.intValue()) {
                        converter3 = new ArrayList<>();
                        converter3.add(new Float(map.get(k).get(0)));
                        converter3.add(new Float(map.get(k).get(2)));
                        converter3.add(new Float(map.get(k).get(3)));
                        orderMap.put(k, new Order(converter3.get(0).intValue(), map.get(k).get(1), converter3.get(1).intValue(), converter3.get(2).intValue(), shoeDetails, orderAddress));
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
            catalog.shoeList.add(new Shoe(index+i, shoeName, 37+i, (float) 0, (float) 0));
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

//    public void editOrder(int orderID){
//        for(int i=0; i<orderMap.size(); i++){
//            if(orderMap.get(i).)
//        }
//    }
}
