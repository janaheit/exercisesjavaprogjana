package be.abis.courseadmin.model;

import be.abis.courseadmin.exceptions.PriceTooHighException;
import be.abis.courseadmin.exceptions.PriceTooLowException;

public class Company {

    private String name;
    private int companyNumber;

    public Company(){

    }

    public Company(String name, int companyNumber){
        this();
        this.name = name;
        this.companyNumber = companyNumber;
    }

    // business methods

    public double requestPriceOfferForCompanySession(Course c, int numOfParticipants) throws PriceTooHighException, PriceTooLowException {

        CompanySession companySession1 = new CompanySession(c, numOfParticipants);

        System.out.println(companySession1.calculatePrice());

        return 0;
    }

    // getters and setters

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "This company is called " + name;
    }

    /**public void printInfo(){
        System.out.println("This company is called " + name);
    }*/
}
