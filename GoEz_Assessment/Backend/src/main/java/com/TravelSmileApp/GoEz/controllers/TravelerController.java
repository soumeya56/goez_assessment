package com.TravelSmileApp.GoEz.controllers;

import com.TravelSmileApp.GoEz.models.Traveler;
import com.TravelSmileApp.GoEz.service.TravelerService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travelers")
public class TravelerController {

    @Autowired
    private TravelerService travelerService;

    @GetMapping
    public ResponseEntity<List<Traveler>> getAllTravelers() {
        return ResponseEntity.ok(travelerService.getAllTravelers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traveler> getTravelerById(@PathVariable Long id) {
        return travelerService.getTravelerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Traveler> createTraveler(@RequestBody Traveler traveler) {
        return ResponseEntity.ok(travelerService.createTraveler(traveler));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraveler(@PathVariable Long id) {
        travelerService.deleteTraveler(id);
        return ResponseEntity.noContent().build();
    }
}
