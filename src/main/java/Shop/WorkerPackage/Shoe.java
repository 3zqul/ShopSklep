package Shop.WorkerPackage;

public class Shoe {

    int shoeID;
    String  shoeName;
    int shoeSize;
    Float shoeBuyPrice;
    Float shoeSellPrice;

    public Shoe(int shoeID, String shoeName, int shoeSize, Float shoeBuyPrice, Float shoeSellPrice){
        this.shoeID=shoeID;
        this.shoeName=shoeName;
        this.shoeSize=shoeSize;
        this.shoeBuyPrice=shoeBuyPrice;
        this.shoeSellPrice=shoeSellPrice;
    }

    public Shoe(){

    }

    @Override
    public String toString(){

        return shoeName + " " + shoeSize;
    }

    public Float buyNowPrice(){

        return this.shoeBuyPrice;
    }
    public Float quickSellPrice(){

        return this.shoeSellPrice;
    }
}
