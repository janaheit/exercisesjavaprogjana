package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AbisEnrolmentService implements EnrolmentService{



    @Override
    public List<Person> sortByFirstName(List<Person> persons) {
        //  Collections.sort(persons, (p1, p2)-> p1.getFirstName().compareTo(p2.getFirstName()));
        persons.sort(Comparator.comparing(Person::getFirstName));
        return persons;
    }

    @Override
    public List<Person> sortByLastName(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getLastName));
        return persons;
    }

    @Override
    public List<Person> sortByName(List<Person> persons) {
        persons.sort(Comparator.comparing(p -> (p.getFirstName() + " " + p.getLastName())));
        return persons;
        //Collections.sort(persons, (p1, p2)-> (p1.getFirstName() + " " + p1.getLastName()).compareTo(p2.getFirstName()+" "+p2.getLastName()));
    }
}
