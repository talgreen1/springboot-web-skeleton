package com.test.app;

import com.app.Application;
import com.app.db.MovieShow;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetAll() throws Exception {
        this.mockMvc.perform(get("/movies")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Star")));

        this.mockMvc.perform(get("/movies")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void shouldCreateMovie() throws Exception {
        ObjectMapper om = new ObjectMapper();
        MovieShow ms = new MovieShow("Spiderman", 120L, LocalDateTime.of(2018, 10, 10, 20, 00));
        this.mockMvc.perform(post("/movies").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(ms))).andExpect(status().isCreated());
    }

    @Test
    public void shouldDeleteMovie() throws Exception {
        this.mockMvc.perform(delete("/movies/10001")).andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateMovie() throws Exception {
        ObjectMapper om = new ObjectMapper();
        MovieShow ms = new MovieShow(10001L,"Star Wars I", 150L, LocalDateTime.of(2018, 10, 10, 20, 00));
        this.mockMvc.perform(put("/movies").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(ms))).andExpect(status().isOk());
    }
}
