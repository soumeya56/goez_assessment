package com.travelSmileApp.GoEz.test;

import com.TravelSmileApp.GoEz.controllers.TripController;
import com.TravelSmileApp.GoEz.models.Trip;
import com.TravelSmileApp.GoEz.service.TripService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.security.test.context.support.WithMockUser;



import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TripController.class)
@ExtendWith(MockitoExtension.class)
public class TripControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TripService tripService;

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldReturnListOfTrips() throws Exception {
        Trip trip = new Trip();
        trip.setDestination("Paris");

        List<Trip> trips = List.of(trip);
        Mockito.when(tripService.getAllTrips()).thenReturn(trips);

        mockMvc.perform(get("/api/trips/getAllTrips"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].destination").value("Paris"));
    }


}
