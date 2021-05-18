package Shop;

import java.io.File;

public abstract class User {

    protected Integer userID;
    protected String password;
    protected String userEmail;
    final protected File file = new File("D:\\Shop\\src\\main\\java\\Shop\\essa.xlsx");

    abstract public String signIn(String userEmail, String password);
}
