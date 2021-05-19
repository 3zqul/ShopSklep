package Shop.CustomerPackage;

public class Order {

    int orderID;
    String orderDate;
    int sellerID;
    int customerID;
    ShoeDetails shoeDetails;

    public Order(int orderID, String orderDate, int customerID, int sellerID, ShoeDetails shoeDetails){
        this.orderID=orderID;
        this.orderDate=orderDate;
        this.sellerID=sellerID;
        this.customerID=customerID;
        this.shoeDetails=shoeDetails;
    }

    public Order() {

    }

    public void createOrder(){

    }

    public void deleteOrder(){

    }
}
