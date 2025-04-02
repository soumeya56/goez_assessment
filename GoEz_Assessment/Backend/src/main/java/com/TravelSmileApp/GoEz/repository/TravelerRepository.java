package com.TravelSmileApp.GoEz.repository;

import com.TravelSmileApp.GoEz.models.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {
    Optional<Traveler> findByEmail(String email);
}
