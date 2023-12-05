package com.myspringapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SuperReport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long reportId;
    private String postalCode;
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
                reportId, postalCode, streetAddress);
    }

    public Long getReportId() {
        return reportId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
}
