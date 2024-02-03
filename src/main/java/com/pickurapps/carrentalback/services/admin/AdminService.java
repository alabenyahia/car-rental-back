package com.pickurapps.carrentalback.services.admin;

import com.pickurapps.carrentalback.dto.CarDto;
import com.pickurapps.carrentalback.repositories.CarRepository;

import java.io.IOException;

public interface AdminService {
    boolean postCar(CarDto carDto) throws IOException;
}
