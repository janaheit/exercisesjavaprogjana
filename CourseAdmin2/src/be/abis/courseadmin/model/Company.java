package be.abis.courseadmin.model;

import be.abis.courseadmin.exceptions.PriceTooHighException;
import be.abis.courseadmin.exceptions.PriceTooLowException;

import java.util.Comparator;

public class Company implements Comparable<Company> {

    private String name;
    private int companyNumber;
    private static int COUNTER = 0;

    public Company(){

    }

    public Company(String name){
        this();
        COUNTER+=1;
        this.name = name;
        this.companyNumber = COUNTER;

    }

    // business methods

    public double requestPriceOfferForCompanySession(Course c, int numOfParticipants) throws PriceTooHighException, PriceTooLowException {

        CompanySession companySession1 = new CompanySession(c, numOfParticipants);

        System.out.println(companySession1.calculatePrice());

        return 0;
    }

    @Override
    public String toString() {
        return name + ": " + companyNumber;
    }

    @Override
    public int compareTo(Company o) {
        return this.getName().compareTo(o.getName());
    }

    public static class ComparatorByCompanyNumber implements Comparator<Company> {

        @Override
        public int compare(Company o1, Company o2) {

            return o1.getCompanyNumber() - o2.getCompanyNumber();
        }
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

    public static int getCOUNTER() {
        return COUNTER;
    }

}
