package com.TravelSmileApp.GoEz.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String departureDate;

    @Column(nullable = false)
    private String returnDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "trip_travelers",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "traveler_id")
    )
    private Set<Traveler> travelers = new HashSet<>();

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Set<Traveler> getTravelers() {
        return travelers;
    }

    public void setTravelers(Set<Traveler> travelers) {
        this.travelers = travelers;
    }

    public Trip(String destination, String departureDate, String returnDate, Set<Traveler> travelers) {
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.travelers = travelers;
    }

    public void addTraveler(Traveler traveler) {
        this.travelers.add(traveler);
        traveler.getTrips().add(this);
    }

    public void removeTraveler(Traveler traveler) {
        this.travelers.remove(traveler);
        traveler.getTrips().remove(this);
    }
}

