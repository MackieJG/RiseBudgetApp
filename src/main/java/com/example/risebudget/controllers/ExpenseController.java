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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

    @GetMapping(value = "/expenses/{id}")
    public ResponseEntity getExpense(@PathVariable Long id) {
        return new ResponseEntity(expenseRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/expenses")
    public ResponseEntity<Expense> postExpense(@RequestBody Expense expense) {
        expenseRepo.save(expense);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

//    @PostMapping(value="/filter")
//    public ResponseEntity<Expense> filterExpense(@RequestBody com.fasterxml.jackson.databind.JsonNode payload){
//        List<Expense> allExpenses = expenseRepo.findAll();
//       ArrayList categories = new ArrayList<>(payload.get("selections"));
//        List<Expense> filteredExpenses = new ArrayList<>();
//        for (int i = 0; i < categories.size(); i++){
////            System.out.println(categories.get(i));
//            for(Expense expense : allExpenses){
//                String expCategory = expense.getCategory().getString();
////                String expCategoryString = expCategory.toString();
//                String currentCategory = String.valueOf(categories.get(i));
//                System.out.println(expCategory);
//                System.out.println(currentCategory);
//                if(expCategory.equals(currentCategory)){
//                    filteredExpenses.add(expense);
//                }
//            }
//        }
//        System.out.println(filteredExpenses);
//
//        return null;
//    }



    @PostMapping(value="/filter")
    public ResponseEntity<List<Expense>> filterExpense(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
        List<Expense> allExpenses = expenseRepo.findAll();

        ArrayList<String> categories = new ArrayList<>();
        JsonNode categorySelections = payload.get("categorySelections");
        if (categorySelections.isArray()) {
            for (JsonNode selection : categorySelections) {
                categories.add(selection.asText());
            }
        }

        System.out.println(categories);

        ArrayList<String> providers = new ArrayList<>();
        JsonNode providerSelections = payload.get("providerSelections");
        if (providerSelections.isArray()) {
            for (JsonNode selection : providerSelections) {
                providers.add(selection.asText());
            }
        }

        System.out.println(providers);

        List<Expense> filteredExpenses = allExpenses.stream()
                .filter(expense -> categories.contains(expense.getCategory().toString()))
                .collect(Collectors.toList());

        System.out.println(filteredExpenses);
        System.out.println(filteredExpenses.size());

        List<Expense> filteredExpenses2 = filteredExpenses.stream()
                .filter(expense -> providers.contains(expense.getProvider().toString()))
                .collect(Collectors.toList());

        System.out.println(filteredExpenses2);
        System.out.println(filteredExpenses2.size());

        return ResponseEntity.ok(filteredExpenses2);
    }



    @DeleteMapping(value = "/expenses/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable Long id) {
        Optional<Expense> expenseToDelete = expenseRepo.findById(id);
        expenseRepo.delete(expenseToDelete.get());
        return new ResponseEntity<>(expenseToDelete.get(), HttpStatus.OK); // DOESN'T WORK
    }
}
