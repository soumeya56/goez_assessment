package com.TravelSmileApp.GoEz.service;

import com.TravelSmileApp.GoEz.models.Traveler;
import com.TravelSmileApp.GoEz.repository.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelerService {

    @Autowired
    private TravelerRepository travelerRepository;

    public List<Traveler> getAllTravelers() {
        return travelerRepository.findAll();
    }

    public Optional<Traveler> getTravelerById(Long id) {
        return travelerRepository.findById(id);
    }

    public Traveler createTraveler(Traveler traveler) {
        return travelerRepository.save(traveler);
    }

    public void deleteTraveler(Long id) {
        travelerRepository.deleteById(id);
    }
}
