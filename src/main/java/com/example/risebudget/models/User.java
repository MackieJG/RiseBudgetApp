package com.example.risebudget.models;

import java.util.List;

public class User {

    private String name;
    private double budget;
    private List<Expense> expenses;
    private List<Pot> pots;

    public User(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Pot> getPots() {
        return pots;
    }

    public void setPots(List<Pot> pots) {
        this.pots = pots;
    }
}
