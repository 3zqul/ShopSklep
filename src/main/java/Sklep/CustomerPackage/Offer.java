package Sklep.CustomerPackage;

public class Offer {

    int offerID;
    int userID;
    int shoeID;
    String shoeSize;
    Float offerPrice;
    String offerType;

    public Offer(int offerID, int userID, int shoeID, String shoeSize, Float aOfferPrice, String offerType){
        this.offerID=offerID;
        this.offerPrice=offerPrice;
        this.offerType=offerType;
        this.shoeID=shoeID;
        this.shoeSize=shoeSize;
        this.userID=userID;
    }
}
