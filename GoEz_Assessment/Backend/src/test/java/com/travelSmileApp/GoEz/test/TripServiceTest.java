package com.travelSmileApp.GoEz.test;

import com.TravelSmileApp.GoEz.models.Trip;
import com.TravelSmileApp.GoEz.repository.TripRepository;
import com.TravelSmileApp.GoEz.service.TripService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TripServiceTest {

    @Mock
    private TripRepository tripRepository;

    @InjectMocks
    private TripService tripService;

    @Test
    void shouldCreateTripSuccessfully() {
        Trip trip = new Trip();
        trip.setDestination("Paris");

        Mockito.when(tripRepository.existsByDestination("Paris")).thenReturn(false);
        Mockito.when(tripRepository.save(trip)).thenReturn(trip);

        Trip createdTrip = tripService.createTrip(trip);

        assertNotNull(createdTrip);
        assertEquals("Paris", createdTrip.getDestination());
        Mockito.verify(tripRepository, times(1)).save(trip);
    }

    @Test
    void shouldThrowExceptionWhenTripDestinationExists() {
        Trip trip = new Trip();
        trip.setDestination("Paris");

        Mockito.when(tripRepository.existsByDestination("Paris")).thenReturn(true);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tripService.createTrip(trip);
        });

        assertEquals("this destination already exists !", exception.getMessage());
    }
}
