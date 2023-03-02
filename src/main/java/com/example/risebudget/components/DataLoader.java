package com.example.risebudget.components;

import com.example.risebudget.models.*;
import com.example.risebudget.repositories.ExpenseRepo;
import com.example.risebudget.repositories.PotRepo;
import com.example.risebudget.repositories.ProviderRepo;
import com.example.risebudget.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Profile("!test")
//@Component
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

    public void run(ApplicationArguments args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        User user = new User("James", 1000);
        userRepo.save(user);

//        Pot pot1 = new Pot("Holiday Trip", 600.00, user);
//        potRepo.save(pot1);
//        Pot pot2 = new Pot("Rainy Day", 5000.00, user);
//        potRepo.save(pot2);

        Provider netflix = new Provider("Netflix");
        providerRepo.save(netflix);

        Provider tesco = new Provider("Tesco");
        providerRepo.save(tesco);
        Provider asda = new Provider("Asda");
        providerRepo.save(asda);
        Provider morrisons = new Provider("Morrisons");
        providerRepo.save(morrisons);

        Provider dominos = new Provider("Dominos");
        providerRepo.save(dominos);

        Provider sse = new Provider("SSE");
        providerRepo.save(sse);
        Provider octopus = new Provider("Octopus");
        providerRepo.save(octopus);



        Date date = dateFormat.parse("01/01/2023");

        Expense groceries1 = new Expense("Food Shopping", 60.25, tesco, CategoryType.GROCERIES, user);
        expenseRepo.save(groceries1);
        Expense groceries2 = new Expense("Food Shopping", 30.50, tesco, CategoryType.GROCERIES, user);
        expenseRepo.save(groceries2);
        Expense groceries3 = new Expense("Food Shopping", 20.45, tesco, CategoryType.GROCERIES, user);
        expenseRepo.save(groceries3);

        Expense groceries4 = new Expense("BEERS", 50.50, asda, CategoryType.GROCERIES, user);
        groceries4.setDate(date);
        expenseRepo.save(groceries4);


        Expense groceries5 = new Expense("MORE BEERS", 20.45, morrisons, CategoryType.GROCERIES, user);
        expenseRepo.save(groceries5);

        Expense expense2 = new Expense("Netflix", 14.99, netflix, CategoryType.SUBSCRIPTIONS, user);
        expenseRepo.save(expense2);

        Expense utilities1 = new Expense("Gas", 64.50, sse, CategoryType.UTILITIES, user);
        expenseRepo.save(utilities1);
        Expense utilities2 = new Expense("Leccy", 88.80, sse, CategoryType.UTILITIES, user);
        expenseRepo.save(utilities2);

    }





}
