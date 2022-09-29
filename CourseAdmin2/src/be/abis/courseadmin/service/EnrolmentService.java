package be.abis.courseadmin.service;

import be.abis.courseadmin.model.CourseParticipant;
import be.abis.courseadmin.model.Person;

import java.util.List;

public interface EnrolmentService {

    List<CourseParticipant> sortByFirstName(List<CourseParticipant> persons);
    List<CourseParticipant> sortByLastName(List<CourseParticipant> persons);
    List<CourseParticipant> sortByName(List<CourseParticipant> persons);
    List<CourseParticipant> sortByPersonNumber(List<CourseParticipant> persons);

}
