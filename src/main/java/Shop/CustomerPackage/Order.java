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

    public void editOrderAddress(Address address){
        this.orderAddress = address;
    }

    public String returnOrderDate() {
        return orderDate;
    }

    public int returnSellerID() {
        return sellerID;
    }

    public int returnCustomerID() {
        return customerID;
    }

    public Order() {}

    public ShoeDetails returnShoeDetails() {
        return shoeDetails;
    }

    public int returnShoeID(){
        return this.shoeDetails.shoeID;
    }

    public String returnShoeName(){
        return shoeDetails.shoeName;
    }

    public int returnOrderID(){
        return orderID;
    }

    public Address returnOrderAddress() {
        return orderAddress;
    }

    @Override
    public String toString(){
        return " id: " + orderID + " shoe: " + shoeDetails.shoeName + " size: " + shoeDetails.shoeSize + " price: " + shoeDetails.shoePrice + " address: " + orderAddress;
    }
}
