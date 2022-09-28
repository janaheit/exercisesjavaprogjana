package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Person;

import java.util.List;

public interface EnrolmentService {

    List<Person> sortByFirstName(List<Person> persons);
    List<Person> sortByLastName(List<Person> persons);
    List<Person> sortByName(List<Person> persons);

}
