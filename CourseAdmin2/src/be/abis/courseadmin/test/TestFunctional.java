package be.abis.courseadmin.test;

import be.abis.courseadmin.functions.Calculator;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.CourseParticipant;
import be.abis.courseadmin.model.Person;
import be.abis.courseadmin.model.PublicSession;
import be.abis.courseadmin.repository.MemoryListPersonRepository;
import be.abis.courseadmin.service.AbisEnrolmentService;

import java.util.List;

public class TestFunctional {

    public static void main(String[] args) {

        Calculator calc = (a, b) -> a*b;
        System.out.println(calc.performCalculator(5.0, 3));


        Course c = new Course("title", 30, 50);

        System.out.println(c.calculateTotalPrice(5));

        /** ----------------------------------------------------------------*/

        PublicSession pS1 = new PublicSession();
        // set up some PUblicSessions to test functional interfaces
        List<Person> persons = MemoryListPersonRepository.getInstance().getPersons();
        // persons.forEach((p)-> pS1.addEnrolment(p));
        persons.forEach(pS1::addEnrolment);
        System.out.println(pS1.getParticipants());

        AbisEnrolmentService abisEnrolmentService = AbisEnrolmentService.getInstance();

        System.out.println("sortByFirstName: "+ abisEnrolmentService.sortByFirstName(pS1.getParticipants()));
        //System.out.println("sortByLastName: "+ abisEnrolmentService.sortByLastName(pS1.getParticipants()));
        //System.out.println("sortByName: "+ abisEnrolmentService.sortByName(pS1.getParticipants()));
        //System.out.println("sortByNumber: "+ abisEnrolmentService.sortByPersonNumber(pS1.getParticipants()));

        pS1.getParticipants().forEach(System.out::println);

    }
}
