package com.example.risebudget.models;

public class Pot {

    private String title;
    private double amount;

    public Pot(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    public Pot(){}

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
}
