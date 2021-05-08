package Sklep.CustomerPackage;

public class Payment {

    String cardNo;
    String cardName;
    int cardExpiryMonth;
    int cardExpiryYear;
    int cardCVV;

    public Payment(String cardNo, String cardName, int cardExpiryYear, int cardExpiryMonth, int cardCVV){
        this.cardCVV=cardCVV;
        this.cardExpiryMonth=cardExpiryMonth;
        this.cardExpiryYear=cardExpiryYear;
        this.cardName=cardName;
        this.cardNo=cardNo;
    }

    public void editPayment(String cardName, String cardNo, int cardExpiryMonth, int cardExpiryYear, int cardCVV){

    }
}
