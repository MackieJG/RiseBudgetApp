package com.example.risebudget.controllers;

import com.example.risebudget.models.Pot;
import com.example.risebudget.models.User;
import com.example.risebudget.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return new ResponseEntity(userRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        Optional<User> userToDelete = userRepo.findById(id);
        userRepo.delete(userToDelete.get());
        return new ResponseEntity<>(userToDelete.get(), HttpStatus.OK); // DOESN'T WORK
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser, @PathVariable Long id){
        User existingUser = userRepo.findById(id).get();

        existingUser.setName(updatedUser.getName());
        existingUser.setBudget(updatedUser.getBudget());

        userRepo.save(existingUser);
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }
}
