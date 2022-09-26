package be.abis.courseadmin.test;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryArrayCompanyRepositoryTest {

    MemoryArrayCompanyRepository repo;
    /**
    public ExpectedException thrown = ExpectedException.none();*/

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
    void findSmalsById() throws CompanyNotFoundException {
        Company checkCompany = repo.findCompany(2);
        assertEquals("Smals", checkCompany.getName());
    }

    @Test
    void findSmalsByName() throws CompanyNotFoundException {
        Company checkCompany = repo.findCompany("Smals");
        assertEquals(2, checkCompany.getCompanyNumber());
    }

    @Test
    void throwsExceptionWhenCompanyNotFound() {
        Exception exception = assertThrows(CompanyNotFoundException.class, () -> {
            repo.findCompany(7);
        });

        // String expectedMessage = "This company does not exist.";
        //String actualMessage = exception.getMessage();

        //assertTrue(actualMessage.contains(expectedMessage));


    }
}