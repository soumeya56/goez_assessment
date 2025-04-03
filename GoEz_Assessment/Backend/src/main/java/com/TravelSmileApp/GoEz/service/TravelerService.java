package com.TravelSmileApp.GoEz.service;

import com.TravelSmileApp.GoEz.models.*;
import com.TravelSmileApp.GoEz.repository.RoleRepository;
import com.TravelSmileApp.GoEz.repository.TravelerRepository;
import com.TravelSmileApp.GoEz.repository.TripRepository;
import com.TravelSmileApp.GoEz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TravelerService {

    @Autowired
    private TravelerRepository travelerRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private  RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripRepository tripRepository;


    public List<Traveler> getAllTravelers() {
        return travelerRepository.findAll();
    }

    public Optional<Traveler> getTravelerById(Long id) {
        return travelerRepository.findById(id);
    }

    public Traveler createTraveler(Long userId, String name, Set<Long> tripIds) {
        // Récupérer l'utilisateur existant
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found: " + userId));

        // Vérifier si cet utilisateur est déjà un Traveler
        if (travelerRepository.existsByEmail(existingUser.getEmail())) {
            throw new RuntimeException("This user is already a traveler!");
        }

        // Créer un nouveau Traveler
        Traveler traveler = new Traveler();
        traveler.setName(name); // Nom facultatif
        traveler.setEmail(existingUser.getEmail());
        traveler.setPassword(existingUser.getPassword());

        // Ajouter les rôles existants de l'utilisateur
        traveler.setRoles(existingUser.getRoles());

        // Sauvegarder le Traveler
        return travelerRepository.save(traveler);
    }



    public void deleteTraveler(Long id) {
        travelerRepository.deleteById(id);
    }
}
