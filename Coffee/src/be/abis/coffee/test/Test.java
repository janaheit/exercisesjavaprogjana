package be.abis.coffee.test;

import be.abis.coffee.model.Instructor;
import be.abis.coffee.model.Student;
import be.abis.coffee.repo.PersonsRepository;

public class Test {

    public static void main(String[] args) {
        PersonsRepository repo = PersonsRepository.getInstance();

        Instructor instructor = repo.getInstructors()[0];
        Student[] students = repo.getStudents();

        for (Student s:students){
            instructor.askForCoffeeFromFor(s, instructor);
        }

    }


}
