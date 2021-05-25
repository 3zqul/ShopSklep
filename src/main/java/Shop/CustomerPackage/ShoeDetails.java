package Shop.CustomerPackage;

public class ShoeDetails {

    int orderID;
    int shoeID;
    String shoeName;
    int shoeSize;
    Float shoePrice;

    public ShoeDetails(int shoeID, String shoeName, int shoeSize, Float shoePrice, int orderID){
        this.shoeID = shoeID;
        this.shoeName = shoeName;
        this.shoeSize = shoeSize;
        this.shoePrice = shoePrice;
        this.orderID = orderID;
    }

    public ShoeDetails() {}

    public int returnOrderID() {
        return orderID;
    }

    public int returnShoeID() {
        return shoeID;
    }

    public String returnShoeName() {
        return shoeName;
    }

    public int returnShoeSize() {
        return shoeSize;
    }

    public Float returnShoePrice() {
        return shoePrice;
    }
}
