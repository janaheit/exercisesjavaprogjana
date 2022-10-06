package be.abis.courseadmin.test;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.exceptions.CourseNotFoundException;
import be.abis.courseadmin.exceptions.PersonNotFoundException;
import be.abis.courseadmin.model.Person;
import be.abis.courseadmin.model.PublicSession;
import be.abis.courseadmin.repository.*;


public class ObserverTest {
    public static void main(String[] args) {
        CompanyRepository companyRepository = FileCompanyRepository.getInstance();
        CourseRepository courseRepository = MemoryListCourseRepository.getInstance();
        PersonRepository personRepository = MemoryListPersonRepository.getInstance();

        System.out.println(courseRepository.getCourses());

        PublicSession session = null;
        try {
            session = new PublicSession((courseRepository.findCourse("Java")), "22/9/2022",
                    companyRepository.findCompany("ABIS"), personRepository.findPerson("Merlin Heitkemper"));
        } catch (CourseNotFoundException | CompanyNotFoundException | PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (Person p: personRepository.getPersons()){
            session.addListeners(p);
        }

        for (Person p: personRepository.getPersons()){
            session.addEnrolment(p);
        }

        System.out.println(session.getParticipants());




    }
}
