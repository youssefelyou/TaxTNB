package com.example.tax.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cin;
    private String username;
    private String tel;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + ", username='" + username + '\'' + ", tel='" + tel + '\'' + ", role=" + role + '}';
    }
}
