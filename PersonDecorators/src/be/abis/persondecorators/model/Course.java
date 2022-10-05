package be.abis.persondecorators.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Course {
    private String title;
    private int numOfDays;
    private int pricePerDay;

    public Course(){

    }

    public Course(String title, int numOfDays, int pricePerDay) {
        this();
        this.title = title;
        this.numOfDays = numOfDays;
        this.pricePerDay = pricePerDay;
    }

    // business methods

    public int calculateTotalPrice(){
        return numOfDays*pricePerDay;
    }


    public void printTotalPrice(){
        double price = calculateTotalPrice();

        Locale currentLoc = Locale.getDefault();
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLoc);
        otherSymbols.setDecimalSeparator(',');
        otherSymbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", otherSymbols);
        System.out.println(df.format(price));
    }

    @Override
    public String toString() {
        return "This course " + title + " has a duration of " + numOfDays + " days and costs " + pricePerDay + "euros per day.";
    }

    // getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }


}
