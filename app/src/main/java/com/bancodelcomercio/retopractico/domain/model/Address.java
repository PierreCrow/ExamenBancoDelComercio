package com.bancodelcomercio.retopractico.domain.model;

import java.io.Serializable;

public class Address implements Serializable {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private UserGeo userGeo;

    public Address(String street, String suite, String city, String zipcode, UserGeo userGeo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.userGeo = userGeo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public UserGeo getUserGeo() {
        return userGeo;
    }

    public void setUserGeo(UserGeo userGeo) {
        this.userGeo = userGeo;
    }
}
