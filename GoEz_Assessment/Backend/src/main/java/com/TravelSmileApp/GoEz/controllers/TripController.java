package com.TravelSmileApp.GoEz.controllers;

import com.TravelSmileApp.GoEz.models.Trip;
import com.TravelSmileApp.GoEz.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/getAllTrips")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        return tripService.getTripById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.createTrip(trip));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{tripId}/travelers/{travelerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Trip> addTravelerToTrip(@PathVariable Long tripId, @PathVariable Long travelerId) {
        return ResponseEntity.ok(tripService.addTravelerToTrip(tripId, travelerId));
    }

    @DeleteMapping("/{tripId}/travelers/{travelerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Trip> removeTravelerFromTrip(@PathVariable Long tripId, @PathVariable Long travelerId) {
        return ResponseEntity.ok(tripService.removeTravelerFromTrip(tripId, travelerId));
    }
}
