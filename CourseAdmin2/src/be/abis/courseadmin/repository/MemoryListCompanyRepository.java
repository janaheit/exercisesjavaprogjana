package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.ArrayList;
import java.util.List;

public class MemoryListCompanyRepository implements CompanyRepository {
    private static final MemoryListCompanyRepository repository = new MemoryListCompanyRepository();
    private List<Company> companies = new ArrayList<>();

    private MemoryListCompanyRepository(){
        companies.add(new Company("ABIS", 1));
        companies.add(new Company("Smals", 2));
        companies.add(new Company("Google", 3));
        companies.add(new Company("IBM", 4));
        companies.add(new Company("Microsoft", 5));
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
