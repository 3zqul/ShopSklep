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

    public String returnStreet() {
        return street;
    }

    public String returnCity() {
        return city;
    }

    public String returnPostalCode() {
        return postalCode;
    }

    public String returnCountry() {
        return country;
    }

    @Override
    public String toString(){

        return this.street + " " + this.city + " " + this.postalCode + " "+ this.country;
    }
}