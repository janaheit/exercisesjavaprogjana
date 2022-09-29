package be.abis.courseadmin.service;

import be.abis.courseadmin.exceptions.PersonNotFoundException;
import be.abis.courseadmin.model.CourseParticipant;
import be.abis.courseadmin.model.Person;
import be.abis.courseadmin.model.PublicSession;
import be.abis.courseadmin.repository.MemoryListPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbisEnrolmentServiceTest {

    private EnrolmentService enrolmentService = AbisEnrolmentService.getInstance();
    private PublicSession pS1 = new PublicSession();

    @BeforeEach
    void setUp() {
        List<Person> persons = MemoryListPersonRepository.getInstance().getPersons();
        // persons.forEach((p)-> pS1.addEnrolment(p));
        persons.forEach(this.pS1::addEnrolment);
    }

    @Test
    void sortByFirstName() {
        List<CourseParticipant> participants = enrolmentService.sortByFirstName(pS1.getParticipants());

    }

    @Test
    void sortByLastName() {
    }

    @Test
    void sortByName() {
    }

    @Test
    void sortByPersonNumber() {
    }
}