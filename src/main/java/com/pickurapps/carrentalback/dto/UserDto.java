package com.pickurapps.carrentalback.dto;

import com.pickurapps.carrentalback.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {
    private Long id;


    private String name;
    private String email;
    private UserRole userRole;
}
