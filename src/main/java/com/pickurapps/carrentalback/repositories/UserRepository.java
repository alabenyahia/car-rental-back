package com.pickurapps.carrentalback.repositories;

import com.pickurapps.carrentalback.entities.User;
import com.pickurapps.carrentalback.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);

    User findByUserRole(UserRole userRole);
}
