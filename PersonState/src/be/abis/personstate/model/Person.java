package be.abis.personstate.model;


import be.abis.personstate.state.Role;

/** This class represents a Person and describes a person's behaviour. */
public class Person {

    private String firstName;
    private String lastName;
    private static int counter = 0;
    private int personNumber;
    private Role role;

    public Person(){
    }

    public Person(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        Person.counter = counter + 1;
        this.personNumber = Person.counter;
    }


    // Business methods

    public void doJob(Course course){
        if (role == null) System.out.println(firstName + " does not have a job atm.");
        else role.doJob(course);
    }

    public void attendCourse(Course course){
        System.out.println(firstName + " is attending a "+ course.getTitle() + " course.");
    }

    public void teachCourse(Course course) {
        System.out.println("teaching " + course.getTitle());
    }


    /**public void printInfo(){
     if (this.company == null){
     System.out.println(firstName + " " + lastName +" is not linked to a company at the moment.");
     }
     else {
     System.out.println(firstName + " " + lastName + " works for " + company.getName() +".");
     }
     System.out.println("Person Number is "+ personNumber);
     }*/

    @Override
    public String toString() {
        return this.personNumber + ": " + firstName + " " + lastName;
    }


    // Getters and setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Person.counter = counter;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public Role getRole() {
        return role;
    }

    public void changeRole(Role role) {
        this.role = role;
    }
}
