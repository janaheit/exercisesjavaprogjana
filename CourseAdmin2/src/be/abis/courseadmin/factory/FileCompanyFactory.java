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
                if (!names.contains(line.trim())){
                    names.add(line.trim());
                    companies.add(new Company(line.trim()));
                    line = bf.readLine();
                } else {
                    throw new CompanyAlreadyExistsException(line.trim() +" will not be added, since it already exists.");
                }

            }

        } catch (IOException | CompanyAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        return companies;
    }


    private void writeAllCompanies(List<Company> companies){
        try(PrintWriter pw = new PrintWriter(new FileWriter("Users/jana/Projects/TrainingAbis/Abis/FactoryFiles/companies.txt"))){
            // PrintWriter enables println()
            for (Company c: companies){
                pw.println(c.getName());
            }
        } catch (IOException e){
            System.out.println("IO Exception! Could not write companies to file.");
        }
    }

    // GETTERS AND SETTERS

    public static FileCompanyFactory getInstance(){
        if (fileCompanyFactory==null) fileCompanyFactory = new FileCompanyFactory();
        return fileCompanyFactory;
    }
}