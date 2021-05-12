package Shop.WorkerPackage;

public class Administrator extends Editor{

    @Override
    public String signIn(String userEmail, String password){
        return "true";
    }
}
