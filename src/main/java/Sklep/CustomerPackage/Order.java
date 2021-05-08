package Sklep.CustomerPackage;

import java.util.Date;

public class Order {

    int orderID;
    Date orderDate;
    int customerID;
    int sellerID;
    OrderDetails orderDetails;

    public Order(int orderID, Date orderDate, int customerID, int sellerID, OrderDetails orderDetails){
        this.orderID=orderID;
        this.orderDate=orderDate;
        this.customerID=customerID;
        this.orderDetails=orderDetails;
        this.sellerID=sellerID;
    }

    public void createOrder(){

    }

    public void deleteOrder(){

    }
}
