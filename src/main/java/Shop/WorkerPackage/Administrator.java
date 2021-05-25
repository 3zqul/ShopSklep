package Shop.WorkerPackage;

import Shop.CustomerPackage.Offer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Administrator extends Editor{

    protected Map<Integer, Offer> offerMap;
    protected Map<Integer, Administrator> administratorMap;

    public Administrator(Integer userID, String password, String userEmail, String userType){
        this.userID = userID;
        this.password = password;
        this.userEmail = userEmail;
        this.userType = userType;
    }

    public Administrator() {}

    public void readOfferData(){

        offerMap = new HashMap<>();

        try {
            Workbook workbook;
            FileInputStream readFile = new FileInputStream(file);
            workbook = new XSSFWorkbook(readFile);
            Sheet sheet = workbook.getSheet("Offer");
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
            List<Float> converter;
            for(int j=1; j< map.size(); j++){
                converter = new ArrayList<>();
                converter.add(new Float(map.get(j).get(1)));
                converter.add(new Float(map.get(j).get(2)));
                converter.add(new Float(map.get(j).get(3)));
                converter.add(new Float(map.get(j).get(4)));
                offerMap.put(j, new Offer(converter.get(0).intValue(), converter.get(1).intValue(), converter.get(2).intValue(), converter.get(3), map.get(j).get(5), map.get(j).get(6)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeOffer(int index){
        System.out.println(offerMap);
        System.out.println();
        offerMap.remove(index);
        for(int i = index+1; i<=offerMap.size();i++ ){
            offerMap.put(i-1,offerMap.get(i));
        }
        offerMap.remove(offerMap.size());
        System.out.println(offerMap);
    }

    public Map<Integer, Offer> returnOfferMap(){
        return offerMap;
    }

    public void readAdministratorData(){

        administratorMap = new HashMap<>();

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
                if (map.get(j).get(3).equals("a")) {
                    Float converter;
                    converter = new Float(map.get(j).get(0));
                    administratorMap.put(index, new Administrator(converter.intValue(), map.get(j).get(1), map.get(j).get(2), map.get(j).get(3)));
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateOfferDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("Offer");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> offerData;
            Map<Integer, ArrayList<String>> offerDataMap = new HashMap<>();
            offerData = new ArrayList<>();
            offerData.add("userID");
            offerData.add("accountNo");
            offerData.add("accountName");
            offerDataMap.put(0, offerData);
            for(int i=0; i<offerMap.size(); i++) {
                for(int j=0; j<customerMap.size(); j++) {
                    for(int k=0; k<customerMap.get(j).returnOffers().size(); k++) {
                        if (offerMap.get(i).returnOfferID() == customerMap.get(j).returnOffers().get(k).returnOfferID()) {
                            offerData = new ArrayList<>();
                            offerData.add(String.valueOf(customerMap.get(j).returnUserID()));
                            offerData.add(String.valueOf(offerMap.get(i).returnOfferID()));
                            offerData.add(String.valueOf(offerMap.get(i).returnShoeID()));
                            offerData.add(String.valueOf(offerMap.get(i).returnShoeSize()));
                            offerData.add(String.valueOf(offerMap.get(i).returnOfferPrice()));
                            offerData.add(offerMap.get(i).returnOfferType());
                            offerData.add(offerMap.get(i).returnShoeName());
                            offerDataMap.put(i + 1, offerData);
                        }
                    }
                }
            }
            Set<Integer> newOfferRows = offerDataMap.keySet();
            int newofferrows = 0;
            for (Integer key : newOfferRows) {
                Row row = sheet.createRow(newofferrows++);
                ArrayList<String> objArr = offerDataMap.get(key);
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

    @Override
    public String signIn(String userEmail, String password) {
        readAdministratorData();
        for(int i=1; i<administratorMap.size()+2; i++) {
            if (administratorMap.get(i).userEmail.equals(userEmail) && administratorMap.get(i).password.equals(password)) {
                this.userID = administratorMap.get(i).userID;
                this.password = administratorMap.get(i).password;
                this.userEmail = administratorMap.get(i).userEmail;
                this.userType = administratorMap.get(i).userType;
                return administratorMap.get(i).userType;
            }
        }
        return "blad";
    }
}
