package be.abis.courseadmin.test;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryArrayCompanyRepositoryTest {

    MemoryArrayCompanyRepository repo;

    @BeforeEach
    void setUp() {
        repo = new MemoryArrayCompanyRepository();
    }

    @Test
    void checkIfSizeIs5(){
        int len = repo.getCompanies().length;
        assertEquals(5, len);
    }

    @Test
    void findSmalsById() {
        Company checkCompany = repo.findCompany(2);
        assertEquals("Smals", checkCompany.getName());
    }

    @Test
    void findSmalsByName() {
        Company checkCompany = repo.findCompany("Smals");
        assertEquals(2, checkCompany.getCompanyNumber());
    }
}