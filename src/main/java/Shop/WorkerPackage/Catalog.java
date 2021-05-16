package Shop.WorkerPackage;

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

public class Catalog {

    ArrayList<Shoe> shoeList= new ArrayList<>();

    public Catalog(ArrayList<Shoe> shoeList){
        this.shoeList=shoeList;
    }

    public Catalog() {}
    public void readShoeList(){
        Workbook workbook;
        try (FileInputStream readFile = new FileInputStream(new File("D:\\Shop\\src\\main\\java\\Shop\\essa.xlsx"))) {
            workbook = new XSSFWorkbook(readFile);
            Sheet sheet = workbook.getSheet("Shoe");
            Map<Integer, List<String>> map;
            map = new HashMap<>();
            int i=0;
            for(Row row : sheet){
                map.put(i, new ArrayList<>());
                for(Cell cell : row){
                    if(cell.equals(0)){
                        map.get(i).add(String.valueOf(cell.getNumericCellValue()));
                    }else if(cell.equals(1)){
                        map.get(i).add(cell.getStringCellValue());
                    }else if(cell.equals(2)){
                        map.get(i).add(String.valueOf(cell.getNumericCellValue()));
                    }else if(cell.equals(3)){
                        map.get(i).add(String.valueOf(cell.getNumericCellValue()));
                    }else if(cell.equals(4)){
                        map.get(i).add(String.valueOf(cell.getNumericCellValue()));
                    }
                }
                i++;
            }
            for(int j=0; j<map.size(); j++){
                System.out.println(map.get(i).get(j));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void searchShoe(String search){

    }
}
