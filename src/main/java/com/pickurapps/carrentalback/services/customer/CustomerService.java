package com.pickurapps.carrentalback.services.customer;

import com.pickurapps.carrentalback.dto.BookACarDto;
import com.pickurapps.carrentalback.dto.CarDto;
import com.pickurapps.carrentalback.dto.CarDtoListDto;
import com.pickurapps.carrentalback.dto.CarSearchDto;

import java.util.List;

public interface CustomerService {
    List<CarDto> getAllCars();
    boolean bookACar(BookACarDto bookACarDto);
    CarDto getCarById(long carId);
    List<BookACarDto> getBookingsByUserId(Long userId);
    CarDtoListDto searchCar(CarSearchDto carSearchDto);

}
