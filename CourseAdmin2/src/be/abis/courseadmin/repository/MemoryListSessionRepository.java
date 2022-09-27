package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.exceptions.CourseNotFoundException;
import be.abis.courseadmin.exceptions.PersonNotFoundException;
import be.abis.courseadmin.exceptions.SessionNotFoundException;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.PublicSession;
import be.abis.courseadmin.model.Session;

import java.util.ArrayList;
import java.util.List;

public class MemoryListSessionRepository implements SessionRepository {

    private static final MemoryListSessionRepository repository = new MemoryListSessionRepository();
    private List<Session> sessions = new ArrayList<>();

    private MemoryListSessionRepository() {
        CompanyRepository companyRepository = MemoryListCompanyRepository.getInstance();
        PersonRepository personRepository = MemoryListPersonRepository.getInstance();
        CourseRepository courseRepository = MemoryListCourseRepository.getInstance();

        try{
            sessions.add(new PublicSession((courseRepository.findCourse("Testing")), "22/9/2022",
                    companyRepository.findCompany(""), personRepository.findPerson("Merlin Heitkemper")));

        } catch (CourseNotFoundException | CompanyNotFoundException | PersonNotFoundException e){
            System.out.println("Couldn't add session... all good?");
        }
    }



    public static MemoryListSessionRepository getInstance(){
        return repository;
    }

    @Override
    public Session findSession(String name) throws SessionNotFoundException {
        return null;
    }

    @Override
    public void addSession(Session company) {

    }

    @Override
    public void updateSession(Session company) {

    }

    @Override
    public void deleteSession(Session session) {

    }

    @Override
    public List<Session> getCompanies() {
        return null;
    }
}
