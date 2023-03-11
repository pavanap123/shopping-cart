package com.example.demo.Model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AddressId")
    Integer addressId;

    @Column(name = "FlatAndApartment")
    String flatandapartment;
    @Column(name = "Street")
    String street;
    @Column(name = "City")
    String city;
    @Column(name="State")
    String state;
    @Column(name = "ZipCode")
    long zipcode;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getFlatandapartment() {
        return flatandapartment;
    }

    public void setFlatandapartment(String flatandapartment) {
        this.flatandapartment = flatandapartment;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }
}
