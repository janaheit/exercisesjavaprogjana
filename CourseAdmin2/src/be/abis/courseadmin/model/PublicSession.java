package be.abis.courseadmin.model;

import be.abis.courseadmin.event.SessionFullEvent;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.observer.SessionFullListener;
import be.abis.courseadmin.observer.SessionFullTrigger;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PublicSession extends Session implements SessionFullTrigger {
    private static int MAX_STUDENTS;
    private CompanyRepository repository = MemoryListCompanyRepository.getInstance();
    private Company abis;     // so that ABIS is initialised once and not changeable
    private List<CourseParticipant> participants = new ArrayList<>();

    private List<SessionFullListener> listeners = new ArrayList<>();


    public PublicSession() {
    }

    public PublicSession(Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
        try {
            abis = repository.findCompany("ABIS");
        } catch (CompanyNotFoundException cnf){
            System.out.println(cnf.getMessage());
        }

        MAX_STUDENTS = 12;
    }

    // Business methods
    @Override
    public double calculatePrice() {
        return 700.0;
    }

    public void addEnrolment(Person p){

        if (!isFull()) participants.add(p);
        else notifyListeners();
    }

    public void addEnrolments(CourseParticipant ... participants){
        this.participants.addAll(Arrays.asList(participants));
    }

    private Boolean isFull(){
        return (participants.size() >= MAX_STUDENTS);
    }



    public void cancelEnrolment(CourseParticipant courseParticipant){
        participants.remove(courseParticipant);
    }

    public void printParticipants(){

        for (CourseParticipant cp: this.participants) {
            System.out.println(cp);
        }
    }

    public List<CourseParticipant> findAbisParticipants(){
        List<CourseParticipant> abisParticipants = new ArrayList<>();
        for (CourseParticipant cp: this.participants) {
            if (cp instanceof Person) {
                if(((Person) cp).getCompany().getName().equals("ABIS")) {
                    abisParticipants.add(cp);
                }
            }
        }
        return abisParticipants;
    }

    public void removeAbisParticipants(){

        Iterator<CourseParticipant> iter = this.participants.iterator();

        while(iter.hasNext()){
            CourseParticipant cp = iter.next();
            if (((Person)cp).getCompany().getName().equals("ABIS")){
                iter.remove();
            }
        }

        //this.participants.removeIf(cp -> ((Person) cp).getCompany().getName().equals("ABIS"));
    }

    private void notifyListeners(){
        for(SessionFullListener l: this.listeners){
            if (l.equals(getInstructor())){
                l.confirm(new SessionFullEvent(this, "The course you teach reached its maximum number of" +
                        "participants."));
            }
        }
    }

    @Override
    public void addListeners(SessionFullListener listener) {
        listeners.add(listener);
    }

    // Getters and setters
    @Override
    public Company getOrganiser() {
        return abis;
    }

    public List<CourseParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<CourseParticipant> participants) {
        this.participants = participants;
    }


}
