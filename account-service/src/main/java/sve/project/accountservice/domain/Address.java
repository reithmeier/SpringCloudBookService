package sve.project.accountservice.domain;


import javax.persistence.*;
import java.util.StringJoiner;


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String country;

    private String zip;

    private String town;

    private String street;

    private String house;

    @ManyToOne
    private User user;

    public Address() {
    }

    public Address(AddressInput addressInput){
        this.country = addressInput.getCountry();
        this.zip = addressInput.getZip();
        this.town = addressInput.getTown();
        this.street = addressInput.getStreet();
        this.house = addressInput.getHouse();
    }

    public Address(String country, String zip, String town, String street, String house) {
        this.country = country;
        this.zip = zip;
        this.town = town;
        this.street = street;
        this.house = house;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("country='" + country + "'")
                .add("zip='" + zip + "'")
                .add("town='" + town + "'")
                .add("street='" + street + "'")
                .add("house='" + house + "'")
                .toString();
    }
}
