package be.abis.courseadmin.factory;

import be.abis.courseadmin.enums.CompanyFactoryType;
import be.abis.courseadmin.model.Company;

import java.util.List;

public abstract class CompanyFactory {

    public static CompanyFactory createFactory(CompanyFactoryType companyFactoryType){
        switch (companyFactoryType){
            default:
            case FILE:
                return FileCompanyFactory.getInstance();
            case LIST:
                return MemoryListCompanyFactory.getInstance();
        }
    }

    public abstract List<Company> createCompanyList();
}
