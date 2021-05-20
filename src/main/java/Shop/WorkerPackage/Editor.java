package Shop.WorkerPackage;

import Shop.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Editor extends User{

    Catalog catalog = new Catalog();
    List<String> nameList = new ArrayList<>();

    public Editor(Integer userID, String password, String userEmail, String userType){
        this.userID = userID;
        this.password = password;
        this.userEmail = userEmail;
        this.userType = userType;
    }

    public Editor(){}

    public String signIn(String userEmail, String password) {
        Float converter;
        try{
            Workbook workbook;
            try (FileInputStream readFile = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(readFile);
            }
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

                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "e";
    }

    public Shoe toList(int i){
        while(i<catalog.shoeList.size()){
            return catalog.shoeList.get(i);
        }
        return null;
    }

    public void addShoe(String shoeName){
        for(int i=0; i<8; i++) {
            catalog.shoeList.add(new Shoe(catalog.shoeList.size()+1, shoeName, 38+i, new Float(0), new Float(0)));
        }
        nameList.add(shoeName);
    }

    public void deleteShoe(String shoeName){
        for(int i=catalog.shoeList.size()-1; i>=1; i--){
            if(catalog.shoeList.get(i).shoeName.equals(shoeName)){
                catalog.shoeList.remove(i);
            }
        }
    }

    public void saveToFile() {
        try {
            Workbook workbook;
            FileInputStream inputFile2 = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputFile2);
            Sheet sheet = workbook.getSheet("Shoe");
            Map<Integer, ArrayList<String>> map = new HashMap<>();
            ArrayList<String> data;
            int j=0;
            int k=0;
            for(int i=0; i<catalog.shoeList.size(); i++) {
                if(catalog.shoeList.get(i).shoeName.equals(nameList.get(k))) {
                    data = new ArrayList<>();
                    data.add(String.valueOf(catalog.shoeList.get(i).shoeID));
                    data.add(catalog.shoeList.get(i).shoeName);
                    data.add(String.valueOf(catalog.shoeList.get(i).shoeSize));
                    data.add(String.valueOf(catalog.shoeList.get(i).shoeBuyPrice));
                    data.add(String.valueOf(catalog.shoeList.get(i).shoeSellPrice));
                    map.put(j, data);
                    j++;
                    if(j>7){
                        k++;
                    }
                }
            }
            Set<Integer> newRows = map.keySet();
            int rownum = sheet.getLastRowNum();
            for (Integer key : newRows) {
                Row row = sheet.createRow(++rownum);
                ArrayList<String> objArr = map.get(key);
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

            FileOutputStream customerOs = new FileOutputStream(file);
            workbook.write(customerOs);
            customerOs.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
