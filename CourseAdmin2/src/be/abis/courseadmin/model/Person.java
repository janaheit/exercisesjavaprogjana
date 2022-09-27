package be.abis.courseadmin.model;

import be.abis.courseadmin.enums.Gender;
import be.abis.courseadmin.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
// SImon was here :D no html luckily
// test

/** This class represents a Person and describes a person's behaviour. */
public class Person implements Instructor, CourseParticipant {

    private String firstName;
    private String lastName;
    private Company company;
    private static int counter = 0;
    private int personNumber;
    private Gender gender;
    private Set<String> hobbies = new TreeSet<>();

    public Person(){
    }

    public Person(String firstName, String lastName, Gender gender) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        Person.counter = counter + 1;
        this.personNumber = Person.counter;
    }

    public Person(String firstName, String lastName, Gender gender, String[] hobbies){
        this(firstName, lastName, gender);
        this.hobbies.addAll(Arrays.asList(hobbies));
    }

    public Person(String firstName, String lastName, Gender gender, String[] hobbies, Company company){
        this(firstName, lastName, gender, hobbies);
        this.company = company;
    }

    // Business methods

    public void attendCourse(Course course){
        System.out.println(firstName + " is attending a "+ course.getTitle() + " course.");
    }

    public void addHobby(String hobby){
        this.hobbies.add(hobby);
    }

    public void addHobbies(String... values){
        for (String value : values) {
            addHobby(value);
        }
    }
    public void printHobbies(){
        System.out.println(hobbies);
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
        String output;
        if (this.company == null){
            output = StringUtils.capitalize(this.gender.getPersonalPronoun()) +" is not linked to a company at the moment.";
        }
        else {
            output = StringUtils.capitalize(this.gender.getPersonalPronoun()) + " works for " + company.getName() +".";
        }
        output = StringUtils.capitalize(firstName)  + " " + StringUtils.capitalize(lastName)
                + ": " + output + " "+ StringUtils.capitalize(this.gender.getPosessivePronoun())+ " ID is "+ personNumber;
        return output;
    }

    @Override
    public void teachCourse(Course course) {
        System.out.println("teaching " + course.getTitle());
    }

    // Getters and setters

    public Set<String> getHobbies() {
        return hobbies;
    }


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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Person.counter = counter;
    }

}
