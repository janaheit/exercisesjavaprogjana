package be.abis.courseadmin.model;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class PublicSession extends Session {
    private CompanyRepository repository = new MemoryArrayCompanyRepository();
    private Company abis;     // so that ABIS is initialised once and not changeable

    public PublicSession(Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
        try {
            abis = repository.findCompany("ABIS");
        } catch (CompanyNotFoundException cnf){
            System.out.println(cnf.getMessage());
        }
    }

    @Override
    public Company getOrganiser() {
        return abis;
    }

    @Override
    public double calculatePrice() {
        return 700.0;
    }
}
