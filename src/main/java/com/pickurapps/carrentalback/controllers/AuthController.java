package com.pickurapps.carrentalback.controllers;

import com.pickurapps.carrentalback.dto.RegisterRequest;
import com.pickurapps.carrentalback.dto.UserDto;
import com.pickurapps.carrentalback.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody RegisterRequest registerRequest) {
        if (authService.isAlreadyRegistered(registerRequest.getEmail())) {
            return new ResponseEntity<>("Email already used !", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdCustomerDto = authService.createCustomer(registerRequest);

        if (createdCustomerDto == null) {
            return new ResponseEntity<>(
                    "Error creating customer", HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }
}
