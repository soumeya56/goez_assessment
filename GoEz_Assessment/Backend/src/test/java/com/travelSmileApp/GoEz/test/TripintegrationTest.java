package com.travelSmileApp.GoEz.test;

import com.TravelSmileApp.GoEz.repository.TripRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TripIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TripRepository tripRepository;

    @BeforeEach
    void setup() {
        tripRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldCreateAndRetrieveTrip() throws Exception {

        String tripJson = "{ \"destination\": \"Paris\" }";

        mockMvc.perform(post("/api/trips/createTrip")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tripJson))
                .andExpect(status().isOk());


        mockMvc.perform(get("/api/trips/getAllTrips"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].destination").value("Paris"));
    }
}

