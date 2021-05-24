package Shop.CustomerPackage;

public class Order {

    int orderID;
    String orderDate;
    int sellerID;
    int customerID;
    ShoeDetails shoeDetails;
    Address orderAddress;

    public Order(int orderID, String orderDate, int customerID, int sellerID, ShoeDetails shoeDetails, Address orderAddress){
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.sellerID = sellerID;
        this.customerID = customerID;
        this.shoeDetails = shoeDetails;
        this.orderAddress = orderAddress;
    }

    public Order() {}

    public int returnShoeID(){
        return this.shoeDetails.shoeID;
    }

    public String returnShoeName(){
        return shoeDetails.shoeName;
    }

    @Override
    public String toString(){
        return " id: " + orderID + " shoe: " + shoeDetails.shoeName + " size: " + shoeDetails.shoeSize + " price: " + shoeDetails.shoePrice + " address: " + orderAddress;
    }
}
