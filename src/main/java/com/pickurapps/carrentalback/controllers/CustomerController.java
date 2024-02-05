package com.pickurapps.carrentalback.controllers;

import com.pickurapps.carrentalback.dto.CarDto;
import com.pickurapps.carrentalback.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> carDtos = customerService.getAllCars();
        return ResponseEntity.ok(carDtos);
    }
}
