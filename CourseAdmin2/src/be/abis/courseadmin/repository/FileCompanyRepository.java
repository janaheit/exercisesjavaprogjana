package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyAlreadyExistsException;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileCompanyRepository implements CompanyRepository {

    private static final FileCompanyRepository fileCompanyRepo = new FileCompanyRepository();
    private List<Company> companies = new ArrayList<>();

    private FileCompanyRepository(){
        try {
            List<String> names = Files.readAllLines(Paths.get("c:/temp/javacourses/companies.txt"));
            System.out.println(names);
            for (String n:names) {
                System.out.println(n);

            }
            createCompanies(names);

        } catch (IOException e) {
            System.out.println("File couldn't be read.");
        }

    }

    private void createCompanies(List<String> names){
        for (int x=0; x<names.size();x++){
            if(!names.get(x).equals("")) {
                companies.add(new Company(names.get(x)));
            }
        }
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        for (Company c: this.companies){
            if (c.getCompanyNumber() == id){
                return c;
            }
        }
        throw new CompanyNotFoundException("This company does not exist.");
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        for (Company c: this.companies){
            if (name.equals(c.getName())){
                return c;
            }
        }
        throw new CompanyNotFoundException("This company does not exist.");
    }

    @Override
    public void addCompany(Company company) throws IOException, CompanyAlreadyExistsException {
        List<String> names = Files.readAllLines(Paths.get("c:/temp/javacourses/companies.txt"));
        if(names.contains(company.getName())){
            throw new CompanyAlreadyExistsException("Company already exists");
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("c:/temp/javacourses/companies.txt", true))){
            //bw.println("\n");
            pw.println(company.getName());
            companies.add(company);
        } catch (IOException e) {
            System.out.println("Couldn't write to file!!!");
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
        try (PrintWriter pw = new PrintWriter(new FileWriter("c:/temp/javacourses/companies.txt"))){

            for(Company c: this.companies){
                pw.println(c.getName());
            }
        } catch (IOException e) {
            System.out.println("IO Exception");
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
