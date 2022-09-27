package be.abis.courseadmin.model;

import be.abis.courseadmin.util.DateUtils;

import java.time.LocalDate;
import java.util.Date;

public abstract class Session extends Service {
    private Course course;
    private LocalDate startDate;
    private Company location;
    private Person instructor;

    public Session() {
    }

    /** This one should only be called from within the package (the subclass PublicSession)*/
    Session(Course course, String startDate, Company location, Person instructor){
        this();
        this.course = course;
        this.startDate = DateUtils.format(startDate);
        this.location = location;
        this.instructor = instructor;
    }

    // business methods

    public void printInfo(){
        System.out.println("The " + course.getTitle() + " will start on " + startDate
                + ". It will take place at " + location.getName() + ". Your instructor is "
                + instructor.getFirstName() + " " + instructor.getLastName() + " of " + instructor.getCompany().getName());
    }

    public void printStartDate(){
        DateUtils.printDate(startDate);
    }

    // getters and setters

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = DateUtils.format(startDate);
    }

    public Company getLocation() {
        return location;
    }

    public void setLocation(Company location) {
        this.location = location;
    }

    public Person getInstructor() {
        return instructor;
    }

    public void setInstructor(Person instructor) {
        this.instructor = instructor;
    }

    public abstract Company getOrganiser();


}
