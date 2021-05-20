package Shop.WorkerPackage;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {

    protected ArrayList<Shoe> shoeList= new ArrayList<>();
    Float convert;
    Shoe shoe;

    public Catalog(ArrayList<Shoe> shoeList){
        this.shoeList=shoeList;
    }

    public Catalog() {readShoeList();}

    public void readShoeList(){
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
    }
    public ArrayList<Shoe> searchShoe(String search){
        ArrayList<Shoe> result = new ArrayList<>();
        for(int i=0; i<shoeList.size(); i++){
            if(search.equals(shoeList.get(i).shoeName)){
                result.add(shoeList.get(i));
            }
        }
        return result;
    }

    public ArrayList<Shoe> returnCatalog(){
        return shoeList;
    }
}
