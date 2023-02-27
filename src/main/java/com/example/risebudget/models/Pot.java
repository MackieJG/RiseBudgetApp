package com.example.risebudget.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "pots")
public class Pot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private double amount;

    @JsonIgnoreProperties({ "pots" })
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Pot(String title, double amount, User user) {
        this.title = title;
        this.amount = amount;
        this.user = user;
    }

    public Pot(){}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
