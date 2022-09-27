package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> sortAllCompaniesByName();
    List<Company> sortAllCompaniesByCompanyNumber();
}
