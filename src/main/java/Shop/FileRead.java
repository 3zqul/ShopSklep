package Shop;

public interface FileRead{

    String readUserID(String sheetName, String password, String email);
    Boolean registerCustomer(String password, String userEmail, String userName, Integer userShoeSize);
}
