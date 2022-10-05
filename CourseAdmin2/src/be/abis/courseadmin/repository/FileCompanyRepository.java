package be.abis.courseadmin.repository;

import be.abis.courseadmin.enums.CompanyFactoryType;
import be.abis.courseadmin.exceptions.CompanyAlreadyExistsException;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.factory.CompanyFactory;
import be.abis.courseadmin.factory.FileCompanyFactory;
import be.abis.courseadmin.model.Company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileCompanyRepository implements CompanyRepository {

    private static final FileCompanyRepository fileCompanyRepo = new FileCompanyRepository();
    private CompanyFactory factory;
    private List<Company> companies;

    private FileCompanyRepository(){
        this.factory = FileCompanyFactory.createFactory(CompanyFactoryType.FILE);
        this.companies = factory.createCompanyList();
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        for (Company c: this.companies){
            if (c.getCompanyNumber() == id){
                return c;
            }
        }
        throw new CompanyNotFoundException("Company ID " + id + " does not exist.");
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        for (Company c: this.companies){
            if (name.equals(c.getName())){
                return c;
            }
        }
        throw new CompanyNotFoundException("Company with the name " + name + " does not exist.");
    }

    @Override
    public void addCompany(Company company) throws IOException, CompanyAlreadyExistsException {
        String home = System.getProperty("user.home");

        List<String> names = Files.readAllLines(Paths.get(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companies.txt"));

        if(names.contains(company.getName())){
            throw new CompanyAlreadyExistsException(company.getName() + " already exists and will therefore not be added. ");
        }

        File file = new java.io.File(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companies.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))){
            //bw.println("\n");
            pw.println(company.getName());
            companies.add(company);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(company.getName() +" was not added");
        }
    }

    @Override
    public void updateCompany(Company company) {

        try {
            findCompany(company.getCompanyNumber());
            company.setName("hardcoded for now");

            writeAllCompanies();
        } catch (CompanyNotFoundException e) {
            System.out.println("Company was not found, couldn't be updated.");;
        }


    }

    private void writeAllCompanies(){
        String home = System.getProperty("user.home");
        File file = new java.io.File(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companies.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))){

            for(Company c: this.companies){
                pw.println(c.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCompany(int id) {

        try {
            Company company = findCompany(id);
            this.companies.removeIf(c -> c.equals(company));

            writeAllCompanies();
        } catch (CompanyNotFoundException cnf){
            System.out.println("Company wasn't found and so couldn't be deleted.");
        }
    }

    @Override
    public List<Company> getCompanies() {
        return companies;
    }

    public static FileCompanyRepository getInstance(){
        return fileCompanyRepo;
    }
}
