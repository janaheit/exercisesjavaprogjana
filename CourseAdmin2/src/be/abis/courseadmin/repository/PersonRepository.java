package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.exceptions.PersonNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Person;

import java.util.List;

public interface PersonRepository {

    Person findPerson(String name) throws PersonNotFoundException;
    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(String name);
    List<Person> getPersons();
}
