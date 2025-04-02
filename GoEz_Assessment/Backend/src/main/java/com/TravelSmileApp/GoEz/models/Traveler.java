package com.TravelSmileApp.GoEz.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "travelers")
public class Traveler extends User{



    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "travelers")
    private Set<Trip> trips = new HashSet<>();

    public Traveler(String name, String email, Set<Trip> trips) {
        this.name = name;
        this.trips = trips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }
}
