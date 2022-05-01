package com.user.controller;

import com.user.model.Users;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class dbStoreService {

    @Autowired
    UserRepository userRepository;
    
    /*user store service*/ //TODO
    @GetMapping("/users")
    public Collection<Users> getFindAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Users> findUserById(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    public Users saveUser(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public String updateUser(@RequestBody Users newUser, @PathVariable("id") int id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty())
            return "Id Not Found";

        Users users = user.get();
        users.setUserName(newUser.getUserName());
        users.setEmail(newUser.getEmail());
        users.setPassword(newUser.getPassword());

        return "Updated User!";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty())
            return "Id Not Found";

        userRepository.deleteById(id);
        return "Deleted user with Id : " + id;
    }

}

