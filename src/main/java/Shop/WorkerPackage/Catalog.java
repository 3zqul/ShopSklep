package Shop.WorkerPackage;

import Shop.CustomerPackage.Offer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Catalog {

    protected ArrayList<Shoe> shoeList= new ArrayList<>();
    Float convert;
    Shoe shoe;

    public Catalog(ArrayList<Shoe> shoeList){
        this.shoeList=shoeList;
    }

    public Catalog() {}

    public void readShoeList(Map<Integer, Offer> offerMap){
        try {
            Workbook workbook;
            FileInputStream readFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(readFile);
            Sheet sheet = workbook.getSheet("Shoe");
            Map<Integer, List<String>> map = new HashMap<>();
            int i=1;
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
            for (int j = 2; j < map.size() + 1; j++) {
                shoe = new Shoe();
                convert = new Float(map.get(j).get(0));
                shoe.shoeID = convert.intValue();
                shoe.shoeName = map.get(j).get(1);
                convert = new Float(map.get(j).get(2));
                shoe.shoeSize = convert.intValue();
                convert = new Float(map.get(j).get(3));
                shoe.shoeBuyPrice = convert;
                convert = new Float(map.get(j).get(4));
                shoe.shoeSellPrice = convert;
                shoeList.add(shoe);
            }
        } catch (NullPointerException | IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        setShoePrice(offerMap);
    }

    public ArrayList<Shoe> searchShoe(String search){
        ArrayList<Shoe> result = new ArrayList<>();
        for(int i=0; i<shoeList.size(); i++){
            if(shoeList.get(i).shoeName.toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT))){
                result.add(shoeList.get(i));
            }else if(search.toLowerCase(Locale.ROOT).equals("all")){
                result.add(shoeList.get(i));
            }
        }
        return result;
    }

    public void addShoe(String name){
        int index;
        index=shoeList.size();
        for(int i=1; i<=8; i++){
            shoeList.add(new Shoe(index+i, name, 37+i, (float) 0, (float) 0));
        }
    }

    public void deleteShoe(String name){
        for(int i=0; i<shoeList.size(); i++){
            if(shoeList.get(i).shoeName.equals(name)){
                shoeList.remove(i);
            }
        }
    }

    public ArrayList<Shoe> returnCatalog(){
        return shoeList;
    }

    public void updateShoePrice(Offer offer){
        switch (offer.returnOfferType()){
            case "sell":
                if(offer.returnOfferPrice()<shoeList.get(offer.returnOfferID()).shoeSellPrice || shoeList.get(offer.returnOfferID()).shoeSellPrice==0){
                    shoeList.get(offer.returnOfferID()).shoeSellPrice = offer.returnOfferPrice();
                }
                break;
            case "buy":
                if(offer.returnOfferPrice()>shoeList.get(offer.returnOfferID()).shoeBuyPrice || shoeList.get(offer.returnOfferID()).shoeBuyPrice==0){
                    shoeList.get(offer.returnOfferID()).shoeBuyPrice = offer.returnOfferPrice();
                }
                break;
            default:
                break;
        }
    }

    public void setShoePrice(Map<Integer, Offer> offerMap){
        for(int i=1; i<=offerMap.size(); i++){
            switch (offerMap.get(i).returnOfferType()){
                case "buy":
                    for(int j=1; j<shoeList.size(); j++) {
                        if (offerMap.get(i).returnShoeID() == shoeList.get(j).shoeID && (offerMap.get(i).returnOfferPrice()>shoeList.get(j).shoeBuyPrice || shoeList.get(j).shoeBuyPrice==0)){
                            shoeList.get(j).shoeBuyPrice=offerMap.get(i).returnOfferPrice();
                        }
                    }
                    break;
                case "sell":
                    for(int j=1; j<shoeList.size(); j++) {
                        if (offerMap.get(i).returnShoeID() == shoeList.get(j).shoeID && (offerMap.get(i).returnOfferPrice()<shoeList.get(j).shoeSellPrice || shoeList.get(j).shoeSellPrice==0)){
                            shoeList.get(j).shoeSellPrice=offerMap.get(i).returnOfferPrice();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void updateDataBase(){
        try {
            Workbook workbook;
            FileInputStream inputFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook = new XSSFWorkbook(inputFile);
            Sheet sheet = workbook.getSheet("Shoe");
            int lastRowNum=sheet.getLastRowNum();
            for(int i=lastRowNum; i>0; i--) {
                sheet.shiftRows(i, lastRowNum, -1);
            }
            sheet.shiftRows(1, lastRowNum, -1);
            FileOutputStream outFile = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(outFile);
            outFile.close();
            ArrayList<String> shoeListData;
            Map<Integer, ArrayList<String>> shoeListMap = new HashMap<>();
            shoeListData = new ArrayList<>();
            shoeListData.add("shoeID");
            shoeListData.add("shoeName");
            shoeListData.add("shoeSize");
            shoeListData.add("shoeBuyPrice");
            shoeListData.add("shoeSellPrice");
            shoeListMap.put(0, shoeListData);
            for(int i=0; i<shoeList.size(); i++) {
                shoeListData = new ArrayList<>();
                shoeListData.add(String.valueOf(shoeList.get(i).shoeID));
                shoeListData.add(shoeList.get(i).shoeName);
                shoeListData.add(String.valueOf(shoeList.get(i).shoeSize));
                shoeListData.add(String.valueOf(shoeList.get(i).shoeBuyPrice));
                shoeListData.add(String.valueOf(shoeList.get(i).shoeSellPrice));
                shoeListMap.put(i+1, shoeListData);
            }
            Set<Integer> newOfferRows = shoeListMap.keySet();
            int newofferrows = 0;
            for (Integer key : newOfferRows) {
                Row row = sheet.createRow(newofferrows++);
                ArrayList<String> objArr = shoeListMap.get(key);
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
            FileOutputStream offerOs = new FileOutputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\DataBase.xlsx"));
            workbook.write(offerOs);
            offerOs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
