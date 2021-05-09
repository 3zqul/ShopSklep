package Shop;

public abstract class User {

    protected int userID;
    protected String password;
    protected String userEmail;
    protected int userType;

    abstract public boolean signIn(String userEmail, String password);
}
