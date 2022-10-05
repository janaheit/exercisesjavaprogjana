package be.abis.courseadmin.test;

import be.abis.courseadmin.enums.CompanyFactoryType;
import be.abis.courseadmin.exceptions.CompanyAlreadyExistsException;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.factory.CompanyFactory;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.FileCompanyRepository;

import java.io.IOException;

public class FileCompanyFactoryTestMain {
    public static void main(String[] args) {
        CompanyRepository companyRepository = FileCompanyRepository.getInstance();

        System.out.println(companyRepository.getCompanies());
        System.out.println("---------------------------");

        try {
            companyRepository.addCompany(new Company("Samsung"));
        } catch (IOException | CompanyAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(companyRepository.getCompanies());
        System.out.println("---------------------------");
        System.out.println("Finding companies: ");

        try {
            System.out.println(companyRepository.findCompany(3));
            System.out.println(companyRepository.findCompany("Microsoft"));
            System.out.println(companyRepository.findCompany(7));
            System.out.println(companyRepository.findCompany("daös"));
            // last one will not be run bc third one throws exception.
        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------");

    }
}
