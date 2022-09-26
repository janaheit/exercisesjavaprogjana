package be.abis.monthandday.test;

import be.abis.monthandday.repo.MonthDayRepo;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> calendar = MonthDayRepo.getInstance().getCalendar();

        // make scanner
    }

    public int calculateDaysTillEndOfMonth(HashMap<String, Integer> calendar, String month, int day){
        int numOfDaysInMonth = calendar.get(month);
        return numOfDaysInMonth-day;
    }


}
