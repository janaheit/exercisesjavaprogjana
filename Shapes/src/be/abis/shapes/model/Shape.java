package be.abis.shapes.model;

import be.abis.shapes.enums.Color;

public abstract class Shape {

    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract double area();

    public Color getColor(){
        return color;
    }

    @Override
    public String toString() {
        return "This " + this.getClass().getSimpleName() + " is " + color.getDescription() + ".";
    }
}
