package com.sda.springapporderclient.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String country;
    @Column(length = 40)
    private String city;
    @Column(length = 50)
    private String street;
    @Column(name = "flat_no")
    private Integer flatNo;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address() {
    }

    public Address(String country, String city, String street, Integer flatNo) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.flatNo = flatNo;
    }

    public Address(String country, String city, String street, Integer flatNo, User user) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.flatNo = flatNo;
        this.user = user;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(Integer flatNo) {
        this.flatNo = flatNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", flatNo=" + flatNo +
                ", user=" + user +
                '}';
    }
}
