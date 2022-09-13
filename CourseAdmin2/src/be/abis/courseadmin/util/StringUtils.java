package be.abis.courseadmin.util;

public class StringUtils {

    public static String capitalize(String s){
        String first = s.substring(0,1);
        first = first.toUpperCase();

        String rest = s.substring(1);
        rest = rest.toLowerCase();

        s = first + rest;

        return s;
    }
}


