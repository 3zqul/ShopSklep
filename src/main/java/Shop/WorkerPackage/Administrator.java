package Shop.WorkerPackage;

public class Administrator extends Editor{

    public Administrator(Integer userID, String password, String userEmail, String userType){
        this.userID = userID;
        this.password = password;
        this.userEmail = userEmail;
        this.userType = userType;
    }

    @Override
    public String signIn(String userEmail, String password){
        return "true";
    }
}
