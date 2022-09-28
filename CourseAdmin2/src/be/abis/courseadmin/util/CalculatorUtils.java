package be.abis.courseadmin.util;

import be.abis.courseadmin.functions.Calculator;

public class CalculatorUtils {

    public static double callCalculator(Calculator c, double d, int i){
        return c.performCalculator(d, i);
    }
}
