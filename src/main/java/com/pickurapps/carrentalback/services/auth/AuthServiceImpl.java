package com.pickurapps.carrentalback.services.auth;

import com.pickurapps.carrentalback.dto.RegisterRequest;
import com.pickurapps.carrentalback.dto.UserDto;
import com.pickurapps.carrentalback.entities.User;
import com.pickurapps.carrentalback.enums.UserRole;
import com.pickurapps.carrentalback.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Override
    public UserDto createCustomer(RegisterRequest registerRequest) {
        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }

    @Override
    public boolean isAlreadyRegistered(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
