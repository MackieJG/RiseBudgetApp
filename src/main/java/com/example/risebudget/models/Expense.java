package com.example.risebudget.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private double amount;

    @JsonIgnoreProperties({ "expenses" })
    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @Column(name="category_type")
    @Enumerated(value = EnumType.STRING)
    private CategoryType category;

    @JsonIgnoreProperties({ "expenses" })
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Expense(String title, double amount, Provider provider, CategoryType category, User user) {
        this.title = title;
        this.amount = amount;
        this.provider = provider;
        this.category = category;
        this.user = user;
    }

    public Expense(){}
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

    public CategoryType getCategory() {
        return category;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
