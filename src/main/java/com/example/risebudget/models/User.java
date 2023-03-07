package com.example.risebudget.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "budget")
    private double budget;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Expense> expenses;

    @JsonIgnoreProperties({ "user" })
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Pot> pots;

    public User(String name, double budget) {
        this.name = name;
        this.budget = budget;
        this.expenses = new ArrayList<>();
        this.pots = new ArrayList<>();
    }

    public User(){}

    public Long getId() {
        return id;
    }

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

    public void addExpense(Expense expense) {
        expenses.add(expense);
        double amount = expense.getAmount();
        double remainingBudget = this.budget - amount;
        setBudget(remainingBudget);
    }

    public void addMoneyToPot(Pot pot) {
        double amount =
    }

    public List<Pot> getPots() {
        return pots;
    }

    public void setPots(List<Pot> pots) {
        this.pots = pots;
    }

}
