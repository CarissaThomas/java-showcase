package com.example.myspringapi.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity
@Table(name="SuperHero")
public class SuperHero {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;
    @Column(name="first_name")
    public String firstName;
    @Column(name="last_name")
    public String lastName;
    @Column(name="super_power")
    public String superPower;

    // No-argument constructor required by JPA
    protected SuperHero() {
    }

    // Constructor
    public SuperHero(String firstName, String lastName, String superPower) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superPower = superPower;
    }

    // Getters and setters for each field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }
}
