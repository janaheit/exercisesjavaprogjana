package be.abis.shapes.model;

import be.abis.shapes.enums.Color;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(Color color, double height, double width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return height*width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return super.toString() + " Its dimensions are " + height + " times " + width + "." ;
    }
}
