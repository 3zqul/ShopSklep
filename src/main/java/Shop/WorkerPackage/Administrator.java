package Shop.WorkerPackage;

import Shop.CustomerPackage.Offer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
