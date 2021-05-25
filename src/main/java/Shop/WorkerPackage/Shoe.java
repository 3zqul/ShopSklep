package Shop.WorkerPackage;

public class Shoe {

    int shoeID;
    String  shoeName;
    int shoeSize;
    Float shoeBuyPrice;
    Float shoeSellPrice;
    int buyOfferID;
    int sellOfferID;

    public Shoe(int shoeID, String shoeName, int shoeSize, Float shoeBuyPrice, Float shoeSellPrice, int buyOfferID, int sellOfferID){
        this.shoeID=shoeID;
        this.shoeName=shoeName;
        this.shoeSize=shoeSize;
        this.shoeBuyPrice=shoeBuyPrice;
        this.shoeSellPrice=shoeSellPrice;
        this.buyOfferID = buyOfferID;
        this.sellOfferID = sellOfferID;
    }

    public Shoe(){

    }

    @Override
    public String toString(){
        return shoeName + " " + shoeSize;
    }

    public Float returnShoeBuyPrice(){
        return this.shoeBuyPrice;
    }

    public Float returnShoeSellPrice(){
        return this.shoeSellPrice;
    }

    public int returnShoeID(){
        return shoeID;
    }

    public int returnSellOfferID(){
        return sellOfferID;
    }

    public int returnBuyOfferID(){
        return buyOfferID;
    }

    public String returnShoeName(){
        return shoeName;
    }

    public int returnShoeSize(){
        return shoeSize;
    }
}