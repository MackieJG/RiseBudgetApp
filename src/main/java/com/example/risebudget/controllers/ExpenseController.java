package com.example.risebudget.controllers;

import com.example.risebudget.models.*;
import com.example.risebudget.repositories.ExpenseRepo;
import com.example.risebudget.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ExpenseController {

    @Autowired
    ExpenseRepo expenseRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping(value = "/expenses")
    public ResponseEntity<List<Expense>> getAllExpenses(
            @RequestParam Optional<CategoryType> category,
            @RequestParam Optional<String> providerName) {
        if(category.isPresent()) {
            return new ResponseEntity<>(expenseRepo.findByCategory(category.get()), HttpStatus.OK);
        }
        if(providerName.isPresent()) {
            return new ResponseEntity<>(expenseRepo.findByProviderName(providerName.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(expenseRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/filteredexpenses")
    public ResponseEntity<List<Expense>> getAllExpenses(
            @RequestParam(required = false) List<CategoryType> categories,
            @RequestParam(required = false) List<String> providers,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate
    ) {
        Set<Expense> expensesSet = new HashSet<>();
        if(categories != null && !categories.isEmpty()) {
            System.out.println(categories);
            expensesSet.addAll(expenseRepo.findByCategoryIn(categories));
        }
        if(providers != null && !providers.isEmpty()){
            System.out.println(providers);
            expensesSet.addAll(expenseRepo.findByProviderNameIn(providers));
        }
        return new ResponseEntity<>(new ArrayList<>(expensesSet), HttpStatus.OK);
    }

    @GetMapping(value = "/expenses/{id}")
    public ResponseEntity getExpense(@PathVariable Long id) {
        return new ResponseEntity(expenseRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/expenses")
    public ResponseEntity<Expense> postExpense(@RequestBody Expense expense) {
        expenseRepo.save(expense);
//        User user = userRepo.findById(expense.getUser().getId()).get();
//        ArrayList expenseList = (ArrayList) user.getExpenses();
//        double total = 0;
//        for(int i = 0; i < expenseList.size(); i++){
//            Expense exp = (Expense) expenseList.get(i);
//            total += exp.getAmount();
//        }
//
//        user.setBudget(user.getBudget() - total);
//        userRepo.save(user);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/expenses/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable Long id) {
        Optional<Expense> expenseToDelete = expenseRepo.findById(id);
        expenseRepo.delete(expenseToDelete.get());
        return new ResponseEntity<>(expenseToDelete.get(), HttpStatus.OK); // DOESN'T WORK
    }

    @PutMapping(value = "/expenses/{id}")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense updatedExpense, @PathVariable Long id){
        Expense existingExpense = expenseRepo.findById(id).get();

        existingExpense.setTitle(updatedExpense.getTitle());
        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setProvider(updatedExpense.getProvider());
        existingExpense.setCategory(updatedExpense.getCategory());
        existingExpense.setDate(updatedExpense.getDate());

        expenseRepo.save(existingExpense);
        return new ResponseEntity<>(existingExpense, HttpStatus.OK);
    }
}
