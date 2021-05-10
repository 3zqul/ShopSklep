package Shop.CustomerPackage;

import Shop.FileRead;
import Shop.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer extends User implements FileRead {

    protected String userShoeSize;
    protected String userName;
    protected Payout userPayout;
    protected Payment userPayment;
    protected Address userAddress;
    protected Offer userOffer;
    protected Order userOrder;

    public Customer() {}

    public Customer(String userShoeSize, String userName, Payout userPayout, Payment userPayment, Address userAddress, Offer userOffer, Order userOrder){
        this.userAddress=userAddress;
        this.userName=userName;
        this.userOffer=userOffer;
        this.userOrder=userOrder;
        this.userPayment=userPayment;
        this.userPayout=userPayout;
        this.userShoeSize=userShoeSize;
    }

    public void displayOrders(){

    }
    public void displayAccount(){

    }
    public void changePassword(){

    }
    public void changeShoeSize(){

    }
    public boolean signUp(String userEmail, String userName, String password, Address userAddress){

        return true;
    }

    @Override
    public Boolean readUserID(String sheetName, String password, String userEmail) {
        Float converter;
        boolean result=false;

        try{
            Workbook workbook;
            try (FileInputStream file = new FileInputStream(new File("C:\\Users\\bigos\\IdeaProjects\\ShopSklep\\src\\main\\java\\Shop\\essa.xlsx"))) {
                workbook = new XSSFWorkbook(file);
            }
            Sheet sheet = workbook.getSheet(sheetName);
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
                if(map.get(j).get(1).equals(password) && map.get(j).get(0).equals(userEmail)) {
                    converter = new Float(map.get(j).get(3));
                    userID = converter.intValue();
                    this.password=password;
                    this.userEmail=userEmail;
                    result=true;
                }
            }
            System.out.println(this.password + " " + this.userEmail);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean signIn(String userEmail, String password) {

        Boolean check = readUserID("User", password, userEmail);
        return check;
    }
}
