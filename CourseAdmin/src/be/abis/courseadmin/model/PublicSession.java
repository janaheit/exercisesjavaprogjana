package be.abis.courseadmin.model;

import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class PublicSession extends Session {
    private CompanyRepository repository = new MemoryArrayCompanyRepository();
    private final Company ABIS = repository.findCompany("ABIS");     // so that ABIS is initialised once and not changeable

    public PublicSession(Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
    }

    @Override
    public Company getOrganiser() {
        return ABIS;
    }

    @Override
    public double calculatePrice() {
        return 700.0;
    }
}
