package be.abis.courseadmin.model;

import be.abis.courseadmin.enums.Gender;
import be.abis.courseadmin.util.StringUtils;
// SImon was here :D no html luckily
// test

/** This class represents a Person and describes a person's behaviour. */
public class Person implements Instructor, CourseParticipant {

    /** name field: a person's first name */
    private String firstName;
    /** name field: a person's last name */
    private String lastName;
    /** company field: a person's workplace */
    private Company company;
    /** hobby field: a person's hobbies in an array */
    private String[] hobbies;
    /** counter field: static field that counts the amount of persons created */
    private static int counter = 0;
    /** personNumber field: a unique number of each person */
    private int personNumber;
    private Gender gender;

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
        this.hobbies = hobbies;
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
        String[] newHobbies = new String[hobbies.length+1];
        for (int x = 0; x < hobbies.length; x++){
            newHobbies[x] = hobbies[x];
        }
        newHobbies[hobbies.length] = hobby;
        hobbies = newHobbies;
    }

    public void addHobbies(String... values){
        for (int x = 0; x < values.length; x++){
            addHobby(values[x]);
        }
    }
    public void printHobbies(){
        for (int x = 0; x < hobbies.length; x++){
            System.out.println(hobbies[x]);
        }
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

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
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
