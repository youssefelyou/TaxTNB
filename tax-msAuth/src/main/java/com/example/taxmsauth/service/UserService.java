package com.example.taxmsauth.service;

import com.example.taxmsauth.bean.Role;
import com.example.taxmsauth.bean.User;
import com.example.taxmsauth.dao.UserDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User save(User user ) {
        return userDao.save(user);
    }

    public Optional<User> findById(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> findByRole(Role role) {
        return userDao.findByRole(role);
    }
}
