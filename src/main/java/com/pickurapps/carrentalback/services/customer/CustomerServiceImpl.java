package com.pickurapps.carrentalback.services.customer;

import com.pickurapps.carrentalback.dto.BookACarDto;
import com.pickurapps.carrentalback.dto.CarDto;
import com.pickurapps.carrentalback.entities.BookACar;
import com.pickurapps.carrentalback.entities.Car;
import com.pickurapps.carrentalback.entities.User;
import com.pickurapps.carrentalback.enums.BookCarStatus;
import com.pickurapps.carrentalback.repositories.BookACarRepository;
import com.pickurapps.carrentalback.repositories.CarRepository;
import com.pickurapps.carrentalback.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final BookACarRepository bookACarRepository;


    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public boolean bookACar(BookACarDto bookACarDto) {
        Optional<Car> optionalCar = carRepository.findById(bookACarDto.getCarId());
        Optional<User> optionalUser = userRepository.findById(bookACarDto.getUserId());

        if (optionalCar.isPresent() && optionalUser.isPresent()) {
            Car existingCar = optionalCar.get();
            BookACar bookACar = new BookACar();

            bookACar.setUser(optionalUser.get());
            bookACar.setCar(existingCar);
            bookACar.setFromDate(bookACarDto.getFromDate());
            bookACar.setToDate(bookACarDto.getToDate());
            bookACar.setBookCarStatus(BookCarStatus.PENDING);
            long diffInMs = bookACarDto.getToDate().getTime() - bookACarDto.getFromDate().getTime();
            long days = TimeUnit.MILLISECONDS.toDays(diffInMs);
            bookACar.setDays(days);
            bookACar.setPrice(existingCar.getPrice() * days);

            bookACarRepository.save(bookACar);
            return true;
        }
        return false;
    }

    @Override
    public CarDto getCarById(long carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            return optionalCar.map(Car::getCarDto).orElse(null);
        }
        return null;
    }

}
