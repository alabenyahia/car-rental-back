package com.pickurapps.carrentalback.services.auth;

import com.pickurapps.carrentalback.dto.RegisterRequest;
import com.pickurapps.carrentalback.dto.UserDto;

public interface AuthService {
    UserDto createCustomer(RegisterRequest registerRequest);
    boolean isAlreadyRegistered(String email);
}
