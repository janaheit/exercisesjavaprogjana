package be.abis.courseadmin.test;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.FileCompanyRepository;

public class TestFileCompanyRepository {
    public static void main(String[] args) {
        FileCompanyRepository fileCompanyRepository = FileCompanyRepository.getInstance();

        Company switchfully = null;
        try {
            System.out.println(fileCompanyRepository.findCompany("ABIS"));
            fileCompanyRepository.addCompany(new Company("Switchfully", fileCompanyRepository.getCompanies().size()));
            switchfully = fileCompanyRepository.findCompany("Switchfully");
            System.out.println(switchfully + ". CompanyNumber is " + switchfully.getCompanyNumber());
        } catch (CompanyNotFoundException e) {
            System.out.println("Couldn't find that company.");
        }


    }
}
