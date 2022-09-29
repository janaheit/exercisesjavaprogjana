package be.abis.courseadmin.service;

import be.abis.courseadmin.exceptions.CourseNotFoundException;
import be.abis.courseadmin.model.CourseParticipant;
import be.abis.courseadmin.model.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AbisEnrolmentService implements EnrolmentService{

    private static final AbisEnrolmentService abisEnrolmentService = new AbisEnrolmentService();

    private AbisEnrolmentService() {
    }

    @Override
    public List<CourseParticipant> sortByFirstName(List<CourseParticipant> persons) {
        //Collections.sort(persons, (p1, p2)-> p1.getFirstName().compareTo(p2.getFirstName()));
        persons.sort(Comparator.comparing((p) -> ((Person)p).getFirstName()));
        return persons;
    }

    @Override
    public List<CourseParticipant> sortByLastName(List<CourseParticipant> persons) {
        persons.sort(Comparator.comparing((p) -> ((Person)p).getLastName()));
        return persons;
    }

    @Override
    public List<CourseParticipant> sortByName(List<CourseParticipant> persons) {
        persons.sort(Comparator.comparing((p) -> (((Person)p).getFirstName() + " "
                + ((Person)p).getLastName())));
        return persons;
        //Collections.sort(persons, (p1, p2)-> (p1.getFirstName() + " " + p1.getLastName()).compareTo(p2.getFirstName()+" "+p2.getLastName()));
    }

    @Override
    public List<CourseParticipant> sortByPersonNumber(List<CourseParticipant> courseParticipants) {
        Collections.sort(courseParticipants);
        return courseParticipants;
    }

    public static AbisEnrolmentService getInstance(){
        return abisEnrolmentService;
    }

}
