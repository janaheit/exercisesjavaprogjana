package be.abis.personstate.state;

import be.abis.personstate.model.Course;
import be.abis.personstate.model.Person;

public class Student implements Role {

    private Person person;

    public Student(Person person) {
        this.person = person;
    }

    @Override
    public void doJob(Course course) {
        attendCourse(course);
    }

    private void attendCourse(Course course){
        course.addStudent(person);
        System.out.println(person.getFirstName() + " is studying " + course.getTitle());
    }

    public Person getPerson() {
        return person;
    }
}
