package Shop.CustomerPackage;

public class Address {
    String street;
    String city;
    String postalCode;
    String country;

    public Address(String street, String city, String postalCode, String country){
        this.street=street;
        this.city=city;
        this.country=country;
        this.postalCode=postalCode;
    }
    @Override
    public String toString(){

        return "Street: " + this.street + " City: " + this.city + " Postal code: " + this.postalCode + " Country: "+ this.country;
    }
}
