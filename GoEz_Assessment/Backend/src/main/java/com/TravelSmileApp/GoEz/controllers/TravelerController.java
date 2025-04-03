package com.TravelSmileApp.GoEz.controllers;

import com.TravelSmileApp.GoEz.DTO.TravelerRequest;
import com.TravelSmileApp.GoEz.models.Traveler;
import com.TravelSmileApp.GoEz.service.TravelerService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/travelers")
public class TravelerController {

    @Autowired
    private TravelerService travelerService;

    @GetMapping("/getALL")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Traveler>> getAllTravelers() {
        return ResponseEntity.ok(travelerService.getAllTravelers());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Traveler> getTravelerById(@PathVariable Long id) {
        return travelerService.getTravelerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addTraveler")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Traveler> createTraveler(@RequestBody TravelerRequest request) {
        Traveler traveler = travelerService.createTraveler(request.getUserId(), request.getName(), request.getTripIds());
        return ResponseEntity.ok(traveler);
    }



    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTraveler(@PathVariable Long id) {
        travelerService.deleteTraveler(id);
        return ResponseEntity.noContent().build();
    }
}
