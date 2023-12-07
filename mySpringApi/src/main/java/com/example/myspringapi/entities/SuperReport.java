package com.example.myspringapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name="SuperReport")
public class SuperReport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;
    @Column(name="postal_code")
    public String postalCode;
    @Column(name="street_address")
    public String streetAddress;
    protected SuperReport() {}

    public SuperReport(String firstName, String lastName) {
        this.postalCode = firstName;
        this.streetAddress = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Super Hero[id=%d, firstName='%s', lastName='%s', superPower='%s']",
                id, postalCode, streetAddress);
    }

    // Getters and setters for each field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
