package be.abis.courseadmin.repository;

import be.abis.courseadmin.enums.Gender;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.exceptions.PersonNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MemoryListPersonRepository implements PersonRepository {

    private static final MemoryListPersonRepository repository = new MemoryListPersonRepository();
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
        Person p1 = new Person("Daniele", "Pisano", Gender.MALE);
        Person p2 = new Person("Anton", "Müller", Gender.FEMALE);
        Person p3 = new Person("Simone", "Kreuz", Gender.MALE);
        Person p4 = new Person("Sam", "Porto", Gender.FEMALE);
        Person p5 = new Person("Jule", "Schulz", Gender.FEMALE);
        Person p6 = new Person("Tom", "Gret", Gender.MALE);
        Person p7 = new Person("Tira", "Misu", Gender.FEMALE);
        Person p8 = new Person("daö", "Misadu", Gender.FEMALE);
        Person p9 = new Person("Tidadra", "Miadsu", Gender.FEMALE);
        Person p10 = new Person("Tiadra", "Miadsu", Gender.FEMALE);




        // make all persons
        persons.add(jana);
        persons.add(merlin);
        persons.add(simon);
        persons.add(claudia);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);
        persons.add(p7);
        persons.add(p8);
        persons.add(p9);
        persons.add(p10);

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
