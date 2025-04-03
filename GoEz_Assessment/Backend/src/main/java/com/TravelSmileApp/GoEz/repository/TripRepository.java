package com.TravelSmileApp.GoEz.repository;

import com.TravelSmileApp.GoEz.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT COUNT(t) FROM Trip t JOIN t.travelers traveler WHERE traveler.id = :travelerId")
    Long countTripsByTraveler(@Param("travelerId") Long travelerId);
    boolean existsByDestination(String destination);
}
