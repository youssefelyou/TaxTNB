package com.example.taxmsauth.auth;



import com.example.taxmsauth.bean.Role;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private String tel;
}