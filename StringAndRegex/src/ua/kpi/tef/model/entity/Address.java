package ua.kpi.tef.model.entity;

/**
 * Created by Dima Skorobogatskii on 13.03.2017.
 */
public class Address {

    private String index;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;

    public void setIndex(String index) {
        this.index = index;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }
}
