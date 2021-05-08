package Sklep;

public abstract class User {

    private int userID;
    String password;
    String userEmail;
    int userType;

    abstract public boolean signIn(String userEmail, String password);
}
