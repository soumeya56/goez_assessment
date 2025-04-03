package com.TravelSmileApp.GoEz.DTO;

import java.util.Set;

public class TravelerRequest {
    private Long userId;
    private String name;
    private Set<Long> tripIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getTripIds() {
        return tripIds;
    }

    public void setTripIds(Set<Long> tripIds) {
        this.tripIds = tripIds;
    }
}
