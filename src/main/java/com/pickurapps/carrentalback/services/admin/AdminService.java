package com.pickurapps.carrentalback.services.admin;

import com.pickurapps.carrentalback.dto.BookACarDto;
import com.pickurapps.carrentalback.dto.CarDto;
import com.pickurapps.carrentalback.dto.CarDtoListDto;
import com.pickurapps.carrentalback.dto.CarSearchDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    boolean postCar(CarDto carDto) throws IOException;
    List<CarDto> getAllCars();
    void deleteCar(Long id);
    CarDto getCarById(Long id);
    boolean updateCar(Long carId, CarDto carDto) throws IOException;
    List<BookACarDto> getBookings();
    boolean changeBookingStatus(Long bookingId, String status);
    CarDtoListDto searchCar(CarSearchDto carSearchDto);

}
