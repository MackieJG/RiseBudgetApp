package com.example.risebudget.models;

public class Expense {

    private String title;
    private double amount;
    private Merchant merchant;
    private CategoryType category;

    public Expense(String title, double amount, Merchant merchant, CategoryType category) {
        this.title = title;
        this.amount = amount;
        this.merchant = merchant;
        this.category = category;
    }

    public Expense(){}

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

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }
}
