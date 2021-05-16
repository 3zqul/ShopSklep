package Shop;

import java.io.File;

public interface FileRead{

    File file = new File("D:\\Shop\\src\\main\\java\\Shop\\essa.xlsx");
    String readUserID(String userEmail, String password);
}
