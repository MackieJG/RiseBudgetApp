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

    public void run(ApplicationArguments args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

//        USER
        User user = new User("James", 4000);
        userRepo.save(user);

//        POTS
        Pot pot1 = new Pot("Holiday", 2000.00, 500.00, user);
        potRepo.save(pot1);
        Pot pot2 = new Pot("Car", 7500.00, 1300.00, user);
        potRepo.save(pot2);

//        RENT PROVIDER
        Provider westernlettings = new Provider("Western Lettings");
        providerRepo.save(westernlettings);


//        SUBSCRIPTION PROVIDERS
        Provider netflix = new Provider("Netflix");
        providerRepo.save(netflix);
        Provider disneyplus = new Provider("Disney Plus");
        providerRepo.save(disneyplus);
        Provider spotify = new Provider("Spotify");
        providerRepo.save(spotify);

//          GROCERY PROVIDERS
        Provider tesco = new Provider("Tesco");
        providerRepo.save(tesco);
        Provider asda = new Provider("Asda");
        providerRepo.save(asda);
        Provider morrisons = new Provider("Morrisons");
        providerRepo.save(morrisons);

//        EATING_OUT PROVIDERS
        Provider dominos = new Provider("Dominos");
        providerRepo.save(dominos);
        Provider kokiro = new Provider( "Kokiro");
        providerRepo.save(kokiro);
        Provider tacobell = new Provider("Taco Bell");
        providerRepo.save(tacobell);
        Provider greggs = new Provider("Greggs");
        providerRepo.save(greggs);
        Provider falafel = new Provider("Falafel Guy");
        providerRepo.save(falafel);

//        UTILITIES PROVIDERS
        Provider sse = new Provider("SSE");
        providerRepo.save(sse);
        Provider octopus = new Provider("Octopus");
        providerRepo.save(octopus);
        Provider council = new Provider("Glasgow City Council");
        providerRepo.save(council);


//        ENTERTAINMENT PROVIDERS
        Provider belljar = new Provider("The Bell Jar");
        providerRepo.save(belljar);
        Provider allisonarms = new Provider("The Allison Arms");
        providerRepo.save(allisonarms);
        Provider pub = new Provider("Pub");
        providerRepo.save(pub);
        Provider masters = new Provider("The Masters");
        providerRepo.save(masters);
        Provider cinema = new Provider("Cinema");
        providerRepo.save(cinema);

//        HEALTH PROVIDERS
        Provider gym = new Provider("Pure Gym");
        providerRepo.save(gym);

//        TRANSPORT PROVIDERS
        Provider scotrail = new Provider("ScotRail");
        providerRepo.save(scotrail);



//         DATES
        Date rentDateJan1 = dateFormat.parse("01/01/2023");
        Date dateJan2 = dateFormat.parse("03/01/2023");
        Date dateJan3 = dateFormat.parse("11/01/2023");
        Date dateJan4 = dateFormat.parse("19/01/2023");
        Date dateJan5 = dateFormat.parse("27/01/2023");
        Date dateJan6 = dateFormat.parse("30/01/2023");

        Date rentDateFeb1 = dateFormat.parse("01/02/2023");
        Date dateFeb2 = dateFormat.parse("03/02/2023");
        Date dateFeb3 = dateFormat.parse("12/02/2023");
        Date dateFeb4 = dateFormat.parse("16/02/2023");
        Date dateFeb5 = dateFormat.parse("25/02/2023");
        Date dateFeb6 = dateFormat.parse("26/02/2023");

        Date rentDateMar1 = dateFormat.parse("01/03/2023");
        Date dateMar2 = dateFormat.parse("03/02/2023");
        Date dateMar3 = dateFormat.parse("09/02/2023");
        Date dateMar4 = dateFormat.parse("16/02/2023");
        Date dateMar5 = dateFormat.parse("25/02/2023");
        Date dateMar6 = dateFormat.parse("29/02/2023");


//          JANUARY EXPENSES
//      RENT
        Expense rentJan = new Expense("Rent", 300.00, westernlettings, CategoryType.RENT, user);
        rentJan.setDate(rentDateJan1);
        expenseRepo.save(rentJan);

//      UTILITIES
        Expense utilities1 = new Expense("Gas", 64.50, octopus, CategoryType.UTILITIES, user);
        utilities1.setDate(rentDateJan1);
        expenseRepo.save(utilities1);
        Expense utilities2 = new Expense("Leccy", 88.80, sse, CategoryType.UTILITIES, user);
        utilities2.setDate(rentDateFeb1);
        expenseRepo.save(utilities2);
        Expense utilities3 = new Expense("Council Tax (daylight robbery)", 88.80, council, CategoryType.UTILITIES, user);
        utilities3.setDate(rentDateJan1);
        expenseRepo.save(utilities3);

//      SUBSCRIPTIONS
        Expense sub1 = new Expense("Netflix Subscription", 14.99, netflix, CategoryType.SUBSCRIPTIONS, user);
        sub1.setDate(dateJan2);
        expenseRepo.save(sub1);
        Expense sub2 = new Expense("Disney Plus Subscription", 11.99, disneyplus, CategoryType.SUBSCRIPTIONS, user);
        sub2.setDate(dateJan2);
        expenseRepo.save(sub2);
        Expense sub3 = new Expense("Spotify Subscription", 11.99, spotify, CategoryType.SUBSCRIPTIONS, user);
        sub3.setDate(dateJan2);
        expenseRepo.save(sub3);

//      HEALTH
        Expense gymMembership1 = new Expense("Pure Gym Membership", 19.99, gym, CategoryType.HEALTH, user);
        gymMembership1.setDate(dateJan2);
        expenseRepo.save(gymMembership1);

//      GROCERIES
        Expense groceries1 = new Expense("Weekly Shop", 60.25, morrisons, CategoryType.GROCERIES, user);
        groceries1.setDate(dateJan2);
        expenseRepo.save(groceries1);
        Expense groceries2 = new Expense("Weekly Shop", 35.50, tesco, CategoryType.GROCERIES, user);
        groceries2.setDate(dateJan3);
        expenseRepo.save(groceries2);
        Expense groceries3 = new Expense("Weekly Shop", 41.45, tesco, CategoryType.GROCERIES, user);
        groceries3.setDate(dateJan4);
        expenseRepo.save(groceries3);
        Expense groceries4 = new Expense("Weekly Shop", 20.45, asda, CategoryType.GROCERIES, user);
        groceries4.setDate(dateJan5);
        expenseRepo.save(groceries4);

//      ENTERTAINMENT
        Expense pints = new Expense("10 pints of Guinness", 49.50, allisonarms, CategoryType.ENTERTAINMENT, user);
        pints.setDate(dateJan2);
        expenseRepo.save(pints);
        Expense drinks = new Expense("Cocktails", 34.00, allisonarms, CategoryType.ENTERTAINMENT, user);
        drinks.setDate(dateJan3);
        expenseRepo.save(drinks);
        Expense movieTickets = new Expense("Movies", 9.50, cinema, CategoryType.ENTERTAINMENT, user);
        movieTickets.setDate(dateJan3);
        expenseRepo.save(movieTickets);
        Expense snooker = new Expense("Snooker", 14.00, masters, CategoryType.ENTERTAINMENT, user);
        snooker.setDate(dateJan5);
        expenseRepo.save(snooker);
        Expense beers = new Expense("Out For Beers", 27.30, belljar, CategoryType.ENTERTAINMENT, user);
        beers.setDate(dateJan5);
        expenseRepo.save(beers);

//      EATINGOUT
        Expense lunch1 = new Expense("Lunch Falafel", 8.99, falafel, CategoryType.EATING_OUT, user);
        lunch1.setDate(dateJan4);
        expenseRepo.save(lunch1);
        Expense takeAway = new Expense("Pizza Party", 40.99, dominos, CategoryType.EATING_OUT, user);
        takeAway.setDate(dateJan6);
        expenseRepo.save(takeAway);
        Expense lunch2 = new Expense("Taco Bell", 10.50, tacobell, CategoryType.EATING_OUT, user);
        lunch2.setDate(dateJan5);
        expenseRepo.save(lunch2);

//      TRANSPORT
        Expense weeklyTicket1 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
        weeklyTicket1.setDate(dateJan2);
        expenseRepo.save(weeklyTicket1);
        Expense weeklyTicket2 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
        weeklyTicket2.setDate(dateJan3);
        expenseRepo.save(weeklyTicket2);
        Expense weeklyTicket3 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
        weeklyTicket3.setDate(dateJan4);
        expenseRepo.save(weeklyTicket3);
        Expense weeklyTicket4 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
        weeklyTicket4.setDate(dateJan5);
        expenseRepo.save(weeklyTicket4);

//          FEB EXPENSES
//      RENT
        Expense rentFeb = new Expense("Rent", 300.00, westernlettings, CategoryType.RENT, user);
        rentFeb.setDate(rentDateFeb1);
        expenseRepo.save(rentFeb);

//      UTILITIES
        Expense utilities4 = new Expense("Gas", 64.50, octopus, CategoryType.UTILITIES, user);
        utilities4.setDate(rentDateFeb1);
        expenseRepo.save(utilities4);
        Expense utilities5 = new Expense("Leccy", 88.80, sse, CategoryType.UTILITIES, user);
        utilities5.setDate(rentDateFeb1);
        expenseRepo.save(utilities5);
        Expense utilities6 = new Expense("Council Tax (daylight robbery)", 88.80, council, CategoryType.UTILITIES, user);
        utilities6.setDate(rentDateFeb1);
        expenseRepo.save(utilities6);

//      SUBSCRIPTIONS
        Expense sub4 = new Expense("Netflix Subscription", 14.99, netflix, CategoryType.SUBSCRIPTIONS, user);
        sub4.setDate(dateFeb2);
        expenseRepo.save(sub4);
        Expense sub5 = new Expense("Disney Plus Subscription", 11.99, disneyplus, CategoryType.SUBSCRIPTIONS, user);
        sub5.setDate(dateFeb2);
        expenseRepo.save(sub5);
        Expense sub6 = new Expense("Spotify Subscription", 11.99, spotify, CategoryType.SUBSCRIPTIONS, user);
        sub6.setDate(dateFeb2);
        expenseRepo.save(sub6);

//      HEALTH
        Expense gymMembership2 = new Expense("Pure Gym Membership", 19.99, gym, CategoryType.HEALTH, user);
        gymMembership2.setDate(dateFeb2);
        expenseRepo.save(gymMembership2);

//      GROCERIES
        Expense groceries5 = new Expense("Weekly Shop", 60.25, morrisons, CategoryType.GROCERIES, user);
        groceries5.setDate(dateFeb2);
        expenseRepo.save(groceries5);
        Expense groceries6 = new Expense("Weekly Shop", 55.50, tesco, CategoryType.GROCERIES, user);
        groceries6.setDate(dateFeb3);
        expenseRepo.save(groceries6);
        Expense groceries7 = new Expense("Weekly Shop", 79.45, tesco, CategoryType.GROCERIES, user);
        groceries7.setDate(dateFeb4);
        expenseRepo.save(groceries7);
        Expense groceries8 = new Expense("Weekly Shop", 68.31, asda, CategoryType.GROCERIES, user);
        groceries8.setDate(dateFeb6);
        expenseRepo.save(groceries8);

//      ENTERTAINMENT
        Expense pints2 = new Expense("Dinner and Drinks", 49.50, allisonarms, CategoryType.ENTERTAINMENT, user);
        pints2.setDate(dateFeb3);
        expenseRepo.save(pints2);
        Expense movieTickets2 = new Expense("Movies", 9.50, cinema, CategoryType.ENTERTAINMENT, user);
        movieTickets2.setDate(dateFeb3);
        expenseRepo.save(movieTickets2);
        Expense snooker2 = new Expense("Snooker and Beers", 88.88, masters, CategoryType.ENTERTAINMENT, user);
        snooker2.setDate(dateFeb5);
        expenseRepo.save(snooker2);
        Expense beers2 = new Expense("Pints", 27.30, belljar, CategoryType.ENTERTAINMENT, user);
        beers2.setDate(dateFeb6);
        expenseRepo.save(beers2);

//      EATINGOUT
        Expense lunch3 = new Expense("Lunch Falafel", 8.99, falafel, CategoryType.EATING_OUT, user);
        lunch3.setDate(dateFeb3);
        expenseRepo.save(lunch3);
        Expense takeAway2 = new Expense("Pizza Party", 40.99, dominos, CategoryType.EATING_OUT, user);
        takeAway2.setDate(dateFeb4);
        expenseRepo.save(takeAway2);
        Expense lunch4 = new Expense("Taco Bell", 10.50, tacobell, CategoryType.EATING_OUT, user);
        lunch4.setDate(dateFeb6);
        expenseRepo.save(lunch4);

//      TRANSPORT
        Expense weeklyTicket5 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
        weeklyTicket5.setDate(dateFeb2);
        expenseRepo.save(weeklyTicket5);
        Expense weeklyTicket6 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
        weeklyTicket6.setDate(dateFeb3);
        expenseRepo.save(weeklyTicket6);
        Expense weeklyTicket7 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
        weeklyTicket7.setDate(dateFeb4);
        expenseRepo.save(weeklyTicket7);
        Expense weeklyTicket8 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
        weeklyTicket8.setDate(dateFeb6);
        expenseRepo.save(weeklyTicket8);



//        //      RENT
//        Expense rent = new Expense("Rent", 300.00, westernlettings, CategoryType.RENT, user);
//        expenseRepo.save(rent);
//
////      UTILITIES
//        Expense utilities1 = new Expense("Gas", 64.50, octopus, CategoryType.UTILITIES, user);
//        expenseRepo.save(utilities1);
//        Expense utilities2 = new Expense("Leccy", 88.80, sse, CategoryType.UTILITIES, user);
//        expenseRepo.save(utilities2);
//        Expense utilities3 = new Expense("Council Tax (daylight robbery)", 88.80, council, CategoryType.UTILITIES, user);
//        expenseRepo.save(utilities3);
//
////      SUBSCRIPTIONS
//        Expense sub1 = new Expense("Netflix Subscription", 14.99, netflix, CategoryType.SUBSCRIPTIONS, user);
//        expenseRepo.save(sub1);
//        Expense sub2 = new Expense("Disney Plus Subscription", 11.99, disneyplus, CategoryType.SUBSCRIPTIONS, user);
//        expenseRepo.save(sub2);
//        Expense sub3 = new Expense("Spotify Subscription", 11.99, spotify, CategoryType.SUBSCRIPTIONS, user);
//        expenseRepo.save(sub3);
//
////      HEALTH
//        Expense gymMembership = new Expense("Pure Gym Membership", 19.99, gym, CategoryType.HEALTH, user);
//        expenseRepo.save(gymMembership);
//
////      GROCERIES
//        Expense groceries1 = new Expense("Weekly Shop", 60.25, morrisons, CategoryType.GROCERIES, user);
//        expenseRepo.save(groceries1);
//        Expense groceries2 = new Expense("Weekly Shop", 35.50, tesco, CategoryType.GROCERIES, user);
//        expenseRepo.save(groceries2);
//        Expense groceries3 = new Expense("Weekly Shop", 41.45, tesco, CategoryType.GROCERIES, user);
//        expenseRepo.save(groceries3);
//        Expense groceries4 = new Expense("Weekly Shop", 20.45, asda, CategoryType.GROCERIES, user);
//        expenseRepo.save(groceries4);
//
////      ENTERTAINMENT
//        Expense pints = new Expense("10 pints of Guinness", 49.50, allisonarms, CategoryType.ENTERTAINMENT, user);
//        expenseRepo.save(pints);
//        Expense drinks = new Expense("Cocktails", 34.00, allisonarms, CategoryType.ENTERTAINMENT, user);
//        expenseRepo.save(drinks);
//        Expense movieTickets = new Expense("Movies", 9.50, cinema, CategoryType.ENTERTAINMENT, user);
//        expenseRepo.save(movieTickets);
//        Expense snooker = new Expense("Snooker", 14.00, masters, CategoryType.ENTERTAINMENT, user);
//        expenseRepo.save(snooker);
//        Expense beers = new Expense("Out For Beers", 27.30, belljar, CategoryType.ENTERTAINMENT, user);
//        expenseRepo.save(beers);
//
////      EATINGOUT
//        Expense lunch1 = new Expense("Lunch Falafel", 8.99, falafel, CategoryType.EATING_OUT, user);
//        expenseRepo.save(lunch1);
//        Expense takeAway = new Expense("Pizza Party", 40.99, dominos, CategoryType.EATING_OUT, user);
//        expenseRepo.save(takeAway);
//        Expense lunch2 = new Expense("Taco Bell", 10.50, tacobell, CategoryType.EATING_OUT, user);
//        expenseRepo.save(lunch2);
//
////      TRANSPORT
//        Expense weeklyTicket1 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
//        expenseRepo.save(weeklyTicket1);
//        Expense weeklyTicket2 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
//        expenseRepo.save(weeklyTicket2);
//        Expense weeklyTicket3 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
//        expenseRepo.save(weeklyTicket3);
//        Expense weeklyTicket4 = new Expense("Weekly Train ticket", 15.50, scotrail, CategoryType.TRANSPORT, user);
//        expenseRepo.save(weeklyTicket4);

    }





}
