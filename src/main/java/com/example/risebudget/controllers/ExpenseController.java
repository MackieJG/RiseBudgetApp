package com.example.risebudget.controllers;

import com.example.risebudget.models.CategoryType;
import com.example.risebudget.models.Expense;
import com.example.risebudget.models.Provider;
import com.example.risebudget.repositories.ExpenseRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/filteredexpenses")
    public ResponseEntity<List<Expense>> getAllExpenses(
            @RequestParam(required = false) List<CategoryType> categories,
            @RequestParam(required = false) List<String> providers,
            @RequestParam(required = false) String startDateStr,
            @RequestParam(required = false) String endDateStr
    ) {
        List<Expense> expenses = new ArrayList<>();
        if(categories != null && !categories.isEmpty()) {
            expenses.addAll(expenseRepo.findByCategoryIn(categories));
        }
        if(providers != null && !providers.isEmpty()){
            expenses.addAll(expenseRepo.findByProviderNameIn(providers));
        }
        if(startDateStr != null && endDateStr != null){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = sdf.parse(startDateStr);
                Date endDate = sdf.parse(endDateStr);
                expenses.addAll(expenseRepo.findByDateBetween(startDate, endDate));
            } catch (ParseException e) {
                // handle exception
            }
        }
        return new ResponseEntity<>(expenses, HttpStatus.OK);
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
