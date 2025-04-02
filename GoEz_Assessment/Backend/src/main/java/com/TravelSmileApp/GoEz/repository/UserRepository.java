package com.TravelSmileApp.GoEz.repository;
import com.TravelSmileApp.GoEz.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByLogin(String login);
}
