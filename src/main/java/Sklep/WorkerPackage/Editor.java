package Sklep.WorkerPackage;

import Sklep.User;

public class Editor extends User {



    public Editor(){

    }

    @Override
    public boolean signIn(String userEmail, String password) {
        return true;
    }
}
