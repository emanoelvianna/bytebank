package com.bytebank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Acount {

    private Person person;
    private BigDecimal balance;
    private LocalDate createdDate;

    public Acount(Person person) {
        this.person = person;
        this.balance = BigDecimal.ZERO;
        this.createdDate = LocalDate.now();
    }

    public Acount(Person person, BigDecimal balance, LocalDate createdDate) {
        this.person = person;
        this.balance = balance;
        this.createdDate = createdDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Acount{" +
                "person=" + person.getDocument() +
                ", balance=" + balance +
                ", createdDate=" + createdDate +
                '}';
    }
}
