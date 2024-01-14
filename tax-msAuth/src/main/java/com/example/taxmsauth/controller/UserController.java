package com.example.taxmsauth.controller;


import com.example.taxmsauth.bean.Role;
import com.example.taxmsauth.bean.User;
import com.example.taxmsauth.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/find/{id}")
    public Optional<User> findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @GetMapping("/username/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @GetMapping("/email/{email}")
    public Optional<User> findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);

    }

    @GetMapping("/role/{role}")
    public List<User> findByRole(@PathVariable Role role) {
        return userService.findByRole(role);
    }
}
