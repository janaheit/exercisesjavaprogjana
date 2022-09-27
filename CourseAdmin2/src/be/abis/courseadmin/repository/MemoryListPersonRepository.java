package be.abis.courseadmin.repository;

import be.abis.courseadmin.enums.Gender;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.exceptions.PersonNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MemoryListPersonRepository implements PersonRepository {

    private static MemoryListPersonRepository repository = new MemoryListPersonRepository();
    private List<Person> persons = new ArrayList<>();

    private MemoryListPersonRepository() {
        CompanyRepository companyRepository = MemoryListCompanyRepository.getInstance();

        Person jana = new Person("Jana", "Heitkemper", Gender.FEMALE,
                new String[] {"cycling", "skating", "bouldering", "yoga"});
        Person merlin = new Person("Merlin", "Heitkemper", Gender.MALE,
                new String[] {"chess", "Jujitsu", "youtube"});
        Person simon = new Person("Simon", "Hazevoets", Gender.MALE,
                new String[] {"crypto", "idk what else"});
        Person claudia = new Person("Claudia", "Negrila", Gender.FEMALE,
                new String[] {"bouldering"});

        // add company
        // jana.setCompany(companyRepository.findCompany("Smals"));


        // make all persons
        persons.add(jana);
        persons.add(merlin);
        persons.add(simon);
        persons.add(claudia);


    }

    // ACCESSOR METHODS
    @Override
    public Person findPerson(String name) throws PersonNotFoundException {
        for (Person p: persons){
            if (name.equals(p.getFirstName() + " " + p.getLastName())){
                return p;
            }
        }
        throw new PersonNotFoundException("This person does not exist.");

    }

    @Override
    public void addPerson(Person person) {
        this.persons.add(person);
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(String name) {
        this.persons.removeIf(p -> (p.getFirstName()+ " "+ p.getLastName()).equals(name));
    }


    // GETTERS AND SETTERS
    public static MemoryListPersonRepository getInstance(){
        return repository;
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }
}
