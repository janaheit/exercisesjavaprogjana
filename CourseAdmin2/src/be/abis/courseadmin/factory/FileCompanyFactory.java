package be.abis.courseadmin.factory;


import be.abis.courseadmin.exceptions.CompanyAlreadyExistsException;
import be.abis.courseadmin.model.Company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCompanyFactory extends CompanyFactory {

    private static FileCompanyFactory fileCompanyFactory;

    public FileCompanyFactory() {
    }

    @Override
    public List<Company> createCompanyList() {
        return readCompaniesFromFile();
    }

    private List<Company> readCompaniesFromFile(){
        List<Company> companies = new ArrayList<>();
        List<String> names = new ArrayList<>();
        String line;

        String home = System.getProperty("user.home");
        File file = new java.io.File(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companies.txt");
        // how to make it a relative path that depends on this project? & OS independent


        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {

            line = bf.readLine();
            while (line != null) {
                if (names.contains(line.trim())){
                    System.out.println(line.trim() +" will not be added, since it already exists.");
                } else if (!line.equals("")){
                    names.add(line.trim());
                    companies.add(new Company(line.trim()));
                }
                line = bf.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return companies;
    }

    // GETTERS AND SETTERS

    public static FileCompanyFactory getInstance(){
        if (fileCompanyFactory==null) fileCompanyFactory = new FileCompanyFactory();
        return fileCompanyFactory;
    }
}
