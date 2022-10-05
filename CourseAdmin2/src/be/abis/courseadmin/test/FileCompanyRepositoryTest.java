package be.abis.courseadmin.test;

import be.abis.courseadmin.exceptions.CompanyAlreadyExistsException;
import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.FileCompanyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.jupiter.api.Assertions.*;

class FileCompanyRepositoryTest {

    FileCompanyRepository fileCompanyRepository;

    @BeforeEach
    void setUp() throws IOException {
        fileCompanyRepository = FileCompanyRepository.getInstance();

        // backup state of repository
        String home = System.getProperty("user.home");

        Files.copy(Paths.get(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companies.txt"),
                Paths.get(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companiesBackup.txt"),
                REPLACE_EXISTING);
    }

    @AfterEach
    void tearDown() throws IOException {
        String home = System.getProperty("user.home");

        Files.copy(Paths.get(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companiesBackup.txt"),
                Paths.get(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companies.txt"),
                REPLACE_EXISTING);
    }


    @Test
    void addNewCompany() throws CompanyNotFoundException, IOException, CompanyAlreadyExistsException {
        Company newCompany = new Company("Raiffeisen");

        fileCompanyRepository.addCompany(newCompany);
        assertEquals(fileCompanyRepository.findCompany("Raiffeisen"), newCompany);

        String home = System.getProperty("user.home");
        List<String> names = Files.readAllLines(Paths.get(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companies.txt"));
        assertTrue(names.contains("Raiffeisen"));
    }

    @Test
    void writingToFile(){

    }

    @Test
    void updateCompany() {
    }

    @Test
    void deleteFirstCompany() throws IOException {
        Company company = fileCompanyRepository.getCompanies().get(0);

        fileCompanyRepository.deleteCompany(company.getCompanyNumber());
        assertThrows(CompanyNotFoundException.class, () -> {
            fileCompanyRepository.findCompany(company.getCompanyNumber());
        });

        String home = System.getProperty("user.home");
        List<String> names = Files.readAllLines(Paths.get(home + "/Projects/TrainingAbis/Abis/FactoryFiles/companies.txt"));
        assertFalse(names.contains(company.getName()));
    }
}