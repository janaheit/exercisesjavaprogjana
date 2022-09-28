package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyAlreadyExistsException;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.io.IOException;
import java.util.List;

public interface CompanyRepository {
    Company findCompany(int id) throws CompanyNotFoundException;
    Company findCompany(String name) throws CompanyNotFoundException;
    void addCompany(Company company) throws IOException, CompanyAlreadyExistsException;
    void updateCompany(Company company);
    void deleteCompany(int id);
    List<Company> getCompanies();
}
