package com.bytebank.model;

import java.time.LocalDate;

public class Person {
    private String name;
    private String document;
    private LocalDate birthDate;
    private String address;
    private String email;

    public Person(String name, String document, LocalDate birthDate, String address, String email) {
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
}
