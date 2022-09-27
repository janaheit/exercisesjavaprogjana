package be.abis.monthandday.test;

import be.abis.monthandday.repo.MonthDayRepo;

import java.util.HashMap;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> calendar = MonthDayRepo.getInstance().getCalendar();

        // make scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type day and month (letters) to find out how many days are still left in the month.");

        // read input
        int day = scanner.nextInt();
        String month = scanner.next();


        // calculate days till end of the month
        System.out.println("You have " + calculateDaysTillEndOfMonth(calendar, day, month) + " days left in "
        + month + ".");


    }

    public static int calculateDaysTillEndOfMonth(HashMap<String, Integer> calendar, int day, String month){
        int numOfDaysInMonth = calendar.get(month);
        return numOfDaysInMonth-day;
    }


}
