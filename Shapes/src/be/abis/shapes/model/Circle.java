package be.abis.shapes.model;

import be.abis.shapes.enums.Color;

public class Circle extends Shape {

    private double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI *(radius*radius);
    }

    public double getRadius() {
        // pi * r to the power of 2

        return radius;
    }

    @Override
    public String toString() {
        return super.toString() + " Its radius is " + radius + ".";
    }
}
