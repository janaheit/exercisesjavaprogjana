package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.Company;

public class MemoryArrayCompanyRepository implements CompanyRepository {
    private Company[] companies = new Company[5];

    public MemoryArrayCompanyRepository(){
        Company c1 = new Company("ABIS", 1);
        Company c2 = new Company("Smals", 2);
        Company c3 = new Company("Google", 3);
        Company c4 = new Company("IBM", 4);
        Company c5 = new Company("Microsoft", 5);

        companies = new Company[]{c1,c2,c3,c4,c5};
    }

    @Override
    public Company findCompany(int id) {
        for (Company c: companies){
            if (c.getCompanyNumber() == id){
                return c;
            }
        }
        return null;        // later with exception handling
    }

    @Override
    public Company findCompany(String name) {
        for (Company c: companies){
            if (name.equals(c.getName())){
                return c;
            }
        }
        return null;
    }

    @Override
    public void addCompany(Company company) {

    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void deleteCompany(int id) {

    }
}