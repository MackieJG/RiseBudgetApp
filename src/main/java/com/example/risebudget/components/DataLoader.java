package com.example.risebudget.components;

import com.example.risebudget.models.*;
import com.example.risebudget.repositories.ExpenseRepo;
import com.example.risebudget.repositories.PotRepo;
import com.example.risebudget.repositories.ProviderRepo;
import com.example.risebudget.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PotRepo potRepo;
    @Autowired
    ExpenseRepo expenseRepo;
    @Autowired
    ProviderRepo providerRepo;

    public DataLoader() {};

    public void run(ApplicationArguments args) {

        User user = new User("James", 1000);
        userRepo.save(user);

        Pot pot1 = new Pot("Holiday Trip", 600.00, user);
        potRepo.save(pot1);
        Pot pot2 = new Pot("Rainy Day", 5000.00, user);
        potRepo.save(pot2);

        Provider netflix = new Provider("Netflix");
        providerRepo.save(netflix);
        Provider tesco = new Provider("Tesco");
        providerRepo.save(tesco);
        Provider dominos = new Provider("Dominos");
        providerRepo.save(dominos);
        Provider sse = new Provider("SSE");
        providerRepo.save(sse);

        Expense expense1 = new Expense("Food Shopping", 60.25, tesco, CategoryType.GROCERIES, user);
        expenseRepo.save(expense1);
        Expense expense2 = new Expense("Netflix", 14.99, netflix, CategoryType.SUBSCRIPTIONS, user);
        expenseRepo.save(expense2);
        Expense expense3 = new Expense("Food Shopping", 30.50, tesco, CategoryType.GROCERIES, user);
        expenseRepo.save(expense3);
        Expense expense4 = new Expense("Food Shopping", 20.45, tesco, CategoryType.GROCERIES, user);
        expenseRepo.save(expense4);
        Expense expense5 = new Expense("Gas", 64.50, sse, CategoryType.UTILITIES, user);
        expenseRepo.save(expense5);

    }





}
