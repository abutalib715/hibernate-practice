package com.talib.hibernate;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, name = "STREET")
    private String street;

    @Column(length = 100, name = "CITY")
    private String city;

    private boolean isOpen;

    @Transient
    private double x;

    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;

    @Lob
    @Column(name = "image")
//    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;


    public Address() {
    }

    public Address(int id, String street, String city, Boolean isOpen, double x, Date addedDate, byte[] image) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
