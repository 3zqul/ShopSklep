package Shop.WorkerPackage;

import Shop.User;

public class Editor extends User {

    public Editor(){

    }

    @Override
    public String signIn(String userEmail, String password) {
        return "true";
    }
}
