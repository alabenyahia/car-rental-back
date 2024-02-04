package com.pickurapps.carrentalback.services.admin;

import com.pickurapps.carrentalback.dto.CarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    boolean postCar(CarDto carDto) throws IOException;
    List<CarDto> getAllCars();
    void deleteCar(Long id);
    CarDto getCarById(Long id);
    boolean updateCar(Long carId, CarDto carDto) throws IOException;
}
