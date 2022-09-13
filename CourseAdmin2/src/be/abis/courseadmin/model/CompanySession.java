package be.abis.courseadmin.model;

public class CompanySession extends Session {
    private Company organiser;
    private int numOfParticipants = 0; // 0 means not known

    public CompanySession(Company organiser, Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
        this.organiser = organiser;
    }

    public CompanySession(Company organiser, Course course, String startDate, Company location, Person instructor, int numOfParticipants) {
        this(organiser, course, startDate, location, instructor);
        this.numOfParticipants = numOfParticipants;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(int numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public void printInfo(){
        super.printInfo();
        System.out.println("This session is offered to you by " + getOrganiser().getName() + ".");
        if (numOfParticipants != 0){
            System.out.println("There will be " + numOfParticipants + "participants.");
        }
    }

    @Override
    public Company getOrganiser() {
        return organiser;
    }

    @Override
    public double calculatePrice() {
        return 650.0;
    }
}
