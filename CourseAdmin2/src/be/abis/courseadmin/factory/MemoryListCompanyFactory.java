package be.abis.courseadmin.factory;

import be.abis.courseadmin.model.Company;

import java.util.ArrayList;
import java.util.List;

public class MemoryListCompanyFactory extends CompanyFactory {

    private static MemoryListCompanyFactory memoryListCompanyFactory;

    public MemoryListCompanyFactory() {
    }

    @Override
    public List<Company> createCompanyList() {
        // Is it true that everytime i run this function different/new companies/instances will be created?
        // Should this be the case? Or should they be created only ONCE when the constructor is called?
        List<Company> companies = new ArrayList<>();

        companies.add(new Company("ABIS"));
        companies.add(new Company("Smals"));
        companies.add(new Company("Google"));
        companies.add(new Company("IBM"));
        companies.add(new Company("Microsoft"));

        return companies;
    }

    // GETTERS AND SETTERS

    public static MemoryListCompanyFactory getInstance(){
        if (memoryListCompanyFactory==null) memoryListCompanyFactory = new MemoryListCompanyFactory();
        return memoryListCompanyFactory;
    }
}
