package com.pickurapps.carrentalback.services.customer;

import com.pickurapps.carrentalback.dto.CarDto;
import com.pickurapps.carrentalback.entities.Car;
import com.pickurapps.carrentalback.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

}
