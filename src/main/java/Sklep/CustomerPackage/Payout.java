package Sklep.CustomerPackage;

public class Payout {

    String accountNo;
    String accountName;
    Address accountAddress;

    public Payout(String accountNo, String accountName, Address accountAddress){
        this.accountAddress=accountAddress;
        this.accountName=accountName;
        this.accountNo=accountNo;
    }

    public void editPayout(String accountName, String accountNo, Address accountAddress){

    }
}
