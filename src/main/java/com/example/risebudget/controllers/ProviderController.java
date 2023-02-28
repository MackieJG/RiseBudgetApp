package com.example.risebudget.controllers;

import com.example.risebudget.models.Provider;
import com.example.risebudget.repositories.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProviderController {

    @Autowired
    ProviderRepo providerRepo;

    @GetMapping(value = "/providers")
    public ResponseEntity<List<Provider>> getAllProviders() {
        return new ResponseEntity<>(providerRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/providers/{id}")
    public ResponseEntity getProvider(@PathVariable Long id) {
        return new ResponseEntity(providerRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/providers")
    public ResponseEntity<Provider> postProvider(@RequestBody Provider provider) {
        providerRepo.save(provider);
        return new ResponseEntity<>(provider, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/providers/{id}")
    public ResponseEntity<Provider> deleteProvider(@PathVariable Long id) {
        Optional<Provider> providerToDelete = providerRepo.findById(id);
        providerRepo.delete(providerToDelete.get());
        return new ResponseEntity<>(providerToDelete.get(), HttpStatus.OK); // DOESN'T WORK
    }
}
