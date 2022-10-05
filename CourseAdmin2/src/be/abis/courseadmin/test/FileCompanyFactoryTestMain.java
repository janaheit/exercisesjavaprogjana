package be.abis.courseadmin.test;

import be.abis.courseadmin.enums.CompanyFactoryType;
import be.abis.courseadmin.factory.CompanyFactory;
import be.abis.courseadmin.model.Company;

import java.util.List;

public class FileCompanyFactoryTestMain {
    public static void main(String[] args) {
        CompanyFactory cf = CompanyFactory.createFactory(CompanyFactoryType.FILE);
        List<Company> companies = cf.createCompanyList();

        System.out.println(companies);


    }
}
