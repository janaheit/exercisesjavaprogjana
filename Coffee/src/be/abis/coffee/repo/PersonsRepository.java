package be.abis.coffee.repo;

import be.abis.coffee.model.Instructor;
import be.abis.coffee.model.MilkType;
import be.abis.coffee.model.Person;
import be.abis.coffee.model.Student;

public class PersonsRepository {

    private static PersonsRepository repo = new PersonsRepository();
    private Person[] persons = new Person[13];
    private Instructor[] instructors = new Instructor[5];
    private Student[] students = new Student[8];

    private PersonsRepository() {
        Instructor i1 = new Instructor("Sandy", "Schillebeeckx");
        i1.setCoffeePreference(MilkType.DAIRY);

        Student s1 = new Student("Simon", "don't know your last name");
        Student s2 = new Student("Esben", "Six");

        instructors = new Instructor[] {i1};
        students = new Student[] {s1, s2};

    }

    public static PersonsRepository getInstance(){
        return repo;
    }

    public Person[] getPersons() {
        return persons;
    }

    public Instructor[] getInstructors() {
        return instructors;
    }

    public Student[] getStudents() {
        return students;
    }
}
