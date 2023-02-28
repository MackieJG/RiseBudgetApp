package com.example.risebudget.controllers;

import com.example.risebudget.models.CategoryType;
import com.example.risebudget.models.Expense;
import com.example.risebudget.models.Provider;
import com.example.risebudget.repositories.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseController {

    @Autowired
    ExpenseRepo expenseRepo;

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

    @GetMapping(value = "/expenses/{id}")
    public ResponseEntity getExpense(@PathVariable Long id) {
        return new ResponseEntity(expenseRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/expenses")
    public ResponseEntity<Expense> postExpense(@RequestBody Expense expense) {
        expenseRepo.save(expense);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/expenses/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable Long id) {
        Optional<Expense> expenseToDelete = expenseRepo.findById(id);
        expenseRepo.delete(expenseToDelete.get());
        return new ResponseEntity<>(expenseToDelete.get(), HttpStatus.OK); // DOESN'T WORK
    }
}
