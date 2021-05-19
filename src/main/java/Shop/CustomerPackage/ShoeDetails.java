package Shop.CustomerPackage;

public class ShoeDetails {

    int orderID;
    int shoeID;
    String shoeName;
    String shoeSize;
    Float shoePrice;

    public ShoeDetails(int shoeID, String shoeName, String shoeSize, Float shoePrice, int orderID){
        this.shoeID = shoeID;
        this.shoeName = shoeName;
        this.shoeSize = shoeSize;
        this.shoePrice = shoePrice;
        this.orderID = orderID;
    }

    public ShoeDetails() {}
}
