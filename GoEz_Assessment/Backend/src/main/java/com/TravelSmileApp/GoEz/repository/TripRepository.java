package com.TravelSmileApp.GoEz.repository;

import com.TravelSmileApp.GoEz.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT t.traveler, COUNT(t) FROM Trip t GROUP BY t.traveler")
    List<Object[]> countTripsByTraveler();
    boolean existsByDestination(String destination);
}
