package Shop.CustomerPackage;

public class Offer {

    int offerID;
    int shoeID;
    int shoeSize;
    Float offerPrice;
    String offerType;

    public Offer(int offerID, int shoeID, int shoeSize, Float offerPrice, String offerType){
        this.offerID=offerID;
        this.offerPrice=offerPrice;
        this.offerType=offerType;
        this.shoeID=shoeID;
        this.shoeSize=shoeSize;
    }

    public Offer() {}
}
