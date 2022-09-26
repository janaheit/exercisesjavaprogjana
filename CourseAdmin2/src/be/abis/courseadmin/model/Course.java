package be.abis.courseadmin.model;

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

    public double calculateTotalPrice(double discountPercentage){
        double totalPrice = numOfDays*pricePerDay;
        return totalPrice * (1-(discountPercentage/100));
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
