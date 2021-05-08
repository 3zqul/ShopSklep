package Sklep;

import Sklep.CustomerPackage.Customer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args){

        //CustomerGUI gui = new CustomerGUI("essa");

        try{
            Workbook workbook;
            try (FileInputStream file = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Sklep\\essa.xlsx"))) {
                workbook = new XSSFWorkbook(file);
            }
            Sheet sheet = workbook.getSheetAt(0);
            Map<Integer, List<String>> map = new HashMap<>();
            int i=0;
            for(Row row : sheet){
                map.put(i, new ArrayList<String>());
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
                if(map.get(j).get(1).equals("dupa123") && map.get(j).get(0).equals("dupa@o2.pl")){
                    System.out.println("Sukces");
                    Customer customer = new Customer();
                    customer.userID=Integer.parseInt(map.get(j).get(3));
                }else{
                    System.out.println("Kloc");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
