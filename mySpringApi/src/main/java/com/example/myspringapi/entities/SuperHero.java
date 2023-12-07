package com.example.myspringapi.entities;
import javax.persistence.*;

@Entity
@Table(name="SuperHero")
public class SuperHero {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long heroId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="super_power")
    private String superPower;

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
    public Long getHeroId() {
        return heroId;
    }

    public void setHeroId(Long heroId) {
        this.heroId = heroId;
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
