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

    public int returnShoeSize() {
        return shoeSize;
    }

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

    public String returnShoeName() {
        return shoeName;
    }

    @Override
    public String toString(){
        return "shoe: " + shoeName + " size: " + shoeSize + " price: " + offerPrice  + " type: " + offerType ;
    }
}
