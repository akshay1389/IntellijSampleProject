package com.example.test.controller;

import com.example.test.Models.User;
import com.example.test.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }
    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "Saved....";
    }

    @PutMapping(value ="update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
     User updatedUser = userRepo.findById(id).get();
     updatedUser.setFirstName(user.getFirstName());
     updatedUser.setLastName(user.getLastName());
     updatedUser.setoccupation(user.getOccupation());
     updatedUser.setAge(user.getAge());
     userRepo.save(updatedUser);
     return "Updated....";
    }

}
