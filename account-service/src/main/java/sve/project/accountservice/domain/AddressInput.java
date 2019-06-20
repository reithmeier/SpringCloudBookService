package sve.project.accountservice.domain;


import javax.persistence.*;
import java.util.StringJoiner;


public class AddressInput {

    private String country;

    private String zip;

    private String town;

    private String street;

    private String house;


    public AddressInput() {
    }

    public AddressInput(String country, String zip, String town, String street, String house) {
        this.country = country;
        this.zip = zip;
        this.town = town;
        this.street = street;
        this.house = house;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AddressInput.class.getSimpleName() + "[", "]")
                .add("country='" + country + "'")
                .add("zip='" + zip + "'")
                .add("town='" + town + "'")
                .add("street='" + street + "'")
                .add("house='" + house + "'")
                .toString();
    }
}
