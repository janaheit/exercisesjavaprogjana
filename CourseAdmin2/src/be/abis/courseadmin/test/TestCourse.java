package be.abis.courseadmin.test;

import be.abis.courseadmin.enums.Gender;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.exceptions.PriceException;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;
import be.abis.courseadmin.service.AbisCompanyService;
import be.abis.courseadmin.util.DateUtils;
import be.abis.courseadmin.util.StringUtils;

public class TestCourse {
    public static void main(String[] args) {

        CompanyRepository repository = MemoryListCompanyRepository.getInstance();

        Course course1 = new Course("java", 80, 50);
        Course course2 = new Course("oop", 4, 5);

        System.out.println(course1);
        System.out.println(course1.calculateTotalPrice());
        //System.out.println(course1.calculateTotalPrice(50));

        Company company1 = null;
        Company company3 = null;
        Company company4 = null;
        try {
            company1 = repository.findCompany("Smals");
            company3 = repository.findCompany("IBM");
            company4 = repository.findCompany("Google");
        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(company1);


        String[] hobbies1 = {"football", "iceskating"};
        String[] hobbies2 = {"football", "running"};

        Person person1 = new Person("Jana", "Heitkemper", Gender.FEMALE, hobbies1, company3);
        Person person2 = new Person("Jane", "Doe",Gender.FEMALE, hobbies2, company1);
        Person person3 = new Person("Abel", "Bakker", Gender.MALE, hobbies2, company4);

        Person[] persons = {person1, person2};
        System.out.println(Person.getCounter());
        for (Person p: persons){
            System.out.println(p);
        }

        person1.addHobby("slacklining");
        person1.addHobbies("skating", "painting");
        person1.printHobbies();

        System.out.println(Person.getCounter());

        /** ------------------------------------------------------------*/

        Company company2 = null;
        try {
            company2 = repository.findCompany("ABIS");
        } catch (CompanyNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Course course2 = new Course("UML design", 7, 20);

        PublicSession publicSession = new PublicSession(course1, "08/09/2022", company2, person2);
        CompanySession companySession = new CompanySession(company1, course2, "08/10/2022", company2, person1);
        CompanySession companySession2 = new CompanySession(company4, course2, "08/10/2022", company2, person3, 30);

        publicSession.printInfo();
        companySession.printInfo();

        /** ----------------------Exercise 2--------------------------------------*/

        Session[] sessions = {publicSession, companySession, companySession2};

        for (Session session: sessions){
            session.printInfo();
        }

        /** ----------------------Exercise 3 and 4--------------------------------------*/

        Consultancy consultancy = new Consultancy();
        Service[] services = {publicSession, companySession, companySession2, consultancy};

        /** for (Service s: services){
            System.out.println(s.calculatePrice());
            if (s instanceof Session){
                ((Session) s).printInfo();
            }
        }*/

        /** ----------------------Exercise 5--------------------------------------*/
        System.out.println(company1);
        System.out.println(person1);
        System.out.println(course1);

        /** ----------------------Exercise 11--------------------------------------*/

        Person person11 = new Person("switch", "roles", Gender.OTHER, new String[] {"football"});
        person11.teachCourse(course1);
        person11.attendCourse(course2);

        /** ----------------------Test StringUtil--------------------------------------*/
        String cap = "jana";
        System.out.println(StringUtils.capitalize(cap));

        /** ----------------------Exceptions --------------------------------------*/



        try{
            System.out.println(company1.requestPriceOfferForCompanySession(course2,9));
            repository.findCompany(7);
        } catch (PriceException | CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally entered");
        }

        /** ----------------------Collections --------------------------------------*/


        person1.addHobby("skating");
        person1.printHobbies();

        /** ----------------------Comparable and sorting --------------------------------------*/

        System.out.println(new AbisCompanyService().sortAllCompaniesByName());
        System.out.println(new AbisCompanyService().sortAllCompaniesByCompanyNumber());

        /** ----------------------LocalDate --------------------------------------*/

        PublicSession publicSession1 = new PublicSession(course1, "21/03/2022", company1, person1);
        DateUtils.printDate(publicSession1.getStartDate());
        publicSession1.getCourse().printTotalPrice();
    }
}
