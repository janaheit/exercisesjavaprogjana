package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.Company;

public interface CompanyRepository {
    Company findCompany(int id);
    Company findCompany(String name);
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int id);
}
