package Shop.CustomerPackage;

public class Payment {

    String cardNo;
    String cardName;
    int cardExpiryMonth;
    int cardExpiryYear;
    String cardCVV;

    public Payment(String cardNo, String cardName, int cardExpiryYear, int cardExpiryMonth, String cardCVV){
        this.cardCVV=cardCVV;
        this.cardExpiryMonth=cardExpiryMonth;
        this.cardExpiryYear=cardExpiryYear;
        this.cardName=cardName;
        this.cardNo=cardNo;
    }
    @Override
    public String toString(){

        return "Card name: " + this.cardName + " Card number: " + this.cardNo + " Expiry date: " + this.cardExpiryMonth +"/"+this.cardExpiryYear + " CVV: " + this.cardCVV;
    }
}
