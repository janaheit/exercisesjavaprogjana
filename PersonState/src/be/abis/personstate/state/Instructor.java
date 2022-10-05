package be.abis.personstate.state;

import be.abis.personstate.model.Course;
import be.abis.personstate.model.Person;

public class Instructor implements Role{

    private Person person;

    public Instructor(Person person) {
        this.person = person;
    }

    @Override
    public void doJob(Course course) {
        teachCourse(course);
    }

    private void teachCourse(Course course){
        course.setInstructor(person);
        System.out.println(person.getFirstName() + " is teaching " + course.getTitle()); // which course?
    }

    public Person getPerson() {
        return person;
    }
}
