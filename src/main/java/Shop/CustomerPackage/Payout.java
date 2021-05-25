package Shop.CustomerPackage;

public class Payout {

    String accountNo;
    String accountName;

    public Payout(String accountNo, String accountName){
        this.accountName=accountName;
        this.accountNo=accountNo;
    }

    public String returnAccountNo() {
        return accountNo;
    }

    public String returnAccountName() {
        return accountName;
    }

    @Override
    public String toString(){
        return "Account No: " + accountNo + " Account Name: " + accountName;
    }
}