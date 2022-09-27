package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AbisCompanyService implements CompanyService {

    private CompanyRepository repo = MemoryListCompanyRepository.getInstance();

    @Override
    public List<Company> sortAllCompaniesByName() {
        Collections.sort(repo.getCompanies());
        return repo.getCompanies();
    }

    @Override
    public List<Company> sortAllCompaniesByCompanyNumber() {
        Collections.sort(repo.getCompanies(), new Company.ComparatorByCompanyNumber());
        return repo.getCompanies();
    }
}
