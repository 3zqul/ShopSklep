package Sklep.CustomerPackage;

import Sklep.User;

public class Customer extends User {

    protected String userShoeSize;
    protected String userName;
    protected Payout userPayout;
    protected Payment userPayment;
    protected Address userAddress;
    protected Offer userOffer;
    protected Order userOrder;

    public Customer(String userShoeSize, String userName, Payout userPayout, Payment userPayment, Address userAddress, Offer userOffer, Order userOrder){
        this.userAddress=userAddress;
        this.userName=userName;
        this.userOffer=userOffer;
        this.userOrder=userOrder;
        this.userPayment=userPayment;
        this.userPayout=userPayout;
        this.userShoeSize=userShoeSize;
    }

    public void displayOrders(){

    }
    public void displayAccount(){

    }
    public void changePassword(){

    }
    public void changeShoeSize(){

    }
    public boolean signUp(String userEmail, String userName, String password, Address userAddress){

        return true;
    }

    @Override
    public boolean signIn(String userEmail, String password) {
        return true;
    }
}
