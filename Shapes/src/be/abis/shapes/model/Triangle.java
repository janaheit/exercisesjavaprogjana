package be.abis.shapes.model;

import be.abis.shapes.enums.Color;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(Color color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5*base*height;
    }

    @Override
    public String toString() {
        return super.toString() + " Its dimensions are base = " + base + " and height = " + height + ".";
    }
}
