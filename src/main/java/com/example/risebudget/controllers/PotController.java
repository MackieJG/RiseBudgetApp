package com.example.risebudget.controllers;

import com.example.risebudget.models.Pot;
import com.example.risebudget.models.User;
import com.example.risebudget.repositories.PotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PotController {

    @Autowired
    PotRepo potRepo;

    @GetMapping(value = "/pots")
    public ResponseEntity<List<Pot>> getAllPots() {
        return new ResponseEntity<>(potRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/pots/{id}")
    public ResponseEntity getPot(@PathVariable Long id) {
        return new ResponseEntity(potRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/pots")
    public ResponseEntity<Pot> postExpense(@RequestBody Pot pot) {
        potRepo.save(pot);
        return new ResponseEntity<>(pot, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/pots/{id}")
    public ResponseEntity<Pot> deletePot(@PathVariable Long id) {
        Optional<Pot> potToDelete = potRepo.findById(id);
        potRepo.delete(potToDelete.get());
        return new ResponseEntity<>(potToDelete.get(), HttpStatus.OK); // DOESN'T WORK
    }
}
