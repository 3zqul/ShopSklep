package Shop.CustomerPackage;

public class Offer {

    int offerID;
    int shoeID;
    int shoeSize;
    Float offerPrice;
    String offerType;
    String shoeName;

    public Offer(int offerID, int shoeID, int shoeSize, Float offerPrice, String offerType, String shoeName){
        this.offerID = offerID;
        this.offerPrice = offerPrice;
        this.offerType = offerType;
        this.shoeID = shoeID;
        this.shoeSize = shoeSize;
        this.shoeName = shoeName;
    }

    public Offer() {}

    public String returnOfferType(){
        return offerType;
    }

    public Float returnOfferPrice(){
        return offerPrice;
    }

    public int returnOfferID(){
        return offerID;
    }

    public int returnShoeID(){
        return shoeID;
    }
}
