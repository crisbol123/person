package co.pragma.person.controller;


import co.pragma.person.model.Person;
import co.pragma.person.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    void getAllRestaurantsTest() throws Exception {
        mockMvc.perform(get("/api/people"))
                .andExpect(status().isOk());
    }

    @Test
    void saveRestaurantTest() throws Exception {
        Person person = new Person();
        person.setName("Test people");

        when(personService.savePerson(any(Person.class))).thenReturn(person);

        mockMvc.perform(post("/api/people")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test people\", \"address\": \"123 Street\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test people"));
    }
}