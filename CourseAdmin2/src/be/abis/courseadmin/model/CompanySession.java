package be.abis.courseadmin.model;

import be.abis.courseadmin.exceptions.PriceTooHighException;
import be.abis.courseadmin.exceptions.PriceTooLowException;

public class CompanySession extends Session {
    private Company organiser;
    private int numOfParticipants = 0; // 0 means not known

    public CompanySession(Course course, int numOfParticipants){
        super();
        setCourse(course);
        this.numOfParticipants = numOfParticipants;
    }

    public CompanySession(Company organiser, Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
        this.organiser = organiser;
    }

    public CompanySession(Company organiser, Course course, String startDate, Company location, Person instructor, int numOfParticipants) {
        this(organiser, course, startDate, location, instructor);
        this.numOfParticipants = numOfParticipants;
    }

    // business methods

    public void printInfo(){
        super.printInfo();
        System.out.println("This session is offered to you by " + getOrganiser().getName() + ".");
        if (numOfParticipants != 0){
            System.out.println("There will be " + numOfParticipants + "participants.");
        }
    }


    @Override
    public double calculatePrice() throws PriceTooHighException, PriceTooLowException {

        double totalPrice = numOfParticipants * getCourse().getPricePerDay() * getCourse().getNumOfDays();


        if (totalPrice > 4000) throw new PriceTooHighException( totalPrice+ " is too much.");
        else if (totalPrice < 200) { throw new PriceTooLowException(totalPrice + " is too low.");

        }
        return totalPrice;
    }

    // getters and setters

    @Override
    public Company getOrganiser() {
        return organiser;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(int numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }
}
