package com.example.taxmsauth.auth;

import com.example.taxmsauth.bean.User;
import com.example.taxmsauth.config.JwtService;
import com.example.taxmsauth.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(AuthenticationController.class.getName());

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        logger.info(request.getEmail());
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

    @PostMapping("/sign-in-with-token")
    public ResponseEntity<User> sign_in_using_token(@RequestBody TokenVo token) {
        String usernameFromToken = jwtService.extractUsername(token.getAccessToken());
        User user = userService.findUserByUsername(usernameFromToken);
        if (user != null) return new ResponseEntity<>(user, OK);
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}

