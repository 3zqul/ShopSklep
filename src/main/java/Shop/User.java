package Shop;

import java.io.File;

public abstract class User {

    protected int userID;
    protected String password;
    protected String userEmail;
    protected int userType;
    final protected File file = new File("D:\\Shop\\src\\main\\java\\Shop\\essa.xlsx");

    abstract public String signIn(String userEmail, String password);
}
