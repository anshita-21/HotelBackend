package com.AgilePeople.project.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;
    @Column(name = "tagline", nullable = true)
    private String tagline;
    @Column(name = "city", nullable = true)
    private String city;
    @Column(name = "description", nullable =true)
    private String description;

    @Column(name = "address", nullable = true)
    private String address;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "contact", nullable = true)
    private String contact;
    @Column(name = "email1", nullable = true)
    private String email1;
    @Column(name = "contact1", nullable = true)
    private String contact1;


    public Hotel() {

    }

    public Hotel(Long id, String name, String tagline, String city, String description, String address, String email, String contact, String email1, String contact1) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.city = city;
        this.description = description;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.email1 = email1;
        this.contact1 = contact1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }
}