package Shop.WorkerPackage;

import Shop.FileRead;
import Shop.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Editor extends User implements FileRead {

    public Editor(){

    }

    @Override
    public String readUserID(String userEmail, String password) {

        Float converter;
        String result = null;

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
                    switch (map.get(j).get(2)) {
                        case "c" -> result = "c";
                        case "e" -> result = "e";
                        case "a" -> result = "a";
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String signIn(String userEmail, String password) {
        return readUserID(userEmail, password);
    }
}
