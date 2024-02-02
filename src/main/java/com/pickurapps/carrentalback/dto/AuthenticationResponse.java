package com.pickurapps.carrentalback.dto;

import com.pickurapps.carrentalback.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;
}
