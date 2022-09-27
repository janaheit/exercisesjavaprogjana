package be.abis.courseadmin.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static LocalDate format(String date){

        return LocalDate.parse(date, dtf);
    }

    public static void printDate(LocalDate date){
        System.out.println(date.format(dtf));
    }
}
