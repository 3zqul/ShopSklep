package Shop.WorkerPackage;

public class Shoe {

    Integer shoeID;
    String shoeName;
    Integer shoeSize;
    Float shoeBuyPrice;
    Float shoeSellPrice;

    public Shoe(Integer shoeID, String shoeName, Integer shoeSize, Float shoeBuyPrice, Float shoeSellPrice){
        this.shoeID=shoeID;
        this.shoeName=shoeName;
        this.shoeSize=shoeSize;
        this.shoeBuyPrice=shoeBuyPrice;
        this.shoeSellPrice=shoeSellPrice;
    }

    public Shoe() {

    }

    public String toString(){
        return " shoeID = " + this.shoeID + " shoeName = " + this.shoeName + " shoeSize = " + this.shoeSize + " shoeBuyPrice = " + this.shoeBuyPrice + " shoeSellPrice = " + this.shoeSellPrice;
    }
}
