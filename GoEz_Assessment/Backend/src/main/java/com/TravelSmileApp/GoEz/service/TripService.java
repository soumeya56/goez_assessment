package com.TravelSmileApp.GoEz.service;

import com.TravelSmileApp.GoEz.models.Traveler;
import com.TravelSmileApp.GoEz.models.Trip;
import com.TravelSmileApp.GoEz.repository.TravelerRepository;
import com.TravelSmileApp.GoEz.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private TravelerRepository travelerRepository;


    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    public Trip createTrip(Trip trip) {
        if (tripRepository.existsByDestination(trip.getDestination())) {
            throw new IllegalArgumentException("this destination already exists !");
        }
        return tripRepository.save(trip);
    }


    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public Trip addTravelerToTrip(Long tripId, Long travelerId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        Traveler traveler = travelerRepository.findById(travelerId)
                .orElseThrow(() -> new RuntimeException("Traveler not found"));

        trip.addTraveler(traveler);
        return tripRepository.save(trip);
    }

    public Trip removeTravelerFromTrip(Long tripId, Long travelerId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        Traveler traveler = travelerRepository.findById(travelerId)
                .orElseThrow(() -> new RuntimeException("Traveler not found"));

        trip.removeTraveler(traveler);
        return tripRepository.save(trip);
    }
}

