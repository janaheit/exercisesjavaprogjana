package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.List;

public interface CompanyRepository {
    Company findCompany(int id) throws CompanyNotFoundException;
    Company findCompany(String name) throws CompanyNotFoundException;
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int id);
    List<Company> getCompanies();
}
