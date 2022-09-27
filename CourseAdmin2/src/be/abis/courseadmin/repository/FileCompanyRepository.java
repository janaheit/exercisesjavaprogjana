package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
                companies.add(new Company(names.get(x), x));
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
    public void addCompany(Company company) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:/temp/javacourses/companies.txt", true))){
            bw.write(company.getName());
            companies.add(company);
        } catch (IOException e) {
            System.out.println("Couldn't write to file!!!");
        }

    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void deleteCompany(int id) {

    }

    @Override
    public List<Company> getCompanies() {
        return companies;
    }

    public static FileCompanyRepository getInstance(){
        return fileCompanyRepo;
    }
}
