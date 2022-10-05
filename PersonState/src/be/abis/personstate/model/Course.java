package be.abis.personstate.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class Course {
    private String title;
    private int numOfDays;
    private int pricePerDay;
    private Person instructor;
    private List<Person> students;

    public Course(){

    }

    public Course (String title){
        this();
        this.title = title;
    }

    public Course(String title, int numOfDays, int pricePerDay) {
        this();
        this.title = title;
        this.numOfDays = numOfDays;
        this.pricePerDay = pricePerDay;
    }

    // business methods

    public int calculateTotalPrice(){
        return numOfDays*pricePerDay;
    }


    public void printTotalPrice(){
        double price = calculateTotalPrice();

        Locale currentLoc = Locale.getDefault();
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLoc);
        otherSymbols.setDecimalSeparator(',');
        otherSymbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", otherSymbols);
        System.out.println(df.format(price));
    }

    @Override
    public String toString() {
        return "This course " + title + " has a duration of " + numOfDays + " days and costs " + pricePerDay + "euros per day.";
    }

    // getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Person getInstructor() {
        return instructor;
    }

    public void setInstructor(Person instructor) {
        this.instructor = instructor;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public void addStudent(Person student){
        this.students.add(student);
    }
}
