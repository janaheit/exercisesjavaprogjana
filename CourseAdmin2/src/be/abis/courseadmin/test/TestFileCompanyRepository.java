package be.abis.courseadmin.test;

import be.abis.courseadmin.exceptions.CompanyAlreadyExistsException;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.FileCompanyRepository;

import java.io.IOException;

public class TestFileCompanyRepository {
    public static void main(String[] args) {
        FileCompanyRepository fileCompanyRepository = FileCompanyRepository.getInstance();

        try {
            fileCompanyRepository.addCompany(new Company("Switchfully"));
        } catch (CompanyAlreadyExistsException e) {
            System.out.println("Company exists already, what are you doing?");
        } catch (IOException e) {
            System.out.println("IO Exception, why idk");
        }
    }

}
