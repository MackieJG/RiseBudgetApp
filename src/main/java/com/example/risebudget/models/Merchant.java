package com.example.risebudget.models;

public class Merchant {

    private String name;

    public Merchant(String name) {
        this.name = name;
    }

    public Merchant(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
