package Sklep.CustomerPackage;

public class OrderDetails {

    int shoeID;
    String shoeName;
    Float shoePrice;
    String shoeSize;

    public OrderDetails(int shoeID, String shoeName, Float shoePrice, String shoeSize){
        this.shoeID=shoeID;
        this.shoeName=shoeName;
        this.shoePrice=shoePrice;
        this.shoeSize=shoeSize;
    }
}
