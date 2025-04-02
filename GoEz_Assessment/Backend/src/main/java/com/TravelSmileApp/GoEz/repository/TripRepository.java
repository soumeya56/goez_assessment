package com.TravelSmileApp.GoEz.repository;

import com.TravelSmileApp.GoEz.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByDestinationContainingIgnoreCase(String destination);
}
