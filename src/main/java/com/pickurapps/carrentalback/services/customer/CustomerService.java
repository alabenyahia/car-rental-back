package com.pickurapps.carrentalback.services.customer;

import com.pickurapps.carrentalback.dto.BookACarDto;
import com.pickurapps.carrentalback.dto.CarDto;

import java.util.List;

public interface CustomerService {
    List<CarDto> getAllCars();
    boolean bookACar(BookACarDto bookACarDto);
    CarDto getCarById(long carId);
}
