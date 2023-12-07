package com.example.myspringapi.entities;

import javax.persistence.*;

@Entity
@Table(name="SuperReport")
public class SuperReport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long heroId;
    @Column(name="postal_code")
    private String postalCode;
    @Column(name="street_address")
    private String streetAddress;
    protected SuperReport() {}

    public SuperReport(String firstName, String lastName) {
        this.postalCode = firstName;
        this.streetAddress = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Super Hero[id=%d, firstName='%s', lastName='%s', superPower='%s']",
                heroId, postalCode, streetAddress);
    }

    // Getters and setters for each field
    public Long getHeroId() {
        return heroId;
    }

    public void setHeroId(Long heroId) {
        this.heroId = heroId;
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
