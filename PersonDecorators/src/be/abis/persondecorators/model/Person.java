package be.abis.persondecorators.model;


import be.abis.persondecorators.decorators.PersonDecorator;

/** This class represents a Person and describes a person's behaviour. */
public class Person implements PersonDecorator {

    private String firstName;
    private String lastName;
    private static int counter = 0;
    private int personNumber;

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

    @Override
    public void assemble() {
        System.out.println("(Person)");
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
}
