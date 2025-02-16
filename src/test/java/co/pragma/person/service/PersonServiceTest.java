package co.pragma.person.service;

import co.pragma.person.model.Person;
import co.pragma.person.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void savePersonTest() {
        Person person = new Person();
        person.setName("Test Restaurant");

        when(personRepository.save(any(Person.class))).thenReturn(person);

        Person result = personService.savePerson(person);
        assertEquals("Test Restaurant", result.getName());
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void getPersonByIdTest() {
        Person person = new Person();
        person.setId(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        Optional<Person> result = personService.getPersonById(1L);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }
}