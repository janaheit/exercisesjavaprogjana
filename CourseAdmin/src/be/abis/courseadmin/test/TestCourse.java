package be.abis.courseadmin.test;

import be.abis.courseadmin.enums.Gender;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import be.abis.courseadmin.util.StringUtils;

public class TestCourse {
    public static void main(String[] args) {

        CompanyRepository repository = new MemoryArrayCompanyRepository();

        Course course1 = new Course("java", 80, 50);

        System.out.println(course1);
        System.out.println(course1.calculateTotalPrice());
        System.out.println(course1.calculateTotalPrice(50));

        Company company1 = repository.findCompany("Smals");
        System.out.println(company1);
        Company company3 = repository.findCompany("IBM");
        Company company4 = repository.findCompany("Google");

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

        Company company2 = repository.findCompany("ABIS");

        Course course2 = new Course("UML design", 7, 20);

        PublicSession publicSession = new PublicSession(course1, "08.09.2022", company2, person2);
        CompanySession companySession = new CompanySession(company1, course2, "08.10.2022", company2, person1);
        CompanySession companySession2 = new CompanySession(company4, course2, "08.10.2022", company2, person3, 30);

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

        for (Service s: services){
            System.out.println(s.calculatePrice());
            if (s instanceof Session){
                ((Session) s).printInfo();
            }
        }

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







    }
}
