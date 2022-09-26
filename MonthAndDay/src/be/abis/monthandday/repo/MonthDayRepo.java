package be.abis.monthandday.repo;

import java.util.HashMap;

public class MonthDayRepo {

    private static final MonthDayRepo monthDayRepo = new MonthDayRepo();
    private HashMap<String, Integer> calendar = new HashMap<>();

    private MonthDayRepo() {
        init();
    }

    private void init(){
        calendar.put("January", 31);
        calendar.put("February", 30);
        calendar.put("March", 31);
        calendar.put("April", 30);
        calendar.put("May", 31);
        calendar.put("June", 30);
        calendar.put("July", 31);
        calendar.put("August", 31);
        calendar.put("September", 30);
        calendar.put("October", 31);
        calendar.put("November", 30);
        calendar.put("December", 31);
    }

    public HashMap<String, Integer> getCalendar() {
        return calendar;
    }

    public static MonthDayRepo getInstance(){
        return monthDayRepo;
    }
}
