package be.abis.courseadmin.test;

import be.abis.courseadmin.functions.Calculator;
import be.abis.courseadmin.model.Course;

public class TestFunctional {

    public static void main(String[] args) {

        Calculator calc = (a, b) -> a*b;
        System.out.println(calc.performCalculator(5.0, 3));


        Course c = new Course("title", 30, 50);

        System.out.println(c.calculateTotalPrice(5));
    }
}
