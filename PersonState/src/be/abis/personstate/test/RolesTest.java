package be.abis.personstate.test;

import be.abis.personstate.model.Course;
import be.abis.personstate.model.Person;
import be.abis.personstate.state.Instructor;

public class RolesTest {

    public static void main(String[] args) {
        Person person1 = new Person("Jana", "Heitkemper");
        person1.changeRole(new Instructor(person1));

        Course course = new Course("java");

        person1.doJob(course);
    }
}
