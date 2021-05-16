package Shop.WorkerPackage;

public class Shoe {

    Integer shoeID;
    String shoeName;
    String shoeSize;
    Float shoeBuyPrice;
    Float shoeSellPrice;

    public Shoe(){}

    public Shoe(Integer shoeID, String shoeName, String shoeSize, Float shoeBuyPrice, Float shoeSellPrice){
        this.shoeID=shoeID;
        this.shoeName=shoeName;
        this.shoeSize=shoeSize;
        this.shoeBuyPrice=shoeBuyPrice;
        this.shoeSellPrice=shoeSellPrice;
    }

    public String toString(){
        return " shoeID = " + this.shoeID + " shoeName = " + this.shoeName + " shoeSize = " + this.shoeSize + " shoeBuyPrice = " + this.shoeBuyPrice + " shoeSellPrice = " + this.shoeSellPrice;
    }
}
