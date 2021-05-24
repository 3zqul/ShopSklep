package Shop.CustomerPackage;

public class UserForMap{

    Integer userID;
    String password;
    String userEmail;
    String userType;

    public UserForMap(Integer userID, String password, String userEmail, String userType){
        this.userID = userID;
        this.password = password;
        this.userEmail = userEmail;
        this.userType = userType;
    }

    public Integer returnUserID() {
        return userID;
    }

    public String returnPassword() {
        return password;
    }

    public String returnUserEmail() {
        return userEmail;
    }

    public String returnUserType() {
        return userType;
    }
}
