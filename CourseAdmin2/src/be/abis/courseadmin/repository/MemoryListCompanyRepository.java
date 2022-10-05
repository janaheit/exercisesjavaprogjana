package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.factory.CompanyFactory;
import be.abis.courseadmin.factory.MemoryListCompanyFactory;
import be.abis.courseadmin.model.Company;

import java.util.ArrayList;
import java.util.List;

public class MemoryListCompanyRepository implements CompanyRepository {
    private static final MemoryListCompanyRepository repository = new MemoryListCompanyRepository();
    private CompanyFactory companyFactory;
    private List<Company> companies;

    private MemoryListCompanyRepository(){
        this.companyFactory = MemoryListCompanyFactory.getInstance();
        this.companies = this.companyFactory.createCompanyList();
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        for (Company c: companies){
            if (c.getCompanyNumber() == id){
                return c;
            }
        }
        throw new CompanyNotFoundException("This company does not exist.");
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        for (Company c: companies){
            if (name.equals(c.getName())){
                return c;
            }
        }
        throw new CompanyNotFoundException("This company does not exist.");
    }

    @Override
    public void addCompany(Company company) {
        this.companies.add(company);
    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void deleteCompany(int id) {
        this.companies.removeIf(c -> c.getCompanyNumber() == id);
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public static MemoryListCompanyRepository getInstance(){
        return repository;
    }
}
